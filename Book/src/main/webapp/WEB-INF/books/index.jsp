<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<!-- your own local CSS-->
<link rel="stylesheet" href="/css/main.css"/>
<!-- for any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<h1>All Books</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Description</th>
				<th scope="col">Language</th>
				<th scope="col">Number of Pages</th>
				<th scope="col">Edit Book</th>
				<th scope="col">Delete Book</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<th scope="row"><a href="/books/${book.id}"><c:out value="${book.id}"/></a></th>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.description}" /></td>
					<td><c:out value="${book.language}" /></td>
					<td><c:out value="${book.numberOfPages}" /></td>
					<td><a href="/books/${book.id}/edit"><button>Edit</button></a></td>
					<td><form action="/books/${book.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete"></form></td>
    				
    				
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/books/new"><button>New Book</button></a>

</body>
</html>