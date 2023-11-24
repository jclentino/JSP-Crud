<%-- 
    Document   : registrar
    Created on : 22/11/2023, 12:59:15 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>¡Registrar nuevo usuario!</h1>
        <form action="UsuarioControlador" method="post" >
            <label for="cedula">Cédula:</label>
            <input type="number" id="cedula" name="cedula" required><br>
            <label for="clave">Contraseña:</label>
            <input type="password" id="clave" name="clave" required><br>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>
            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            <input type="submit" name="action" value="CrearUsuario">
        </form>
        <a href="UsuarioControlador?action=listarUsuarios">Volver</<a>
    </body>
</html>
