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


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">AirLine Simulation - <s:text name="test.version"/></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <li><s:a href="/Demo/console/pages/home.jsp">Home</s:a></li>
            <li><a href="<s:url action='showAircraft' namespace="/aircraft"/>">Aircraft</a></li>
            <li class="active"><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
            <li><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>
           <li><a href="<s:url action='signout' namespace="/login"/>">Log Out</a></li>
        </ul>
    </div>
</nav>


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
<h2>Distance Between above two airports is <s:property value="distance" /> miles<br>
</h2>

        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>

</body>
</html>