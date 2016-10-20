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
<%@include file="header.jsp"%>




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