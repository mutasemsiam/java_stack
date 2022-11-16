<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
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
		<div class="d-flex justify-content-between mynav">
		<h1>Welcome, ${currentUser.firstName} </h1>
		<h6><a href="/logout">Logout</a></h6>
		</div>
		
		<div class="d-flex justify-content-between">
		<h6>All Projects</h6>
		<h6><a href="/projects/new">Create New Project</a></h6>
		</div>
		
		<table class="table table-striped all_books_table">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
     
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${unjoinedProjects}">
    <tr>
      <td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
      <td><c:out value="${project.lead.firstName}"/></td>
      <td><c:out value="${project.dueDate}"/></td>
       <td> <c:choose>
    <c:when test="${project.lead.id == userId}">
   	<div class="d-flex edit_delete">
    <a href="/projects/${project.id}/edit">Edit</a>
     
    <a href="/delete/${project.id}">Delete</a>
    </div>
    
    </c:when>    
    <c:otherwise>
        <a href="/join/${project.id}">Join team</a>
    </c:otherwise>
</c:choose></td>
      
    </tr>
</c:forEach>
  </tbody>
</table>

<h6>Your Projects</h6>
<table class="table table-striped all_books_table">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
     
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${joinedProjects}">
    <tr>
      <td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
      <td><c:out value="${project.lead.firstName}"/></td>
      <td><c:out value="${project.dueDate}"/></td>
       <td> 
         <c:choose>
		    <c:when test="${project.lead.id == userId}">
		   	<div class="d-flex edit_delete">
		    <a href="/projects/${project.id}/edit">Edit</a>
		     
		    <a href="/delete/${project.id}">Delete</a>
		    </div>
		    
		    </c:when>    
		    <c:otherwise>
		        <a href="/leave/${project.id}">leave team</a>
		    </c:otherwise>
		</c:choose>
	 </td>
      
    </tr>
</c:forEach>
  </tbody>
</table>

		</div>
</body>
</html>