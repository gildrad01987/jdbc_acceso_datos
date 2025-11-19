/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicajdbc;

import java.sql.SQLException;

/**
 *
 * @author gilda
 */
public class PracticaJdbc {

    public static void main(String[] args) throws SQLException {
         Persona persona=new Persona();
         persona.setTipoDoc("DNI");
         persona.setNroDocumento("12345678A");
         persona.setNombres("gildardo aguirre");
         persona.setApellidos("RIOS AGUIRRE");
         persona.setEmailPersonal("persaonal.com");
         persona.setEmailInstitucional("institucional@gmail.ocm");
         
         //if (persona.existe("DNI","12345678A" )==null) {
         ConPERSONA cpersona= new ConPERSONA();
         cpersona.insertarPersona(persona);
         for (Persona pe : cpersona.traerTodos()) {
             System.out.println(" - :   "+pe.getEmailInstitucional());
        }
         persona.setEmailInstitucional("ultima prueba.com");
         cpersona.modificarPersona(persona);
         for (Persona pe : cpersona.traerTodos()) {
             System.out.println(" - :   "+pe);
        }
         
         cpersona.eliminarPersona(persona);
         for (Persona pe : cpersona.traerTodos()) {
             System.out.println(" - :   "+pe);
        }
         
         System.out.println("---------------------------------------------");
         System.out.println("--   MATERIA  --");
         System.out.println("---------------------------------------------");
          
         Materia mat=new Materia();
         mat.setIdMateria(9);
         MateriaBD mdb=new MateriaBD();
         
        
         for (Materia matteria : mdb.traerTodos()) {
             System.out.println("todos -- >"+matteria.toString());
        }
         
         
         mat.setNombre("prueba 1");
         mdb.modificarMateria(mat);
         
         for (Materia matteria : mdb.traerTodos()) {
             System.out.println("-- >"+matteria.toString());
        }
         
         mat.setIdMateria(3);
         mdb.eliminarMateria(mat);
         
         
         for (Materia matteria : mdb.traerTodos()) {
             System.out.println("-- >"+matteria.toString());
        }
         
         
    }
}
