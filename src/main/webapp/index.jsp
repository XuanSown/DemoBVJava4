<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark mb-4">
		<div class="container">
			<div class="d-flex">
				<!-- đăng nhập -->
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="card p-4 mb-4">
			<h3 class="text-center">User Management - CRUD</h3>
			<div class="alert alert-into">${message}</div>

			<!-- Form input -->
			<form action="${pageContext.request.contextPath }/user/index"
				method="post">
				<div class="mb-3">
					<input type="text" name="id" class="form-control"
						value="${user.id}" placeholder="UserID">
				</div>
				<div class="mb-3">
					<input type="password" name="password" class="form-control"
						value="${user.password}" placeholder="Password">
				</div>
				<div class="mb-3">
					<input type="text" name="fullname" class="form-control"
						value="${user.fullname}" placeholder="Fullname">
				</div>
				<div class="mb-3">
					<input type="email" name="email" class="form-control"
						value="${user.email}" placeholder="Email">
				</div>
				<div class="mb-3">
					<label>Role</label> <br>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="admin"
							value="true" ${user.admin ? 'checked' : ''}> <label
							class="form-check-label">Admin</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="admin"
							value="false" ${user.admin ? 'checked' : ''}> <label
							class="form-check-label">User</label>
					</div>
				</div>

				<button formaction="${pageContext.request.contextPath}/user/create"
					class="btn btn-primary">Create</button>
				<button formaction="${pageContext.request.contextPath}/user/update"
					class="btn btn-warning">Update</button>
				<button formaction="${pageContext.request.contextPath}/user/delete"
					class="btn btn-danger">Delete</button>
				<a href="${pageContext.request.contextPath}/user/index"
					class="btn btn-success">Reset</a>
			</form>
		</div>

		<!-- Tìm kiếm -->
		<form action="${pageContext.request.contextPath}/user/index"
			method="get">
			<div class="col-auto">
				<input type="text" name="search" class="form-control"
					placeholder="Tìm kiếm theo Fullname...">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-outline-primary">Search</button>
			</div>
		</form>

		<!-- Table -->
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>User ID</th>
					<th>Password</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.id}</td>
						<td>${item.password}</td>
						<td>${item.fullname}</td>
						<td>${item.email}</td>
						<td>${item.admin ? 'Admin':'User'}</td>
						<td><a
							href="${pageContext.request.contextPath}/user/edit?id=${item.id}"
							class="btn btn-sm btn-info">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>