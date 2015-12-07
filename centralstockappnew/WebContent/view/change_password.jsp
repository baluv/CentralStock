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
<link rel="stylesheet" href="../view//jquery-ui.css" />
<script src="../view/js/jquery-1.9.1.js"></script>
<script src="../view/js/format.js"></script>
<script src="../view/js/jquery-ui.js"></script>

<style type="text/css">
.combo {
	background-color: #FFFFE8
}
</style>

<%-- This script for Login Validation --%>
 <script>
 function validateForm()
{
  var x=document.forms["login"]["userId"].value;
  var y=document.forms["login"]["changePw"].value;
  var z=document.forms["login"]["confirmPw"].value;

if (x==null || x=="" )
    {
      alert("Enter Current Password");
      return false;
    }
 else if (y==null || y=="")
    {
      alert("Enter New Password");
      return false;
    }
 else if (z==null || z=="")
    {
      alert("Enter Confirm Password");
      return false;
    }
  
 }
 </script>
 
</head>
<body>

<div id="container">
<div id="logo">
<h1>Central Stock</h1>
</div>

  <div id="main"></div>
  <div class="cont">
  <div class="floatLeft">

  <table align="center">
</table>
</div>

<div style="margin-left: 30%; margin-right: 15%; margin-top: 10%; background-color: ">
<c:url var="passwordChangeURL" value="/stock/passwordChange.html" /> 
<form:form modelAttribute="changepw" action="${passwordChangeURL}" id="login" name="login" onsubmit="return validateForm();" method="post">

	<table cellpadding="10" cellspacing="15">
		<tr>
		  <td><strong>Institution:</strong></td>
          <td>				
           <select name="insName" class="combo">
            <option value="0">Select Institution Name</option>
            <option >Central Admin</option>
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
	 <tr>
		<td><strong>Old Password:</strong></td>
		<td><input name="oldPw" type="text" id="userId" style=" width: 240px"></td>
	 </tr>
	 <tr>
		<td><strong>New Password:</strong></td>
		<td><input name="newPw" type="password" id="userId" style=" width: 240px"></td>
	 </tr>
   	 <tr>
   	    <td></td>
        <td align="center"><input value="Submit" type="submit" style="width: 70px"></td>
	 </tr>
	</table>

  </form:form></div>
  </div>
</div>

</body>
</html>