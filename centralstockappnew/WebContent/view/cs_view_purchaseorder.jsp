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
		<th colspan="2" align="center" bgcolor="#D9D9D9">The Request Stock Details</th>
	</tr>
	<tr>
		<td colspan="2" align="center" ><a href="viewPurchaseIns.html"><strong>Request Order Details By Institution</strong></a></td>
	</tr>
</table>

<c:if test="${!empty orderList}">
	<table class="example2">
		<tr>
			<th title="Request Details ID">RD ID</th>
			<th>Institution Name</th>
			<th>Ordered Date</th>
			<th>Ordered Person</th>
		</tr>
		<c:forEach items="${orderList}" var="item">
			<tr>
				<td align="center" width="8%"><a href="/centralstockappnew/stock/requestOrderList.html?rid=${item.rid}&insName=${item.insName}&orderedDate=${item.orderedDate}&orderedPerson=${item.orderedPerson}"><c:out value="${item.rid}"></c:out></a></td>
				<td align="center" width="34%"><c:out value="${item.insName}"/></td>
				<td align="center" width="24.5%"><c:out value="${item.orderedDate}"/></td>
				<td align="center"><c:out value="${item.orderedPerson}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>

</body>
</html>