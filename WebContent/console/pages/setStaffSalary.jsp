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
    

     <script type="text/javascript">
            function confirmation(){
             if (!confirm("Confirm purchase?")) {
        		return false;
    }
            }
    </script>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Set the salary for staff:</h1>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
       
  <s:form action="setStaffSalary" method="post" namespace="/" theme="bootstrap" cssClass="form-horizontal" onsubmit="greeting()">
 <font face="Arial" size="4" color="orange">
                        <h3>1.Set the salary for captains (Suggest salary 100000/year)</h3>
                        <input type="range" name="captainSalary" min="0" max="200000" value="100000" step="5000" class="slider-width100" onchange="showValue(this.value,this.name)" />
						<span id="captainSalary">100000</span>
                     	<br>
                        <h3>2.Set the salary for first officers (Suggest salary 75000/year)</h3>
                        <input type="range" name="firstOfficerSalary" min="0" max="150000" value="75000" step="5000" onchange="showValue(this.value,this.name)" />
                        <span id="firstOfficerSalary">75000</span>
                        <br>
                        <h3>3.Set the salary for flight attendant (Suggest salary 70000/year)</h3>
                        <input type="range" name="attendantSalary" min="0" max="150000" value="70000" step="5000" onchange="showValue(this.value,this.name)" />
                        <span id="attendantSalary">70000</span>
                        <h3>4.Set the salary for support staff (Suggest salary 50000/year)</h3>
                        <input type="range" name="supportSalary" min="0" max="100000" value="50000" step="5000" onchange="showValue(this.value,this.name)" />
                        <span id="supportSalary">50000</span>


     <script type="text/javascript">
function showValue(newValue,id)
{
	document.getElementById(id).innerHTML=newValue;
}
</script>                   
</font>                 
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit value="NEXT" name="NEXT" cssClass="btn btn-primary"/>
							<font face="Arial" size="4" color="red"> <s:property
									value="errorMsg" />
							</font>
		</div>
  </div>
  <br>
  </s:form>     


        </div>    
    </div>
    
</div>
</body>
</html>