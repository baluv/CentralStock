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
		<th colspan="2" align="center" bgcolor="#D9D9D9">The Distribution Stock Details</th>
	</tr>
	<tr>
		<td colspan="2" align="center" ><a href="viewDistributionIns.html"><strong> Distribution Stock Item Details By Institution</strong></a></td>
	</tr>
</table>
<c:if test="${!empty distAllList}">
	<table class="example2">
		<tr>
			<th title="Distribution Details ID">DD ID</th>
			<th>Institution Name</th>
			<th>Issued Date</th>
			<th>Received Person</th>
		</tr>
		<c:forEach items="${distAllList}" var="item">
			<tr>
				<td align="center" width="8%"><a href="/centralstockappnew/stock/allDistributionList.html?did=${item.did}&insName=${item.insName}&issuedDate=${item.issuedDate}&receivedperson=${item.receivedperson}"><c:out value="${item.did}"></c:out></a></td>
				<td align="center" width="34%"><c:out value="${item.insName}"/></td>
				<td align="center" width="24.5%"><c:out value="${item.issuedDate}"/></td>
				<td align="center"><c:out value="${item.receivedperson}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
</body>
</html>
