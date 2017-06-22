package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.*;
import beans.*;

public class AccountSpecialistServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        String position = (String) session.getAttribute("position");
        String action = request.getParameter("action");
        if(action != null){
            if(action.equals("createAccount")){
                handleCreateAccountRequest(request,response);
            }
        }
    }

    private void handleCreateAccountRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String telNum = request.getParameter("telNum");
        String emailID = request.getParameter("emailID");
        String address = request.getParameter("address");
        long zip = Long.valueOf(request.getParameter("zip"));
        String creditCard = request.getParameter("creditCard");

        CustomerCatalogBean.addUserID(userID, password);

        CustomerInformation customerInfo = new CustomerInformation(
                firstName, lastName, address, telNum, zip, creditCard, emailID);
        CustomerInformationBean.addCustomerInformation(userID, customerInfo);

        CustomerSubscription customerSubscription = 
                new CustomerSubscription(userID, "basic");
        CustomerSubscriptionBean.addCustomerSubscription(userID, customerSubscription);
        
        response.getWriter().write("Successfully created the account");
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

}
