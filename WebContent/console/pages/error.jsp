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
            <li><s:a href="/Demo/console/pages/home.jsp">Home</s:a></li>
            <li><a href="<s:url action='showAircraft' namespace="/aircraft"/>">Aircraft</a></li>
            <li><a href="<s:url action='showAirport' namespace="/airport"/>">Airport</a></li>
            <li><a href="<s:url action='getRoute' namespace="/route"/>">Route Setup</a></li>
        </ul>
    </div>
</nav>



<div class="container">
    <div class="row">
        <div class="col-md-9">
   <div class="alert alert-danger actionError">
            <p><h2><s:property value="errorMsg" /> </h2></p>
</div>
</div>
</div>

 <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
    
</div>
  



</body>
</html>