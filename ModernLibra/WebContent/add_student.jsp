<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" href="./css/main.css" rel="stylesheet" />
<link type="text/css" href="./css/menu.css" rel="stylesheet" />

<!-- CSS for date picker. -->
<link type="text/css" href="./css/jquery.datepick.css" rel="stylesheet">

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/jquery.min.js"></script>

<!-- JS for date picker. -->
<script type="text/javascript" src="./js/jquery.plugin.js"></script>
<script type="text/javascript" src="./js/jquery.datepick.js"></script>

<!-- script for date picker. -->
<script>
$(function() {
	$('#yearsAbsPicker').datepick({ 
	    minDate: new Date(1975, 1-1, 1), maxDate: new Date(2005, 12-1, 31), 
	    yearRange: '1975:2005', showTrigger: '#calImg'});
});
</script>
<title>Modern Libra</title>
</head>
<body>
	<div id="header">
		<%@include file="./header.jsp"%>
	</div>
	<div id="container">
		<center>
			<div id="addBox">
				<div class="heading">
					<b><div Style="padding: 9px;">Student Registration</div></b>
				</div>
				<br> 
				<b> <s:actionmessage />	</b>
				<s:actionerror />
				<!--  Add Student form -->
				<s:form action="addStudent">
					<table>
						<tr>
							<td><s:textfield name="studentTO.firstName"
									label="First Name" maxlength="45" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.middleName"
									label="Middle Name" maxlength="45" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.lastName" label="Last Name"
									maxlength="45" /></td>
						</tr>

						<tr>
							<td><s:radio label="Gender" name="studentTO.gender"
									list="{'Male','Female'}" /></td>
						</tr>
						
						<tr>
							<td><s:textfield name="studentTO.dateOfBirth"
									label="Date Of Birth (mm/dd/yyyy)" maxlength="10" id="yearsAbsPicker" />
							</td>
						</tr>

						<tr>
							<td><s:select name="studentTO.course.id" label="Course"
									list="courseOptionList" listKey="value" listValue="label" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.addmissionYear"
									label="Addmission Year" maxlength="4" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.challanNo"
									label="Challan Number" maxlength="10" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.emailId" label="Email Id"
									maxlength="45" /></td>
						</tr>

						<tr>
							<td><s:textfield name="studentTO.mobileNo"
									label="Mobile Number" maxlength="10" /></td>
						</tr>

						<tr>
							<td><s:password name="studentTO.password" label="Password"
									maxlength="45" /></td>
						</tr>

						<tr>
							<td><s:password name="confirmPassword"
									label="Confirm Password" maxlength="45" /></td>
						</tr>
						
						<tr>
							<td> <br> </td>
						</tr>
						
						<tr>
							<td align="right"><img id="capimg" border="1" 
								src="<c:url value="simpleCaptcha.png" />" width="200" height="45" />
							</td>
							
							<td align="center">
							<img src="./images/refersh.jpg" onclick="document.getElementById('capimg').setAttribute('src', '<c:url value="simpleCaptcha.png?id=1"/>')"
								width="35" height="35">
							</td>
						</tr>


						<tr>
							<td><s:textfield name="captchaCode" label="Security Code"
									maxlength="10" /></td>
						</tr>

					</table>
					<s:submit name="submit" value="submit" />
				</s:form>
			</div>
		</center>
	</div>
</body>
</html>