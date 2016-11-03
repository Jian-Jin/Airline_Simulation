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
    
    <script type="text/javascript">
            function confirmation(){
             if (!confirm("Confirm updating your password?")) {
        		return false;
    }
            }
    </script>
</head>
<body>
<%@include file="header.jsp"%>

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
				<br/>
          		<h>Username: <s:property value="user.name" /></h>
          		<br/>
          		<br/>
         <s:form action="updatePassword" method="post" namespace="/profile" >
				 <h>Input your new password:
				 <input type="password" name="password"  value="">  </h>
				<input onclick ="return confirmation();" type="submit" value="UPDATE" name="UPDATE" />
     	</s:form>
				<br/>
				<h>Balance: <s:property value="millions" />Millions</h>
         </div>

</div>
</div>
</body>
</html>