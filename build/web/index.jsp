<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aplicación MVC</h1>
        <nav>
            <ul>
                <h3>Usuarios</h3>
                <li><a href="UsuarioControlador?action=listarUsuarios">Listar Usuarios</a></li>
            </ul>
            <ul>
                <h3>Docentes</h3>
                <li><a href="DocenteControlador?action=listarDocentes">Listar Docentes</a></li>
            </ul>
        </nav>
    </body>
</html>
