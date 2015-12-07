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
	/* width: 50%; */
}

table.example2 th,table.example2 td {
	border: 1px solid black;
}

table.example2 th {
	background-color: #D9D9D9;
}

table.example2 td:first-child {
/* 	width: 50%; */
}
</style>

</head>
<body>
<c:url var="updateStovkItemsURL" value="/stock/updateStockItems.html" />
<form:form modelAttribute="stockitem" action="${updateStovkItemsURL}" method="post">
	<table width="500" align="center" cellpadding="20" cellspacing="10">
		<tr>
		  <th colspan="2" align="center" bgcolor="#D9D9D9">Edit the Received Stock Item Details</th>
		</tr>
		<tr>
	   </tr>
	</table>
	<c:if test="${!empty editstock}">
	<table class="example2" width="500" align="center">
		<tr>
		    <th></th>
			<th title="Received Stock Item Details ID ">RSI ID</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
			<th>Amount</th>
		</tr>
			<c:forEach items="${editstock}" var="item">
				<tr>
					<td><input type="hidden" name="invoiceNumber" value="${item.invoiceNumber}" readonly="readonly" /></td>
					<td><input type="text" name="sno" size="2" value="${item.sno }" readonly="readonly"></td>
					<td ><input type="text" name="category" size="10" value="${item.category}" readonly="readonly" ></td>
					<td ><input type="text" name="itemName" size="15" value="${item.itemName}"  readonly="readonly"/></td>
					<td ><input type="text" name="quantity" size="12" value="${item.quantity}"/></td>
					<td ><input type="text"  name="units" size="5" value="${item.units}" readonly="readonly"/></td>
					<td><input type="text" name="amount" size="8" value="${item.amount}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<br>
	<table width="420" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td align="right"><input type="submit" value="Save Changes"/></td>
			<td align="left"><input type="reset" value="clear" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>