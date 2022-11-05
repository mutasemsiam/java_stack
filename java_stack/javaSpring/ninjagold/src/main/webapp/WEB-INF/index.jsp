<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
  <div class="container">
        <div class="top">
            <h1>Your Gold:</h1>
            <div class="col-md-8">
                <section class="total"><c:out value="${totalGold}"></c:out></section>
            </div>
          <div class="restart_button text-center"><a href="/delete">Restart</a></div>
        </div>
        <div class="row" id="places">
            <div class="col-md-3">
                <h3 class="text-center">Farm</h3>
                <h4 class="text-center">(earns 10-20 gold)</h4>
                <form class="gold_button text-center" action="/process_money" method="post">
                    <input type="hidden" name="goldGame" value="farm">
                    <button>Find Gold!</button>
                </form>
            </div>
            <div class="col-md-3">
                    <h3 class="text-center">Cave</h3>
                    <h4 class="text-center">(earns 10-20 gold)</h4>
                    <form class="gold_button text-center" action="/process_money" method="post">
                        <input type="hidden" name="goldGame" value="cave">
                        <button>Find Gold!</button>
                    </form>
            
            </div>
            <div class="col-md-3">
                
                    <h3 class="text-center">House</h3>
                    <h4 class="text-center">(earns 10-20 gold)</h4>
                    <form class="gold_button text-center" action="/process_money" method="post">
                        <input type="hidden" name="goldGame" value="house">
                        <button>Find Gold!</button>
                    </form>
            
            </div>
            <div class="col-md-3">
                    <h3 class="text-center">Quest</h3>
                    <h4 class="text-center">(earns/takes 0-50 gold)</h4>
                    <form class="gold_button text-center" action="/process_money" method="post">
                        <input type="hidden" name="goldGame" value="quest">
                        <button>Find Gold!</button>
                    </form>
            </div>
        
            <div class="col-md-12">
                <h1>Activities:</h1>
                <div class="activities">
               	<c:forEach items="${showMessages}" var="msg">
               	
				<c:choose>
					<c:when test="${msg.contains('lost')}">
						<p class="text-danger">${msg}</p>
					</c:when>
					<c:otherwise>
						<p class="text-success">${msg}</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>
</html>