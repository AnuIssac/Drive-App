<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty placementstats}">
	<table align="left" border="1">
<tr>
			<th>Placement Stats Id:</th>
			<th>Company Id:</th>
		<th>Year:</th>
		 <th>Branch:</th>
			<th>No applied:</th>
		<th>Total no of students:</th>
	    <th>No of students selected:</th>
			<th>No of students rejected:</th>
		<th>No of students joined:</th>
	   <th>Percentage placed:</th>
			
		
		</tr>
		<c:forEach items="${placementstats}" var="a">
			<tr>
			
			<td>${a.placment_stats_id}</td>	
			<td>${a.company_id}</td>	
		    <td>${a.year}</td>	
			<td>${a.branch}</td>	
			<td>${a.no_applied}</td>	
		    <td>${a.total_no_of_students}</td>	
			<td>${a.no_selected}</td>	
			<td>${a.no_rejected}</td>	
		    <td>${a.no_joined}</td>	
		    <td>${a.percentage_placed }
								
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>