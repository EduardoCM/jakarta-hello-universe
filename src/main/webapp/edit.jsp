<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<div
		class="container vh-100 d-flex justify-content-center align-items-center">

		<div class="card p-4 shadow" style="width: 350px">

			<h4 class="text-center mb-3">Editar estudiante</h4>

			<form action="updateStudent" method="post">

				<input type="hidden" name="id" value="${student.id}" /> <input
					name="name" class="form-control mb-3" value="${student.name}"
					required>

				<button class="btn btn-success w-100">Actualizar</button>

			</form>

		</div>
	</div>

</body>
</html>