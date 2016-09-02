<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE>
<html>
<head>

<%@ include file="common-code-in-head-section.txt"  %>

<title>Current Request List</title>

</head>
<body>

    <div align="center">
		<c:choose>
       		<c:when test="${ not empty message }">
       			${message}<br/>
       		</c:when>
       		<c:when test="${ not empty calcReqList }">
				<table style="width: 650px" class="table table-striped">
				<tr> <td>Shape</td><td>Type</td><td>Dimension</td></tr>
					<c:forEach items="${calcReqList }" var="req">
           				<tr> <td>${req.shapeName}</td><td>${req.calcType}</td><td>${req.dimension}</td> </tr>
					</c:forEach>
       			</table>
       		</c:when>
       	</c:choose>
    </div>

</body>
</html>