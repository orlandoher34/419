package beans;

import java.util.HashMap;

public class CustomerTickets {
    String userID;
    HashMap<String,Ticket> tickets;
    
    public CustomerTickets(String userID){
        this.tickets = new HashMap<String, Ticket>();
        this.userID = userID;
    }
    public void addTicket(Ticket t){
        String key = generateKey(t.getTimeOfService(), t.getDescription());
        tickets.put(key, t);   
    }
    
    public HashMap<String, Ticket> getCustomerTickets(){
        System.out.println("returning customer tickets:" + this.tickets);
        return this.tickets;
    }

    public static String generateKey(String time, String description){
        return (time + description.length());
    }
    
}


