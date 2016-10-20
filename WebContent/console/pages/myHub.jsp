<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link id="bootstrap_styles" rel="stylesheet"
      href="/struts2-bootstrap-showcase/struts/bootstrap/css/bootstrap.min.css?s2b=2.5.0" type="text/css"/>

    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>

</head>
<body>
<%@include file="header.jsp"%>


    <script type="text/javascript">
            function confirmation(){
                return confirm("Change a hub will delete all your existing routes!")
            }
    </script>
    
<font face="Comic Sans MS" size="5" color="orange">
<h1><center>My Profile</center></h1></font>
<font size="5" color="black">
<b>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                 <li><a href="<s:url action='getUserProfile' namespace="/profile"/>">My Account</a></li>  
           		 <li><a href="<s:url action='getUserAircrafts' namespace="/profile"/>">My Aircrafts</a></li>
           		 <li><a href="<s:url action='getUserAirport' namespace="/profile"/>">My Hub</a></li>              
                 </ul>
        	</div>
    	</div>
		<div class="col-md-9">
		<font face="Comic Sans MS" size="3" color="orange">
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
 <s:iterator value="userAirports" var="p">
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
		
		<s:form action="changeUserAirport" method="post" namespace="/profile" theme="bootstrap" cssClass="form-horizontal">
  <h2>
   <s:select label="Select the hub to change" name="airportToChange" list="%{airportList.{name}}" value="" />
   </h2>
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit onclick = "return confirmation();" value="Change" name="Change" cssClass="btn btn-primary"/>
          </div>
  </div>
  
  </s:form>  	
         </div>

</div>
</div>
</body>
</html>