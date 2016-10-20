<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sb:head includeScripts="true" includeStyles="false"/>
    <link rel="stylesheet" href="<s:url value="/styles/bootstrap-superhero.css" />" type="text/css"/>
    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</head>
<body>

<%@include file="header.jsp"%>



<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Departure airport :</h1>
 <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>State</th>
    <th>Identifier</th>
    <th>City</th>
    <th>Landing Fee</th>
    <th>Runway Length</th>
  </tr>
 <tr>
   <td> <s:property value="fromAirport.name" /></td>
   <td> <s:property value="fromAirport.state" /></td>
   <td> <s:property value="fromAirport.identifier" /></td>
   <td> <s:property value="fromAirport.city" /></td>
   <td> <s:property value="fromAirport.landingFee" /></td>
   <td> <s:property value="fromAirport.runwayLength" /></td>
    </tr>
</table>

        <h1>Arrival airport :</h1>
 <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>State</th>
    <th>Identifier</th>
    <th>City</th>
    <th>Landing Fee</th>
    <th>Runway Length</th>
  </tr>
 <tr>
   <td> <s:property value="toAirport.name" /></td>
   <td> <s:property value="toAirport.state" /></td>
   <td> <s:property value="toAirport.identifier" /></td>
   <td> <s:property value="toAirport.city" /></td>
   <td> <s:property value="toAirport.landingFee" /></td>
   <td> <s:property value="toAirport.runwayLength" /></td>
    </tr>
</table>

<br>
<br>
<h2>Distance Between above two airports is <font face="Comic Sans MS" size="5" color="red"><s:property value="distance" /></font> miles<br>
</h2>

        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>

</body>
</html>