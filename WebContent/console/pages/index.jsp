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
	<title>Airline Simulation</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<img src='../images/map.png' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'>

<body>
<font face="Comic Sans MS" size="5" color="black">
<h1><center>AIRLINE SIMULATION</center></h1>
</font>

<ul class="nav nav-pills">
<li role="presentation" class="active"><a href="<s:url action='showAircraft' namespace="/aircraft"/>">Aircraft</a></li>
<li role="presentation"><a href="#">Route</a></li>
<li role="presentation" class="active"><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>

<li role="presentation"><a href="#">Profitability Analysis</a></li>
</ul>

</body>
</html>