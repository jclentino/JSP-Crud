package co.edu.udec.devweb.actividad2.juan_lentino.config;

import java.sql.*;

public class Conexion {
    Connection con; 
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "toor");
        } catch (Exception e){
            System.err.println("Error: "+e);
        }
    }
    
    public Connection getConnection(){
        return con; 
    }
}

