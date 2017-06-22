package servlet;

import beans.CustomerInformation;
import controller.CustomerInformationBean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerInfoController")
public class CustomerInfoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strAction = request.getParameter("action");
        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("getAccountDetails")) {
                handleAccountInfoRequest(response, request);
            }else if(strAction.equals("editInfo")){
                handleEditDetailsRequest(response, request);
            }
        }
        
    }
    
    private void handleEditDetailsRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String userID = (String)session.getAttribute("userID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String telNum = request.getParameter("telNum");
        long zip = Long.parseLong(request.getParameter("zipCode"));
        String emailID = request.getParameter("emailID");
        String creditCard = request.getParameter("creditCard");
        
        CustomerInformation customer = CustomerInformationBean.
                getCustomerInformation(userID);
        customer.setAddress(address);
        customer.setEmailAddress(emailID);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setTelNum(telNum);
        customer.setZipCode(zip);
        customer.setCreditCardNumber(creditCard);
        response.sendRedirect("../Customerportal.jsp");
        CustomerInformationBean.store();
    }

    private void handleAccountInfoRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/xml");
        HttpSession session = request.getSession();
        String userID = (String)session.getAttribute("userID");
        PrintWriter out = response.getWriter();
        try {

            out.println("<customers>"+prepareOutput(userID)+"</customers>");
        }catch(Exception e){
            out.println(e.getMessage());
        } 
        finally {
            out.close();
        }
    }

    private String prepareOutput(String userID) {
        StringBuffer output = new StringBuffer();
        CustomerInformation customerInfo = CustomerInformationBean.
                getCustomerInformation(userID);
        output.append("<CustomerInfo>");
        output.append("<FirstName>" + customerInfo.getFirstName() + "</FirstName>");
        output.append("<LastName>" + customerInfo.getLastName() + "</LastName>");
        output.append("<Address>" + customerInfo.getAddress()+ "</Address>");
        output.append("<TelNumber>" + customerInfo.getTelNum()+ "</TelNumber>");
        output.append("<CreditCard>" + customerInfo.getCreditCardNumber() + "</CreditCard>");
        output.append("<Zip>" + customerInfo.getZipCode()+ "</Zip>");
        output.append("<Email>" + customerInfo.getEmailAddress()+ "</Email>");
        output.append("</CustomerInfo>");
        return (output.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public static void main(String args[]){
        new CustomerInfoController().prepareOutput("test2");
    }
}