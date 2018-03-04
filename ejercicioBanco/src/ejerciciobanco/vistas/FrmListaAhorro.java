/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import javax.swing.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class FrmListaAhorro  extends JFrame{
    
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;

    public FrmListaAhorro() {
        
          
         this.setSize(800, 600);
        this.setLayout(new BorderLayout());
       // this.setClosable(true);
        lblTitulo = new JLabel("Listado" );
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    
      public void cargarTabla(){
        modelo = new  DefaultTableModel();
        
        modelo.addColumn("CODIGO AHORROS");
        modelo.addColumn("INTERES");
        
        
        List<CuentaAhorro> lista = new ArrayList<>();
        try {
            ICuentaAhorro prestamoDao = new CuentaAhorroImpl();
            lista = prestamoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(CuentaAhorro est : lista){
            modelo.addRow(new Object[] { est.getCodigoca(), est.getInteres()});
            }
           tabla.setModel(modelo); 
        }
     public static void main(String[] args) {

        FrmListaAhorro frmMenu = new FrmListaAhorro();
        frmMenu.setVisible(true);

    }
    
}
