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
            <li class="active"><a href="<s:url action='manageUser' namespace="/login"/>">manageUser</a></li>
            <li><a href="<s:url action='manageDemand' namespace="/login"/>">manageDemand</a></li>
            <li><a href="<s:url action='downAircraftHome' namespace="/aircraft"/>">downAircraft</a></li>
            <li><a href="<s:url action='simulateHome' namespace="/login"/>">simulation</a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-md-9">
         <font face="Comic Sans MS" size="3" color="orange">
        
        <h1>Simulate run time : <s:property value="simulateRunTime" /></h1>
 <table class="table table-striped">
 <tr>
    <!-- <th>Purchase</th> -->
    <th>Rank</th>
    <th>User</th>
    <th>Profit</th>
  </tr>
 <s:iterator value="profits" var="p">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#p.rank" /></td>
   <td> <s:property value="#p.userName" /></td>
   <td> <s:property value="#p.profit" /></td>
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