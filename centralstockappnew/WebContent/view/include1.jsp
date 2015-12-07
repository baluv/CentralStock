<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Stock</title>
<link href="../view//style.css" rel="stylesheet" type="text/css" /> 
<link rel="stylesheet" href="../view//jquery-ui.css" />
  <script src="../view/js/jquery-1.9.1.js"></script>
  <script src="../view/js/format.js"></script>
  <script src="../view/js/jquery-ui.js"></script>
</head>
<body>
<div id="container">
		<div id="logo">
		<h1><a href="home.html">Central Stock</a></h1>
</div>

<div id="main">
</div>
	
<div id="sidebar"><b>
		<ul class="sidelink">
		<li><a href="#">Stock Availability</a>
				<ul>
				    <li><a href="orgCurrentStock.html?organisation=${insName}">Current Stock</a></li>
					<li><a href="orgCurrentStat.html?organisation=${insName}">Stationary</a></li>
					<li><a href="orgCurrentClean.html?organisation=${insName}">Cleaning</a></li>
				</ul>
			</li>
					<li><a href="newRequestOrder.html">New Request Order</a></li>
						<!-- <li><a href="#">View Request Order</a></li> -->
					<li><a href="newConsumption.html">Consumption Entry</a></li>
					<li><a href="viewConsumption1.html">View Consumption Details</a></li>
			<li>
				<ul>
					<li><a href="login.html">Logout</a></li>
				</ul>
			</li>
		</ul>
		</b>
	</div>
	</div>
</body>
</html>