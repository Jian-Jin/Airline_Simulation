<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link id="bootstrap_styles" rel="stylesheet"
	href="/struts2-bootstrap-showcase/struts/bootstrap/css/bootstrap.min.css?s2b=2.5.0"
	type="text/css" />

<style type="text/css">
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>

</head>
<body>
	<%@include file="header.jsp"%>
	<font face="Arial" size="5" color="orange"> </font>
	<font size="5" color="black"> <b>
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<font face="Arial" size="3" color="orange">
							<h1>My Aircraft:</h1>
							<table class="table table-striped">
								<tr>
									<th>Name</th>
									<th>Aircraft</th>
									<th>Captain Salary</th>
									<th>First Officer Salary</th>
									<th>Flight Attendant Salary</th>
									<th>Support Staff Salary</th>
								</tr>
								<s:iterator value="userPlanes" var="p">
									<tr>
										<!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
										<td><s:property value="#p.customizedName" /></td>
										<td><s:property value="#p.name" /></td>
										<td><s:property value="#p.captainSalary" /></td>
										<td><s:property value="#p.firstOfficerSalary" /></td>
										<td><s:property value="#p.attendantSalary" /></td>
										<td><s:property value="#p.supportSalary" /></td>
									</tr>
								</s:iterator>

							</table> <s:form action="gotoUpdateSalaryPage" method="post"
								namespace="/staff" theme="bootstrap" cssClass="form-horizontal">
								<h2>
									<s:select label="Select an aircraft to set staff salary(yearly)"
										headerKey="" headerValue="Select an aircraft"
										name="aircraftToSetSalary"
										list="%{userPlanes.{customizedName}}" value="" />
								</h2>
								<div class="form-group">
									<div class="col-sm-offset-3 col-md-9">
										<s:submit value="NEXT" name="NEXT" cssClass="btn btn-primary" />
									</div>
									<font face="Arial" size="4" color="red"> <s:property
											value="errorMsg" />
									</font>
								</div>

							</s:form>
					</div>
				</div>
			</div>
</body>
</html>