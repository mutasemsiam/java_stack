<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="container">
		
		<div class="d-flex justify-content-between">
		<h3>Project Details</h3>
		<h6><a href="/dashboard">Back to Dashboard</a></h6>
		</div>
			
			<div class="form-group row">
				<p class="col-sm-3 col-form-label">Project:</p>
				<p class="col-sm-9">${project.title}</p>	
			</div>
			<div class="form-group row">
				<p class="col-sm-3 col-form-label">Description:</p>
				<p class="col-sm-9">${project.description}</p>	
			</div>
			<div class="form-group row">
				<p class="col-sm-3 col-form-label">Due Date:</p>
				<p class="col-sm-9">${project.dueDate}</p>	
			</div>
			<div class="form-group row">
				<p class="col-sm-3 col-form-label">Project Lead:</p>
				<p class="col-sm-9">${project.lead.firstName}</p>	
			</div>
			<div class="form-group row">
				<p class="col-sm-3 col-form-label">Members:</p>
				
				<ul class="col-sm-9">
				<c:forEach var="member" items="${project.members}">
				<li>${member.firstName}</li>
				</c:forEach>
				</ul>
					
			</div>
			
			     <c:choose>
		    <c:when test="${project.lead.id == userId}">
		   	<div class="col-sm-2 add-button d-flex justify-content-between">
				<a href="/delete/${project.id}" class="btn btn-danger form-control">Delete</a>
				
			</div>
		    
		    </c:when>    
		</c:choose>
			
			
			
	</div>
</body>
</html>