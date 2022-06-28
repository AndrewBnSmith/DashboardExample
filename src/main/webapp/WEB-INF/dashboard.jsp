<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Welcome, <c:out value="${user.firstName }"/></h1>
		<h6>Course Schedule</h6>
		<a href="/logout">Log out</a>
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Instructor</th>
					<th>Weekday</th>
					<th>Price</th>
					<th>Time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
					
						<td><a href="/courses/${course.id}"><c:out value="${course.name }"/> </a>
						<c:if test="${user_id == course.creator.id }">
								<a href="/courses/edit/${course.id}">Edit</a>
								<a href="/courses/delete/${course.id}">Delete</a>
						</c:if>
					
						<td>
							<c:out value="${course.creator.firstName }"/>
						</td>
						<td><c:out value="${course.day }"/></td>	
						<td>$<c:out value="${course.price }"/></td>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/courses/new">New course</a>
	</div>
</body>
</html>