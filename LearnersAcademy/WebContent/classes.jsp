<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Classes</title>

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

	<h3>Classes</h3>

	<div class="container">
		<table border=1>
			<tr>
				<th>Class Section</th>
				<th>Teacher Name</th>
				<th>Subject Name</th>
				<th>Class Time</th>
				<th>Students List</th>
			</tr>

			<c:forEach var="Class" items="${classes}">
			<tr>
				<c:url var="studentList" value="ClassServlet">
					<c:param name="getClassStudents" value="getClassStudents"/>
					<c:param name="classId" value="${Class.id }" />
					<c:param name="section" value="${Class.section }" />
					<c:param name="subject" value="${Class.subjectName }" />
				</c:url>

					<td>${Class.section}</td>
					<td>${Class.teacherName}</td>
					<td>${Class.subjectName}</td>
					<td>${Class.time}</td>
					<td><a href="${studentList}">View</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<form action ="ClassServlet" method="post">
	<label>ID : </label>
	<input type="text" name = "id">
	<label>Section : </label>
	<input type="text" name = "section">
	<label>Time : </label>
	<input type="text" name = "time">
	<label>Teacher Name : </label>
	<input type="text" name = "teacherName">
	<label>Subject Name : </label>
	<input type="text" name = "subjectName">
	<br><br><input type="submit" value="Save">
</form>
	
</body>
</html>