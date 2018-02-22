/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.dao;

import ejerciciobanco.rnegocio.entidades.Pedido;
import java.util.List;

/**
 *
 * @author eddyf
 */
public interface IPedido {
     public int insertar(Pedido pedido) throws Exception;
    public int modificar(Pedido pedido) throws Exception;
    public int eliminar(Pedido pedido) throws Exception;
    public Pedido obtener(int CodigoP) throws Exception;
    public List<Pedido> obtener() throws Exception; 
    
}
