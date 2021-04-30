<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" 
	pageEncoding="UTF-8"%>

<%--
========================================================================
=== Note ===============================================================
 This is meant to show the side bar, from level 1 jsp. 
 	i.e. /FOLDER/example.jsp
 	
 this should not be used by another level jsps, otherwise links would 
 not work 
========================================================================
 --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body>
	<input type="checkbox" id="check">
	<label for="check"> <i class="fas fa-bars" id="btn"></i> 
		<i	class="fas fa-times" id="cancel"></i>
	</label>

	<div class="sidebar">
		<header>
			<c:if test="${not empty sessionScope['uid']}">User</c:if> Dashboard 
			<span id="Side_uname"> 
			<c:if test="${not empty sessionScope['userName']}">
					<i class="fas fa-user"></i>
          		${sessionScope['userName']}</c:if>
			</span>
		</header>
		<c:choose>
			<%--
            ==========================
            	When not Signed
            ==========================
             --%>
			<c:when test="${empty sessionScope['userName']}">
				<a href="${pageContext.request.contextPath}/Login.jsp"> <i class="fas fa-sign-in-alt"></i> 
					<span>Sign in</span>
				</a>
			</c:when>
			<c:otherwise>
				
				<a href="${pageContext.request.contextPath}/index.jsp"  > <i class="fas fa-car"></i>
                                        <span>Add new Car</span>
                                </a>	
								
                                <a href="${pageContext.request.contextPath}/table.jsp"  > <i class="fas fa-car"></i>
                                        <span>Car Table</span>
                                </a>

				<a href="${pageContext.request.contextPath}/LogoutServlet"> <i class="fas fa-sign-out-alt">
					</i> <span>Sign out</span>
				</a>
			</c:otherwise>
		</c:choose>
		<%--
            ==================
            	Show Always
            ==================
             --%>
<!--		<a href="../home/about.jsp"> <i class="far fa-question-circle"></i> 
			<span>About</span>
		</a>-->
	</div>
</body>
</html>