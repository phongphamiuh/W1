<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css" />"></link> 	
</head>
<body>
<div align="center">
    <h2>Book Manager</h2>
    
    <h3><a href="${pageContext.request.contextPath}/book">New Book</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Author </th>
            <th>Publish Year</th>
            <th>Rating</th>
            <th>Image</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
        <tr>
            <td><c:out value="${book.bookID}"></c:out></td>
            <td><c:out value="${book.bookName}"></c:out></td>
            <td><c:out value="${book.author}"></c:out></td>
            <td><c:out value="${book.publishYear}"></c:out></td>
            <td><c:out value="${book.rating}"></c:out></td>
            <td><img src="${pageContext.request.contextPath}/book/photo/${book.bookID}"></img></td>
            <td>
                <a href="${pageContext.request.contextPath}/book/edit?id=${book.bookID}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/book/delete?id=${book.bookID}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>