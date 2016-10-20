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
    <th>departure Airport</th>
    <th>departure Day</th>
    <th>departure Time</th>
    <th>arrival Airport</th>
    <th>arrival Day</th>
    <th>arrival Time</th>
  </tr>
 <s:iterator value="routes" var="r">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#r.departureAirportName" /></td>
   <td> <s:property value="#r.departureDay" /></td>
   <td> <s:property value="#r.departureTime" /></td>
   <td> <s:property value="#r.arrivalAirportName" /></td>
   <td> <s:property value="#r.arrivalDay" /></td>
   <td> <s:property value="#r.arrivalTime" /></td>
    </tr>
 </s:iterator>
</table>
<font face="Comic Sans MS" size="3" color="orange">
     Please make sure the final arrival airport of the last route is your initial departure airport(your hub)
  </font>
<br>
<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
            
<h2>Add a new leg to its route:</h2>
<s:form action="addRoute" namespace="/" theme="bootstrap" cssClass="form-horizontal">
<h2>
<s:select label="1.departure Hour"
	headerValue="00"
	list="hours"
	name="hour" />
	
	<s:select label="departure Min"
	headerValue="00"
	list="mins"
	name="min" />
	<br>
<br>
<s:select label="2. Select the aircraft arrival airport"
	headerKey="-1" headerValue="Select the aircraft arrival airport"
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
 <font face="Comic Sans MS" size="3" color="red">
     <s:property value="errorMsg" />
  </font>
</s:form>

        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>


</body>
</html>