
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modelos.Docente"%>
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modeloDao.DocenteDao"%>
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
        <h1>Lista de Docentes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Blog</th>
                    <th>Profesional</th>
                    <th>Escalaron</th>
                    <th>Idioma</th>
                    <th>Años de experiencia</th>
                    <th>Area de trabajo</th>
                    <th>Usuario_id</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <% 
                    DocenteDao dao = new DocenteDao();
                    List<Docente> list = dao.listar();
                    Iterator<Docente> i = list.iterator();
                    Docente d = null;
                    while(i.hasNext()){
                        d = i.next();
             %>
            
            <tbody>
                <td><%= d.getId() %></td>
                <td><%= d.getNombre() %></td>
                <td><%= d.getApellidos()%></td>
                <td><%= d.getEmail() %></td>
                <td><%= d.getTelefono() %></td>
                <td><%= d.getBlog() %></td>
                <td>
                    <% if (d.isProfesional()) { %>
                        SI
                    <% } else { %>
                        NO
                    <% } %>
                </td>
                <td>
                    <% if (d.isEscalaron()) { %>
                        SI
                    <% } else { %>
                        NO
                    <% } %>
                </td> 
                <td><%= d.getIdioma()%></td>
                <td><%= d.getAñosExperiencia()%></td>
                <td><%= d.getAreaTrabajo()%></td>
                <td><%= d.getUsuario_id()%></td>
                <td>
                    <a href="DocenteControlador?action=editarDocente&id=<%= d.getId() %>">Editar</a>
                    <a href="DocenteControlador?action=eliminarDocente&id=<%= d.getId() %>">Eliminar</a>
                </td>
            </tbody>
            <% } %> 
        </table>
        <a href="../Desarrollo_web_act_2/index.jsp">Volver a la página principal</a> <br/>
        <a href="DocenteControlador?action=registrarNuevoDocente">Registrar nuevo docente</<a>
    </body>
</html>
