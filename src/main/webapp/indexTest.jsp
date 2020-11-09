<%-- 
    Document   : indexTest
    Created on : 7/11/2020, 06:29:18 AM
    Author     : dajaimes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alumnos</h1>
        <a href="${pageContext.request.contextPath}/ServletAlumno?accion=seleccionar">Lista de alumnos</a>
    </body>
</html>
