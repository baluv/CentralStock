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

 <script>
 function validateForm()
{
  var x=document.forms["login"]["userId"].value;
  var y=document.forms["login"]["password"].value;
  if (document.forms["login"].insName.value == "0")
    {
     alert("Select Institution");
      document.login.insName.focus();
      return false;
    }
 else if (x==null || x=="" )
    {
      alert("please enter username");
      return false;
    }
 else if (y==null || y=="")
    {
      alert("please enter password");
      return false;
    }
  
 }
 </script>
 <!--  
 <style type="text/css">
 .changepassword{
 padding-left: 100 px;
 font-size: 35px;
 }
 </style>
 --->
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
<c:url var="checkLoginURL" value="/stock/checkLogin.html" /> 
<form:form modelAttribute="login" action="${checkLoginURL}" id="login" name="login" onsubmit="return validateForm();" method="post">
	<table width="300"  height="150">
			<tr>
				<td><strong>Institution:</strong></td>
                <td>				
                   <select name="insName" class="combo" >
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
			 <tr>
				<td><strong>User Id:</strong></td>
				<td><input name="userId" type="text" id="userId" style=" width: 240px"></td>
			</tr>
			<tr>
				<td><strong>Password:</strong></td>
				<td><input name="userPw" id="password" type="password" style=" width: 240px"></td>
			</tr>
			<tr>
			   <td></td>
				<td align="center"><input value="Login" type="submit" style="width: 70px"></td>
		</tr>
			<tr>
			    <td></td>
				<td align="center"><a href="change_password.html">Change Password</a></td>
			</tr>
			
			

	</table>


</form:form></div>
</div>

</div>
</body>
</html>