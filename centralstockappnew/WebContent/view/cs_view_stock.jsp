<%@include file="include.jsp"%>
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
	width: 50%;
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
</head>
<body>
<c:url var="searchItemURL" value="/stock/search.html" />
<form:form modelAttribute="itemSearch" action="${searchItemURL}" method="post">
	<table width="500" align="left" cellpadding="10" cellspacing="10">
		<tr>
		  <td align="center" bgcolor="#D9D9D9">Search Bill Details by Invoice Number</td>
		  <td><input type="text" name="invoiceNumber"></td>
		</tr>
		<tr>
		  <td>
			<center>(OR)</center>
		  </td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D9D9D9">Search Item Details by Item Name</td>
			<td><c:if test="${!empty list}">
				<select name="itemName" class="combo" style=" width:175px">
				<c:forEach items="${list}" var="item">
				   <option><c:out value="${item.itemName}"></c:out></option>
				</c:forEach>
				</select>
				</c:if></td>
		</tr>
		<tr>
		  <td></td>
		  <td align="center"><input type="submit" value="Search" style="width: 70px"/></td>
		</tr>
	</table>
</form:form>
<br>
<br>
<c:if test="${!empty stockbill}">

	<table class=" example2">
		<tr>
			<th>Invoice Number</th>
			<th>Vendor Name</th>
			<th>Invoice Date</th>
			<th>Delivery Date</th>
			<th>Total Amount</th>
		</tr>
		<c:forEach items="${stockbill}" var="item">
			<tr>
				<td align="center"><c:out value="${item.invoiceNumber}" /></td>
				<td align="center"><c:out value="${item.vendorName}" /></td>
				<td align="center"><c:out value="${item.invoiceDate}" /></td>
				<td align="center"><c:out value="${item.deliveryDate}" /></td>
				<td align="center"><c:out value="${item.totalAmount}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br>

<c:if test="${!empty stockItems}">
	<table class=" example2">
		<tr>
			<th>RSI ID</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${stockItems}" var="item" >
		<tr>
			
				<td align="center"><c:out value="${item.sno}" /></td>
				<td align="center"><c:out value="${item.category}" /></td>
				<td align="center"><c:out value="${item.itemName}" /></td>
				<td align="center"><c:out value="${item.quantity}" /></td>
				<td align="center"><c:out value="${item.units}" /></td>
				<td align="center"><c:out value="${item.amount}" /></td>
			
		</tr>
		</c:forEach>
	</table>
</c:if>
<br>

<c:if test="${!empty itemlist}">
	<table class=" example2">
		<tr>
			<th>Item Name</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
		<c:forEach items="${itemlist}" var="item">
			<tr>
				<td align="center"><c:out value="${item.itemName}" /></td>
				<td align="center"><c:out value="${item.category}" /></td>
				<td align="center"><c:out value="${item.quantity}" /></td>
				<td align="center"><c:out value="${item.units}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>