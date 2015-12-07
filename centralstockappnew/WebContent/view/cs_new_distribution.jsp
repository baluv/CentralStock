<%@include file="include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Stock</title>
<script language="javaScript" type="text/javascript" src="../view/js/calendar.js"></script>
<link href="../view//style/calendar.css" rel="stylesheet" type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />  

<style type="text/css">
table.example2 {background-color:transparent;border-collapse:collapse;width:50%;}
table.example2 th, table.example2 td {border:1px solid black;}
table.example2 th {background-color: #D9D9D9;}
table.example2 td:first-child {width:5%;}
</style>

<style type="text/css">
table.example1 {background-color:transparent;border-collapse:collapse;width:50%;}
table.example1 tr, table.example1 td {border:1px solid black;}
.combo {  background-color: #FFFFE8}
</style>

<script>
 function validateForm()
{
  var x=document.forms["distribution"]["issuedDate"].value;
  var y=document.forms["distribution"]["receivedperson"].value;
  if (x==null || x=="" )
    {
      alert("please enter fromDate");
      return false;
    }
  if (y==null || y=="")
    {
      alert("please enter Recieved Person name");
      return false;
    }
 }
 </script>
</head>
<body>
<c:url var="saveDistributionURL" value="/stock/saveDistribution.html" />
<form:form modelAttribute="distribution" action="${saveDistributionURL}" id="distribution" name="distribution" onsubmit="return validateForm();" method="post">
<table width="500" align="left" cellpadding="20" cellspacing="10" >
    <tr>
      <th colspan="2" align="center" bgcolor="#D9D9D9">Enter the Issued Stock Details</th>
    </tr>
	<tr>
	  <td align="right">Name of the Institution:</td>
	  <td><select name="insName" class="combo" >
             <option >Select Institution</option>
             <option >Centeral Admin</option>
             <option >Dental College</option>
             <option >Dental College Boys Hostel</option>
             <option >Dental College Girls Hostel</option>
             <option >Kalinagara Nursing Hostel</option>
             <option >Nursing college Building Boys Hostel</option>
             <option >Nursing college Building Girls Hostel</option>
             <option >Nursing college</option>
             <option >MMPS School</option>
		  </select></td>
	</tr>
	<tr>
	  <td align="right">Issued Date:</td>
	  <td><input type="text"  class="datepicker" name="issuedDate" readonly="readonly" style="width: 243px"/></td>
	</tr>
	<tr>
	  <td align="right">Received Person:</td>
	  <td><input type="text" name="receivedperson" style="width: 243px"/></td>
	</tr>
	</table>
  <table width="500" align="center" cellpadding="10" cellspacing="10">
      <tr>
		<td width="280" align="right"><input type="submit" value="Next" style="width: 70px"/></td>
		<td><input type="reset" value="clear" style="width: 70px"/></td>
	  </tr>

	</table>
</form:form>

</body>
</html>