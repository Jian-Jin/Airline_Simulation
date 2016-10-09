<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<font face="Comic Sans MS" size="5" color="black">
<h1><center>AIRLINE SIMULATION</center></h1>
</font>

<ul class="nav nav-pills"> 
<li role="presentation" ><a href="/Demo/console/pages/home.jsp">Home</a></li>
<li role="presentation" ><a href="<s:url action='showAircraft' namespace="/aircraft"/>">Aircraft</a></li>
<li role="presentation" class="active"><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
<li role="presentation"><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>

<li role="presentation"><a href="#">Profitability Analysis</a></li>
<br>
<br>
FROM AIRPORT:
<br>
NAME:<s:property value="fromAirport.name" /><br>

STATE:<s:property value="fromAirport.state" /><br>
IDENTIFIER:<s:property value="fromAirport.identifier" /><br>
CITY:<s:property value="fromAirport.city" /><br>
LANDING FEE:<s:property value="fromAirport.landingFee" /><br>
RUNWAY LENGTH:<s:property value="fromAirport.runwayLength" /><br>
<br>

TO AIRPORT:
<br>
NAME:<s:property value="toAirport.name" /><br>
STATE:<s:property value="toAirport.state" /><br>
IDENTIFIER:<s:property value="toAirport.identifier" /><br>
CITY:<s:property value="toAirport.city" /><br>
LANDING FEE:<s:property value="toAirport.landingFee" /><br>
RUNWAY LENGTH:<s:property value="toAirport.runwayLength" /><br>
<br>

DISTANCE BETWEEN TWO AIRPORTS IS <s:property value="distance" /> METERS<br>

</body>
</html>