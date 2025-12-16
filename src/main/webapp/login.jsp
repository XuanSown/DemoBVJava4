<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4">
			<h3 class="text-center mb-3">Login</h3>
			<div class="text-danger mt-2">${message}</div>
			<form action="LoginServlet" method="post">
				<div class="mb-3">
					<input type="text" name="id" class="form-control"
					placeholder="Nhập UserID" required>
				</div>
				<div class="mb-3">
					<input type="password" name="password" class="form-control"
					placeholder="Nhập password" required>
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
</body>
</html>