<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
</head>

<body>
<%@include file="header.jsp"%>
 <script type="text/javascript">
            function confirmation(){
             if (!confirm("Confirm purchase?")) {
        		return false;
    }
            }
    </script>

<div class="container">
    <div class="row">
        <div class="col-md-9">
        <font face="Arial" size="3" color="orange">
        
        <h2>Query airport information :</h2>
 

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
  
  
<s:form action="getAirport" namespace="/" theme="bootstrap" cssClass="form-horizontal" >
<s:select label="Departure Airport: " headerKey="" headerValue="Select Departure Airport" name="fromAirportName" list="allAirports" listKey="name" listValue="identifier + ' - ' + name" />
<s:select label="Destination Airport: " headerKey="" headerValue="Select Destination Airport" name="toAirportName" list="allAirports" listKey="name" listValue="identifier + ' - ' + name" />
<center><s:submit value="QUERY" name="QUERY" cssClass="btn btn-primary"/></center>
</s:form>  
 
<h2> Buy a hub : </h2>
<s:form action="buyAirport" theme="bootstrap" cssClass="form-horizontal">
<s:select label="Choose your hub: " name="airportToBuy" headerKey="" headerValue="Select Hub to Buy" list="allAirports" listKey="name" listValue="identifier + ' - ' + name + ' - '+ cost/1000000 + ' Million USD'" />
<center><s:submit onclick ="return confirmation();" value="PURCHASE" name="PURCHASE" cssClass="btn btn-primary"/></center>
</s:form>

<h1>Your Airport Hub:</h1>
  <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>State</th>
    <th>Identifier</th>
    <th>City</th>
    <th>Landing Fee</th>
    <th>Runway Length</th>
    <th>Size</th>
    <th>Cost(Million USD)</th>
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
   <td> <s:property value="#p.size" /></td>
   <td> <s:property value="#p.cost/1000000" /></td>
    </tr>
 </s:iterator>
</table>

        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>


</body>
</html>