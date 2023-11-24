<%-- 
    Document   : registrar
    Created on : 22/11/2023, 12:59:15 AM
    Author     : ACER
--%>

<%@page import="java.util.List"%>
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modelos.Usuario"%>
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modeloDao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>¡Registrar nuevo docente!</h1>
        <form action="DocenteControlador" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" required><br>

            <label for="blog">Blog:</label>
            <input type="text" id="blog" name="blog"><br>

            <label for="profesional">¿Es profesional?</label>
            <select id="profesional" name="profesional" required>
                <option value="esProfesional">SI</option>
                <option value="noEsProfesional">NO</option>
            </select>

            <label for="escalaron">¿Han escalado?</label>
            <select id="escalaron" name="escalaron" required>
                <option value="esEscalaron">SI</option>
                <option value="noEsEscalaron">NO</option>
            </select>

            <label for="idioma">Idioma:</label>
            <input type="text" id="idioma" name="idioma" required><br>

            <label for="experiencia">Años de Experiencia:</label>
            <input type="number" id="experiencia" name="experiencia" required><br>

            <label for="areaTrabajo">Área de Trabajo:</label>
            <input type="text" id="areaTrabajo" name="areaTrabajo" required><br>

            <label for="usuario">Usuario:</label>
            <select id="usuario" name="usuario" required>
                <option value="">Selecciona un usuario</option>
                <%
                    UsuarioDao usuarioDao = new UsuarioDao();
                    List<Usuario> usuarios = usuarioDao.listar();
                    for (Usuario usuario : usuarios) {
                %>
                    <option value="<%= usuario.getCedula() %>"><%= usuario.getNombre() %></option>
                <%
                    }
                %>
            </select><br>

            <input type="submit" name="action" value="CrearDocente">
        </form>
        <a href="DocenteControlador?action=listarDocentes">Volver</<a>
    </body>
</html>
