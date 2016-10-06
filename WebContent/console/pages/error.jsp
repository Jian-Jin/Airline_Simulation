<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR</title>
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
</style></head>
<body>
<h1>
<s:property value="errorMsg" />
</h1>

	<s:form action="http://localhost:8080/Demo/console/pages/home.jsp"
		method="post" namespace="/">
		<button class="button">HOME</button>
	</s:form>
</body>
</html>