
<%@page import="java.util.Iterator"%>
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
        <h1>Lista de Usuarios</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Clave</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <% 
                    UsuarioDao dao = new UsuarioDao();
                    List<Usuario> list = dao.listar();
                    Iterator<Usuario> i = list.iterator();
                    Usuario u = null;
                    while(i.hasNext()){
                        u = i.next();
             %>
            
            <tbody>
                <td><%= u.getCedula() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getTelefono() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getClave() %></td>
                <td>
                    <a href="UsuarioControlador?action=editarUsuario&id=<%= u.getCedula() %>">
                        Editar
                    </a>
                    <a href="UsuarioControlador?action=eliminarUsuario&id=<%= u.getCedula() %>">
                        Eliminar
                    </a>
                </td>
            </tbody>
            <% } %>
        </table>
        <a href="../Desarrollo_web_act_2/index.jsp">Volver a la página principal</a> <br/>
        <a href="UsuarioControlador?action=registrarNuevoUsuario">Registrar nuevo usuario</<a>
    </body>
</html>
