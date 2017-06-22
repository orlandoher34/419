<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="customerPortal.js"></script>
  <script src="technicalsupport.js"></script>
<center><img src="telecom.png" alt="WideCast Telecom" width="128" height="128"></center>
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
<H1 ALIGN="CENTER">WideCast Cable</H1>
<H3 ALIGN="CENTER"><i>We provide Entertainment for more</i></H3>
<br>
<H3 ALIGN="CENTER"><i>Incident Management Portal</i></H3>
<br>
<br>
<a id = "createIncident" onclick = 'setNewForm("")'>Create Incident&nbsp;|</a>
<a id = "closeIncident">&nbsp;Close Incident&nbsp;|</a>
<a href="Main.jsp">&nbsp;Logout</a>
				<br>
				<br>
<div id = "technicalSupportContainer">
  User account look up:
  <input type="text" name="userID"><br>
  <br>
    <input type="submit" value="Submit" id = "checkID">

</div>
<br>
<br>
<br>
<br>	
<h3>Real-time call volume per region:</h3>
<div id="graphDiv1"></div>

	<div id="graphDiv2"></div>
	<!--[if IE]><script src="excanvas.js"></script><![endif]-->
	<script src="html5-canvas-bar-graph.js"></script>
	<script>(function () {

		function createCanvas(divName) {
			
			var div = document.getElementById(divName);
			var canvas = document.createElement('canvas');
			div.appendChild(canvas);
			if (typeof G_vmlCanvasManager != 'undefined') {
				canvas = G_vmlCanvasManager.initElement(canvas);
			}	
			var ctx = canvas.getContext("2d");
			return ctx;
		}
		
		var ctx = createCanvas("graphDiv1");
		
		var graph = new BarGraph(ctx);
		graph.maxValue = 30;
		graph.margin = 2;
		graph.colors = ["#49a0d8", "#d353a0", "#ffc527", "#df4c27"];
		graph.xAxisLabelArr = ["Northeast", "Midwest", "West", "South"];
		setInterval(function () {
			graph.update([Math.random() * 6.5, Math.random() * 15.0, Math.random() * 3.5, Math.random() * 20.9]);
		}, 1000);
		
		

	}());</script>
</body>
</html>