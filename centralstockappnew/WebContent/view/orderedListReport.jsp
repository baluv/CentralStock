<%@ page contentType="application/vnd.ms-word"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javaScript" type="text/javascript"
	src="../view/js/calendar.js"></script>
<link href="../view//style/calendar.css" rel="stylesheet"
	type="text/css" />
<link href="../view//style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	width: 58%;
}

table.example2 th,table.example2 td {
	border: 1px solid black;
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
	border: 1px solid black;
	border-collapse: collapse;
	width: 58%;
}

table.example1 tr,table.example1 td {
	border: 1px solid black;
}

table.example2 th:first-child {
	width: 8%;
}
</style>
</head>
<body>

<%
	response.addHeader("Content-Disposition",
			"attachment;filename=Title1.xls");
%>
<table width="500" align="left" cellpadding="20" cellspacing="10">
	<tr>
		<th colspan="2" bgcolor="#D9D9D9">The Requested Purchase Stock
		Item Details</th>
	</tr>

</table>
<br>

<strong>Organization </strong>
:
<c:out value="${insName}" />
<br>
<Strong>Ordered Date</strong>
:
<c:out value="${orderedDate}" />
<br>
<Strong>Ordered Person</strong>
:
<c:out value="${orderedPerson}" />
<br>
<!-- 
<table class="example1" >
	<tr>
		<td  align="left"><strong>Organization </strong></td> 
		<td align="left">:<c:out value="${insName}" /></td>
	</tr>
	<tr><td align="left"><Strong>Ordered Date</strong></td>
		 <td align="left">:<c:out value="${orderedDate}" /></td>
	</tr>
	<tr><td align="left"><Strong>Ordered Person</strong></td>
	 <td align="left">:<c:out value="${orderedPerson}"/></td>
	</tr>
</table>
-->
<br>

<c:if test="${!empty requestOrderList}">

	<table class="example2">
		<tr>
			<th>Sno</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
	
		<c:forEach items="${requestOrderList}" var="item">
			<tr>
				<td align="center"><c:out value="${item.sno}"></c:out></td>
				<td align="center"><c:out value="${item.category}" /></td>
				<td align="center"><c:out value="${item.itemName}" /></td>
				<td align="center"><c:out value="${item.quantity}" /></td>
				<td align="center"><c:out value="${item.units}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>