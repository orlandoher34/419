package beans;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class CustomerSubscription implements Serializable {
    
    private String userID;
    private String tvChannelPlan;
    private ArrayList<String> PPVList ;
    private int amount;

    public CustomerSubscription(String userID, String tvChannel, String[] array) {
        PPVList = new ArrayList<String>();
        for(int i = 0; i < array.length; i++){
            PPVList.add(array[i]);
        }
        this.userID = userID;
        this.tvChannelPlan = tvChannel;
        amount = new Random().nextInt(1000);
    }
    
     public CustomerSubscription(String userID, String tvChannel) {
        PPVList = new ArrayList<String>();
        this.userID = userID;
        this.tvChannelPlan = tvChannel;
        amount = new Random().nextInt(1000);
    }
    
    public String getUserID(){
        return this.userID;
    }
    
    public String getTVPlan(){
        return this.tvChannelPlan;
    }
    
    public ArrayList<String> getPPVList(){
        return this.PPVList;
    }
    
    public void setUserID(String id){
        this.userID = id;
    }
    
    public int getAmmount(){
        return this.amount;
    }
    
    public void setAmmount(int amount){
        this.amount = amount;
    }
    
    public void setTVChannelPlan(String plan){
        this.tvChannelPlan = plan;
    }
    
    public void setPPVList(ArrayList<String> list){
        this.PPVList = list;
    }
    
    public void removePPV(String PPVEvent){
        PPVList.remove(PPVEvent);
    }
    
    public void addPPV(String PPVEvent){
        if(!PPVList.contains(PPVEvent)){
            PPVList.add(PPVEvent);
        }
    }
    
    public static void main (String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("ab");
        list.add("fg");
        String[] ar = {"ddas","happy"};
        CustomerSubscription cus = new CustomerSubscription("happy", "happy", ar);
        cus.removePPV("ddas");
        cus.addPPV("hkjash");
        cus.addPPV("happy");
        System.out.println(cus.getAmmount());
    }
    
}