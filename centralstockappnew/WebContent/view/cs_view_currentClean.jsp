<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@page import="java.util.*" %>

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
  
  
  <style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	/* width: 50%; */
}
table.example2 th,table.example2 td {
	border: 1px solid black;
	/* width: 10% */
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 td:first-child {
/* 	width: 10%; */
}
</style>
  
   <script>
 function validateForm()
{
  var x=document.forms["requestOrder"]["orderedDate"].value;
  var y=document.forms["requestOrder"]["orderedPerson"].value;

    
   if (x==null || x=="" )
    {
      alert("please enter Ordered Date");
      return false;
    }
  if (y==null || y=="")
    {
      alert("please enter the Name of Ordered Person");
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
					<!-- 	<li><a href="#">View Request Order</a></li> -->
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
		
		<table width="500" align="left" cellpadding="20" cellspacing="10">
	<tr>
		<th colspan="2" align="center" bgcolor="#D9D9D9">The Cleaning Stock Details</th>
	</tr>
	<%-- <tr>
		<td colspan="2" align="center" ><a href="viewDistributionIns.html"><strong> Present
		Cleaning Items Avalaible in ${insName}</strong></a></td>
	</tr> --%>
</table>
<br><br>
<%
ArrayList f1=(ArrayList)request.getAttribute("fl");
Map list1=(HashMap)f1.get(0);
Map list2=(HashMap)f1.get(1);
//String[] l1=(String[])list1.toArray(new String[list1.size()]);
//String[] l2=(String[])list2.toArray(new String[list2.size()]);

request.setAttribute("list23", list1);
request.setAttribute("list24", list2);

%>
<br><br>
<table class="example2" cellpadding="10" cellspacing="10" width="400">     
     <tr>     
         <th width="60">S.NO</th>
         <th>Item Name</th>     
         <th width="100">Quantity</th>
     </tr>     
          <c:set var="numberOfRows" value="0"/>
          <c:forEach var="map" items="${list23}">    
 		  <c:forEach var="map1" items="${list24}">  
 		  <c:if test="${map.key==map1.key}"> 	
 		  <c:set var="numberOfRows" value="${numberOfRows+1}"/>			        
 	 <tr>  
 		  <td>${numberOfRows}</td>
          <td>${map.key}</td>
          <td>${map.value-map1.value}</td>   
     </tr>
 		  </c:if>
          </c:forEach>  
          </c:forEach>     
 </table> 
         <br><br>    
</body>
</html>