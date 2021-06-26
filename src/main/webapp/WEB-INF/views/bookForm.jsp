<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <style>  
        .error {color:red}  
    </style>
	<form:form action="${pageContext.request.contextPath}/book" method="POST"  
			modelAttribute="book" class="form" enctype="multipart/form-data">
		<table border="0" cellpadding="5">
				<tr>
					<td>Book Name: </td>
					<td><form:input path="bookName" /></td>
					<td><form:errors path="bookName" cssClass="error" />  </td>
				</tr>
				<tr>
					<td>Author: </td>
					<td><form:input path="author" /></td>
					<td><form:errors path="author" cssClass="error" />  </td>
				</tr>
				<tr>
					<td>Publish Year: </td>
					<td><form:input path="publishYear" /></td>
					<td><form:errors path="publishYear" cssClass="error" />  </td> 
				</tr>		
				
				<tr>
					<td>Rating: </td>
					<td><form:input path="rating" /></td>
					<td><form:errors path="rating" cssClass="error" />  </td>
				</tr>	
				
				<tr>
					<td>Image: </td>
					<td><form:input type="file" path="image"/></td>
					<td><form:errors path="image" cssClass="error" />  </td>
				</tr>	
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>	
									
		</table>
	</form:form>