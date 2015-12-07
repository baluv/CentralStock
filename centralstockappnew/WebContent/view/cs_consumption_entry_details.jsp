<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
  
   <script>
 function validateForm()
{
  var x=document.forms["consumption"]["issuedDate"].value;
  var y=document.forms["consumption"]["enteredby"].value;
   if (x==null || x=="" )
    {
      alert("please enter Issued Date");
      return false;
    }
  if (y==null || y=="")
    {
      alert("please enter the Name of Person Entered");
      return false;
    }
 }
 </script>
  
</head>
<body>
<div id="container">
		<div id="logo">
		<h1><a href="ins_home.html">Central Stock</a></h1>
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
<c:url var="saveConsumptionDetailsURL" value="/stock/saveConsumptionDetails.html" />
<form:form modelAttribute="consumption" action="${saveConsumptionDetailsURL}" name="consumption" id="consumption"  onsubmit="return validateForm();" method="post"  >
<table width="500" align="left" cellpadding="20" cellspacing="10" >
    <tr>
       <th colspan="2" align="center" bgcolor="#D9D9D9">Enter the Consumption Details</th>
    </tr>
	<tr>
		<td align="right">Institution Name:</td>
		<td><input type="text"  name="insName" value="${insName}" readonly="readonly"/>
	</tr>
	<tr>
		<td align="right">Date:</td>
		<td><input type="text"  class="datepicker" name="issuedDate" readonly="readonly"/>
	</tr>
	<tr>
		<td align="right">Entered By:</td>
		<td><input type="text" name="enteredby" /></td>
	</tr>
</table>
	<br>
<table width="550" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td align="right"><input type="submit" value="Next" style="width: 50px"/></td>
			<td><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>

	</table>
	</form:form>
</body>

</html>