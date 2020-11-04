<%-- 
    Document   : alumnos
    Created on : 4/11/2020, 04:12:15 PM
    Author     : dajaimes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Librería de core para JSP --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Escolar</title>
    </head>
    <body>
        <h1>Alumnos</h1
        <ul>
            <c:forEach var="alumno" items="${alumnos}">
                <li>${alumno.id} ${alumno.nombre} ${paterno} ${alumno.materno}</li>
            </c:forEach>
        </ul>
    </body>
</html>
