<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="./js/jquery.js"></script>
<title>Modern Libra</title>
</head>
<body>
	<div id="header">
		<%@include file="./header.jsp"%>
	</div>
	<div id="container">
		<center>
			<s:hidden name = "courseTO.id"></s:hidden>
		<b>	<s:actionmessage /> </b>
			<s:actionerror />
			<div id="searchBox">
				<div class=heading>
					<b>
					<div Style="padding: 7px;">
						Courses List (<s:property value="courseList.size" />) 
						<span style="margin: 317px;"></span>
						 <a href="addCourse">Add Course</a>
					 </div>
					</div>
				</div>
			<span style="padding: 1px;"></span>
			<table class="" align="center" style="width: 70%; overflow: hidden;">
				<tr>
					<th width="40%">Course Name</th>
					<th width="15%">Duration</th>
					<th width="15%">Number of Semester</th>
				</tr>
				
				<s:iterator value='courseList' status="rowstatus">
					<tr align="center"
						class="<s:if test="#rowstatus.odd == true ">odd</s:if>
						<s:else>even</s:else>">
						<td width="40%">
							<a href="updateCourse?id=<s:property value="id"/>">
							<s:property	value='courseName' /></a>
						</td>
						<td width="15%">
							<s:property value='duration' />
						</td>
						<td width="15%">
							<s:property value='numberOfSemester' />
						</td>
					</tr>
				</s:iterator>

			</table>
		</center>
	</div>



</body>
</html>