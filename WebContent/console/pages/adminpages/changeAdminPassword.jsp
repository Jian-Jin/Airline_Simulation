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
<%@include file="adminheader.jsp"%>


				


<div class="container">
    <div class="row">
        <div class="col-md-9">

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>



<div class="col-md-9">
			<font face="Arial" size="3" color="orange">
				<br/>				
          		<h>Administrator Account: 
          		<br/>
				<s:form action="setAdminPassword" method="post" namespace="/user" >				
				 <h>Input the new password for your account: 
				 <input type="text" name="adminPassword"  value="<s:property value="" />">  </h>
				<input type="submit" value="UPDATE" name="UPDATE" />
				 <h2>WRITE THIS DOWN NOW!</h2>
				<h3>New Password: <s:property value="adminPassword"/> </h3>
     	</s:form>
 				</div>
 
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>
</body>
</html>