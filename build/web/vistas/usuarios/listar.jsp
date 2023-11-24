
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Usuario"%>
<%@page import="modeloDao.UsuarioDao"%>
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
                    <a>Editar</a>
                    <a>Eliminar</a>
                </td>
            </tbody>
            <% } %>
        </table>
    </body>
</html>
