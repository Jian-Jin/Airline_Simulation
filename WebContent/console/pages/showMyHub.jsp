<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
<title>Your hub information</title>
</head>
<body>
Your hub information
  <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>State</th>
    <th>Identifier</th>
    <th>City</th>
    <th>Landing Fee</th>
    <th>Runway Length</th>
  </tr>
 <s:iterator value="userAirport" var="p">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#p.name" /></td>
   <td> <s:property value="#p.state" /></td>
   <td> <s:property value="#p.identifier" /></td>
   <td> <s:property value="#p.city" /></td>
   <td> <s:property value="#p.landingFee" /></td>
   <td> <s:property value="#p.runwayLength" /></td>
    </tr>
 </s:iterator>
</table>
 <s:form action="http://localhost:8080/Demo/console/pages/home.jsp" method="post" namespace="/">
    	<button class="button">HOME</button>
 </s:form>
</body>
</html>