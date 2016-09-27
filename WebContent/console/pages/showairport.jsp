<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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