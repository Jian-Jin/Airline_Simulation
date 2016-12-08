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
<%@include file="adminheader.jsp"%>

<font face="Arial" size="4" color="orange">
<h1>Pick an Airport and adjust the demand value</h1>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-9">

 <script type="text/javascript">
            function confirmation(){
             if (!confirm("Confirm Change")) {
        		return false;
    }
            }
    </script>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>




<s:form action="adjustMultiplier" namespace="/" theme="bootstrap" cssClass="form-horizontal" >
<h2>Airport with current demand Value:</h2>
<s:select label="" headerKey="" headerValue="Airport Name" name="fromAirportName" list="allAirportDemand" listKey="name" listValue="identifier + ' - ' + name + ': ' + multiplier" />
<br>
	<h3>Current Demand Value: </h3>
	<h4>Demand Value: </h4>
	<input type="range" name="toAirportName" min="0.1" max="5.0" step="0.1" onchange="showValue(this.value,this.name)"/>
<span id="toAirportName">2.6</span>


  <script type="text/javascript">
function showValue(newValue,id)
{
	document.getElementById(id).innerHTML=newValue;
}
</script>    
  
<br>
<br>
<s:submit onclick = "return confirmation();" value="Change" name="Change" cssClass="btn btn-primary"/>
</s:form>  
 
        </div>    
    </div>
   
   
</div>

</body>
</html>