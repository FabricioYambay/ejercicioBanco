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


public class FrmEliminarPago extends JInternalFrame{
    Pago pago = new Pago();
    IPago pagoDao = new PagoImpl();
    JLabel lblTitulo,lblCodigoPa;
    JTextField txtCodigoPa;
    JPanel pnlCentral;
    JTable tabla;
    JButton btnEliminar;
    JButton btnActualizar;
    
    JScrollPane jscTabla;
    DefaultTableModel modelo;
    public FrmEliminarPago(){
    this.setSize(400,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Pagos Ingresados");
    pnlCentral= new JPanel(new FlowLayout());
    lblCodigoPa=new JLabel("ID: ");
    txtCodigoPa= new JTextField(2);
    btnEliminar=new JButton("Eliminar");
    btnActualizar=new JButton("Actualizar");
    pnlCentral.add(lblCodigoPa);
    pnlCentral.add(txtCodigoPa);
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
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(pnlCentral,BorderLayout.NORTH);
    this.add(jscTabla,BorderLayout.CENTER);
    cargarTabla();
    }
    
    private void btnEliminarActionListener(java.awt.event.ActionEvent e) throws Exception{                                            
        if (pago != null) {
            int respuesta = JOptionPane.YES_NO_CANCEL_OPTION;
            pago.setCodigoPa(Integer.parseInt(txtCodigoPa.getText()));
            respuesta = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea Eliminar el Pago "
                    + pago.getCodigoPa()+ " ?" + respuesta);
            if (respuesta == JOptionPane.YES_OPTION) {
                int numFilasAfectadas = pagoDao.eliminar(pago);
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
        modelo.addColumn("Id Pago");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Categoria");
        
        List<Pago> lista = new ArrayList<>();
        try {
            IPago pagoDao= new PagoImpl();
            lista = pagoDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Pago est:lista){
            modelo.addRow(new Object[]{est.getCodigoPa(),est.getFecha(),est.getValor(),est.getPrestamo()});
        }
        tabla.setModel(modelo);
    }
}
