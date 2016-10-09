<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

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
<li role="presentation"><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
<li role="presentation" class="active"><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>

<li role="presentation"><a href="#">Profitability Analysis</a></li>
</ul>

<h1>
Below are all the aircrafts you have :
</h1>
<br>
<table class="table table-striped">
 <tr>
    <!-- <th>Purchase</th> -->
    <th>Name</th>
    <th>Cost New (Million USD)</th>
    <th>Max Seats</th>
    <th>Range (SM, full capacity)</th>
    <th>Speed (MPH)</th>
    <th>Fuel Capacity (Gallons)</th>
    <th>Fuel Burn (Gallons/hour)</th>
    <th>Takeoff Distance (feet)</th>
    <th>Landing Distance (feet)</th>
  </tr>
 <s:iterator value="planes" var="p">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#p.name" /></td>
   <td> <s:property value="#p.cost" /></td>
   <td> <s:property value="#p.maxSeat" /></td>
   <td> <s:property value="#p.range" /></td>
   <td> <s:property value="#p.speed" /></td>
   <td> <s:property value="#p.fuelCapacity" /></td>
   <td> <s:property value="#p.fuelBurn" /></td>
   <td> <s:property value="#p.takingOffDis" /></td>
   <td> <s:property value="#p.landingDis" /></td>
    </tr>
 </s:iterator>
</table>

<br>
<br>
<h2>Select your aircraft to set its route:</h2>
<s:form action="aircraftRoute" namespace="/">
<h2>
<br>
<s:select label="Select your aircraft to set the route"
	headerKey="-1" headerValue="planeToSet"
	list="myPlanes"
	name="planeToSet" />
</h2>
<br>
<br>
<s:submit value="NEXT STEP" name="NEXT STEP" />

</s:form>
</body>
</html>