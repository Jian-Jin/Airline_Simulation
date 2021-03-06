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
<img src='${pageContext.request.contextPath}/console/images/airline1.jpg' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'><body>

<body>

<%@include file="header.jsp"%>

<font face="Arial" size="5" color="orange">
<h1><center>AIRLINE SIMULATION beta</center></h1></font>
<font size="5" color="black">
<b>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">
                    Operations
                    </li>
        		<li><s:a href="/Demo/console/pages/home.jsp">Home</s:a></li>
           		 <li><a href="<s:url action='showAircraft' namespace="/aircraft"/>">Aircraft</a></li>
           		 <li><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
           		 <li><a href="<s:url action='aircraftStaff' namespace="/aircraft"/>">Staff</a></li>
           		 <li><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>
           		 <li><a href="<s:url action='simulateHome' namespace="/login"/>">Simulation Result</a></li>
           		 <li><a href="<s:url action='getUserProfile' namespace="/profile"/>">My Profile</a></li>                
                 </ul>
            </div>
        </div>
    </div>
</div>
</b>

</body>
</html>