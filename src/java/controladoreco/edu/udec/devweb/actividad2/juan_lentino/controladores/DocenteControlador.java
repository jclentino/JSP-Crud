package controladoreco.edu.udec.devweb.actividad2.juan_lentino.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.udec.devweb.actividad2.juan_lentino.modeloDao.DocenteDao;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Docente;

public class DocenteControlador extends HttpServlet {
    
    String listar = "vistas/docente/listar.jsp";
    String registrar = "vistas/docente/registrar.jsp";
    String editar = "vistas/docente/editar.jsp";
    String eliminar = "vistas/docente/eliminar.jsp";
    
    Docente d = new Docente();
    DocenteDao dao = new DocenteDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DocenteControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DocenteControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listarDocentes")){
            accesso = listar; 
        } else if (action.equalsIgnoreCase("registrarNuevoDocente")){
            accesso = registrar;
        } else if (action.equalsIgnoreCase("editarDocente")){
            request.setAttribute("idDocente", request.getParameter("id"));
            accesso= editar; 
        } else if (action.equalsIgnoreCase("ActualizarDocente")){
            doPut(request, response);
        } else if (action.equalsIgnoreCase("eliminarDocente")){
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
        boolean esProfesional = false;
        boolean esEscalaron = false;
        if (action.equalsIgnoreCase("CrearDocente")){
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String blog = request.getParameter("blog");
            
            if (request.getParameter("profesional").equals("esProfesional")){
                esProfesional = true; 
            }
            
            if (request.getParameter("escalaron").equals("esEscalaron")){
                esEscalaron = true; 
            }
            
            String idioma = request.getParameter("idioma");
            int añosExperiencia = Integer.parseInt(request.getParameter("experiencia"));
            String areaTrabajo = request.getParameter("areaTrabajo");
            int usuario_id = Integer.parseInt(request.getParameter("usuario"));
            
            d.setNombre(nombre);
            d.setApellidos(apellidos);
            d.setEmail(email);
            d.setTelefono(telefono);
            d.setBlog(blog);
            d.setProfesional(esProfesional);
            d.setEscalaron(esEscalaron);
            d.setIdioma(idioma);
            d.setAñosExperiencia(añosExperiencia);
            d.setAreaTrabajo(areaTrabajo);
            d.setUsuario_id(usuario_id);
            
            dao.registrar(d);
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
        boolean esProfesional = false;
        boolean esEscalaron = false;
        
        if (action.equalsIgnoreCase("ActualizarDocente")){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String blog = request.getParameter("blog");
            
            if (request.getParameter("profesional").equals("esProfesional")){
                esProfesional = true; 
            }
            
            if (request.getParameter("escalaron").equals("esEscalaron")){
                esEscalaron = true; 
            }
            
            String idioma = request.getParameter("idioma");
            int añosExperiencia = Integer.parseInt(request.getParameter("añosExperiencia"));
            String areaTrabajo = request.getParameter("areaTrabajo");
            int usuario_id = Integer.parseInt(request.getParameter("usuario"));
            
            d.setId(id);
            d.setNombre(nombre);
            d.setApellidos(apellidos);
            d.setEmail(email);
            d.setTelefono(telefono);
            d.setBlog(blog);
            d.setProfesional(esProfesional);
            d.setEscalaron(esEscalaron);
            d.setIdioma(idioma);
            d.setAñosExperiencia(añosExperiencia);
            d.setAreaTrabajo(areaTrabajo);
            d.setUsuario_id(usuario_id);
            
            dao.editar(d);
            accesso = listar; 
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accesso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("eliminarDocente")){
            int id = Integer.parseInt(request.getParameter("id"));
            d.setId(id);
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
