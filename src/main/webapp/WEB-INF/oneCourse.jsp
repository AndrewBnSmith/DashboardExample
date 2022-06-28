<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Show Book</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${course.name }"/></h1>
		<h5>Day: <c:out value="${course.day }"/></h5>
		<h5>Cost: $<c:out value="${course.price }"/></h5>
		<h5>Time:</h5>
		<h6><c:out value="${course.description }"/></h6>
		
		<a href="/courses/delete/${course.id}">Delete</a>
		<a href="/dashboard">Cancel</a>
		<a href="/courses/edit/${course.id}">Edit</a>
		
	</div>
</body>
