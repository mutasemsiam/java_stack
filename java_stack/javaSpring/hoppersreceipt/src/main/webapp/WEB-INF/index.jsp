<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Customer Name: <c:out value="${name}"></c:out></h1>
	<h4>Item Name: <c:out value="${item}"></c:out></h4>
	<h4>Price: $<c:out value="${price}"></c:out></h4>
	<h4>Description: <c:out value="${desc}"></c:out></h4>
	<h4>Vendor: <c:out value="${vendor}"></c:out></h4>
	
	
</body>
</html>