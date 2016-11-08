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
        <h1>Below are all the users that are generated :</h1>
 <table class="table table-striped">
 <tr>
    <th>Name</th>
    <th>Password</th>
  </tr>
 <s:iterator value="newAddedUsers" var="u">
 <tr>
   <td> <s:property value="#u.name" /></td>
   <td> <s:property value="#u.password" /></td>
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