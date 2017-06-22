package servlet;

import beans.Ticket;
import controller.TicketBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TechnicalSupportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        String position = (String) session.getAttribute("position");
        String action = request.getParameter("action");
        if(action.equals("checkID")){
            checkIfUserIDExists(request, response);
        }else if(action.equals("addTicket")){
            addTicket(request, response);
        }else if(action.equals("getOpenTickets")){
            getOpenTickets(request, response);
        }else if(action.equals("closeTicket")){
            closeTicket(request);
        }
            
    }
    
    private void checkIfUserIDExists(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String customerID = request.getParameter("userID");
        boolean exists = TicketBean.ifUserIDExists(customerID);
        response.getWriter().write(String.valueOf(exists));
    }
    
    private void addTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String customerID = request.getParameter("userID");
        String time = request.getParameter("timeOfService");
        String description = request.getParameter("description");
        TicketBean.addTicket(customerID, description, time);
        response.getWriter().write(TicketBean.getTicket(customerID,description, time).getDescription());
        response.sendRedirect("./Technicalportal.jsp");
    }
    
    private void getOpenTickets(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/xml");
        response.getWriter().write("<Tickets>" + prepareOutput() + "</Tickets>");
    }
    
    private String prepareOutput(){
        ArrayList<Ticket> tickets = TicketBean.
                getTicketsByStatus(Ticket.TICKET_OPENED);
        StringBuilder output = new StringBuilder();
        for(Ticket ticket : tickets){
            output.append("<Ticket>");
            output.append("<UserID>").append(ticket.getUserID()).append("</UserID>");
            output.append("<TimeOfService>").append(ticket.getTimeOfService()).append("</TimeOfService>");
            output.append("<Description>").append(ticket.getDescription()).append("</Description>");
            output.append("</Ticket>");
        }
        return output.toString();
    }
    
    private void closeTicket(HttpServletRequest request){
        String customerID = request.getParameter("userID");
        String time = request.getParameter("timeOfService");
        String description = request.getParameter("description");
        Ticket t = TicketBean.getTicket(customerID, description, time);
        TicketBean.closeTicket(t);
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
