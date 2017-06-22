package beans;

public class Ticket {
    
    public static final int TICKET_COSED = 0;
    public static final int TICKET_OPENED = 1;
    private String userID;
    private String description;
    private String timeOfService;
    private int status;
    
    public Ticket(String userID, String description, String time, int status){
        this.userID = userID;
        this.description = description;
        this.status = status;
        this.timeOfService = time;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getTimeOfService(){
        return this.timeOfService;
    }
    
    public String getUserID(){
        return this.userID;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public void setTimeOdService(String time){
        this.timeOfService = time;
    }
    
    public void setUserID(String id){
        this.userID = id;
    }
    
   
}
