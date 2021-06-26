<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/font-awesome-4.5.0/css/font-awesome.min.css"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css" />"></link> 

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<c:forEach items="${bookList}" var="book">
					    <div class="col-md-6">
							<div class="card" style="width: 100%">
							  <img class="card-img-top" src="${pageContext.request.contextPath}/book/photo/${book.bookID}" alt="Card image cap">
							  <div class="card-body">
							    <h5 class="card-title"><c:out value="${book.bookName}"></c:out></h5>
							    <p class="card-text">By <c:out value="${book.author}"></c:out></p>
							    <a href="#"><c:out value="${book.rating}"></c:out></a>
	  					  	   </div>
							</div>
						</div>
	        		</c:forEach>
				</div>
			</div>
			<div class="col-md-4">
				<ul class="nav flex-column">
				  <li class="nav-item">
				    <a href="${pageContext.request.contextPath}/book">
        				Add book</a>
				  </li>
				  <li class="nav-item">
				    <a href="${pageContext.request.contextPath}/book/list">
   	 					Manager</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="#">Copy Right</a>
				  </li>
				</ul>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</html>