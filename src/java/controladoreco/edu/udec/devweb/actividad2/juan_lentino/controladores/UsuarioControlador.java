
package controladoreco.edu.udec.devweb.actividad2.juan_lentino.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.udec.devweb.actividad2.juan_lentino.modeloDao.UsuarioDao;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Usuario;

public class UsuarioControlador extends HttpServlet {
    
    String listar = "vistas/usuario/listar.jsp";
    String registrar = "vistas/usuario/registrar.jsp";
    String editar = "vistas/usuario/editar.jsp";
    String eliminar = "vistas/usuario/eliminar.jsp";
    
    Usuario u = new Usuario();
    UsuarioDao dao = new UsuarioDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listarUsuarios")){
            accesso = listar; 
        } else if (action.equalsIgnoreCase("registrarNuevoUsuario")){
            accesso = registrar;
        } else if (action.equalsIgnoreCase("editarUsuario")){
            request.setAttribute("idUser", request.getParameter("id"));
            accesso= editar; 
        } else if (action.equalsIgnoreCase("ActualizarUsuario")){
            doPut(request, response);
        } else if (action.equalsIgnoreCase("eliminarUsuario")){
            doDelete(request, response);
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("CrearUsuario")){
            String cedula = request.getParameter("cedula");
            String clave = request.getParameter("clave");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            
            u.setCedula(Integer.parseInt(cedula));
            u.setClave(clave);
            u.setNombre(nombre);
            u.setTelefono(Integer.parseInt(telefono));
            u.setEmail(email);
            dao.registrar(u);
            
            accesso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("ActualizarUsuario")){
            String cedula = request.getParameter("cedula");
            String clave = request.getParameter("clave");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            
            u.setCedula(Integer.parseInt(cedula));
            u.setClave(clave);
            u.setNombre(nombre);
            u.setTelefono(Integer.parseInt(telefono));
            u.setEmail(email);
            
            dao.editar(u);
            accesso=listar; 
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("eliminarUsuario")){
            int id = Integer.parseInt(request.getParameter("id"));
            u.setCedula(id);
            dao.eliminar(id);
            accesso=listar; 
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
