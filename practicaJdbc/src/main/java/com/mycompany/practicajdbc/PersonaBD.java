package com.mycompany.practicajdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gilda
 */
public class PersonaBD {
        public  ConexionBD bd;
    

        public ArrayList<Persona> traerPorId(String tipoDni,String dni) {
            String sql = "select * from personas where tipo_doc="+tipoDni+"  and nroDocumento = "+dni+";";
            ArrayList<Persona> resultado= new ArrayList<Persona>();
            ArrayList<Object> res= bd.ejecutarConsulta(sql);
            
            for (Object re : res) {
                resultado.add((Persona) re);
                
            }
            
            return resultado;

        }
        public ArrayList<Persona> traerTodos() {
            String sql = "select * from personas ;";
            ArrayList<Persona> resultado= new ArrayList<Persona>();
            ArrayList<Object> res= bd.ejecutarConsulta(sql);
            
            for (Object re : res) {
                resultado.add((Persona) re);
                
            }
            
            return resultado;

        }

    public boolean modificarPersona(Persona person) throws SQLException {
        
        boolean respuesta=false;
        
        String sql = "update personas set nombres= '"+person.getNombres()+ 
          "', apellidos='"+person.getApellidos()+
          "', emailPersonal='"+person.getEmailPersonal()+"', emailInstitucional='"+person.getEmailInstitucional()+ "' where "
          + "tipo_doc='"+person.getTipoDoc()+"' and nroDocumento='"+person.getNroDocumento()+"';";
        if (bd.ejecutarModificacion(sql)>0) {
            respuesta=true;
        }
  
        
        return respuesta;
        
    }

    public boolean insertarPersona(Persona person) throws SQLException {
        
        boolean respuesta=false;
        
         String sql = "update personas set nombres= '"+person.getNombres()+ 
          "', apellidos='"+person.getApellidos()+
          "', emailPersonal='"+person.getEmailPersonal()+"', emailInstitucional='"+person.getEmailInstitucional()+ "' where "
          + "tipo_doc='"+person.getTipoDoc()+"' and nroDocumento='"+person.getNroDocumento()+"';";
        if (bd.ejecutarModificacion(sql)>0) {
            respuesta=true;
        }
  
        
        return respuesta;
        
    }

    public boolean eliminarPersona(Persona person) throws SQLException {
        
        boolean respuesta=false;
        
         String sql = "delete from personas  where "
          + "tipo_doc='"+person.getTipoDoc()+
           "' and nroDocumento='"+person.getNroDocumento()+"';";
        if (bd.ejecutarModificacion(sql)>0) {
            respuesta=true;
        }
  
        return respuesta;
        
    }

    
}
