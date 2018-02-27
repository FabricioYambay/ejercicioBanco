/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.test;

import static org.junit.Assert.assertEquals;
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
 * @author DELL
 */
public class testcliente {

    public testcliente() {
    }
    @Test
    public void TestGeneral(){
          ICliente cursoDao = new ClienteImpl();
        
        Cliente nestudiante = new Cliente();
        try {
            nestudiante = cursoDao.obtener("GSD");
            System.out.println("            " + nestudiante.getCedula()+""+nestudiante.getNombre()+""+nestudiante.getApellido());
        } catch (Exception e) {
        }
        assertEquals(nestudiante!=null, true);
    }
    
    
      
}
