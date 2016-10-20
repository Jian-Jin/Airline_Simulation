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
            function greeting(){
                alert("Comfirm your aircraft purchase!")
            }
    </script>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-9">
        <h1>Customize the aircraft <s:property value="aircraftToBuy"/> before purchase  :</h1>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>
       
  <s:form action="customizePlane" method="post" namespace="/" theme="bootstrap" cssClass="form-horizontal" onsubmit="greeting()">
 <font face="Comic Sans MS" size="4" color="orange">
                        <h3>1. the percentage of first class seat here (0-100%)</h3>
                        <br>
                        <input type="range" name="firstClassRatio" min="0" max="100" value="0" step="5" class="slider-width100" onchange="showValue(this.value,this.name)" />
<span id="firstClassRatio">0</span>

                     <br>  
                     <br>
                        <h3>2. the percentage of business class seat here (0-100%)</h3>

                        <input type="range" name="businessClassRatio" min="0" max="100" value="0" step="5" onchange="showValue(this.value,this.name)" />
                        <span id="businessClassRatio">0</span>


     <script type="text/javascript">
function showValue(newValue,id)
{
	document.getElementById(id).innerHTML=newValue;
}
</script>                   

<br>
<br>
 <h3>3. customize aircraft name:
<input type="text" name="planeCustomizeName"  value="input your customized aircraft name"></h3>
</font>
                        
   <div class="form-group">
          <div class="col-sm-offset-3 col-md-9">
                 <s:submit value="NEXT" name="NEXT" cssClass="btn btn-primary"/>
          </div>
  </div>
  <br>
  <font face="Comic Sans MS" size="3" color="red">
     <s:property value="errorMsg" />
  </font>
  </s:form>     


        </div>    
    </div>
    
    
    <footer class="footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
    </footer>
</div>
</body>
</html>