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
public interface ICuentaAhorro {
      public int insertar(CuentaAhorro cuentaahorro) throws Exception;
    public int modificar(CuentaAhorro cuentaahorro) throws Exception;
    public int eliminar(CuentaAhorro cuentaahorro) throws Exception;
    public CuentaAhorro obtener(int codigo) throws Exception;
    public List<CuentaAhorro> obtener() throws Exception;
}
