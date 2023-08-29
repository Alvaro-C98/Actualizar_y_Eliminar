<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
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
<title>Edit Book</title>
</head>
<body>    
<h1>Edit Book</h1>
<form:form action="/books/${book.id}" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
<div class="container p-2 m-2">
			<div class="row mb-2">
					<form:label path="title" class="col-sm-1">Title</form:label>
					<form:input path="title" class="col-sm-2"/>
					<form:errors path="title" class="col text-danger"/>
			</div>
			<div class="row mb-2">
					<form:label path="language" class="col-sm-1">Language</form:label>
					<form:input path="language" class="col-sm-2"/>
					<form:errors path="language" class="col text-danger"/>
			</div>
			<div class="row mb-2">
					<form:label path="numberOfPages" class="col-sm-1">Pages</form:label>
					<form:input type="number" path="numberOfPages" class="col-sm-2"/>
					<form:errors path="numberOfPages" class="col text-danger"/>
			</div>
			<div class="row mb-2">
					<form:label path="description" class="col-sm-1">Description</form:label>
					<form:textarea path="description" class="col-sm-2"/>
					<form:errors path="description" class="col text-danger"/>
			</div>
			<input type="submit" value="Submit" />
		</div>
</form:form>


</body>
</html>