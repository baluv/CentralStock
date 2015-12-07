<%@ include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Stock</title>
<script language="javaScript" type="text/javascript" src="..view/js/calendar.js"></script>
<link href="../style/calendar.css" rel="stylesheet" type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />

<style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	width: 15%;
}
table.example2 th,table.example2 td {
	border: 1px solid black;
	width: 10%
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 td:first-child {
	width: 10%;
}
</style>

<style type="text/css">
table.example1 {
	background-color: transparent;
	border-collapse: collapse;
	width: 30%;
}
table.example1 tr,table.example1 td {
	border: 1px solid black;
}
.combo {
	background-color: #FFFFE8
}
</style>

<script>
 function validateForm()
{
  if(document.item.itemName.value=="")
    {
      alert("Enter Item Name");
      document.item.itemName.focus();
      return false;
    }
     else if (document.forms["item"].category.value == "0")
    {
     alert("Select category");
      document.item.category.focus();
      return false;
    }
     else if(document.item.quantity.value=="")
    {
      alert("Quantity must not be empty");
      document.item.quantity.focus();
      return false;
    }
     else if (document.forms["item"].units.value == "0")
    {
     alert("Select Units");
      document.item.units.focus();
      return false;
      }
 }
 </script>

</head>
<body>
<%-- Enter New Item Name And Quantity Details --%>
   <c:url var="saveItemURL" value="/stock/save.html" />
   <form:form modelAttribute="item" action="${saveItemURL}" id="item" name="item" onsubmit="return validateForm();" method="post">
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
		  <th colspan="2" align="center" bgcolor="#D9D9D9">Enter New Item Name And Quantity Details</th>
		</tr>
		<tr></tr>
		<tr>
		  <td align="right">Item Name:</td>
		  <td><input type="text" name="itemName"/></td>
		</tr>
		<tr>
		  <td align="right">Category:</td>
		  <td><select name="category" class="combo" style="width: 173px">
				<option value="0">Select Category</option>
				<option>Stationary</option>
				<option>Cleaning</option>
			</select></td>
		</tr>
		<tr>
		  <td align="right">Quantity:</td>
		  <td><input type="text" name="quantity"></td>
		</tr>
		<tr>
		  <td align="right">Units:</td>
		  <td><select name="units" class="combo" style="width: 173px">
				<option value="0">Select Units</option>
				<option>no's</option>
				<option>bundles</option>
				<option>rolls</option>
				<option>pkts</option>
				<option>bottles</option>
				<option>box</option>
				<option>loos</option>
				<option>rolls</option>
				<option>kg</option>
				<option>sets</option>
				<option>ltrs</option>
				<option>nill</option>
			</select></td>
		</tr>
	</table>
	<table width="460" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td align="right"><input type="submit" value="Submit" style=" width: 50px"/></td>
			<td align="left"> <input type="reset" value="clear" style=" width: 50px"/></td>
		</tr>
		</table>
		<%-- This  error message is Item Saved successfully --%>
		<table width="800" align="right" cellpadding="10" cellspacing="10">
		<tr>
			<td><b><font color="green"><c:out value="${message}"></c:out></font></b></td>
		</tr>
	<%-- This error message for Item Already Existed!!!! --%>	
		<tr>
			<td></td>
			<td><b><font color="red"><c:out value="${errorMessage}"></c:out></font></b></td>
		</tr>
	</table>

</form:form>
</body>
</html>