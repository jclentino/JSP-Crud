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
        <% 
            UsuarioDao dao = new UsuarioDao();
            int id = Integer.parseInt((String)request.getAttribute("idUser"));
            Usuario u = (Usuario)dao.list(id);
            
        %>
        <h1>¡Editar usuario!</h1>
        <form action="UsuarioControlador" method="put" >
            <label for="cedula">Cédula:</label>
            <input type="number" id="cedula" name="cedula" required readonly value="<%= u.getCedula() %>" ><br>
            <label for="clave">Contraseña:</label>
            <input type="password" id="clave" name="clave" required value="<%= u.getClave() %>"><br>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required value="<%= u.getNombre()%>"><br>
            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" required value="<%= u.getTelefono()%>"><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required value="<%= u.getEmail() %>"><br>            
            <input type="submit" name="action" value="ActualizarUsuario">
        </form>
        <a href="UsuarioControlador?action=listarUsuarios">Volver</<a>
    </body>
</html>
