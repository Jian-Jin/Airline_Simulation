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
<h1>
Aircraft Name  : <s:property value="planeToSet" />
</h1>
<br>
<table class="table table-striped">
 <tr>
    <th>departure Airport</th>
    <th>departure Time</th>
    <th>arrival Airport</th>
    <th>arrival Time</th>
  </tr>
 <s:iterator value="routes" var="r">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#r.departureAirportName" /></td>
   <td> <s:property value="#r.departureTime" /></td>
   <td> <s:property value="#r.arrivalAirportName" /></td>
   <td> <s:property value="#r.arrivalTime" /></td>

    </tr>
 </s:iterator>
</table>

<br>
<br>
<h2>Add a new leg to its route:</h2>
<s:form action="addRoute" namespace="/">
<h2>
<br>
<s:select label="Select your aircraft departure time"
	headerKey="-1" headerValue="depatureTime"
	list="timeslots"
	name="depatureTime" />

<s:select label="Select the aircraft arrival airport"
	headerKey="-1" headerValue="airportToGo"
	list="airports"
	name="airportToGo" />
</h2>
<br>
<br>
<s:submit value="ADD ROUTE" name="ADD ROUTE" />

</s:form>
</body>
</html>