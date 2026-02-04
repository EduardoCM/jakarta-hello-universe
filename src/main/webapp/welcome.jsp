<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container vh-100 d-flex justify-content-center align-items-center">

    <div class="card shadow p-4 text-center" style="width: 400px;">

        <h3 class="mb-3">
            Bienvenido al Curso
        </h3>

        <h5 class="text-primary">
            <%= request.getAttribute("studentName") %>
        </h5>

        <p class="mt-3">
            Tu saludo fue registrado correctamente
        </p>

        <a href="index.jsp" class="btn btn-outline-primary mt-3">
            Volver
        </a>

    </div>

</div>

</body>
</html>
