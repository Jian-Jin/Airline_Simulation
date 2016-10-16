<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
            <li><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
            <li class="active"><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>
           <li><a href="<s:url action='signout' namespace="/login"/>">Log Out</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Aircraft Name  : <s:property value="planeToSet" /><h1>
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
<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
            
<h2>Add a new leg to its route:</h2>
<s:form action="addRoute" namespace="/" theme="bootstrap" cssClass="form-horizontal">
<h2>
<s:select label="1.departure Hour"
	headerKey="-1" headerValue="00"
	list="hours"
	name="hour" />
	
	<s:select label="departure Min"
	headerKey="-1" headerValue="00"
	list="mins"
	name="min" />
	<br>
<br>
<s:select label="2. Select the aircraft arrival airport"
	headerKey="-1" headerValue="Select the aircraft arrival airpor"
	list="airports"
	name="airportToGo" />
</h2>
<br>
<br>
<div class="form-group">
            <div class="col-sm-offset-3 col-md-9">
                   <s:submit value="ADD ROUTE" name="ADD ROUTE" cssClass="btn btn-primary"/>
              </div>
 </div>
</s:form>

        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>


</body>
</html>