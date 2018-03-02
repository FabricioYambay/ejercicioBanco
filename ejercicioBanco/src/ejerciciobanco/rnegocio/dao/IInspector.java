/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.dao;

import ejerciciobanco.rnegocio.entidades.Inspector;
import java.util.ArrayList;

/**
 *
 * @author Gilda
 */
public interface IInspector {
    public int insertar (Inspector inspector) throws Exception;
    public int modificar (Inspector inspector) throws Exception; 
    public int eliminar (Inspector inspector) throws Exception;
    public Inspector obtener (int CodigoI) throws Exception;
    public Inspector obtener_x_nombre(String Nombre) throws Exception;
    public ArrayList<Inspector> obtener() throws Exception; 
    
}
