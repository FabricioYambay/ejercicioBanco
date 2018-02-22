/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IPedido;
import ejerciciobanco.rnegocio.entidades.Pedido;
import ejerciciobanco.rnegocio.implementacion.PedidoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eddyf
 */
public class FrmListaPedido extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaPedido(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Pedidos");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo Pedido");
        modelo.addColumn("Resultado");
        modelo.addColumn("Cliente");
        modelo.addColumn("Inspector");
        modelo.addColumn("Prestamo");
        
        
        List<Pedido> lista = new ArrayList<>();
        try {
            IPedido empleadoDao = new PedidoImpl();
            lista = empleadoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Pedido est : lista){
            modelo.addRow(new Object[] { est.getCodigoP(),
                est.getResultado(), est.getCliente(),est.getInspector(),est.getPrestamo()});
            }
           tabla.setModel(modelo); 
        }

    
    
}
