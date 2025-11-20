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
         persona.setTipoDoc("PAS");
         persona.setNroDocumento("11111c");
         persona.setNombres("geeeeee aguirre");
         persona.setApellidos("eeeeeeGUIRRE");
         persona.setEmailPersonal("persaonal.com");
         persona.setEmailInstitucional("institucional@gmail.ocm");
         persona.setTipoPersona("EST");
         
         //if (persona.existe("DNI","12345678A" )==null) {
         ConPERSONA cpersona= new ConPERSONA();
         if (cpersona.insertarPersona(persona)) {
             System.out.println("creada correctamente");
        }
         
         for (Persona pe : cpersona.traerTodos()) {
             System.out.println(" - :   "+pe.getNroDocumento());
        }
         persona.setEmailInstitucional("ultima prueba.com");
         cpersona.modificarPersona(persona);
         
         for (Persona pe : cpersona.traerPorId(persona.getTipoDoc(), persona.getNroDocumento())) {
             System.out.println("consultada por id - :   "+pe.toString());
        }
         
         cpersona.eliminarPersona(persona);
         for (Persona pe : cpersona.traerTodos()) {
             System.out.println(" validar si existe - :   "+pe);
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
