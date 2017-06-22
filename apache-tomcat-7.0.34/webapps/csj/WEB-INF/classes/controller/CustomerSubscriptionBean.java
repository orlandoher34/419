package controller;
import beans.CustomerSubscription;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import utilities.Utils;

public class CustomerSubscriptionBean implements Serializable{
    private static HashMap<String,CustomerSubscription> subscriptionMap;
    private static boolean isInitialized = false;
    public static final String fileName = "C://apache-tomcat-7.0.34/webapps/csj/WEB-INF/subscription";

    public static void initializeMap() {
        subscriptionMap = new HashMap<String, CustomerSubscription>();
        File f = new File(fileName);
        if(!f.exists()) { 
            CustomerSubscription c1 = new CustomerSubscription("test", "elite");
            c1.addPPV("starwars");
            subscriptionMap.put("test", c1);

            CustomerSubscription c2 = new CustomerSubscription("test2", "elite");
            c2.addPPV("starwars");
            c2.addPPV("boxing");
            subscriptionMap.put("test2", c2); 
            Utils.store(fileName, subscriptionMap);
        }else{
            subscriptionMap = Utils.read(fileName);
        }
        isInitialized = true;
    }
    
    public static CustomerSubscription getCustomerSubscription(String userID){
        if(!isInitialized){

            initializeMap();
        }
        return subscriptionMap.get(userID);
    }
    
    public static void addCustomerSubscription(String userID, 
            CustomerSubscription subscription){
        if(!isInitialized){

            initializeMap();
        } 
        subscriptionMap.put(userID, subscription);
    }
    
    public static void store(){
        Utils.store(fileName, subscriptionMap);
    }
    
    public static void read(){
        subscriptionMap = Utils.read(fileName);
    }
    public static void main (String[] args){
        System.out.println(getCustomerSubscription("test").getAmmount());
        System.out.println(subscriptionMap);
    }
}
