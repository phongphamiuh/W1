<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css" />"></link> 	
</head>
<body>
    <div align="center">
        <h2>Edit Customer</h2>
        <form:form action="save" method="post" modelAttribute="book">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${book.bookID}
                        <form:hidden path="bookID"/>
                    </td>
                </tr>        
                <tr>
					<td>Book Name: </td>
					<td><form:input path="bookName" /></td>
				</tr>
				<tr>
					<td>Author: </td>
					<td><form:input path="author" /></td>
				</tr>
				<tr>
					<td>Publish Year: </td>
					<td><form:input path="publishYear" /></td>
				</tr>		
				
				<tr>
					<td>Rating: </td>
					<td><form:input path="rating" /></td>
				</tr>	
				
				<tr>
					<td>Address: </td>
					<td><form:input type="file" path="image"/></td>
				</tr>	
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>