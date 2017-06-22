package beans;

import controller.CustomerCatalogBean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.Enumeration;

public class CustomerCatalog implements Serializable{
	private String userID;
	private String password;
	 private String position;
	
	public CustomerCatalog(String userID, String password, String position){
		this.userID = userID;
		this.password = password;
        this.position = position;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPosition(){
        return this.position;
        }
        
    public void setPosition( String position){
        this.position = position;
        }
		
    public boolean compare(CustomerCatalog obj){
        boolean isEqual = false;
        if(password.equals(obj.getPassword())&&
            userID.equals(obj.getUserID())&& (position.equals(obj.position)))
			{
                isEqual = true;
            }
            return isEqual;
        }
}