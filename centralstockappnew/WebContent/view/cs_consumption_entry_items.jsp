<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Stock</title>
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
	/* width: 5%; */
}
.adjust
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
function validateForms()
{
    if(document.consumptionList.sno.value=="")
    {
      alert(" Enter seriel_number ");
      document.consumptionList.sno.focus();
      return false;
    }
    else  if (document.forms["consumptionList"].category.value == "0")
    {
     alert("Select category");
      document.consumptionList.category.focus();
      return false;
    }
    else  if (document.forms["consumptionList"].itemName.value == "0")
    {
     alert("Select Item Name");
      document.consumptionList.itemName.focus();
      return false;
    }
    else if(document.consumptionList.quantity.value=="")
    {
      alert("Quantity must not be empty");
      document.consumptionList.quantity.focus();
      return false;
    }
    else  if (document.forms["consumptionList"].units.value == "0")
    {
     alert("Select Units");
      document.consumptionList.units.focus();
      return false;
    }
}
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

</script>
 </head>
<body>
<div id="container">
		<div id="logo">
		<h1><a href="ins_home.html">Central Stock</a></h1>
</div>
<div id="main">
</div>
<div id="sidebar"><b>
		<ul class="sidelink">
		<li><a href="#">Stock Availability</a>
				<ul>
				    <li><a href="orgCurrentStock.html?organisation=${insName}">Current Stock</a></li>
					<li><a href="orgCurrentStat.html?organisation=${insName}">Stationary</a></li>
					<li><a href="orgCurrentClean.html?organisation=${insName}">Cleaning</a></li>
				</ul>
			</li>
					<li><a href="newRequestOrder.html">New Request Order</a></li>
					<li><a href="newConsumption.html">Consumption Entry</a></li>
					<li><a href="viewConsumption1.html">View Consumption Details</a></li>
			<li>
				<ul>
					<li><a href="login.html">Logout</a></li>
				</ul>
			</li>
		</ul>
		</b>
	</div>
	</div>
<div class="adjust" >
<c:url var="saveConsumptionItemsURL" value="/stock/saveConsumptionItems.html" />
<form:form modelAttribute="consumptionList" action="${saveConsumptionItemsURL}" name="consumptionList" id="consumptionList" onSubmit="return validateForm();" method="post">
   <table width="500" align="left" cellpadding="10" cellspacing="10">
		<tr>
			<th colspan="2" align="center" bgcolor="#D9D9D9">Enter the Consumption Item Details</th>
		</tr>
		<tr>
		 <td align="center"><b>Institution Name:-</b><b style="color: green;">${insName}</b> </td>
		</tr>
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="cid" value="${cidno}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="insName" value="${insName}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="issuedDate" value="${issuedDate}" readonly="readonly" /></td>
		</tr>
		
	</table>
	<br><br><br><br><br><br><br>
	Stationary Item Here:-
	<table class="example2">
		<tr>
			<th></th>
			<th></th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
			<th>Usage Person</th>
		</tr>
		<tr>
			<td><input type="hidden" name="sno" size="2"></td>
            <td><input type="hidden" name="category" size="10" value="Stationary"></td>
			<td><c:if test="${!empty list1}">
				<select name="itemName" class="combo">
				    <option value="0">select Item</option>
					<c:forEach items="${list1}" var="item">
					<option><c:out value="${item.itemName}"></c:out></option>
					</c:forEach>
				</select>
			</c:if></td>
			<td><input type="text" name="quantity" size="15" onkeypress="return isNumber(event)"></td>
			<td><select name="units" class="combo">
				    <option value="0">Select Unites</option>
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
			<td><input type="text" name="uname" size="10"></td>
		</tr>
	</table>
	<br>
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
			<td><input type="reset" value="clear" style="width: 50px"/></td>
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
<c:url var="saveConsumptionItemsURL" value="/stock/saveConsumptionItems1.html" />
<form:form modelAttribute="consumptionList" action="${saveConsumptionItemsURL}" name="consumptionList" id="consumptionList" onSubmit="return validateForms();" method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="cid" value="${cidno}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="insName" value="${insName}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right"></td>	
			<td><input type="hidden" name="issuedDate" value="${issuedDate}" readonly="readonly" /></td>
		</tr>
	</table>
	<br><br><br>
	
	Cleaning Item Here:-
	<table class="example2">
		<tr>
			<th></th>
			<th></th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
			<th>Usage Person</th>
		</tr>
		<tr>
			<td><input type="hidden" name="sno" size="2"></td>
	        <td><input type="hidden" name="category" size="10" value="Cleaning"></td>
			<td><c:if test="${!empty list2}">
				<select name="itemName" class="combo">
				    <option value="0">select Item</option>
					<c:forEach items="${list2}" var="item">
					<option><c:out value="${item.itemName}"></c:out></option>
					</c:forEach>
				</select>
			</c:if></td>
			<td><input type="text" name="quantity" size="15" onkeypress="return isNumber(event)"></td>
			<td><select name="units" class="combo">
				   <option value="0">Select Unites</option>
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
			<td><input type="text" name="uname" size="10"></td>
		</tr>
	</table>
	<br>
	<table width="500" align="center" cellpadding="10" cellspacing="10">
		<tr>
			<td align="right"><input type="submit" value="Submit" style="width: 50px"/></td>
		    <td><input type="reset" value="clear" style="width: 50px"/></td>
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
<br><br>
<c:if test="${!empty consumedList}">
	<table class="example2" width="600" style="margin-left:30%; margin-right:70%;" >
		<tr>
			<th title="Consumption Item Details ID">CID ID</th>
			<th>Category</th>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Units</th>
			<th>Usage Person</th>
		</tr>
		<c:forEach items="${consumedList}" var="item">
			<tr>
				<td align="center"><c:out value="${item.sno}"></c:out></td>
				<td align="center"><c:out value="${item.category}" /></td>
				<td align="center"><c:out value="${item.itemName}" /></td>
				<td align="center"><c:out value="${item.quantity}" /></td>
				<td align="center"><c:out value="${item.units}" /></td>
				<td align="center"><c:out value="${item.uname}" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
</body>
</html>