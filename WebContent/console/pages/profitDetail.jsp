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
            <font face="Verdana" size="5" color="#ccccff">
        
        <br>
        <br>
        
        Profit Details:
        <br>
 <table class="table table-striped">
 <tr>
    <th>User</th>
    <th>AircraftName</th>
    <th>Departure Airport</th>
    <th>Departure Time</th>
    <th>Arrival Airport</th>
    <th>Arrival Time</th>
    <th>Flight Time</th>
    <th>Average Competitor Num</th>
    <th>Average Seats Purchased</th>
    <th>Cost</th>
    <th>Revenue</th>
    <th>Profit</th>
  </tr>
 <s:iterator value="routeProfits" var="p">
 <tr>
   <td> <s:property value="#p.user.name" /></td>
   <td> <s:property value="#p.airplaneName" /></td>
   <td> <s:property value="#p.departureAirportIdentifier" /></td>
   <td> <s:property value="#p.departureTimeLocal" /></td>

   <td> <s:property value="#p.arrivalAirportIdentifier" /></td>
   <td> <s:property value="#p.arrivalTimeLocal" /></td>
   <td> <s:property value="#p.flightTime" /></td>
   <td> <s:property value="#p.competitorNum" /></td>
   <td> <s:property value="#p.seatsPurchased" /></td>
   <td> <s:property value="#p.costString" /></td>
   <td> <s:property value="#p.revenueString" /></td>
   <td> <s:property value="#p.profitString" /></td>
    </tr>
 </s:iterator>
</table>

       
        </div>    
    </div>
    
</div>

</body>
</html>