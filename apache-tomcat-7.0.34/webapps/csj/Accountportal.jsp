<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="accountportal.js"></script>
    <script src="accountSpecialistPPV.js"></script>
<center><img src="telecom.png" alt="WideCast Telecom" width="128" height="128"></center>
<title>WideCast Cable</title> 
<link rel="stylesheet" type="text/css" href="stylesheet.css">	
</head>
<body>
<%@ page import="beans.*, controller.CustomerCatalogBean" %>
 <%@ page import="servlet.CustomerController"  %>
 <%@ page import="mbeans.*, mcontroller.*" %>
 <%@ page import="mservlet.*"  %>
<nav class="topright">
<a href="Main.jsp">Home&nbsp;</a>
<a href="About.jsp">About Us&nbsp;</a>
<a href="Contact.jsp">Contact Us&nbsp;</a>
<a href="http://www.tvguide.com/">TV Guide</a>
</nav>	
<H1 ALIGN="CENTER">WideCast Cable</H1>
<H3 ALIGN="CENTER"><i>We provide Entertainment for more</i></H3>
<br>
<H3 ALIGN="CENTER"><i>Account Specialist Portal</i></H3>
<jsp:useBean id="servletBean" class="servlet.CustomerController" scope="session"></jsp:useBean>
<br>
<jsp:useBean id="customerBean" class="controller.CustomerCatalogBean" scope="session"></jsp:useBean>
<br>
<br>
<a id = "createAccount">Create Customer Account&nbsp;|</a>
<a id = "editAccount">&nbsp;Manage Customer Account&nbsp;|</a>
<a id = "createTicket">&nbsp;Create Customer Ticket&nbsp;|</a>
<a href="Main.jsp">&nbsp;Logout</a>
<br>
<br>
<div id = "accountSpecialistContainer">
    Please Select the tabs above to operate system.
</div>
</body>
</html>