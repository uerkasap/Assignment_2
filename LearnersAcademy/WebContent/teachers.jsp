<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
p {
	color: white;
	background-color: black;
	padding: 10px;
}
</style>

</head>
<body style="background-color:powderblue;">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">LA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="navbar.jsp">Home</a></li>
					<%
					String id = (String) session.getAttribute("id");
					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="ClassServlet">Classes</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="SubjectServlet">Subjects</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="TeacherServlet">Teachers</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="StudentServlet">Students</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Log out</a>
					</li>
					<%
					}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<h3>Teachers</h3>

	<div class="container">
		<table border=1>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>age</th>
			</tr>
			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td>${teacher.fname}</td>
					<td>${teacher.lname}</td>
					<td>${teacher.age}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<br><br>
	<form action ="TeacherServlet" method="post">
	<label>First Name : </label>
	<input type="text" name = "fname">
	<label>Last Name : </label>
	<input type="text" name = "lname">
	<label>Age : </label>
	<input type="text" name = "age">
	<br><br><input type="submit" value="Save">
	
</body>
</html>