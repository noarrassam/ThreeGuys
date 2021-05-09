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
	<%@ include file="/_shared/userbar.jsp"%>
	<%@ include file="/_shared/message.jsp"%> 
        
        
	<c:if test="${empty sessionScope.uid}">
            <p style="color:red;">Unauthorized</p>
        </c:if>
        <c:if test="${not empty sessionScope.uid}">
	<main class="rmdT">
                <section class="rmdT">
                <form class="toolBox" action="details" id="searchBox"> 			
			<button type="submit" formaction="./table.jsp" formmethod="get"><i class="fas fa-arrow-left"> Back to List</i></button>
		</form>
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
                                                
                                                    <c:choose>
                                                            <c:when test="${review.reviewID == requestScope.review.reviewID}">
                                                                <!--this means review is being editted-->
                                                                <div class="review selected">	
                                                            </c:when>
                                                    <c:otherwise>
                                                                 <div class="review">	
                                                            </c:otherwise>
                                                    </c:choose>
						
                                                  
                                                    <c:if test="${review.userID == sessionScope.uid}">
                                                        <div class="actionButtons">
                                                            <i class="fa fa-trash appearable" style="color:red" onclick="confirmGo('Are you sure you want to delete the review?',window.location='./deleteReview?id=${review.carID}&reviewID=${review.reviewID}')"></i> 
                                                            <i  class="fas fa-pen appearable" style="color:green;" onclick="window.location='./details?action=edit&id=${review.carID}&reviewID=${review.reviewID}'"></i> 
                                                        </div>
                                                    </c:if>
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
                                
                                
		<form action="./${requestScope.action}Review" method="POST" class="rmdT">
                    <input type="submit" class="btnSave" value="${requestScope.action}" class="btn btn-primary btn-block btn-lg"/>
                        <h2>${requestScope.action} Review</h2>
                        
                        <input type="hidden" name="reviewID" value="${requestScope.review.reviewID}" />
                        <input type="hidden" name="uid" value="${sessionScope.uid}" />
                        <input type="hidden" name="id" value="${requestScope.model.id}" />

                        <div class="formElement">
                                <label for="name">Review Title:</label>
                                <input type="text" class="form-control" id="name" name="title" placeholder="Review Title" value="${requestScope.review.title}"/>
                        </div>
                        <div class="formElement">
                                <label for="contact">Review Rating:</label>
                                <input type="Number"  class="form-control" id="contact" name="rating" placeholder="Rating 1-5" max="5" min="1" value="${requestScope.review.rating}"/>
                        </div>
                        <div class="formElement">
                                <label for="comments">Description:</label> <br />
                                <textarea id="comments"  class="form-control" name="description" placeholder="Add extra details" >${fn:trim(requestScope.review.description)}</textarea>
                        </div>
                        
                </form>
				
		</section>
                        
                
		</main>
		</c:if>
    <footer class="page-footer font-small" style="background-color: #f5f5f5;">
		<div class="footer-copyright text-center py-4" style="align-items: center;">
			<a> © 2021 Three Guys </a>
		</div>
	</footer>
	<script>function confirmGo(msg,url) {
    if ( confirm(msg) ) {
        window.location = url;
    }
        }
    
const appendError = (controlName, innerHTML) => {
	 	
			 var controlElement = document.getElementById(controlName);
			 var span = document.createElement("span");
			 span.innerHTML = innerHTML;
			 controlElement.parentNode.insertBefore( span, controlElement.nextSibling );
 		}
	
/*
	Insert Top Corner Message
*/ 
	 const insertMessage = (Message, ErrBoolean) => {
		 let msgobj = document.createElement("div");
         msgobj.setAttribute("id", "CtlMsg");
         if (!ErrBoolean) msgobj.setAttribute("class", "CtlMsg success"); else msgobj.setAttribute("class", "CtlMsg fail");
         msgobj.innerHTML = Message;
		 document.body.appendChild(msgobj);
		 removeSlowly("CtlMsg");
	 }
        

/*
	Fade Out Animation used mainly for Message
*/
	 const removeSlowly = controlName => {
		 	let obj = document.getElementById(controlName);
		 	obj.style.opacity =  1;
		 	setTimeout(() => {
		 		let fx = setInterval(() => {
		        	if (obj.style.opacity != 0) { 
		        		obj.style.opacity -=  0.1;
    				} else {
	    				clearInterval(fx);
			        	obj.remove();    
			        }
				}, 50);	
			}, 1000);     
	 }     
    
</script>
</body>
</html>