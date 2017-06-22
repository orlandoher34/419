var req;
var isIE;
var paymentRequest = false;
var amount;
function getCustomerData (){
    var url = "servlet/CustomerInfoController?action=getAccountDetails";
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callback;
    req.send(null);
    
};

function getPaymentDetails(){
    paymentRequest = true;
    getCustomerData();
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callback() {

    if (req.readyState == 4) {
        if (req.status == 200) {
            if(!paymentRequest)
                parseResponse(req.responseXML);
            else
                paymentHandler(req.responseXML);
        }
    }
}

function parseResponse(responseXML){
 
    if (responseXML == null) {
        $('#customerInfoContent').html("Information not found.");
        return;
    } else {
        var html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        var customers = responseXML.getElementsByTagName("customers")[0];
        
        if (customers.childNodes.length > 0) {    
            for (loop = 0; loop < customers.childNodes.length; loop++) {
                var customer = customers.childNodes[loop];
                var firstName = customer.getElementsByTagName("FirstName")[0].childNodes[0].nodeValue;
                var lastName = customer.getElementsByTagName("LastName")[0].childNodes[0].nodeValue;
                var address = customer.getElementsByTagName("Address")[0].childNodes[0].nodeValue;
                var zipCode = customer.getElementsByTagName("Zip")[0].childNodes[0].nodeValue;
                var emailID = customer.getElementsByTagName("Email")[0].childNodes[0].nodeValue;
                var telNum = customer.getElementsByTagName("TelNumber")[0].childNodes[0].nodeValue;
                var creditCardNumber = customer.getElementsByTagName("CreditCard")[0].childNodes[0].nodeValue;

                html += "<tr>";
                html += "<td>First Name</td>";
                html += "<td>" + firstName + "</td>";
                html += "</tr>";

                html += "<tr>";
                html += "<td>Last Name</td>";
                html += "<td>" + lastName + "</td>";
                html += "</tr>";

                html += "<tr>";
                html += "<td>Address</td>";
                html += "<td>" + address + "</td>";
                html += "</tr>";

				html += "<tr>";
                html += "<td>Zip Code</td>";
                html += "<td>" + zipCode + "</td>";
                html += "</tr>";
				
				html += "<tr>";
                html += "<td>Telephone Number</td>";
                html += "<td>" + telNum + "</td>";
                html += "</tr>";
				
                html += "<tr>";
                html += "<td>Email</td>";
                html += "<td>" + emailID + "</td>";
                html += "</tr>";

                html += "<tr>";
                html += "<td>Credit Card Number</td>";
                html += "<td>" + creditCardNumber + "</td>";
                html += "</tr>";

            }
        }
        html += "</table>";
        html+='<center><button type="button" class="btn btn-primary" onClick = "editForm()">Edit Information</button></center>';
    }
    $('#customerInfoContent').html(html);

}

function paymentHandler(responseXML){
     if (responseXML == null) {
        $('#customerInfoContent').html("Information not found.");
        return;
    } else {
        var html = "";
        var ajaxURL = "./subscription?action=getAmount";  
        $.get( ajaxURL, function( data ) {
            amount = data;
        
        html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        var customers = responseXML.getElementsByTagName("customers")[0];
        html += "<tr><td><b>Credit Card</b></td><td><b>Account Balance</b></td></tr>";
        if (customers.childNodes.length > 0) {    
            for (loop = 0; loop < customers.childNodes.length; loop++) {
                var customer = customers.childNodes[loop];
                var creditCardNumber = customer.getElementsByTagName("CreditCard")[0].childNodes[0].nodeValue; 
                html += "<tr>";
                html += "<td>" + creditCardNumber + "</td>";
                html += '<td id = "amount">$' + amount + '.00</td>';
                html += "</tr>";
            }
        }
        html += "</table>";
        html+='<center><button type="button" class="btn btn-primary" onClick = "pay()">Pay</button></center>';
        $('#customerInfoContent').html(html);
        });
    }
    
    paymentRequest = false;
}

function pay(){
    $('#amount').html('$0.00');
    payAmount(0);
}
function editForm(){
    var responseXML = req.responseXML;
    var customers = responseXML.getElementsByTagName("customers")[0];
     var customer = customers.childNodes[0];
                var firstName = customer.getElementsByTagName("FirstName")[0].childNodes[0].nodeValue;
                var lastName = customer.getElementsByTagName("LastName")[0].childNodes[0].nodeValue;
                var address = customer.getElementsByTagName("Address")[0].childNodes[0].nodeValue;
                var zipCode = customer.getElementsByTagName("Zip")[0].childNodes[0].nodeValue;
                var emailID = customer.getElementsByTagName("Email")[0].childNodes[0].nodeValue;
                var telNum = customer.getElementsByTagName("TelNumber")[0].childNodes[0].nodeValue;
                var creditCardNumber = customer.getElementsByTagName("CreditCard")[0].childNodes[0].nodeValue;
      var html = '<form name="accountform" method="POST" action="servlet/CustomerInfoController?action=editInfo">';
      html += '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
    
                html += "<tr>";
                html += "<td>First Name</td>";
                html += '<td><input type = "text" name = "firstName" value = "' + firstName + '"></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Last Name</td>";
                html += '<td><input type = "text"  name = "lastName" value = "' + lastName + '"></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Address</td>";
                html += '<td><input type = "text" name = "address" value = "' + address + '"></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Email</td>";
                html += '<td><input type = "text" name = "emailID" value = "' + emailID + '"></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Credit Card Number</td>";
                html += '<td><input type = "text"  name = "creditCard" value = "' + creditCardNumber + '"></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Telephone Number</td>";
                html += '<td><input type = "text" name = "telNum" value = "' + telNum + '"></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Zip Code</td>";
                html += '<td><input type = "text" name = "zipCode"  value = "' + zipCode + '"></td>';
                html += "</tr>";
            
        
        html += "</table>";
        html+='<center><input type="submit" value="Submit"></center></form>';
        $('#customerInfoContent').html(html);
 }


function getAmount(){
    var ajaxURL = "./subscription?action=getAmount";  
    $.get( ajaxURL, function( data ) {
        amount = data;
    });
}

function payAmount(amount){
    var ajaxURL = "./subscription?action=pay";  
    $.get( ajaxURL, function( data ) {
    });
}