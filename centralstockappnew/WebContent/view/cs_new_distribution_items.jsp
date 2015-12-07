<%@include file="include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	/* width: 50%; */
}
table.example2 th,table.example2 td {
	border: 1px solid black;
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 td:first-child {
/* 	width: 5%; */
}
.adjust
{
padding: 0px 0px 0px 440px;
align: center;
}
.adjust1
{
padding: 0px 0px 0px 440px;
align: center;
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
</style>

<script>
function validateForm()
{
    if(document.distributionItem.sno.value=="")
    {
      alert(" Enter seriel_number ");
      document.distributionItem.sno.focus();
      return false;
    }
    else  if (document.forms["distributionItem"].category.value == "0")
    {
     alert("Select category");
      document.distributionItem.category.focus();
      return false;
    }
    else  if (document.forms["distributionItem"].itemName.value == "0")
    {
     alert("Select Item Name");
      document.distributionItem.itemName.focus();
      return false;
    }
    else if(document.distributionItem.quantity.value=="")
    {
      alert("Quantity must not be empty");
      document.distributionItem.quantity.focus();
      return false;
    }
    else  if (document.forms["distributionItem"].units.value == "0")
    {
     alert("Select Units");
      document.distributionItem.units.focus();
      return false;
    }
}
</script>

</head>
<body>
<div class="adjust" >
<c:url var="saveDistributionItemURL" value="/stock/saveDistributionItem.html" />
<form:form modelAttribute="distributionItem" action="${saveDistributionItemURL}" id="distributionItem" name="distributionItem" onSubmit="return validateForm()"  method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<th colspan="2" align="center" bgcolor="#D9D9D9">Enter the Distribution Stock Details :-<b style="color: green;">${ins_name}</b></th>
		</tr>
		<tr>
			<td align="right"></td>
			<td><input  name="did"  type="hidden" value="${didno}" readonly="readonly" /></td>
		</tr>
			<tr>
			<td align="right"></td>
			<td><input  name="insName" type="hidden" value="${ins_name}" readonly="readonly" /></td>
		</tr>
			<tr>
			<td align="right"></td>
			<td><input  name="issuedDate" type="hidden" value="${issuedDate}"
				readonly="readonly" /></td>
		</tr>
	</table>
	<br><br><br><br><br>
	
	<b>Stationary Item Here:-</b>
	<table class="example2" width="300">
		<tr>
			<th></th>
			<th></th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
		<tr>
		   <td><input type="hidden" name="sno" size="3"></td>
           <td><input type="hidden" name="category" value="Stationary" size="3"></td>
		   <td><c:if test="${!empty list1}">
				<select name="itemName" class="combo">
				  <option value="0">Select Item</option>
				  <c:forEach items="${list1}" var="item">
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
		</tr>
	</table>
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td width="170" align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
			<td align="left"><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>
	</table>
	<br>
	<table width="500" align="left" cellpadding="10" cellspacing="10">
		<tr>
			<td align="left">
			<h4><font color="red"><c:out value="${errorMessage}"></c:out></font></h4>
			</td>
		</tr>
	</table>
	<br>
</form:form>
<br>
<c:url var="saveDistributionItemURL" value="/stock/saveDistributionItem1.html" />
<form:form modelAttribute="distributionItem" action="${saveDistributionItemURL}" id="distributionItem" name="distributionItem" onSubmit="return validateForm()"  method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<td align="right"></td>
			<td><input  name="did"  type="hidden" value="${didno}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td><input  name="insName" type="hidden" value="${ins_name}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td><input  name="issuedDate" type="hidden" value="${issuedDate}" readonly="readonly" /></td>
		</tr>
	</table>
<br><br><br>
	<b>Cleaning Item Here:-</b>
	<table class="example2" width="300" align="center">
		<tr>
			<th></th>
			<th></th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
		<tr>
			<td><input type="hidden" name="sno" size="3"></td>
            <td><input type="hidden" name="category" size="3" value="Cleaning"></td>
			<td><c:if test="${!empty list2}">
			  <select name="itemName" class="combo">
				<option value="0">Select Item</option>
				<c:forEach items="${list2}" var="item">
				<option><c:out value="${item.itemName}"></c:out></option>
				</c:forEach>
			  </select>
			</c:if></td>
			<td><input type="text" name="quantity"></td>
			<td><select name="units" class="combo">
				  <option value="0">Select Item</option>
				  <option>no's</option>
				  <option>bundles</option>
				  <option>rolls</option>
				  <option>pkts</option>
				  <option>bottles</option>
				  <option>box</option>
				  <option>loos</option>
				  <option>kg</option>
				  <option>sets</option>
				  <option>ltrs</option>
                  <option>nill</option>
			</select></td>
		</tr>
	</table>
	
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td width="170" align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
			<td align="left"><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>
	</table>
	<br>
	<table width="500" align="left" cellpadding="10" cellspacing="10">
		<tr>
			<td align="left">
			<h4><font color="red"><c:out value="${errorMessage}"></c:out></font></h4>
			</td>
		</tr>
	</table>
	<br>
</form:form>
</div>
<div class="adjust1" >
<br><br>
<c:if test="${!empty distList}">
	<table class="example2" width="500">
		<tr>
			<th title="Distibution Item Details ID">DID ID</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
		</tr>
	
		<c:forEach items="${distList}" var="item">
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
</div>
</body>
</html>