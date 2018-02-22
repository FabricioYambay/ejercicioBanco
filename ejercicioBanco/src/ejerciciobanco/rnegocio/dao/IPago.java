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
public interface IPago {
    public int insertar(Pago pago) throws Exception;
    public int modificar(Pago pago) throws Exception;
    public int eliminar(Pago pago) throws Exception;
    public Pago obtener(int codigopa) throws Exception;
    public List<Pago> obtener() throws Exception;    
}
