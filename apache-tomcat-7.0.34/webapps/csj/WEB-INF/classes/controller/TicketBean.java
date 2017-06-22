package controller;
import beans.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import controller.CustomerCatalogBean;
import beans.CustomerCatalog;
import beans.CustomerTickets;
import java.util.Iterator;

public class TicketBean {
    
    private static final HashMap<String,CustomerTickets> ticketMap = new HashMap<String, CustomerTickets>();
    
    public static void addTicket(String userID, String description, String time){
        Ticket ticket = new Ticket(userID, description, time, Ticket.TICKET_OPENED);
        CustomerTickets tickets = ticketMap.get(userID);
        if(tickets == null){
            tickets = new CustomerTickets(userID);
        }
        tickets.addTicket(ticket);
        ticketMap.put(userID, tickets);
        System.out.println("Added" + userID);
    }
    
    public static ArrayList<Ticket> getTicketsByStatus(int status){
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for(String id : ticketMap.keySet()){
            CustomerTickets customerTickets = ticketMap.get(id);
            HashMap<String, Ticket> customerTicketMap = customerTickets.getCustomerTickets();
            for (String ticketId : customerTicketMap.keySet()) {
                Ticket t = customerTicketMap.get(ticketId);
                if(t.getStatus() == status){
                    tickets.add(t);
                }
            }
        }
        return tickets;
    } 
    
    public boolean ticketExists(String userID, String description, String time){
        boolean exists = false;
        CustomerTickets customerTickets = ticketMap.get(userID);
   
        if(customerTickets != null)
        {
            HashMap<String, Ticket> customerTicketMap = customerTickets.getCustomerTickets();
            String key = CustomerTickets.generateKey(time, description);
            Ticket ticket = customerTicketMap.get(key);
            if(ticket!=null){
                exists = true;
            }
                
        }
        return exists;
    }
    
    public static boolean ifUserIDExists(String userID){
        boolean exists = false;
        CustomerCatalog customer = CustomerCatalogBean.getUserID(userID);
        if(customer != null){
            if(customer.getPosition().equals("customer")){
                exists = true;
            }
        }
        return exists;
    }
    
    
    public static Ticket getTicket(String userID, String description, String time){
        CustomerTickets customerTickets = ticketMap.get(userID);
        HashMap<String, Ticket> customerTicketMap = customerTickets.getCustomerTickets();
        String key = CustomerTickets.generateKey(time, description);
        System.out.println(customerTicketMap + ":key:" + key);
        return customerTicketMap.get(key);
    }
    
    public static void closeTicket(Ticket t){
        t.setStatus(Ticket.TICKET_COSED);
    }
//ignore code below - random code for debugging
    public static void main(String[] args){
        addTicket("test", "dsfsdf", "dsdsf");
        addTicket("test2", "dsfsdf", "dsdsf");
        addTicket("test3", "dsf**sdf", "dsdsf");
        
        System.out.println(ticketMap);
        ArrayList<Ticket> list = getTicketsByStatus(Ticket.TICKET_OPENED);
        for(Ticket t : list){
            System.out.println(t.getDescription());
        }
        System.out.println(getTicket("test", "dsfsdf", "dsdsf").getDescription());
    }
    
}
