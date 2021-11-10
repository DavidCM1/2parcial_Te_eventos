<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>
            <c:if test="${evento.id ==0}">Nuevo</c:if>
            <c:if test="${evento.id !=0}">Editar</c:if>
            Registro
        </h1>
            <form action="Inicio" method="post">
                <input type="hidden" name="id" value="${evento.id}">
            <label ">Titulo</label>
            <input type="text"  name="titulo" value="${evento.titulo}" placeholder="Escriba su Titulo">
            <br><br>
            <label>Expositor</label>
            <input type="text"  name="expositor" value="${evento.expositor}" placeholder="Escriba el Expositor">
            <br><br>
            <lable>Fecha</lable>
            <input type="date" name="fecha" value="${evento.fecha}" >
            <br><br>
            <label>Hora</label>
            <input type="text" name="hora" value="${evento.hora}" placeholder="Ingrese la hora de inicio y hora final">
            <br><br>
            <label>Cupo</label>
            <input type="number" name="cupo" min="0" value="${evento.cupo}" >
            <br><br>
            <input type="submit" class="btn btn-primary" value="Enviar">
            </form>

    </body>
</html>
