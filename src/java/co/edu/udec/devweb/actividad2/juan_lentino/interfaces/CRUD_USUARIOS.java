package co.edu.udec.devweb.actividad2.juan_lentino.interfaces;

import java.util.List;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Usuario;


public interface CRUD_USUARIOS {
    public List listar();
    public Usuario list(int id);
    public boolean registrar(Usuario u);
    public boolean editar(Usuario u);
    public boolean eliminar(int id);
}

