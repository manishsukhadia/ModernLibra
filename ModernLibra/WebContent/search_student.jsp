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
			<h4 style="color: RED; margin-right: 45%">For search all records
				click on submit without filling up fields.</h4>
			<hr>
			<s:hidden name="studentTO.id"></s:hidden>
			<b> <s:actionmessage />
			</b>
			<s:actionerror />
			<div>
				<s:form action="searchStudent" method="get">
					<table align="left"
						style="width: 40%; overflow: hidden; margin-left: 12%;">
						<tr>
							<td><s:textfield name="studentTO.firstName"
									label="First Name" maxlength="45" style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:textfield name="studentTO.lastName" label="Last Name"
									maxlength="45" style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:textfield name="studentTO.addmissionYear"
									label="Admission Year" maxlength="4" style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:textfield name="studentTO.uniqueId" label="Unique Id"
									maxlength="30" style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:select name="studentTO.course.id" label="Course"
									list="courseOptionList" listKey="value" listValue="label"
									style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:textfield name="studentTO.mobileNo" label="Mobile No"
									maxlength="30" style="width: 40%;" /></td>
						</tr>
						<tr>
							<td><s:radio label="Status" name="studentTO.status"
									list="{'active','inactive'}" /></td>
						</tr>
						<tr>
							<td><s:submit name="submit" value="submit" align="center"></s:submit></td>
						</tr>
					</table>
				</s:form>
			</div>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>

			<s:if test="studentList.size == 0">
				<h3 style="color: RED; margin-right: 50%">Records Not Found !!
				</h3>
			</s:if>

			<s:if test="studentList.size > 0">
				<div id="searchBox">
					<div class=heading>
						<b>
							<div Style="padding: 7px;">
								Student List (
								<s:property value="studentList.size" />
								) <span style="margin: 317px;"></span> <a href="addStudent">Add
									Student</a>
							</div>
						</b>
					</div>
				</div>
				<span style="padding: 1px;"></span>
				<table class="" align="center"
					style="width: 85%; overflow: hidden; margin-bottom: 5%">
					
					<tr>
						<th width="15%">Unique Id</th>
						<th width="15%">First Name</th>
						<th width="15%">Last Name</th>
						<th width="15%">Course Name</th>
						<th width="5%">Admission Year</th>
						<th width="10%">Mobile No.</th>
						<th width="10%">Status</th>
					</tr>

					<s:iterator value='studentList' status="rowstatus">
						<tr align="center"
							class="<s:if test="#rowstatus.odd == true ">odd</s:if>
						<s:else>even</s:else>">
							<td width="15%"><a
								href="updateStudent?recordId=<s:property value="id"/>"> <s:property
										value='uniqueId' /></a></td>
							<td width="15%"><s:property value='firstName' /></td>
							<td width="15%"><s:property value='lastName' /></td>
							<td width="15%"><s:property value='course.courseName' /></td>
							<td width="5%"><s:property value='addmissionYear' /></td>
							<td width="10%"><s:property value='mobileNo' /></td>
							<td width="10%"><s:property value='status' /></td>
						</tr>
					</s:iterator>

				</table>
			</s:if>

		</center>
	</div>
</body>
</html>