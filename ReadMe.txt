
How to

1. In the zipped file attached, locate the apache-tomcat-7.0.34 directory.
2. Unzip the directory.
3. Place the directory on the root of C:\
4. Create the following directory: csj\s1\
Copy the following file to the S1 directory: env-setup-for-tomcat.bat
5. Copy and paste the commands below on a command prompt and hit enter:
cd c:\csj\s1\
env-setup-for-tomcat.bat
:wait
cd c:\apache-tomcat-7.0.34\bin\
startup.bat

6. Once the Tomcat environment is running, navigate to http://localhost/csj/Main.jsp ****Use Firefox or Chrome****
7. The credentials are below: 
 ("test", "password", "customer"));
 ("test2", "password", "customer"));
 ("Hernandezo", "temp1234", "customer"));
 ("Jonesj", "password", "customer"));
 ("Badera", "project", "manager"));
 ("Garciaa", "password1234", "manager"));
 ("Smithj", "test1234", "account"));
 ("Chenk", "pw1234", "technical"));
 ("Petersf", "test123", "account"));
 ("Hernandezg", "pw123", "technical")); 

Project Implementation

Total lines of code (JS, JSP, Java, html, CSS): 3,790 

HTML to code ratio: Less than 10%

Requirements implemented:

* Build an application that will be used to enroll in a plan or to order services/PPV events
* Implement four different roles/logins/webpages:
1. Managers
2. Account Specialists (Customer Support)
3. Technical Support Specialists (Technician)
4. Customers
* A manager has all privileges and can cancel/update/delete any type of order
* Account Specialist can:
1. Create an account for a new customer
2. Update customer account
3. Create an incident ticket and assign it to a Technician
4. Place an order of a PPV
* Technical Support Specialist can:
1. Schedule incident ticket
2. Close incident ticket
3. Cancel incident ticket
* A customer that has an existing account can:
1. Update Record (credit card, personal info, etc.)
2. Pay Monthly Bill
3. Order a PPV event
4. Cancel an ordered PPV 
5. Change TV or Internet plan
* The users/customers have a valid login and password. Hard-coded logins/passwords in HashMap data structure.


Requirements attempted:

* A manager has all privileges and can cancel/update/delete any type of order
1. Did not have time to complete the function to process a customer payment

Requirements excluded:

* PPV Live Sports Events
1. Hard-Code 10 Events – only one was hard coded
* PPV Movies
1. Hard-Code 20 Movies – only one was hard coded
* Cancel an ordered PPV event 24 hours before the PPV date
1. Did not have time to implement a time stamp with an if statement to validate the time before allowing the customer to cancel 
* Cancel/Add Internet account
1. Completely overlooked this requirement until now






Orlando D Hernandez


