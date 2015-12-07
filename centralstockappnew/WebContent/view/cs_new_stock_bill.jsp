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

<style type="text/css">
table.example2 {
	background-color: transparent;
	border-collapse: collapse;
	width: 50%;
}
table.example2 th,table.example2 td {
	border: 1px solid black;
}
table.example2 th {
	background-color: #D9D9D9;
}
table.example2 td:first-child {
	width: 5%;
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
}
.combo {
	background-color: #FFFFE8
}
</style>
<script>
function validateForm()
{
     if(document.stockBill.invoiceNumber.value=="")
    {
      alert("Enter invoiceNumber name");
      document.stockBill.invoiceNumber.focus();
      return false;
    }
     else if(document.stockBill.vendorName.value=="")
    {
      alert("Enter Vendor name");
      document.stockBill.vendorName.focus();
      return false;
    }
     else if(document.stockBill.invoiceDate.value=="")
     {
      alert("Date should not be empty");
      document.stockBill.invoiceDate.focus();
      return false;
      }
       else if(document.stockBill.deliveryDate.value=="")
     {
      alert("Date should not be empty");
      document.stockBill.deliveryDate.focus();
      return false;
    }
      else if(document.stockBill.totalAmount.value=="")
    {
      alert("Total Amount should not be empty");
      document.stockBill.totalAmount.focus();
      return false;
    }
}
</script>
</head>
<body>
<c:url var="saveStockBillURL" value="/stock/saveStockBill.html" />
<form:form modelAttribute="stockBill" action="${saveStockBillURL}" name="stockBill" id="stockBill" onSubmit="return validateForm()" method="post">
	<table width="500" align="left" cellpadding="20" cellspacing="10">
		<tr>
		   <th colspan="2" align="center" bgcolor="#D9D9D9">Enter the Received Stock Details</th>
		</tr>
		<tr>
		   <td align="right">Invoice Number:</td>
		   <td><input type="text" name="invoiceNumber"/></td>
		</tr>
		<tr>
		   <td align="right">Vendor Name:</td>
		   <td><input type="text" name="vendorName"/></td>
		</tr>
		<tr>
		   <td align="right">Invoice Date:</td>
		   <td><input type="text"  class="datepicker" name="invoiceDate" readonly="readonly"/></td>
		</tr>
		<tr>
		   <td align="right">Delivery Date:</td>
	       <td><input type="text"  class="datepicker" name="deliveryDate" readonly="readonly"/></td>
		</tr>
		<tr>
		   <td align="right">Total Amount:</td>
		   <td><input type="text" name="totalAmount" /></td>
		</tr>
	</table>
	<table width="560" align="center" cellpadding="10" cellspacing="10">
		<tr>
		   <td align="right"><input type="submit" value="Next" style="width: 50px"/></td>
		   <td align="left"><input type="reset" value="clear" style="width: 50px"/></td>
		</tr>
	</table>
	</form:form>
</body>
</html>