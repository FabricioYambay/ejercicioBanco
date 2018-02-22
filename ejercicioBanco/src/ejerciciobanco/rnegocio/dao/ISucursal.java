/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.dao;

import ejerciciobanco.rnegocio.entidades.Sucursal;
import java.util.List;

/**
 *
 * @author CRISTIAN
 */
public interface ISucursal {
    
    public int insertar(Sucursal sucursal) throws Exception;
    public int modificar(Sucursal sucursal) throws Exception;
    public int eliminar(Sucursal sucursal) throws Exception;
    public Sucursal obtener(int codigoS) throws Exception;
    public List<Sucursal> obtener() throws Exception;     
}
