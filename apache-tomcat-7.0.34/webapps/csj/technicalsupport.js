var requestType;

var openTicketRequest;
var conatainer = "#technicalSupportContainer";
$( document ).ready(function() {
    
    $('#checkID').click(function(){
        requestType = "createIncident";
        var userID = $("input[name=userID]").val();
        console.log(userID);
        checkIfUserIDExists(userID)
    });
    
    $('#closeIncident').click(function(){
        requestType = "closeIncident";
        getOepnTickest();
    });

});

function checkIfUserIDExists(id){
    var ajaxURL = "./TechnicalSupport?action=checkID&userID=" + id;  
    $.get( ajaxURL, function( data ) {

        var html = "";
        if(data == "true"){
            console.log("yes:" + data);
            html += '<form name="technicalSupportForm" method="POST" action="./TechnicalSupport?action=addTicket">'
            html += 'User ID:'+
                '<input type="text" name="userID" value = "' + id +'"><br><br>' +
                'Description:<input type="textbox" name="description"><br><br>' +
                'Date/Time of Service Appointment:<input type="text" name="timeOfService"><br><br>' +
                '<input type="submit" value="Submit">';
            html += '</form>';
            $('#technicalSupportContainer').html(html);
        }else{
            console.log("No:" + data);
            html += '<div>Sorry! User ID doesn not exist</div>';
            setNewForm(html);
        }
            
    });
}

function setNewForm(html){
            html += 'User account look up:<input type="text" name="userID"><br><br><input type="submit" value="Submit" id = "checkID">';
            $('#technicalSupportContainer').html(html);
            $('#checkID').click(function(){
                requestType = "createIncident";
                var userID = $("input[name=userID]").val();
                checkIfUserIDExists(userID)
            });
}

function getOepnTickest(){
    var url = "./TechnicalSupport?action=getOpenTickets";
    openTicketRequest = initRequest();
    openTicketRequest.open("GET", url, true);
    openTicketRequest.onreadystatechange = callbackForOpenTickets;
    openTicketRequest.send(null);
}

function callbackForOpenTickets(){
    if (openTicketRequest.readyState == 4) {
        if (openTicketRequest.status == 200) {          
            parseOpenTickets(openTicketRequest.responseXML);
        }
    }
}

function parseOpenTickets(responseXML){
    if (responseXML == null) {
        $(conatainer).html("Sorry!Information not found");
        return;
    } else {
        var html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        var tickets = responseXML.getElementsByTagName("Tickets")[0];
        if (tickets.childNodes.length > 0) {    
            for (var loop = 0; loop < tickets.childNodes.length; loop++) {
                var ticket = tickets.childNodes[loop];
                var userID = ticket.getElementsByTagName("UserID")[0].childNodes[0].nodeValue;
                var timeOfService = ticket.getElementsByTagName("TimeOfService")[0].childNodes[0].nodeValue;
                var Description = ticket.getElementsByTagName("Description")[0].childNodes[0].nodeValue;
                
                html += "<tr>"; 
                html += '<td class = "userID">' + userID + "</td>"
                html += '<td class = "description">' + Description + "</td>"
                html += '<td class = "timeOfService">' + timeOfService + "</td>"
                html += '<td><button type = "submit" class = "closeTicket">Close Ticket</button></td>'
                html += "<tr>"; 
            }
        }
        html += "</table>";
    }
    $(conatainer).html(html);
    closeTicketListener();
}

function closeTicketListener(){
    $('.closeTicket').click(function(event){
        var target = $( event.target );
        var description = target.closest('tr').find('.description').text();
        var time = target.closest('tr').find('.timeOfService').text();
        var userID = target.closest('tr').find('.userID').text();
              
        sendCloseTicketRequest(userID,description,time);
        var closesttd = target.closest('td');
        target.remove();
        closesttd.html("Ticket Closed");
    });
}

function sendCloseTicketRequest(userID,description,time){
    var ajaxURL = "./TechnicalSupport?action=closeTicket&userID=" + userID + "&timeOfService=" + time
    + "&description=" + description;  
    $.get( ajaxURL, function( data ) {
       
    });
}