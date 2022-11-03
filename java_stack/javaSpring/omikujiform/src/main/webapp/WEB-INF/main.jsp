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
	

<form action="/omikuji/process" method="POST">
<label>Pick any number from 5 to 25</label>
<div class="d-flex">
  <div class="value-button" id="decrease" onclick="decreaseValue()" onmouseover="" style="cursor: pointer;" value="Decrease Value">-</div>
  <input type="number" id="number" value="5" name="number" />
  <div class="value-button" id="increase" onclick="increaseValue()" onmouseover="" style="cursor: pointer;" value="Increase Value">+</div>
</div>
<div>
<label>Enter the name of any city</label>
<div>
<input type="text" name="city">
</div>
</div>
<div>
<label>Enter the name of any person</label>
<div>
<input type="text" name="person">
</div>
</div>
<div>
<label>Enter a hobby</label>
<div>
<input type="text" name="hobby">
</div>
</div>
<div>
<input type="submit" value="Send" class="btn-primary">
</div>
</form>
</div>

</body>
</html>