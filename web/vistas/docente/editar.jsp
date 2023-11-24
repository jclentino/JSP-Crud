<%@page import="java.util.List"%>
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modeloDao.DocenteDao"%>
<%@page import="co.edu.udec.devweb.actividad2.juan_lentino.modelos.Docente"%>
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
            DocenteDao dao = new DocenteDao();
            UsuarioDao Udao = new UsuarioDao();
            int id = Integer.parseInt((String)request.getAttribute("idDocente"));
            Docente d = (Docente)dao.list(id);
            
        %>
        <h1>¡Editar docente!</h1>
        <form action="DocenteControlador" method="put">
            <input type="hidden" id="id" name="id"  value="<%= d.getId() %>" required readonly><br>

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre"  value="<%= d.getNombre()%>" required><br>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" value="<%= d.getApellidos()%>"  required><br>

            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" value="<%= d.getTelefono()%>" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= d.getEmail()%>" required><br>

            <label for="blog">Blog:</label>
            <input type="text" id="blog" name="blog" value="<%= d.getBlog()%>" required ><br>


            <label for="profesional">¿Es profesional?</label>
            <select id="profesional" name="profesional" required>
                <%
                    if (d.isProfesional()) {
                %>
                    <option value="esProfesional" selected>SI</option>
                    <option value="noEsProfesional">NO</option>
                <%
                    } else {
                %>
                    <option value="esProfesional">SI</option>
                    <option value="noEsProfesional" selected>NO</option>
                <%
                    }
                %>
            </select>
        
            <label for="escalaron">¿Han escalado?</label>
            <select id="escalaron" name="escalaron" required>
                <%
                    if (d.isProfesional()) {
                %>
                    <option value="esEscalaron" selected>SI</option>
                    <option value="noEsEscalaron">NO</option>
                <%
                    } else {
                %>
                    <option value="esEscalaron">SI</option>
                    <option value="noEsEscalaron" selected>NO</option>
                <%
                    }
                %>
            </select>


            <label for="idioma">Idioma:</label>
            <input type="text" id="idioma" name="idioma" value="<%= d.getIdioma()%>" required><br>

            <label for="añosExperiencia">Años de Experiencia:</label>
            <input type="number" id="añosExperiencia" name="añosExperiencia" value="<%= d.getAñosExperiencia()%>" required><br>

            <label for="areaTrabajo">Área de Trabajo:</label>
            <input type="text" id="areaTrabajo" name="areaTrabajo" value="<%= d.getAreaTrabajo()%>" required><br>

            <label for="usuario">Usuario:</label>
            <select id="usuario" name="usuario" required>
                <option value="">Selecciona un usuario</option>
                <% 
                    List<Usuario> usuarios = Udao.listar();
                    for (Usuario usuario : usuarios) {
                        String selected = (usuario.getCedula() == d.getUsuario_id()) ? "selected" : "";
                %>
                        <option value="<%= usuario.getCedula() %>" <%= selected %>><%= usuario.getNombre() %></option>
                <%
                    }
                %>
            </select><br>
        
            <input type="submit" name="action" value="ActualizarDocente">
        </form>
        <a href="DocenteControlador?action=listarDocentes">Volver</<a>
    </body>
</html>
