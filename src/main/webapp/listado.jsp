<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Listado</title>
    </head>
    <body>
        <div class="container"> 
            <br><center>
            SEGUNDO PARCIAL TEM-742
            <br>
            Nombre: David Hector Canaza Mayta
            <br>
            Carnet: 12990278 LP
            </center>
        </div>
        <div class="container">
        <h1><center>Registro de Seminarios</center></h1>
        <a href="Inicio?action=add" class="btn btn-primary btn-sm"> Nuevo Registro</a>
        <br><br>
        <table class="table table-striped">
            <th>Id</th>
            <th>Titulo</th>
            <th>Expositor</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Cupo</th>
            <th></th>
            <th></th>
            <c:forEach var="item" items="${eventos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.expositor}</td>
                <td>${item.fecha}</td>
                <td>${item.hora}</td>
                <td>${item.cupo}</td>
                <td><a href="Inicio?action=edit&id=${item.id}" class="fas fa-edit"></a></td>
                <td><a href="Inicio?action=delete&id=${item.id}" class="fas fa-trash-alt"></a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
