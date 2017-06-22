<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<center><img src="telecom.png" alt="Hercom Telecom" width="128" height="128"></center>
    <title>WideCast Cable</title> 
		 <link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
<nav class="topright">
<a href="Main.jsp">Home&nbsp;</a>
<a href="About.jsp">About Us&nbsp;</a>
<a href="Contact.jsp">Contact Us&nbsp;</a>
<a href="http://www.tvguide.com/">TV Guide</a>
</nav>		
<%@ page import="beans.*, controller.CustomerCatalogBean" %>
 <%@ page import="servlet.CustomerController"  %>
<H1 ALIGN="CENTER">WideCast Cable</H1>
<H3 ALIGN="CENTER"><i>We provide Entertainment for more</i></H3>
		<jsp:useBean id="servletBean" class="servlet.CustomerController" scope="session"></jsp:useBean>
<br>
<H3 ALIGN="CENTER">Welcome!</H3>
<br>
<br>
<TABLE WIDTH="50%" border="1" cellspacing="3" cellpadding="3" align="center">
<tr>
<td>
<jsp:useBean id="customerBean" class="controller.CustomerCatalogBean" scope="session"></jsp:useBean>

<i>Customer Login</i>
<form name="customerform" method="POST" action="servlet/CustomerController?action=getaccount&position=customer">
  Username:
  <input type="text" name="userID"><br>
  Password:
  <input type="text" name="password"><br>
  <br>
    <input type="submit" value="Submit">
</form>
</td>
<td>
<i>Manager Login</i>
<br>
<form name="managerform" method="POST" action="servlet/CustomerController?action=getaccount&position=manager">
  Username:
  <input type="text" name="userID"><br>
  Password:
  <input type="text" name="password"><br>
  <br>
    <input type="submit" value="Submit">
</form>
</td>
<td>
<i>Account Specialist Login</i>
<br>
<form name="accountform" method="POST" action="servlet/CustomerController?action=getaccount&position=account">
  Username:
  <input type="text" name="userID"><br>
 Password:
  <input type="text" name="password"><br>
  <br>
    <input type="submit" value="Submit">
</form>
</td>
<td>
<i>Technical Support Login</i>
<br>
<form name="accountform" method="POST" action="servlet/CustomerController?action=getaccount&position=technical">
  Username:
  <input type="text" name="userID"><br>
 Password:
  <input type="text" name="password"><br>
  <br>
    <input type="submit" value="Submit">
</form>
</td>
</tr>
</TABLE>
</body>
</html>