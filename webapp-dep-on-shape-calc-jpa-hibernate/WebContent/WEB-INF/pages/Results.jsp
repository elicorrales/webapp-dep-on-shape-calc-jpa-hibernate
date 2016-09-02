<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE>
<html>
<head>

<%@ include file="common-code-in-head-section.txt"  %>

<title>List Results(Run if Needed)</title>

</head>
<body>

    <div align="center">
		<c:choose>
       		<c:when test="${ not empty message }">
       			${message}<br/>
       		</c:when>
       		<c:when test="${ not empty resultsList }">

				<div align="center">
       				<form:form action="delallres" method="post" commandName="deleteAllResultsForm">
						<table style="width: 650px" class="table table-striped">
           					<tr> <td align="center"><input type="submit" value="Delete All Results" /></td> </tr>
           				</table>
       				</form:form>
   				</div>

				<table style="width: 650px" class="table table-striped">
				<tr> <td>Shape</td><td>Type</td><td>Dimension</td><td>Result</td></tr>
					<c:forEach items="${resultsList }" var="res">
            		<tr> <td>${res.shapeName}</td><td>${res.calcType}</td><td>${res.dimension}</td><td>${res.result }</td></tr>
					</c:forEach>
        		</table>
       		</c:when>
       	</c:choose>
    </div>
</body>
</html>