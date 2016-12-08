<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <a class="navbar-brand" href="#">Airline Simulation</a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="<s:url action='manageUser' namespace="/login"/>">Manage Users</a></li>            
            <li><a href="<s:url action='manageDemand' namespace="/airport"/>">Adjust Demand Values</a></li>
            <li><a href="<s:url action='downAircraftHome' namespace="/aircraft"/>">Down Aircraft</a></li>
            <li><a href="<s:url action='simulateHome' namespace="/login"/>">Run Simulation</a></li>
            <li><a href="<s:url action='signout' namespace="/login"/>">Log Out</a></li>
        </ul>
    </div>
</nav>

</body>
</html>