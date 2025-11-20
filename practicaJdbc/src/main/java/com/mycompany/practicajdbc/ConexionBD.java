/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConexionBD {
    private static Connection conexion = null;
    private static final String URL = "jdbc:mysql://localhost:3306/ACCESOADATOS"; // Reemplazar
    private static final String USUARIO = "root"; // Reemplazar
    private static final String CONTRASENA = "YEKA1987"; // Reemplazar

    
    

    public static Connection getConexion() {
        try {
            // Cargar el controlador (opcional en versiones recientes, pero seguro)
            // Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public static ArrayList<Object> ejecutarConsulta(String consulta) {
         ArrayList<Object> resultado=null;
    try (Connection con = ConexionBD.getConexion();
         Statement st = con.createStatement();
         ResultSet rs= st.executeQuery(consulta)) {
        while (rs.next()) { 
            resultado.add((Object) rs.next()) ;
            }
        rs.close();
        con.close();
    } catch (Exception e) {
        System.out.println( "Error: ejecutarconsulta...." + e.getMessage());
    }finally{
        
    }
            return resultado;
}
    public static int ejecutarModificacion(String consulta) {
         int resultado=0;
         int registros=-1; 
    try (Connection con = ConexionBD.getConexion();
         Statement st = con.createStatement();
             ) {
            registros= st.executeUpdate(consulta);
            
    } catch (SQLException e) {
        System.out.println( "Error: ejecutarUpdate...." + e.getMessage());
    }finally{
        
    }
            return resultado;
}
    
}
