<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline Simulation</title>
<link rel="stylesheet" type="text/css" href="mystyles.css" media="screen" />

<style>
.button {
    background-color: #33A2FF;
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>

</head>
<img src='map.png' style='position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;'>

<body>
<font face="Comic Sans MS" size="5" color="black">
<h1><center>AIRLINE SIMULATION</center></h1>
</font>
  <s:form action="aircraft" method="post" namespace="/">
    	<button class="button">Aircraft</button>
  </s:form>
<br>
<button class="button">Route</button><br>
<button class="button">Airport</button><br>
<button class="button">Profitability Analysis</button><br>

 <h2>SIGN IN :</h2>
 
  <s:form action="login" method="post" namespace="/">
    	<s:textfield name="userName" label="USERNAME" key="user"></s:textfield>
    	<s:password  name="passWord" label="PASSWORD" key="password"></s:password>
    	<s:submit key="login" value="SUBMIT"></s:submit>
  </s:form>
</body>
</html>