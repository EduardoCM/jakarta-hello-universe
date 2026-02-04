<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Hola Mundo Multicapa</title>

<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">


	<div
		class="container vh-100 d-flex justify-content-center align-items-center">

		<div class="card shadow p-4" style="width: 350px;">
			<h4 class="text-center mb-3">Hola Mundo</h4>

			<form action="greet" method="post">

				<div class="mb-3">
					<input type="text" name="studentName" class="form-control"
						placeholder="Tu nombre" required>
				</div>

				<div class="mb-3">
					<input type="email" name="email" class="form-control mb-3"
						placeholder="Tu correo" required>
				</div>


				<div class="d-grid">
					<button class="btn btn-primary">Saludar</button>
					<a href="students" class="btn btn-outline-secondary"> Ver
						estudiantes registrados </a>
				</div>

			</form>
		</div>

	</div>

</body>
</html>
