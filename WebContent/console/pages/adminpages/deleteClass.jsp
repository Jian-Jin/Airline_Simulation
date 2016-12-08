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
        <h1>ARE YOU SURE YOU WANT TO DELETE ALL USERS</h1>          
        </div>    
    </div>
    
    <s:form action="deleteClass" method="post" namespace="/user" theme="bootstrap" cssClass="form-horizontal">
    
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit onclick = "return confirmation();" value="DELETE ALL USERS" name="NEXT" cssClass="btn btn-primary"/>
          </div>
  </div>  
   </s:form>
   <h2>THIS CAN NOT BE UNDONE!!</h2> 
    
</div>
</body>
</html>