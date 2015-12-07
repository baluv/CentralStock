<%@ page session="true"%>
<%@include file="include1.jsp"%>
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
table.example1 tr, table.example1 td {border:1px solid black;
}
</style>
 <script>
 function validateForm()
{
  var x=document.forms["itemDistributionSearch"]["fromDate"].value;
  var y=document.forms["itemDistributionSearch"]["toDate"].value;

    if (document.forms["itemDistributionSearch"].insName.value == "0")
    {
     alert("Select Institution");
      document.itemDistributionSearch.insName.focus();
      return false;
    }

  if (x==null || x=="" )
    {
      alert("please enter fromDate");
      return false;
    }
  if (y==null || y=="")
    {
      alert("please enter toDate");
      return false;
    }
 }
 </script>

</head>
<body>
<c:url var="searchConsumptionURL" value="/stock/searchConsumption1.html" />
<form:form modelAttribute="itemDistributionSearch" action="${searchConsumptionURL}" name="itemDistributionSearch" id="itemDistributionSearch" onsubmit="return validateForm();"  method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10" >
         <tr>
            <th colspan="2" align="center" bgcolor="#D9D9D9">The View Consumption Stock Details</th>
         </tr>
         <tr>
		    <td align="right">Name of the Institution:</td>
            <td><input type="text"  name="insName" value="${insName}"  readonly="readonly"/>
	    </tr>
	
        <tr>
		   <td align="right">From Date:</td>
		   <td><input type="text" class="datepicker" name="fromDate" readonly="readonly"/></td>
		</tr>
		<tr>
		   <td align="right">To Date:</td>
		   <td><input type="text"  class="datepicker" name="toDate" readonly="readonly"/></td>
		</tr>
	</table>
	<table width="630" align="center" cellpadding="10" cellspacing="10">
	    <tr>
		   <td align="center"><input type="submit" value="Submit" style="width: 70px"/></td>	
	</tr>
	</table>
</form:form>
<br>
<c:if test="${!empty consumedAllList}">
<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<th colspan="2" align="center" bgcolor="#D9D9D9">The View Consumption Item  Details</th>
		</tr>
		<tr>
			<td align="right"><b>Institution Name:</b></td>
			<td><b style="color: green;">${instName}</b></td>
		</tr>
	</table>
	<br>
	
	<table class="example2">
		<tr>
			<th width="4%" align="center" title="Consumption Item Details ID">CID ID</th>
			<th width="8%" align="center">Category</th>
			<th width="15%" align="center">Item Name</th>
			<th width="8%" align="center">Quantity</th>
			<th width="4%" align="center">Units</th>
			<th width="8%" align="center">Date</th>
			<th width="8%" align="center">Usage Person</th>
		</tr>

		<c:forEach items="${consumedAllList}" var="item">
			<tr>
				<td align="center"><c:out value="${item.sno}"></c:out></td>
				<td align="center"><c:out value="${item.category}" /></td>
				<td align="center"><c:out value="${item.itemName}" /></td>
				<td align="center"><c:out value="${item.quantity}" /></td>
				<td align="center"><c:out value="${item.units}" /></td>
				<td align="center"><c:out value="${item.issuedDate}" /></td>
				<td align="center"><c:out value="${item.enteredby}" /></td>
			</tr>
		</c:forEach>
		
	</table>
</c:if>
<br><br>
</body>
</html>