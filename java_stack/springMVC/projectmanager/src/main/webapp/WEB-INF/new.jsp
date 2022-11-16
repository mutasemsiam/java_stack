<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Project</title>
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
		<form:form action="/projects/new" method="post"
			modelAttribute="project" class="regForm">
			<h3>Create a Project</h3>
			<div class="form-group row">
				<form:label path="title" class="col-sm-3 col-form-label">Project Title</form:label>
				<div class="col-sm-9">
					<form:input type="text" class="form-control"
						placeholder="Project Title" path="title" />
				</div>
				<form:errors class="text-danger" path="title" />
			</div>
			<div class="form-group row">
				<form:label path="description" class="col-sm-3 col-form-label">Description</form:label>
				<div class="col-sm-9">
					<form:input type="text" class="form-control"
						placeholder="Description" path="description" />
				</div>
				<form:errors class="text-danger" path="description" />
			</div>
			<div class="form-group row">
				<form:label path="dueDate" class="col-sm-3 col-form-label">Due Date</form:label>
				<div class="col-sm-9">
					<form:input type="date" class="form-control" placeholder="Due date"
						path="dueDate" />
				</div>
				<form:errors class="text-danger" path="dueDate" />
			</div>


			

			<div class="col-sm-6 add-button d-flex justify-content-between">
				<a href="/dashboard" class="btn btn-danger form-control col-sm-2">Cancel</a>
				<button type="submit" class="btn btn-primary form-control col-sm-2">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>