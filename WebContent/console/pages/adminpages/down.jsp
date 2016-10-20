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

    <script type="text/javascript">
            function greeting(){
                alert("Comfirm your aircraft purchase!")
            }
    </script>
        
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">AirLine Simulation - <s:text name="Adminpage"/></a>
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
            <li><a href="<s:url action='simulateHome' namespace="/login"/>">simulate</a></li>
              <li><a href="<s:url action='signout' namespace="/login"/>">Log Out</a></li>
        </ul>
    </div>
</nav>



<div class="container">
    <div class="row">
        <div class="col-md-9">

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
 <s:form action="downAircraft" method="post" namespace="/aircraft" theme="bootstrap" cssClass="form-horizontal">
  <s:checkboxlist
                        tooltip="Choose down aircrafts"
                        label="Choose down aircrafts"
                        list="names"
                        value="downAircrafts"
                        name="aircraftsToDown"/>
                        
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit value="SAVE" name="SAVE" cssClass="btn btn-primary"/>
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