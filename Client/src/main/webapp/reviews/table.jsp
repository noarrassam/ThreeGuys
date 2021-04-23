<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Supplier List</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" >
	
	<script>
	function resetForm(e) {
	  document.getElementById('search').value = ""
	  document.forms.searchBox.submit();
	}
	</script>
</head>
<body class="rmdB">
		<div class="table-wrapper">
		<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h1>Reviews' List</h1>
					</div>
					<div class="col-sm-7">
						<form action="" Method="POST" id="searchBox" class="table-title">
							<div class="searchItem">
								<c:if test="${not empty requestScope.search}">
									<button id="clearButton" onclick="resetForm(this)"><i class="fa fa-close tablebtn"></i></button>
								</c:if>
								<input type="text" placeholder="Type a keyword" name="search" id="search" value="${requestScope.search}"/>
								<button type="submit"><i class="fa fa-search"></i></button>
							</div>
							<%--<c:if test="${sessionScope.urole == 'Administrator' or sessionScope.urole == 'Manager'}">--%>
								<button type="submit" formaction="reviews/add" formmethod="get"><i class="fas fa-plus"> Add New</i></button>
							<%--</c:if>--%>
					</form>
					</div>
				</div>
			</div>
	<c:choose>
		<c:when test="${not empty requestScope.list}">
		
			
			<table class="rmdT table-striped table-hover">				
					<tr>
						<th><span>Car ID</span></th>
                                                <th><span>User ID</span></th>
						<th><span>Title</span></th>
						<th><span>rating</span></th>
                                                <th><span>Description</span></th>
						<%--<c:if test="${sessionScope.urole == 'Administrator' or sessionScope.urole == 'Manager'}">--%>
                                                    <th><span>Actions</span></th>
						<%--</c:if>--%>
					</tr>
					<c:forEach var="review" items="${requestScope.list}">		
					<tr>											
						<td><a href="./Details?id=${review.reviewID}"><span>${review.carID}</span></a></td>
                                                <td><a href="./Details?id=${review.reviewID}"><span>${review.userID}</span></a></td>
						<td><a href="./Details?id=${review.reviewID}"><span>${review.title}</span></a></td>
                                                <td><a href="./Details?id=${review.reviewID}"><span>${review.rating}</span></a></td>
						<td><a href="./Details?id=${review.reviewID}"><span>${review.description}</span></a></td>
                                                <td class="actionCell"><div>
							<a href="javascript:confirmGo('Are you sure you want to delete?','./Delete?id=${review.reviewID}')"><i class="fa fa-close" style="color:red;"></i> </a> 
                                                <a href="./Edit?id=${review.reviewID}"><i class="fas fa-pen" style="color:green;"></i> </a>
                                            </div></td>
						<!--<c:if test="${sessionScope.urole == 'Administrator' or sessionScope.urole == 'Manager'}">-->
						
	                	<!--</c:if>-->
					</tr>
				</c:forEach>
				</table>
		</c:when>
		<c:otherwise>
			<p>No Reviews Found.</p>
		</c:otherwise>
	</c:choose>
		</div>
		
		<footer class="page-footer font-small" style="background-color: #f5f5f5;">
		<div class="footer-copyright text-center py-4" style="align-items: center;">
			<a> © 2021 Three Guys </a>
		</div>
	</footer>
</body>
</html>
