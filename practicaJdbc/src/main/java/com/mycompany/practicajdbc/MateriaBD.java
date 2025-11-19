/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gilda
 */
public class MateriaBD {
    
        public ArrayList<Materia> traerTodos() {
            ArrayList<Materia> resultado= new ArrayList<>();
            boolean respuesta=false;
            String sql = "select * from materias ;";
            Connection conn = ConexionBD.getConexion();
            ResultSet rs;
            try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                rs= pstmt.executeQuery();
                while (rs.next()) {
                    
                    Materia p= new Materia();
                    p.setIdMateria(rs.getInt("id_materias"));
                    p.setNombre(rs.getString("nombre"));
                    p.setIdMateria(rs.getInt("creditos"));
                    p.setIdMateria(rs.getInt("cupos"));
                    resultado.add(p);
                    
                }
                

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
    

        public ArrayList<Materia> traerPorId(int wIdMateria) {
            ArrayList<Materia> resultado= new ArrayList<>();
            boolean respuesta=false;
            String sql = "select * from MATERIAs where id_materias=? ;";
            Connection conn = ConexionBD.getConexion();
            ResultSet rs;
            try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, wIdMateria);
                
                rs= pstmt.executeQuery();
                
                    Materia p= new Materia();
                    p.setIdMateria(rs.getInt("id_materias"));
                    p.setNombre(rs.getString("nombre"));
                    p.setIdMateria(rs.getInt("creditos"));
                    p.setIdMateria(rs.getInt("cupos"));
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

    public boolean modificarMateria(Materia materia) throws SQLException {
        
        boolean respuesta=false;
        
        String sql = "update MATERIAS set NOMBRE=?, CREDITOS=?,CUPOS=? where "
          + "ID?MATERIAS=?";
        Connection conn = ConexionBD.getConexion();
        int registro=0;
        
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, materia.getNombre());
            pstmt.setInt(2, materia.getCreditos());
            pstmt.setInt(3, materia.getCupos());
            pstmt.setInt(4,materia.getIdMateria());
            
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

    public boolean insertMateria(Materia materia) throws SQLException {
        
        boolean respuesta=false;
        
        String sql = "insert into  MATERIAS values (?,?,?)";
        Connection conn = ConexionBD.getConexion();
        int registro=0;
        
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, materia.getNombre());
            pstmt.setInt(2, materia.getCreditos());
            pstmt.setInt(3, materia.getCupos());    
            
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

    public boolean eliminarMateria(Materia materia) throws SQLException {
        
        boolean respuesta=false;
        
        String sql = "delete from MATERIAS  where  where ID_MATERIAS=?";
        Connection conn = ConexionBD.getConexion();
        int registro=0;
        
        
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1,materia.getIdMateria());
            
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
