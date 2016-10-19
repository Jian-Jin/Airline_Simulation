<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
	<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        
</head>
<%@include file="header.jsp"%>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Below are all the aircrafts information :</h1>
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

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
       
  <s:form action="buyPlane" method="post" namespace="/" theme="bootstrap" cssClass="form-horizontal">
  <h2>
   <s:select label="Select the aircraft to buy" name="aircraftToBuy" list="names" value="" />
   </h2>
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit onclick = "confirmation()" value="NEXT" name="NEXT" cssClass="btn btn-primary"/>
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