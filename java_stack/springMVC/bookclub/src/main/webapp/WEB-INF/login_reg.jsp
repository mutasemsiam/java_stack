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

		<h1>Welcome!</h1>

		<h4>Join our growing community.</h4>

		<div class="d-flex myforms">
			<form:form action="/register" method="post" modelAttribute="newUser"
				class="regForm">
				<h3>Registration</h3>
				<div class="form-group row">
					<form:label path="userName" class="col-sm-3 col-form-label">User
						Name</form:label>
					<div class="col-sm-9">
						<form:input type="text" class="form-control"
							placeholder="User Name" path="userName" />
					</div>
					<form:errors class="text-danger" path="userName" />
				</div>

				<div class="form-group row">
					<form:label path="email" class="col-sm-3 col-form-label">Email</form:label>
					<div class="col-sm-9">
						<form:input type="email" class="form-control" placeholder="Email"
							path="email" />
					</div>
					<form:errors class="text-danger" path="email" />
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-3 col-form-label">Password</form:label>
					<div class="col-sm-9">
						<form:input type="password" class="form-control"
							placeholder="Password" path="password" />
					</div>
					<form:errors class="text-danger" path="password" />
				</div>
				<div class="form-group row">
					<form:label path="confirm" class="col-sm-3 col-form-label">Confirm PW</form:label>
					<div class="col-sm-9">
						<form:input type="password" class="form-control"
							placeholder="Password" path="confirm" />
					</div>
					<form:errors class="text-danger" path="confirm" />
				</div>

				<div class="col-sm-4 add-button">
					<button type="submit" class="btn btn-primary form-control">Register</button>
				</div>

			</form:form>

			<form:form action="/login" method="post" modelAttribute="newLogin"
				class="loginForm">

				<h3>Login</h3>
				<div class="form-group row">
					<form:label path="email" class="col-sm-3 col-form-label">Email</form:label>
					<div class="col-sm-9">
						<form:input type="email" class="form-control" placeholder="Email"
							path="email" />
					</div>
					<form:errors class="text-danger" path="email" />
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-3 col-form-label">Password</form:label>
					<div class="col-sm-9">
						<form:input type="password" class="form-control"
							placeholder="Password" path="password" />
					</div>
					<form:errors class="text-danger" path="password" />
				</div>

				<div class="col-sm-4 add-button">
					<button type="submit" class="btn btn-primary form-control">Log
						In</button>
				</div>

			</form:form>


		</div>



	</div>

</body>
</html>