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
    
    

        public ArrayList<Persona> traerPorId(String tipoDni,String dni) {
            ArrayList<Persona> resultado= new ArrayList<>();
            boolean respuesta=false;
            String sql = "select * from personas where tipo_doc= ? and nroDocumento = ?;";
            Connection conn = ConexionBD.getConexion();
            ResultSet rs;
            try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tipoDni);
                pstmt.setString(2, dni);
                rs= pstmt.executeQuery();
                
                    Persona p= new Persona();
                    p.setNroDocumento(rs.getString("nroDocumento"));
                    p.setNroDocumento(rs.getString("tipo_doc"));
                    p.setNroDocumento(rs.getString("nombres"));
                    p.setNroDocumento(rs.getString("apellidos"));
                    p.setNroDocumento(rs.getString("emailPersonal"));
                    p.setNroDocumento(rs.getString("emailInstitucional"));
                    resultado.add(p);

                System.out.println(">>>>>   "+resultado.size());
                if (rs!=null) {
                    rs.close();
                    conn.close();
                }

            } catch (SQLException ex) {
                //System.out.println(""+ex);
                System.out.println("Fallo en consulta bd: "+ex);
            }finally{

            }
            return resultado;

        }

    public boolean modificarPersona(Persona person) throws SQLException {
        
        boolean respuesta=false;
        
        String sql = "update personas set nombres=?, apellidos=?,emailPersonal=?, emailInstitucional=? where "
          + "tipo_doc=? and nroDocumento=?";
        Connection conn = ConexionBD.getConexion();
        int registro=0;
        
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, person.getNombres());
            pstmt.setString(2, person.getApellidos());
            pstmt.setString(3, person.getEmailPersonal());
            pstmt.setString(4, person.getEmailInstitucional());
            pstmt.setString(5, person.getTipoDoc());
            pstmt.setString(6, person.getNroDocumento());
            
            registro= pstmt.executeUpdate();
            
            if (registro>0) {
                respuesta=true;
            }
                        
        } catch (SQLException ex) {
            //System.out.println(""+ex);
            System.out.println("Fallo en consulta bd: "+ex);
        }finally{
            conn.close();
        }
        return respuesta;
        
    }
    
    
}
