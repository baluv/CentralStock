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
<script language="javaScript" type="text/javascript" src="../view/js/calendar.js"></script>
<link href="../view//style/calendar.css" rel="stylesheet" type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />

<style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	/*  width: 50%;  */
}
table.example2 th,table.example2 td {
	border: 1px solid black;
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 td:first-child {
	width: 5%;
}
</style>

<style type="text/css">
table.example1 {
	background-color: transparent;
	border-collapse: collapse;
	/* width: 50%; */
}
table.example1 tr,table.example1 td {
	border: 1px solid black;
}
.combo {
	background-color: #FFFFE8
}
table.example2 td:first-child {
	width: 7%;
}
</style>

<script>
function validateForm()
{
    if(document.stockitem.sno.value=="")
    {
      alert(" Enter seriel_number ");
      document.stockitem.sno.focus();
      return false;
    }
    else  if (document.forms["stockitem"].category.value == "0")
    {
     alert("Select category");
      document.stockitem.category.focus();
      return false;
    }
    else  if (document.forms["stockitem"].itemName.value == "0")
    {
     alert("Select itemName");
      document.stockitem.itemName.focus();
      return false;
    }
    else if(document.stockitem.quantity.value=="")
    {
      alert("Quantity must not be empty");
      document.stockitem.quantity.focus();
      return false;
    }
     else  if (document.forms["stockitem"].units.value == "0")
    {
     alert("Select Units");
      document.stockitem.units.focus();
      return false;
    }
     else if(document.stockitem.amount.value=="")
    {
      alert("Amount should not be Empty");
      document.stockitem.amount.focus();
      return false;
    }
}
</script>

</head>
<body>

<c:url var="saveStovkItemsURL" value="/stock/saveStockItems.html" />
<form:form modelAttribute="stockitem" action="${saveStovkItemsURL}" id="stockitem" name="stockitem" onSubmit="return validateForm()" method="post">
	<table width="500" align="center" cellpadding="20" cellspacing="10">
		<tr>
		  <th colspan="2" align="center"  bgcolor="#D9D9D9">Enter the Received Stock Item Details</th>
		</tr>
		<tr>
		  <td align="center"><b>Invoice Number:-</b><b style="color: red">${invoiceNumber}</b></td>
		  <td><input type="hidden" name="invoiceNumber" value="${invoiceNumber}" readonly="readonly" /></td>
		</tr>
	</table>
	<br>
	
	<b>Enter Stationary Details Here:-</b>
 	<table class="example2" width="500" align="center">
		<tr>
		  <th></th> 
		  <th></th> 
		  <th>Item Name</th>
		  <th>Quantity</th>
		  <th>Units</th>
		  <th>Amount</th>
		</tr>
		<tr>
		  <td><input type="hidden" name="sno" size="3"></td>
		  <td><input type="hidden" name="category" value="Stationary" size="3"></td>
		  <td><c:if test="${!empty list1}">
			 <select name="itemName" class="combo">
				<option value="0">Select Item Name</option>
				<c:forEach items="${list1}" var="item">
				<option><c:out value="${item.itemName}"></c:out></option>
				</c:forEach>
				</select></c:if></td>
		  <td><input type="text" name="quantity"></td>
		  <td><select name="units" class="combo">
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
		<td><input type="text" name="amount" ></td>
		</tr>
	</table>
	<br>
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
		  <td align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
		  <td align="left"><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>
	</table>
</form:form>

<c:url var="saveStovkItemsURL" value="/stock/saveStockItems1.html" />
<form:form modelAttribute="stockitem" action="${saveStovkItemsURL}" id="stockitem" name="stockitem" onSubmit="return validateForm()" method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
		 <td><input type="hidden" name="invoiceNumber" value="${invoiceNumber}" readonly="readonly" /></td>
		</tr>
	</table>
	<br>
	<br>
	<b>Enter Cleaning Details Here:-</b>
	<table class="example2" width="200">
		<tr>
		  <th></th>
		  <th></th>
		  <th>Item Name</th>
		  <th>Quantity</th>
		  <th>Units</th>
		  <th>Amount</th>
		</tr>
		<tr>
         <td><input type="hidden" name="sno" size="3"></td>
         <td><input type="hidden" name="category" value="Cleaning" size="3"></td>
		  <td><c:if test="${!empty list2}">
			  <select name="itemName" class="combo">
				 <option value="0">Select Item Name</option>
				 <c:forEach items="${list2}" var="item">
				 <option><c:out value="${item.itemName}"></c:out></option>
				 </c:forEach>
			  </select>
			  </c:if></td>
			<td><input type="text" name="quantity"></td>
			<td><select name="units" class="combo">
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
		  <td><input type="text" name="amount"></td>
		</tr>
	</table>
	<br>
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
		  <td align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
		  <td align="left"><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>
	</table>
</form:form>

<c:url var="deleteUrl" value="stock/deleteStockItem.html" />
<c:if test="${!empty stockList}">
	<table class="example2" width="590"  align="center">
		<tr>
		  <th title="Received Stock Item Details ID ">RSI ID</th>
		  <th>Category</th>
		  <th>Item Name</th>
		  <th>Quantity</th>
		  <th>Units</th>
		  <th>Amount</th>
		  <th>Edit</th>
		  <th>Delete</th>
		</tr>
		<c:forEach items="${stockList}" var="item">
		<tr>
		  <td width="7%" align="center"><c:out value="${item.sno}"/></td>
		  <td width="12%" align="center"><c:out value="${item.category}"/></td>
		  <td width="20%" align="center"><c:out value="${item.itemName}"/></td>
		  <td width="10%" align="center"><c:out value="${item.quantity}"/></td>
		  <td width="10%" align="center"><c:out value="${item.units}" /></td>
		  <td width="13%" align="center"><c:out value="${item.amount}" /></td>
		  <td width="7%" align="center"><a href="/centralstockappnew/stock/editStockItems.html?sno=${item.sno}&invoiceNumber=${item.invoiceNumber}&category=${item.category}&itemName=${item.itemName}&quantity=${item.quantity}&units=${item.units}">Edit</a></td>
		  <td width="8%" align="center"><a href="/centralstockappnew/stock/deleteStockItems.html?sno=${item.sno}&invoiceNumber=${item.invoiceNumber}&category=${item.category}&itemName=${item.itemName}&quantity=${item.quantity}&units=${item.units}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<br>
<br>
</body>
</html>