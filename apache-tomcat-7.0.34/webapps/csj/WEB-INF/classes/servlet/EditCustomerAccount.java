package servlet;

import beans.CustomerSubscription;
import controller.CustomerSubscriptionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilities.Utils;

@WebServlet("/EditCustomerAccount")
public class EditCustomerAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strAction = request.getParameter("action");
        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("getSubscription")) {
                handleSubscriptionRequest(response, request);
            }else if(strAction.equals("cancelPPV")){
                handleCancelPPVRequest(response, request);
            }else if(strAction.equals("orderPPV")){
                handleOrderPPVRequest(response, request);
            }else if(strAction.equals("getAmount")){
                handlePayementRequest(response, request, "getAmount");
            }else if(strAction.equals("pay")){
                handlePayementRequest(response, request, "pay");
            }else if(strAction.equals("tvPlan")){
                handleTVPlanRequest(response, request);
            }
        }
    }
    
        private void handleTVPlanRequest(HttpServletResponse response, HttpServletRequest request) throws IOException{
        String userID = request.getParameter("userID");
        CustomerSubscription cusSubscription = CustomerSubscriptionBean.
                getCustomerSubscription(userID);
        String tvID = request.getParameter("tvID");
        cusSubscription.setTVChannelPlan(tvID);
        CustomerSubscriptionBean.store();
    }

    public void handleSubscriptionRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/xml");
        String userID = request.getParameter("userID");
        PrintWriter out = response.getWriter();
        try {
            out.println("<Subscription>"+prepareOutput(userID)+"</Subscription>");
        }catch(Exception e){
            out.println(e.getMessage());
        } 
        finally {
            out.close();
        }
    }
    
    private void handleCancelPPVRequest(HttpServletResponse response, HttpServletRequest request) throws IOException{
        String userID = request.getParameter("userID");
        CustomerSubscription cusSubscription = CustomerSubscriptionBean.
                getCustomerSubscription(userID);
        String ppvID = request.getParameter("ppvID");
        cusSubscription.removePPV(ppvID);
        CustomerSubscriptionBean.store();
    }
    
    private void handleOrderPPVRequest(HttpServletResponse response, HttpServletRequest request) throws IOException{
       String userID = request.getParameter("userID");
        CustomerSubscription cusSubscription = CustomerSubscriptionBean.
                getCustomerSubscription(userID);
        String ppvID = request.getParameter("ppvID");
        cusSubscription.addPPV(ppvID);
        CustomerSubscriptionBean.store();
    }
    
    private String prepareOutput(String userID){
        CustomerSubscription cusSubscription = CustomerSubscriptionBean.
                getCustomerSubscription(userID);
        StringBuilder output = new StringBuilder();
        output.append("<PPVList>");
        ArrayList<String> PPVList = cusSubscription.getPPVList();
        for (String elem : PPVList) {
            String event = Utils.getPPVEvent(elem);

            output.append("<PPV>");
            output.append("<PPVName>").append(event).append("</PPVName>");
            output.append("<PPVID>").append(elem).append("</PPVID>");
            output.append("</PPV>");
        }
        output.append("</PPVList>");
        String tvPlanID = cusSubscription.getTVPlan();
        output.append("<TV>").append(Utils.getTVPlan(tvPlanID)).append("</TV>");
        output.append("<TVID>").append(tvPlanID).append("</TVID>");
        return output.toString();
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
    private void handlePayementRequest(HttpServletResponse response, HttpServletRequest request, String action) throws IOException {
        String userID = request.getParameter("userID");
        CustomerSubscription cusSubscription = CustomerSubscriptionBean.
                getCustomerSubscription(userID);
        if(action.equals("getAmount")){
            response.setContentType("text/html");
            int amount = cusSubscription.getAmmount();
            response.getWriter().write(String.valueOf(amount));
        }else if(action.equals("pay")){
            cusSubscription.setAmmount(0);
            CustomerSubscriptionBean.store();
        }
    }

}
