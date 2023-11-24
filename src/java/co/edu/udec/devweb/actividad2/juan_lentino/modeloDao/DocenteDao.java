package co.edu.udec.devweb.actividad2.juan_lentino.modeloDao;

import co.edu.udec.devweb.actividad2.juan_lentino.config.Conexion;
import co.edu.udec.devweb.actividad2.juan_lentino.interfaces.CRUD_DOCENTES;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Docente;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Usuario;

public class DocenteDao implements CRUD_DOCENTES {
       Conexion cn = new Conexion();
       Connection con; 
       PreparedStatement ps; 
       ResultSet rs; 
       Docente d = new Docente();
    
    @Override
    public List listar() {
        ArrayList<Docente> list = new ArrayList<>();
        String sql = "SELECT * FROM Docentes;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Docente d = new Docente();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setEmail(rs.getString("email"));
                d.setTelefono(Integer.parseInt(rs.getString("telefono")));
                d.setBlog(rs.getString("blog"));
                
                if (rs.getInt("profesional") == 1){
                    d.setProfesional(true);
                } else {
                    d.setProfesional(false);
                }
                
                if (rs.getInt("escalaron") == 1){
                    d.setEscalaron(true);
                } else {
                    d.setEscalaron(false);
                }
                
                d.setIdioma(rs.getString("idioma"));
                d.setAñosExperiencia(rs.getInt("añosExperiencia"));
                d.setAreaTrabajo(rs.getString("areaTrabajo"));
                d.setUsuario_id(rs.getInt("usuario_id"));
                
                list.add(d);
            }
        } catch (Exception e){
             // ...
             e.printStackTrace();
        }
        System.out.println("list: "+list.size());
        return list; 
    }

    @Override
    public Docente list(int id) {
        String sql = "SELECT * FROM Docentes WHERE id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setEmail(rs.getString("email"));
                d.setTelefono(rs.getInt("telefono"));
                d.setBlog(rs.getString("blog"));
                
                if (rs.getInt("profesional") == 1){
                    d.setProfesional(true);
                } else {
                    d.setProfesional(false);
                }
                
                if (rs.getInt("escalaron") == 1){
                    d.setEscalaron(true);
                } else {
                    d.setEscalaron(false);
                }
                
                d.setIdioma(rs.getString("idioma"));
                d.setAñosExperiencia(rs.getInt("añosExperiencia"));
                d.setAreaTrabajo(rs.getString("areaTrabajo"));
                d.setUsuario_id(rs.getInt("usuario_id"));
            }
        } catch (Exception e){
        }
        return d; 
    }

    @Override
    public boolean registrar(Docente d) {
        int isProfesional = 0;
        int isEscalaron = 0;
        
        if (d.isProfesional()){
            isProfesional = 1;
        }
        
        if (d.isEscalaron()){
            isEscalaron = 1;
        }
        
        String sql = "INSERT INTO Docentes (usuario_id, nombre, apellidos, email, telefono, blog, profesional, escalaron, idioma, añosExperiencia, areaTrabajo) VALUES ('"+d.getUsuario_id()+"','"+d.getNombre()+"','"+d.getApellidos()+"', '"+d.getEmail()+"', '"+d.getTelefono()+"', '"+d.getBlog()+"', '"+isProfesional+"', '"+isEscalaron+"', '"+d.getIdioma()+"', '"+d.getAñosExperiencia()+"', '"+d.getAreaTrabajo()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        
        return false; 
    }

    @Override
    public boolean editar(Docente d) {
        int isProfesional = 0;
        int isEscalaron = 0;
        
        if (d.isProfesional()){
            isProfesional = 1;
        }
        
        if (d.isEscalaron()){
            isEscalaron = 1;
        }
        
        String sql = "UPDATE Docentes SET usuario_id='"+d.getUsuario_id()+"', nombre='"+d.getNombre()+"', apellidos='"+d.getApellidos()+"', email='"+d.getEmail()+"', telefono='"+d.getTelefono()+"', blog='"+d.getBlog()+"', profesional='"+isProfesional+"', escalaron='"+isEscalaron+"', idioma='"+d.getIdioma()+"', añosExperiencia='"+d.getAñosExperiencia()+"', areaTrabajo='"+d.getAreaTrabajo()+"' WHERE id="+d.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return false; 
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Docentes WHERE id ="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return false; 
    }
}
