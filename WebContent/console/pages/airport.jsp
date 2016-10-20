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
        <font face="Comic Sans MS" size="3" color="orange">
        
        <h2>Query airport information :</h2>
 

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
  
  
<s:form action="getAirport" namespace="/" theme="bootstrap" cssClass="form-horizontal" >
departure   airport:   <input type="search"  name="fromAirportName" id="fromAirportName" size="40" list="airports" placeholder="Pick the departure airport..">
<br>
destination airport:   <input type="search" name="toAirportName" id="toAirportName" size="40" list="airports" placeholder="Pick the destination airport..">
<datalist id="airports">
<option value="Akron-Canton Regional">
<option value="Albany International">
<option value="Albuquerque International Sunport">
<option value="Austin-Bergstrom International">
<option value="Baltimore/Washington International Thurgood Marshall">
<option value="Bill and Hillary Clinton National/Adams Field">
<option value="Birmingham-Shuttlesworth International">
<option value="Blue Grass">
<option value="Bob Hope">
<option value="Boise Air Terminal/Gowen Field">
<option value="Bradley International">
<option value="Buffalo Niagara International">
<option value="Charleston AFB/International">
<option value="Charlotte/Douglas International">
<option value="Chicago Midway International">
<option value="Chicago OHare International">
<option value="Cincinnati/Northern Kentucky International">
<option value="Cleveland-Hopkins International">
<option value="Dallas Love Field">
<option value="Dallas-Fort Worth International">
<option value="Dane County Regional-Truax Field">
<option value="Denver International">
<option value="Des Moines International">
<option value="Detroit Metropolitan Wayne County">
<option value="El Paso International">
<option value="Eppley Airfield">
<option value="Fort Lauderdale/Hollywood International">
<option value="Fresno Yosemite International">
<option value="General Edward Lawrence Logan International">
<option value="General Mitchell International">
<option value="George Bush Intercontinental/Houston">
<option value="Gerald R Ford International">
<option value="Greater Rochester International">
<option value="Greenville Spartanburg International">
<option value="Hartsfield - Jackson Atlanta International">
<option value="Indianapolis International">
<option value="Jacksonville International">
<option value="James M Cox Dayton International">
<option value="John F Kennedy International">
<option value="John Wayne Airport-Orange County">
<option value="Kansas City International">
<option value="Laguardia">
<option value="Lambert-St Louis International">
<option value="Long Beach /Daugherty Field/">
<option value="Los Angeles International">
<option value="Louis Armstrong New Orleans International">
<option value="Louisville International-Standiford Field">
<option value="Manchester">
<option value="McCarran International">
<option value="McGhee Tyson">
<option value="Memphis International">
<option value="Metropolitan Oakland International">
<option value="Miami International">
<option value="Minneapolis-St Paul International/Wold-Chamberlain">
<option value="Myrtle Beach International">
<option value="Nashville International">
<option value="Newark Liberty International">
<option value="Norfolk International">
<option value="Norman Y Mineta San Jose International">
<option value="Northwest Arkansas Regional">
<option value="Ontario International">
<option value="Orlando International">
<option value="Orlando Sanford International">
<option value="Palm Beach International">
<option value="Palm Springs International">
<option value="Pensacola International">
<option value="Philadelphia International">
<option value="Phoenix Sky Harbor International">
<option value="Phoenix-Mesa Gateway">
<option value="Piedmont Triad International">
<option value="Pittsburgh International">
<option value="Port Columbus International">
<option value="Portland International">
<option value="Portland International Jetport">
<option value="Raleigh-Durham International">
<option value="Reno/Tahoe International">
<option value="Richmond International">
<option value="Ronald Reagan Washington National">
<option value="Sacramento International">
<option value="Salt Lake City International">
<option value="San Antonio International">
<option value="San Diego International">
<option value="San Francisco International">
<option value="Sarasota/Bradenton International">
<option value="Savannah/Hilton Head International">
<option value="Seattle-Tacoma International">
<option value="Southwest Florida International">
<option value="Spokane International">
<option value="St Pete-Clearwater International">
<option value="Syracuse Hancock International">
<option value="Tampa International">
<option value="Theodore Francis Green State">
<option value="Tucson International">
<option value="Tulsa International">
<option value="Washington Dulles International">
<option value="Westchester County">
<option value="Wichita Dwight D Eisenhower National">
<option value="Will Rogers World">
<option value="William P Hobby">
</datalist>
<br>
<br>
<s:submit value="QUERY" name="QUERY" cssClass="btn btn-primary"/>
 
</s:form>   
<br>
<br>
<h2> Buy a hub : </h2>
<s:form action="buyAirport" theme="bootstrap" cssClass="form-horizontal">
Choose your hub: <input type="search" name="airportToBuy" id="airportToBuy" size="40" list="airports" placeholder="Pick a hub to buy">
<br>
<br>
<s:submit onclick ="return confirmation();" value="PURCHASE" name="PURCHASE" cssClass="btn btn-primary"/>

</s:form>
<br>
<h1>Below is the information of your hub:</h1>
  <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>State</th>
    <th>Identifier</th>
    <th>City</th>
    <th>Landing Fee</th>
    <th>Runway Length</th>
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