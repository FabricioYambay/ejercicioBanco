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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eddyf
 */
public class FrmNuevoPedido extends JInternalFrame {
    
     JLabel lblTitulo0;
    JLabel lblCodigo;
    JLabel lblResultado;
    JLabel lblCliente; 
    JLabel lblInspector;
    JLabel lblPrestamo;
    
    JTextField txtCodigo;
    JTextField txtResultado;
    JTextField txtCliente;
    JTextField txtInspector;
    JTextField txtPrestamo;
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoPedido() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Pagos");
       
        lblCodigo = new JLabel("Codigo:");
        lblResultado = new JLabel("Rresultado");
        lblCliente = new JLabel("Cliente:");
        lblInspector= new JLabel("Inspector:");
        lblPrestamo= new JLabel("Presatamo:");
      
        

        txtCodigo = new JTextField(2);
        txtResultado = new JTextField(2);
        txtCliente= new JTextField(2);
        txtInspector = new JTextField(2);
        txtPrestamo = new JTextField(2);
       
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        

        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblResultado);
        pnlCentral.add(txtResultado);
        pnlCentral.add(lblCliente);
        pnlCentral.add(txtCliente);
        pnlCentral.add(lblInspector);
        pnlCentral.add(txtInspector);
        pnlCentral.add(lblPrestamo);
        pnlCentral.add(txtPrestamo);
                      
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
        FrmNuevoPedido frmMenu= new FrmNuevoPedido();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IPedido prestamoDao = new PedidoImpl();
        Pedido prestamo = new Pedido();
        
        prestamo.setCodigoP(Integer.parseInt(txtCodigo.getText()));
        prestamo.setCodigoP(Integer.parseInt(txtResultado.getText())); 
        prestamo.setCodigoP(Integer.parseInt(txtCliente.getText())); 
        prestamo.setCodigoP(Integer.parseInt(txtInspector.getText()));   
        prestamo.setCodigoP(Integer.parseInt(txtPrestamo.getText()));  
        
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
