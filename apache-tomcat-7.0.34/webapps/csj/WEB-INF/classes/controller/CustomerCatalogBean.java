package controller;


import beans.CustomerCatalog;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.Enumeration;
import utilities.Utils;

public class CustomerCatalogBean {

private static HashMap<String, CustomerCatalog> tokens;
  // This would come from a database in real life.
  // We use a static table for ease of testing and deployment.
  // See JDBC chapters for info on using databases in
  // servlets and JSP pages.

  private static boolean initialize = false;
  public static final String fileName = "C://apache-tomcat-7.0.34/webapps/csj/WEB-INF/CustomerBean";
  
  public static void initializeBean(){
    tokens = new HashMap<String, CustomerCatalog> ();
    File f = new File(fileName);
    if(!f.exists()){
        

        tokens.put("test", new CustomerCatalog("test", "password", "customer"));
        tokens.put("test2", new CustomerCatalog("test2", "password", "customer"));
        tokens.put("Hernandezo", new CustomerCatalog("Hernandezo", "temp1234", "customer"));
        tokens.put("Jonesj", new CustomerCatalog("Jonesj", "password", "customer"));
        tokens.put("Badera", new CustomerCatalog("Badera", "project", "manager"));
        tokens.put("Garciaa", new CustomerCatalog("Garciaa", "password1234", "manager"));
            tokens.put("Smithj", new CustomerCatalog("Smithj", "test1234", "account"));
        tokens.put("Chenk", new CustomerCatalog("Chenk", "pw1234", "technical"));
        tokens.put("Petersf", new CustomerCatalog("Petersf", "test123", "account"));
        tokens.put("Hernandezg", new CustomerCatalog("Hernandezg", "pw123", "technical"));
        Utils.store(fileName, tokens);
    }else{
        tokens = Utils.read(fileName);
    }
    initialize = true;
     }

    public static CustomerCatalog getUserID(String userID) { 
        if(!initialize){
            initializeBean();
        }
        return tokens.get(userID);
    }
    
    public static void addUserID(String userID, String password){
        if(!initialize){
            initializeBean();
        }
        CustomerCatalog customerCatalog = 
                new CustomerCatalog(userID, password, "customer");
        tokens.put(userID, customerCatalog);
        Utils.store(fileName, tokens);
    }
    
    public static String getMap(){
        return tokens.toString();
    }
    
    public static void main (String[] args){
        getUserID("test");
        System.out.println(tokens.get("orlando").getUserID().equals("orlando"));
        System.out.println(tokens.get("orlando").getPassword().equals("orlando"));
        System.out.println(tokens.get("orlando").getPosition().equals("customer"));
    }
}