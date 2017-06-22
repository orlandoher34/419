package controller;
import beans.CustomerInformation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class CustomerInformationBean implements Serializable{
    private static boolean isInitialized = false; 
    private final static String fileName = "C://apache-tomcat-7.0.34/webapps/csj/WEB-INF/StoredMap";
    public static HashMap<String, CustomerInformation> customerInfoMap;
    
    public static void initializeMap(){
        customerInfoMap = new HashMap<String, CustomerInformation>();
        File f = new File(fileName);
        if(!f.exists()) { 
            customerInfoMap.put("test", new CustomerInformation("testFirst", "testSecond", "test", "test", 123, "test", "test@mail.com"));
            customerInfoMap.put("test2", new CustomerInformation("testFirst", "testSecond", "test", "test", 123, "test", "test@mail.com"));
            customerInfoMap.put("Hernandezo", new CustomerInformation("Orlando", "Hernandez", "123 Main St.", "312-123-2343", 60606, "543212345678", "odh@mail.com"));
			customerInfoMap.put("Jonesj", new CustomerInformation("Jason", "Jones", "456 8th St.", "312-123-4323", 60607, "453112345678", "JJ@mail.com"));
            System.out.println("File Not Found.");
            store();
        }else{
            read();
        }
    }
    
    public static CustomerInformation getCustomerInformation(String userID){
        if(!isInitialized){
            initializeMap();
            isInitialized = true;
        }
        return customerInfoMap.get(userID);
    }
    
    public static void addCustomerInformation(String userID, CustomerInformation customerInfo){
        if(!isInitialized){
            initializeMap();
            isInitialized = true;
        }
        customerInfoMap.put(userID, customerInfo);
    }
    
    public static boolean store() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerInfoMap);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public static boolean read(){
        try {
            FileInputStream fos = new FileInputStream(fileName);
            ObjectInputStream oos = new ObjectInputStream(fos);
            customerInfoMap = (HashMap<String, CustomerInformation>)oos.readObject();
            oos.close();
            fos.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
        
    }
    
}