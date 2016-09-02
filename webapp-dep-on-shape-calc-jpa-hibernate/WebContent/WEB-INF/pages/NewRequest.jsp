<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<!DOCTYPE>
<html>
<head>

<%@ include file="common-code-in-head-section.txt"  %>

<title>Request Calculation</title>

</head>
<body>

   		<div align="center">
        	<form:form action="newreq" method="post" commandName="calcRequestForm">
				<table style="width: 650px" class="table table-striped">
               		<tr> <td>Shape:</td> <td><form:select path="shapeName" items="${shapeList}" /></td> </tr>
               		<tr> <td>Type:</td> <td><form:select path="calcType" items="${calcTypeList}" /></td> </tr>
               		<tr> <td>Dim:</td> <td><form:input path="dimension" /></td> </tr>
               		<tr> <td colspan="2" align="center"><input type="submit" value="Request" /></td> </tr>
            	</table>
        	</form:form>
    	</div>

</body>
</html>