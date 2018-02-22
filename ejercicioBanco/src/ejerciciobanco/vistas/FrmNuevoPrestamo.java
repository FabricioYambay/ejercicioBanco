/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import ejerciciobanco.rnegocio.implementacion.PrestamoImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrmNuevoPrestamo extends JInternalFrame {
    JLabel lblTitulo0;
    JLabel lblRegistroImporte;
    JLabel lblPagos;
    JLabel lblAhorros; 
    JLabel lblCodigo;
    
    JTextField txtRegistroImporte;
    JTextField txtPagos;
    JTextField txtAhorros;
    JTextField txtCodigo;
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoPrestamo() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Pagos");
       
        lblRegistroImporte = new JLabel("RegistroImporte:");
        lblPagos = new JLabel("Pagos");
        lblAhorros = new JLabel("Ahorros:");
        lblCodigo= new JLabel("Codigo:");
      
        

        txtCodigo = new JTextField(2);
        txtRegistroImporte= new JTextField(2);
        txtPagos = new JTextField(2);
        txtAhorros = new JTextField(2);
        txtCodigo = new JTextField(2);
       
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        

        pnlCentral.add(lblRegistroImporte);
        pnlCentral.add(txtRegistroImporte);
        pnlCentral.add(lblPagos);
        pnlCentral.add(txtPagos);
        pnlCentral.add(lblAhorros);
        pnlCentral.add(txtAhorros);
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
                      
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoPrestamo frmMenu= new FrmNuevoPrestamo();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IPrestamo prestamoDao = new PrestamoImpl();
        Prestamo prestamo = new Prestamo();
        
        prestamo.setRegistroImporte(txtRegistroImporte.getText());
        prestamo.setPagos(txtPagos.getText());
        prestamo.setAhorros(txtAhorros.getText());
        prestamo.setCodigoPr(Integer.parseInt(txtCodigo.getText()));   
        
        try {
            if(prestamoDao.insertar(prestamo)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
