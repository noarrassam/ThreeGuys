<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page isELIgnored="false" %>
<%@ page import="interfaceapp.Car,com.threeguys.services.Reviews;" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Supplier ${requestScope.action} Details</title>
        <link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	
</head>
<body class="rmdB">
	<%--<%@ include file="/_shared/LeftBar.jsp"%>
	<%@ include file="/_shared/message.jsp"%> --%>
	
	<main class="rmdT">
                <section class="rmdT">
   
		<h1>${requestScope.model.brand} Car Details</h1>
                </section>
		<section class="elements">
			<p><strong>Car brand</strong> ${requestScope.model.brand}</p>
			<c:if test="${not empty requestScope.model.model}">
				<p><strong>Car Model</strong> ${requestScope.model.model}</p>
			</c:if>
			<c:if test="${not empty requestScope.model.engine}">
				<p><strong>Car Engine</strong> ${requestScope.model.engine}</p>
			</c:if>
                        <c:if test="${not empty requestScope.model.transmission}">
				<p><strong>Car Engine</strong> ${requestScope.model.transmission}</p>
			</c:if>
                        <c:if test="${not empty requestScope.model.year}">
				<p><strong>Car Year</strong> ${requestScope.model.year}</p>
			</c:if>
                        <c:if test="${not empty requestScope.model.price}">
				<p><strong>Car Price</strong> ${requestScope.model.price}</p>
			</c:if>
			<c:if test="${not empty requestScope.convimage}">
                            ${requestScope.convimage}
			</c:if>
		</section>
		<section class="rmdT">
   
						<h1>Reviews Section</h1>
					
				
					
	
					
				
			<c:choose>
			<c:when test="${not empty requestScope.reviews}">
                            
						<c:forEach var="review" items="${requestScope.reviews}">		
						<div class="review">	
                                                    <div class="actionButtons">
                                                        <i class="fa fa-trash appearable" style="color:red" onClick=""></i> 
                                                        <i  class="fas fa-pen appearable" style="color:green;" onClick=""></i> 
                                                    </div>
                                                    <div class="reviewTitle">		
                                                        <c:forEach var="test" begin="1" end="${review.rating}">
                                                            <i class="fas fa-star"></i>
                                                        </c:forEach>
                                                        <c:forEach var="test"  begin="${review.rating+1}" end="5">
                                                            <i class="far fa-star"></i>
                                                        </c:forEach>
                                                        <span>${review.title}</span></a>
                                                    </div>

                                                    <div><span>${review.description}</span></a></div>
						</div>
					</c:forEach>	
			</c:when>
			<c:otherwise>
				<tr><td colspan="3"><div>No Reviews Found.</div></td></tr>
			</c:otherwise>
		</c:choose>
			
				
		</section>
                        
                        <form class="toolBox" action="details" id="searchBox"> 			
		
		
				<button type="submit" formaction="./CarServlet" formmethod="get"><i class="fas fa-arrow-left"> Back to List</i></button>
		</form>
		</main>
		
		<footer class="page-footer font-small" style="background-color: #f5f5f5;">
		<div class="footer-copyright text-center py-4" style="align-items: center;">
			<a> © 2021 Three Guys </a>
		</div>
	</footer>
	
</body>
</html>