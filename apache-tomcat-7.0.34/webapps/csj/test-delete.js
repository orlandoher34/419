var req;
var isIE;
var userID;
var xmlOutput = null;
var accountContainer = 'accountSpecialistContainer';
var requestType;
var ppvNames = ["Star Wars XX - The big fight", "Boxing - Pacquiao VS Mayweather #4"];
var ppvIDList = ["starwars", "boxing"];
var tvPlanIDList = ["basic","medium","elite"];
var resultContainer = '#resultContainer';
var tvPlanNamesList = ["Basic Internet/Cable TV $50/mo","Internet/Cable TV $75/mo","Elite Internet/Cable TV $100/mo"];
$( document ).ready(function() {
    
    $('#editAccount').click(function(){
        openForm();
    });
    
    $('#createTicket').click(function(){
        createTicketForUser();
    });
	
	    $('#payAccount').click(function(){
        openForm();
    });
    
});

function openForm(){
    var html = '<div><input type = "text" name = "userID" id = "inputUserID">Enter UserID</div><div>'+
            '<button onclick = "initializeClickListeners()">Submit</button></div>'
    $('#'+accountContainer).html(html);
}

function createTicketForUser(){
    var html = '<form name="technicalSupportForm" method="POST" action="./TechnicalSupport?action=addTicket&redirectPage=accountSpecialist">'
            html += 'User ID:'+
                '<input type="text" name="userID"><br><br>' +
                'Description:<input type="text" name="description"><br><br>' +
                'Time of Service<input type="text" name="timeOfService"><br><br>' +
                '<input type="submit" value="Submit">';
            html += '</form>';
            $('#' + accountContainer ).html(html);
}

