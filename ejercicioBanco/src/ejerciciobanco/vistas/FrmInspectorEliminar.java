/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.implementacion.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FrmInspectorEliminar extends JInternalFrame{
    Inspector inspector = new Inspector();
    IInspector inspectorDao = new InspectorImpl();
    JLabel lblTituloO,lblCodigoI;
    JTextField txtCodigoI;
    JPanel pnlCentral;
    JTable tabla;
    JButton btnEliminar;
    JButton btnActualizar;
    
    JScrollPane jscTabla;
    DefaultTableModel modelo;
    public FrmInspectorEliminar(){
    this.setSize(600,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTituloO=new JLabel("Inpecor Ingresados");
    pnlCentral= new JPanel(new FlowLayout());
    lblCodigoI=new JLabel("ID: ");
    txtCodigoI= new JTextField(2);
    btnEliminar=new JButton("Eliminar");
    btnActualizar=new JButton("Actualizar");
    pnlCentral.add(lblCodigoI);
    pnlCentral.add(txtCodigoI);
    pnlCentral.add(btnEliminar);
    pnlCentral.add(btnActualizar);
    
    btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnEliminarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
    
    btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnActualizarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
    
    tabla = new JTable();
    jscTabla=new JScrollPane(tabla);
    this.add(lblTituloO,BorderLayout.NORTH);
    this.add(pnlCentral,BorderLayout.NORTH);
    this.add(jscTabla,BorderLayout.CENTER);
    cargarTabla();
    }
    
    private void btnEliminarActionListener(java.awt.event.ActionEvent e) throws Exception{                                            
        if (inspector != null) {
            int respuesta = JOptionPane.YES_NO_CANCEL_OPTION;
            inspector.setCodigoI(Integer.parseInt(txtCodigoI.getText()));
            respuesta = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea Eliminar Inspector "
                    + inspector.getCodigoI()+ " ?" + respuesta);
            if (respuesta == JOptionPane.YES_OPTION) {
                int numFilasAfectadas = inspectorDao.eliminar(inspector);
                if (numFilasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Se Elimino!!");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar contiene llave foranea!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Eliminar!!");
            }
        }
    }
    
    private void btnActualizarActionListener(java.awt.event.ActionEvent e) throws Exception{                                            
        cargarTabla();
    }
    
    public void cargarTabla(){


        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
     
   
        modelo.addRow(new Object[]{"CodigoI","Nombre","Apellido","Direccion","Titulo"});
     
        
        List<Inspector> list = new ArrayList<>();
        try {
            IInspector inspectorDao= new InspectorImpl();
            list = inspectorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        for(Inspector clt : list){
            modelo.addRow(new Object[]{clt.getCodigoI(),clt.getNombre(),clt.getApellido(),clt.getDireccion(),clt.getTitulo()});
        }
        tabla.setModel(modelo);
    }
}

