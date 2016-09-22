<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aircraft</title>
<style>
.button {
    background-color: #33A2FF;
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>

  <script type="text/javascript">
            function greeting(){
                alert("Comfirm your aircraft purchase!")
            }
        </script>
        
</head>

<body>

<table>
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
  <s:form action="buyPlane" method="post" namespace="/" onsubmit="greeting()">
  <h2>
   <s:radio label="aircraftToBuy" name="aircraftToBuy" list="names" value="" />
   </h2>
  <!--<s:submit value="submit" name="purchase" />-->
   <button class="button">purchase</button>
  
  </s:form>

</body>
</html>