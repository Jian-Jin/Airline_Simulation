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


<%@include file="header.jsp"%>



<div class="container">
    <div class="row">
        <div class="col-md-9">
            <font face="Verdana" size="5" color="#ccccff">
        
        Last Simulation Run Time : <s:property value="simulateRunTime" />
        </font>
        <br>
        <br>
                 <font face="Arial" size="6" color="orange">
        
        Balance Ranking:
        <br>
 <table class="table table-striped">
 <tr>
    <!-- <th>Purchase</th> -->
    <th>Rank</th>
    <th>User</th>
    <th>Last Simulation Profit</th>
    <th>Balance</th>
  </tr>
 <s:iterator value="profits" var="p">
 <tr>
   <!--<td><input type="radio" name="planeId" value="#p.id"></td>  -->
   <td> <s:property value="#p.rank" /></td>
   <td> <s:property value="#p.userName" /></td>
   <td> <s:property value="#p.profitString" /></td>
   <td> <s:property value="#p.balanceString" /></td>
    </tr>
 </s:iterator>
</table>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
 <s:form action="profitDetails" namespace="/route" theme="bootstrap" cssClass="form-horizontal">
   <div class="form-group">
            <div class="col-sm-offset-11 col-md-9">
                   <s:submit value="Profit Details" name="Profit Details" cssClass="btn btn-primary"/>
              </div>
 </div>
 </s:form> 

       
        </div>    
    </div>
    

</div>

</body>
</html>