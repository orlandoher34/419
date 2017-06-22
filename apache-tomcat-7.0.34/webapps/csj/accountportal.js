var requestType;

var accountRequest;
var accountConatainer = "#accountSpecialistContainer";
$( document ).ready(function() {
    
    $('#createAccount').click(function(){
        requestType = "createAccount";
        handleCreateAccountRequest();
    });
   
});

function handleCreateAccountRequest(){
     var html = '<form name="AccountSpecialist" method="POST" action="./AccountSpecialist?action=createAccount">';
     html += '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';

                html += "<tr>";
                html += "<td>User ID</td>";
                html += '<td><input type = "text" name = "userID" ></td>';
                html += "</tr>";               

                html += "<tr>";
                html += "<td>password</td>";
                html += '<td><input type = "text" name = "password" ></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>First Name</td>";
                html += '<td><input type = "text" name = "firstName" ></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Last Name</td>";
                html += '<td><input type = "text"  name = "lastName" ></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Address</td>";
                html += '<td><input type = "text" name = "address" ></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Email</td>";
                html += '<td><input type = "text" name = "emailID" ></td>';
                html += "</tr>";
                
                html += "<tr>";
                html += "<td>Credit Card Number</td>";
                html += '<td><input type = "text"  name = "creditCard" ></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Telephone Number</td>";
                html += '<td><input type = "text" name = "telNum" ></td>';
                html += "</tr>";

                html += "<tr>";
                html += "<td>Zip Code</td>";
                html += '<td><input type = "text" name = "zip"  ></td>';
                html += "</tr>";
            
        
        html += "</table>";
        html+='<center><input type="submit" value="Submit"></center></form>';
    $(accountConatainer).html(html);
}