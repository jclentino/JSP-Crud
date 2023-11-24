package co.edu.udec.devweb.actividad2.juan_lentino.modeloDao;

import co.edu.udec.devweb.actividad2.juan_lentino.config.Conexion;
import co.edu.udec.devweb.actividad2.juan_lentino.interfaces.CRUD_USUARIOS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Usuario;

public class UsuarioDao implements CRUD_USUARIOS {
       Conexion cn = new Conexion();
       Connection con; 
       PreparedStatement ps; 
       ResultSet rs; 
       Usuario u = new Usuario();
    
    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setCedula(rs.getInt("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setTelefono(rs.getInt("telefono"));
                u.setEmail(rs.getString("email"));
                u.setClave(rs.getString("clave"));
                list.add(u);
            }
        } catch (Exception e){
             // ... 
        }
        return list; 
    }

    @Override
    public Usuario list(int id) {
        String sql = "SELECT * FROM Usuarios WHERE cedula="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                u.setCedula(rs.getInt("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setTelefono(rs.getInt("telefono"));
                u.setEmail(rs.getString("email"));
                u.setClave(rs.getString("clave"));
            }
        } catch (Exception e){
        }
        return u; 
    }

    @Override
    public boolean registrar(Usuario u) {
        String sql = "INSERT INTO Usuarios (cedula, clave, nombre, telefono, email) VALUES ('"+u.getCedula()+"','"+u.getClave()+"','"+u.getNombre()+"', '"+u.getTelefono()+"', '"+u.getEmail()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        
        return false; 
    }

    @Override
    public boolean editar(Usuario u) {
        String sql = "UPDATE Usuarios SET clave='"+u.getClave()+"', nombre='"+u.getNombre()+"', telefono='"+u.getTelefono()+"', email='"+u.getEmail()+"' WHERE cedula="+u.getCedula();
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
        String sql = "DELETE FROM Usuarios WHERE cedula ="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return false; 
    }
}
