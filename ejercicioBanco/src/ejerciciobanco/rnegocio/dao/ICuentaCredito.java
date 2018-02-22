/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.dao;

import ejerciciobanco.rnegocio.entidades.*;
import java.util.List;

/**
 *
 * @author Wen
 */
public interface ICuentaCredito {
     public int insertar(CuentaCredito cuentacredito) throws Exception;
    public int modificar(CuentaCredito cuentacredito) throws Exception;
    public int eliminar(CuentaCredito cuentacredito) throws Exception;
    public CuentaCredito obtener(int codigo) throws Exception;
    public List<CuentaCredito> obtener() throws Exception;
}
