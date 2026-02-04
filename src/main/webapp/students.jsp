<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Estudiantes</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <h3 class="mb-4 text-center">Estudiantes registrados</h3>

    <table class="table table-bordered table-striped shadow">

        <thead class="table-dark">
        <tr>
            <th>Nombre</th>
            <th>Fecha</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${students}" var="s">
    <tr>
        <td>${s.name}</td>
        <td>${s.createdAt}</td>
        <td>

            <a href="editStudent?id=${s.id}" class="btn btn-sm btn-warning">
                Editar
            </a>

            <a href="deleteStudent?id=${s.id}"
               class="btn btn-sm btn-danger"
               onclick="return confirm('¿Eliminar registro?')">
                Eliminar
            </a>

        </td>
    </tr>
</c:forEach>

        </tbody>

    </table>

    <div class="text-center mt-4">
        <a href="index.jsp" class="btn btn-outline-primary">Volver</a>
    </div>

</div>

</body>
</html>
