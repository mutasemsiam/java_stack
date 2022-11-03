<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css" />
<script type="text/javascript" src="js/script.js"></script>

</head>
<body>
	
	<div class="mycontainer">
	<h1>Here's Your Omikuji!</h1>
	<div class="mymsg">
	<h3>The number is ${number}. You live in ${city} with ${person} as your roommate, ${hobby} for a living</h3>
	</div>
	<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>