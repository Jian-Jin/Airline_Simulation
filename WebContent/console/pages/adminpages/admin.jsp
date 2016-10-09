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
<title>Admin page</title>

        
</head>

<body>
<font face="Comic Sans MS" size="5" color="black">
<h1><center>Admin Homepage</center></h1>
<br>
</font>

<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<ul class="nav nav-pills">
					<li role="presentation" class="active"><a href="/Demo/console/pages/adminpages/admin.jsp">Admin Home</a></li>
					<li role="presentation" class="active"><a href="/Demo/console/pages/adminpages/managestudents.jsp">Manage Students</a></li>
					<li role="presentation" ><a href="">Manage Demand</a></li>
					<li role="presentation"><a href="">Down Aircraft</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>