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
public class FrmModificarCredito extends JFrame{
    
      JLabel lblTitulo;
    JLabel lblNumeroCC;
    JLabel lblSobregiro;

    JTextField txNumeroCC;
    JTextArea txSobregiro;

    JButton btnBuscar;
    JButton btnModificar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;
    
    CuentaCredito cre;

    public FrmModificarCredito() {
        
        
        
     this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("Modificar CUENTA");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblNumeroCC = new JLabel("NUMERO DE CREDITO: ");
        lblSobregiro = new JLabel("Sobregiro: ");

        txNumeroCC = new JTextField("");
        txSobregiro = new JTextArea("");

        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblNumeroCC);
        pnlInterno.add(txNumeroCC);
        pnlInterno.add(lblSobregiro);
        pnlInterno.add(txSobregiro);

        this.add(pnlInterno, BorderLayout.CENTER);
        
          btnModificar = new JButton("Insertar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnModificarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnBuscarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
        btnLimpiar = new JButton("Limpiar");
//        btnLimpiar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    btnLimpiarActionListener(e);
//                } catch (Exception ex) {
//                    System.out.println("Error:" + ex.getMessage());
//                }
//            }
//        });
        pnlBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlBotones.add(btnBuscar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        //   this.setClosable(true);
    }

    public void btnBuscarActionListener(ActionEvent e) {
        cre = new CuentaCredito();
        ICuentaCredito clientDao = new CuentaCreditoImpl();
        try {

            cre = clientDao.obtener(Integer.parseInt(txNumeroCC.getText()));
            txSobregiro.setText(String.valueOf(cre.getValorsobregiro()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void btnModificarActionListener(ActionEvent e) {
        cre = new CuentaCredito();
        ICuentaCredito clientDao = new CuentaCreditoImpl();
        try {

            cre.setCodigocc(Integer.parseInt(txNumeroCC.getText()));
            cre.setValorsobregiro(Double.parseDouble(txSobregiro.getText()));

            if (clientDao.modificar(cre) > 0) {
                JOptionPane.showMessageDialog(this, "Cuenta Ingresado Correctamente!!",
                        "Transacción", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error de Insercion",
                        "Transacción", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String[] args) {

        FrmModificarCredito frmMenu = new FrmModificarCredito();
        frmMenu.setVisible(true);

    }
    
}
