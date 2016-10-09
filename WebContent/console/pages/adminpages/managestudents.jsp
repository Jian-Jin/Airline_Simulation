<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<title>Manage Students</title>

  <link href="css/login.css" rel="stylesheet">
</head>

<body>
	<font face="Comic Sans MS" size="5" color="black">
		<h1><center>Manage Students</center></h1>
	</font>

	<ul class="nav nav-pills">
	</ul>
	<div class="container">
	    <div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="register-form-link">Register</a>
							</div>
							<div class="col-xs-6">
								<a href="/Demo/console/pages/adminpages/student.jsp">View Students</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<s:form id="register-form" theme="simple" action="register" namespace="/register" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="userName" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="passWord" id="password" tabindex="2" class="form-control" placeholder="Password" value="password">
									</div>
									<div class="form-group">
										<input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" value="password">
									</div>
									<div class="form-group">
										<input type="text" name="osuDotnum" id="osudotnum" tabindex="3" class="form-control" placeholder="OSU dot numer" value="">
									</div>
									<center><div>
										<label for="superuser">Superuser?</label>
										<input type="checkbox" name="superUser" id="superuser" tabindex="4" class="form-control" placeholder="Superuser" value="Superuser">
									</div></center>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Add User">
											</div>
										</div>
									</div>
								</s:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>