<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="./css/main.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="./css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="./js/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
					<b><div Style="padding: 9px;">Update Course</div></b>
				</div>
				<br>
		<b>		<s:actionmessage /> </b>
				<s:actionerror /> 
				<!--  update Course form -->
				<s:form action="updateCourse">
				 <s:hidden name = "courseTO.id"/>  	<!--  storing id b/w submit update and non submit update -->
					<s:textfield name="courseTO.courseName"
						label="Course Name" maxlength="45" />
					<s:textfield name="courseTO.duration"
						label="Duration (no. of year)" maxlength="1" />
					<s:textfield name="courseTO.numberOfSemester"
						label="Number Of Semester" maxlength="2" />
					<s:submit name="submit" value="submit" />
				</s:form>
			</div>
		</center>
	</div>
</body>
</html>