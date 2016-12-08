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

	<script type="text/javascript">
		function confirmation() {
			return confirm("Comfirm your aircraft to be sold!")
		}
	</script>
	<font face="Arial" size="5" color="orange">
		<h1>
			<center>My Profile</center>
		</h1>
	</font>
	<font size="5" color="black"> <b>
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="well sidebar-nav">
							<ul class="nav nav-list">
								<li><a
									href="<s:url action='getUserProfile' namespace="/profile"/>">My
										Account</a></li>
								<li><a
									href="<s:url action='getUserAircrafts' namespace="/profile"/>">My
										Aircraft</a></li>
								<li><a
									href="<s:url action='getUserAirport' namespace="/profile"/>">My
										Hub</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-9">
						<font face="Arial" size="3" color="orange">
							<h1>My Aircraft:</h1>
							<table class="table table-striped">
								<tr>
									<th>Name</th>
									<th>Aircraft</th>
									<th>FirstClassRatio</th>
									<th>BusinessClassRatio</th>
									<th>Cost New (Million USD)</th>
									<th>Max Seats</th>
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
										<td><s:property value="#p.firstClassRatio" /></td>
										<td><s:property value="#p.businessClassRatio" /></td>
										<td><s:property value="#p.cost" /></td>
										<td><s:property value="#p.maxSeat" /></td>
										<td><s:property value="#p.captainSalary"/></td>
										<td><s:property value="#p.firstOfficerSalary" /></td>
										<td><s:property value="#p.attendantSalary" /></td>
										<td><s:property value="#p.supportSalary" /></td>
									</tr>
								</s:iterator>
								
							</table> <s:form action="deleteUserAircrafts" method="post"
								namespace="/profile" theme="bootstrap"
								cssClass="form-horizontal">
								<h2>
									<s:select label="Sell Aircraft (50% of cost)" headerKey=""
										headerValue="Select aircraft to sell"
										name="aircraftCustomizeNameToDelete"
										list="%{userPlanes.{customizedName}}" value="" />
								</h2>
								<div class="form-group">
									<div class="col-sm-offset-3 col-md-9">
										<s:submit onclick="return confirmation();" value="Sell"
											name="Delete" cssClass="btn btn-primary" />
									</div>
								</div>

							</s:form>
					</div>


					<footer class="footer">
					<p class="pull-right">
						<a href="#">Back to top</a>
					</p>
					</footer>
				</div>
			</div>
</body>
</html>