function initializeClickListeners(){
    userID = $('#inputUserID').val();
    console.log(userID);
    var html =  '<div><a id = "orderPPV">Order PPV</a></div>'+
            '<a id = "cancelPPV">Cancel PPV</a>'+ 
            '<div><a id = "tvPlan">Manage TV/Internet Plan</a></div><div id = "resultContainer"></div>';
    
    $('#' + accountContainer).html(html);
    
    console.log($('#cancelPPV').text());
    $('#cancelPPV').click(function(){
        requestType = "cancelPPV";
        getSubscriptionData();
    });
    
    $('#orderPPV').click(function(){
        requestType = "orderPPV";
        getSubscriptionData();
    });
    
    $('#tvPlan').click(function(){
        requestType = "tvPlan";
        getSubscriptionData();
    });
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

function getSubscriptionData (){
    
    var url = "./EditAccount?action=getSubscription&userID=" + userID;
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callbackSubscription;
    req.send(null);
    
};

function getPaymentDetails (){
    
    var url = "./PayAccount?action=getAmount&userID=" + userID;
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callback;
    req.send(null);
    
};

function callbackSubscription() {

    if (req.readyState == 4) {
        if (req.status == 200) {
            if(requestType == "cancelPPV")
                handleCancelRequest();
            else if(requestType == "orderPPV")
                handleOrderRequest();
            else
                handleTVPLanRequest();
        }
    }
}

function handleCancelRequest(){
    var responseXML = req.responseXML;
    xmlOutput = req.responseXML;
    if (responseXML == null) {
        $(resultContainer).html("Sorry!Information not found. ");
        return;
    } else {
        var html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        var subscription = responseXML.getElementsByTagName("Subscription")[0];
        var ppvList = subscription.childNodes[0];
        for(loop = 0; loop < ppvList.childNodes.length; loop++){
            var ppv = ppvList.childNodes[loop];
            var ppvName = ppv.getElementsByTagName("PPVName")[0].childNodes[0].nodeValue;
            var ppvID = ppv.getElementsByTagName("PPVID")[0].childNodes[0].nodeValue;
            html += "<tr>"; 
            html += "<td>" + ppvName + "</td>"
            html += '<td><button id ="'+ ppvID +'" class = "cancelPPV">Cancel Order</button></td>';   
        }
        html += "</table>";
    }
    $(resultContainer).html(html);
    cancelPPVListener();
}


function cancelPPVListener(){
    $('.cancelPPV').click(function(event){
        ppvCancelRequest(event.target.id);
        $('#' + event.target.id).closest('tr').remove();
    });
}

function ppvCancelRequest(ppvID){
    var ajaxURL = "./EditAccount?action=cancelPPV&ppvID=" + ppvID + '&userID=' + userID;  
    $.get( ajaxURL, function( data ) {
    });
}

function handleOrderRequest(){
    var responseXML = req.responseXML;
    xmlOutput = req.responseXML;
    if (responseXML == null) {
        $(resultContainer).html("Sorry!Information not found");
        return;
    } else {
        var orderedList = getOrderedPPVList(responseXML);
        var html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        for(var loop = 0; loop < ppvNames.length; loop++){
            var ppvName = ppvNames[loop];
            var ppvID = ppvIDList[loop];
            html += "<tr>"; 
            html += "<td>" + ppvName + "</td>"
            if(!isAlreadyAvailable(ppvID,orderedList))
                html += '<td><button id ="'+ ppvID +'" class = "orderPPV">Order</button></td>';   
            else
                 html += '<td id ="'+ ppvID +'">Already Ordered</td>';  
        }
        html += "</table>";
    }
    $(resultContainer).html(html);
    orderPPVListener();
}

function getOrderedPPVList(responseXML){
     var ppvOutputList = [];
     var subscription = responseXML.getElementsByTagName("Subscription")[0];
        var ppvList = subscription.childNodes[0];
        for(var loop = 0; loop < ppvList.childNodes.length; loop++){
            var ppv = ppvList.childNodes[loop];
            var ppvID = ppv.getElementsByTagName("PPVID")[0].childNodes[0].nodeValue;
            ppvOutputList.push(ppvID);
        }
        
        return ppvOutputList;
}

function isAlreadyAvailable(ppvID, orderedList){
    for(var i = 0; i < orderedList.length; i++){
        if(orderedList[i] == ppvID){
            return true;
        }
    }
    return false;
}

function orderPPVListener(){
    $('.orderPPV').click(function(event){
       sendOrderRequest(event.target.id);
       var elem = $('#' + event.target.id).closest('td');
       $('#' + event.target.id).remove();
       elem.html("Ordered");
    });
}

function sendOrderRequest(ppvID){
    var ajaxURL = "./EditAccount?action=orderPPV&ppvID=" + ppvID + '&userID=' + userID;  
    $.get( ajaxURL, function( data ) {
    });
}

function getAmount(){
    var ajaxURL = "./subscription?action=getAmount" + '&userID=' + userID;  
    $.get( ajaxURL, function( data ) {
	 amount = data;
    });
}

function payAmount(amount){
    var ajaxURL = "./subscription?action=pay" + '&userID=' + userID;  
    $.get( ajaxURL, function( data ) {
    });
}

function handleTVPLanRequest(){
    var responseXML = req.responseXML;
    xmlOutput = req.responseXML;
    if (responseXML == null) {
        $(resultContainer).html("Sorry!No Infomration is found");
        return;
    } else {
        var html = '<table class="table-responsive" style = "background-color: #f1f1c1; border: 1px solid black; width:100%;">';
        var subscription = responseXML.getElementsByTagName("Subscription")[0];
        var ppvList = subscription.childNodes[0];
        var tvPlanID = subscription.getElementsByTagName("TVID")[0].childNodes[0].nodeValue;
        var tvPlanName = subscription.getElementsByTagName("TV")[0].childNodes[0].nodeValue;
        
        for(var i = 0; i < tvPlanIDList.length; i++){
        
           var name = tvPlanNamesList[i];
           var id = tvPlanIDList[i];
           html += "<tr>"; 
           html += "<td>" + name + "</td>"
           if(id != tvPlanID)
               html += '<td><button id ="'+ id +'" class = "tvPlan">Update this Plan</button></td>';   
           else
               html += '<td id ="'+ id +'" class = "tvPlan">Selected Plan</td>';
        }
        
       
        html += "</table>";
    }
    $(resultContainer).html(html);
    tvPlanListener();
    
}

function tvPlanListener(){
    $('.tvPlan').click(function(event){
        tvPlanRequest(event.target.id);
        $('#' + event.target.id).closest('td').html("Updated Plan Successfully");
        requestType = "tvPlan";
        getSubscriptionData();
    });
}

function tvPlanRequest(id){
    var ajaxURL = "./EditAccount?action=tvPlan&tvID=" + id + '&userID=' + userID;  
    $.get( ajaxURL, function( data ) {
    });
}