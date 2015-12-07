<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javaScript" type="text/javascript" src="../view/js/calendar.js"></script>
<link href="../view//style/calendar.css" rel="stylesheet" type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />

<style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	width: 50%;
}
table.example2 th,table.example2 td {
	border: 1px solid black;
	padding: 0.5%;
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 th:first-child {
	width: 8%;
}
</style>

<style type="text/css">
table.example1 {
	background-color: transparent;
	border-collapse: collapse;
	width: 50%;
}
table.example1 tr,table.example1 td {
	border: 1px solid black;
	padding: 0.5%;
}
</style>

</head>
<body>
<table width="500" align="left" cellpadding="20" cellspacing="10">
	<tr>
		<th colspan="2" align="center" bgcolor="#D9D9D9">The Request Stock Item Details</th>
	</tr>
</table>
<br>
<c:if test="${!empty requestOrderList}">
	<table class="example2">
		<tr>
			<th title="Request Details ID">RD ID</th>
			<th>Institution Name</th>
			<th>Ordered Date</th>
			<th>Ordered Person</th>
		</tr>
		<tr>
			 <td align="center" width="8%"><c:out value="${rid}"></c:out></td>
			 <td align="center" width="34%"><c:out value="${insName}" /></td>
			 <td align="center" width="24.5%"><c:out value="${orderedDate}" /></td>
			 <td align="center"><c:out value="${orderedPerson}" /></td>
		</tr>
	</table>
  <br>
	<table class="example2">
		<tr>
			<th title="Request Item Details ID">RID ID</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
		<c:forEach items="${requestOrderList}" var="item">
			<tr>
				<td width="7%" align="center"><c:out value="${item.sno}"></c:out></td>
				<td width="16.5%" align="center"><c:out value="${item.category}" /></td>
				<td width="20%" align="center"><c:out value="${item.itemName}" /></td>
				<td width="15%" align="center"><c:out value="${item.quantity}" /></td>
				<td width="10%" align="center"><c:out value="${item.units}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<th colspan="2" align="right"><strong><a href="saveOrderedItemsExcelFormate.html?rid=${rid}&insName=${insName}&orderedDate=${orderedDate}&orderedPerson=${orderedPerson}">Save In Excel Format</a></strong></th>
		</tr>
	</table>
</body>
</html>