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
        <h1>Below are all the aircrafts you have :</h1>
        <table class="table table-striped">
 <tr>
    <!-- <th>Purchase</th> -->
    <th>Name</th>
    <th>Aircraft</th>
    <th>FirstClassRatio</th>
    <th>BusinessClassRatio</th>
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
    <td> <s:property value="#p.customizedName" /></td>
   <td> <s:property value="#p.name" /></td>
   <td> <s:property value="#p.firstClassRatio" /></td>
   <td> <s:property value="#p.businessClassRatio" /></td>
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

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
            

<s:form action="aircraftRoute" namespace="/" theme="bootstrap" cssClass="form-horizontal">
<h2>
<br>
<s:select label="Select aircraft:"
	headerKey="" headerValue="Select your aircraft to set the route"
	list="myPlanes"
	name="planeToSet" />
</h2>
<br>
<br>
<div class="form-group">
            <div class="col-sm-offset-3 col-md-9">
                   <s:submit value="NEXT STEP" name="NEXT STEP" cssClass="btn btn-primary"/>
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