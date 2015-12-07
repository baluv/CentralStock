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

<style type="text/css">
table.example2 {background-color:transparent;border-collapse:collapse;width:55%;}
table.example2 th, table.example2 td {border:1px solid black;}
table.example2 th {background-color: #D9D9D9;}
table.example2 td:first-child {width:5%;}

</style>
<style type="text/css">
table.example1 {background-color:transparent;border-collapse:collapse;width:55%;}
table.example1 tr, table.example1 td {border:1px solid black;}
</style>

<style type="text/css">
.combo {
	background-color: #FFFFE8
}
</style>

 <script>
 function validateForm()
{
  if (document.forms["itemDistributionSearch"].insName.value == "0")
    {
     alert("Select Institution");
      document.login.insName.focus();
      return false;
    }
  }
    </script>

</head>
<body>
<c:url var="searchRquestedOredersURL" value="/stock/searchRequestedOrders.html" />
<form:form modelAttribute="itemDistributionSearch" action="${searchRquestedOredersURL}" id="itemDistributionSearch" name="itemDistributionSearch" onsubmit="return validateForm();" method="post">
  <table width="500" align="left" cellpadding="20" cellspacing="10" >
      <tr>
         <th colspan="2" align="center" bgcolor="#D9D9D9">The Requested Ordered Stock Details</th>
     </tr>
     <tr>
		<td align="right">Name of the Institution:</td>
		<td><select name="insName" class="combo">
               <option value="0">Select Institution Name</option>
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
 </table>
 <table width="500" align="center" cellpadding="10" cellspacing="10">
	<tr>
	   <td align="center"><input type="submit" value="Submit" style="width: 60px"/></td>	
	</tr>
	</table>
</form:form>
<br>
<c:if test="${!empty rquestedOrderList}">
<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<th colspan="2" align="center" bgcolor="#D9D9D9">The Ordered Details</th>
		</tr>
		<tr>
			<td align="right"><b>Institution Name:</b></td>
			<td><b style="color: green;">${insName}</b></td>
		</tr>
	</table>
	<br>
	<table class="example2">
		<tr>
			<th width="04%" align="center" title="Request Item Details ID">RID ID</th>
			<th width="10%" align="center">Category</th>
			<th width="10%" align="center">Item Name</th>
			<th width="10%" align="center">Quantity</th>
			<th width="03%" align="center">Units</th>
			<th width="08%" align="center">Ordered Date</th>
			<th width="08%" align="center">ordered Person</th>
		</tr>
	</table>
	<table class="example1">
		<c:forEach items="${rquestedOrderList}" var="item">
			<tr>
				<td width="04%" align="center"><c:out value="${item.sno}"></c:out></td>
				<td width="10%" align="center"><c:out value="${item.category}" /></td>
				<td width="10%" align="center"><c:out value="${item.itemName}" /></td>
				<td width="10%" align="center"><c:out value="${item.quantity}" /></td>
				<td width="03%" align="center"><c:out value="${item.units}" /></td>
				<td width="08%" align="center"><c:out value="${item.orderedDate}" /></td>
				<td width="08%" align="center"><c:out value="${item.orderedPerson}" /></td>
			</tr>
		</c:forEach>
		
	</table>
</c:if>
<br><br>

</body>
</html>