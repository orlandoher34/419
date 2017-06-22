package beans;
import java.io.Serializable;

public class CustomerInformation implements Serializable{
    
    private String firstName;
    private String lastName;
    private String address;
    private String telNum;
    private long zipCode;
    private String creditCardNumber;
    private String emailAddress;

    public CustomerInformation(String firstName, String lastName, String address,
            String telNum, long zip, String creditCard, String emailAddress) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telNum = telNum;
        this.zipCode = zip;
        this.creditCardNumber = creditCard;
        this.emailAddress = emailAddress;
    }
    
    public  String getFirstName() {
	return firstName;
    }
    
    public  void setFirstName(String firstName) {
	this.firstName = firstName;
    }
    public  String getLastName() {
	return lastName;
    }
    public  void setLastName(String lastName) {
	this.lastName = lastName;
    }
    public  String getAddress() {
    	return address;
    }
    public  void setAddress(String address) {
    	this.address = address;
    }
    public  String getTelNum() {
    	return telNum;
    }
    public  void setTelNum(String telNum) {
    	this.telNum = telNum;
    }
    public  long getZipCode() {
    	return zipCode;
    }
    public  void setZipCode(long zipCode) {
    	this.zipCode = zipCode;
    }
    public  String getCreditCardNumber() {
    	return creditCardNumber;
    }
    public  void setCreditCardNumber(String creditCardNumber) {
    	this.creditCardNumber = creditCardNumber;
    }
    public  String getEmailAddress() {
    	return emailAddress;
    }
    public  void setEmailAddress(String emailAddress) {
    	this.emailAddress = emailAddress;
    }

    
}