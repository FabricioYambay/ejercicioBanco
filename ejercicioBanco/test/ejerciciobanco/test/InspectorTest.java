/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.test;

import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gilda
 */
public class InspectorTest {
     public InspectorTest() {
    }
    @Test
    public void testGeneral() {
        IInspector inspectorDao=new InspectorImpl();
       
//TEST INSERTAR

        int filas=0;
        Inspector nuevoInspector=new Inspector();
        try {
            filas=inspectorDao.insertar(nuevoInspector);
            System.out.println("Filas Insertadas:"+filas+"\n\n");
        } catch (Exception e) {
        }
        assertEquals(filas>0, true);
        
//TEST OBTENER POR CODIGO

        Inspector inspector=new Inspector();
        try {
            inspector=inspectorDao.obtener(1);
            System.out.println(inspector.CodigoI()+"    "+inspector.getNombre()+"    "+inspector.getApellido()+"    "+inspector.getDireccion()+"    "+inspector.getTitulo()"\n");
        } catch (Exception e) {
        }
        
//TEST LISTADO

        ArrayList<Inspector> inspector=new ArrayList<>();
        try {
            inspector=inspectorDao.obtener();
            for(Inspector rol:inspector){
                System.out.println(inspector.getCodigoI()+"\t\t\t"+inspector.getNombre()+"\t\t\t"+inspector.getApellido()+"\t\t\t"+inspector.getDireccion()+"\t\t\t"+rol.getTitulo());
            }
        } catch (Exception e) {
        }
        assertTrue(inspector.size()>0);
    }
    
}
