package co.edu.udec.devweb.actividad2.juan_lentino.interfaces;

import java.util.List;
import co.edu.udec.devweb.actividad2.juan_lentino.modelos.Docente;


public interface CRUD_DOCENTES {
    public List listar();
    public Docente list(int id);
    public boolean registrar(Docente u);
    public boolean editar(Docente u);
    public boolean eliminar(int id);
}

