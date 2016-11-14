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



<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Aircraft Name  : <s:property value="planeToSet" />
       <br> Current location : <s:property value="#session.planeCurLocation"/><h1>
  <table class="table table-striped">
 <tr>
    <th>Departure Airport</th>
    <th>Local Departure Day</th>
    <th>Local Departure Time</th>
    <th>Arrival Airport</th>
    <th>Local Arrival Day</th>
    <th>Local Arrival Time</th>
    <th>Flight Time</th>
  </tr>
 <s:iterator value="routes" var="r">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#r.departureAirportIdentifier" /></td>
   <td> <s:property value="#r.departureDayLocal" /></td>
   <td> <s:property value="#r.departureTimeLocal" /></td>
   <td> <s:property value="#r.arrivalAirportIdentifier" /></td>
   <td> <s:property value="#r.arrivalDayLocal" /></td>
   <td> <s:property value="#r.arrivalTimeLocal" /></td>
   <td> <s:property value="#r.flightTime" /></td>
    </tr>
 </s:iterator>
</table>
<br>
<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
 <s:form action="undoRoute" namespace="/" theme="bootstrap" cssClass="form-horizontal">
   <div class="form-group">
            <div class="col-sm-offset-11 col-md-9">
                   <s:submit value="UNDO LAST ROUTE ADD" name="UNDO" cssClass="btn btn-primary"/>
              </div>
 </div>
 </s:form> 
<font face="Arial" size="3" color="orange">
     Please make sure the final arrival airport of the last route is your initial departure airport(your hub).
  </font>
<br>
          
<h2>Add a new leg to its route:</h2>
 <font face="Arial" size="5" color="red">
     <s:property value="errorMsg" />
 </font>
<s:form action="addRoute" namespace="/" theme="bootstrap" cssClass="form-horizontal">
<h2>

<s:select label="1.departure Hour (local)"
	headerValue="00"
	list="hours"
	name="hour" />
	

	<s:select label="departure Min (local)"
	headerValue="00"
	list="mins"
	name="min" />
	<br>
<br>
<s:select label="2. Arrival Airport"
	headerKey="-1" headerValue="Select the aircraft arrival airport"
	list="airports"
	name="airportToGo" listKey="name" listValue="identifier + ' - ' + name" />
</h2>
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