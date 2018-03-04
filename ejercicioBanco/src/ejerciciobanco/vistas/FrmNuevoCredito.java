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

public class FrmNuevoCredito extends JFrame{
    
    
    
    JLabel lblTitulo;
    JLabel lblNumeroCC;
    JLabel lblSobregiro;

    JTextField txNumeroCC;
    JTextField txSobregiro;

    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    public FrmNuevoCredito() {
        
        
        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("NUEVA CUENTA");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblNumeroCC = new JLabel("NUMERO DE CREDITO: ");
        lblSobregiro = new JLabel("Sobregiro: ");

        txNumeroCC = new JTextField("");
        txSobregiro = new JTextField("");

        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblNumeroCC);
        pnlInterno.add(txNumeroCC);
        pnlInterno.add(lblSobregiro);
        pnlInterno.add(txSobregiro);

        this.add(pnlInterno, BorderLayout.CENTER);
        
        btnIngresar = new JButton("Insertar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnIngresarActionListener(e);
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
        pnlBotones.add(btnIngresar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        //   this.setClosable(true);
    }

    public void btnIngresarActionListener(ActionEvent e) {
        CuentaCredito nCuenta = new CuentaCredito();
        ICuentaCredito clientDao = new CuentaCreditoImpl();
        try {

            nCuenta.setCodigocc(Integer.parseInt(txNumeroCC.getText()));
            nCuenta.setValorsobregiro(Double.parseDouble(txSobregiro.getText()));

            if (clientDao.insertar(nCuenta) > 0) {
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

        FrmNuevoCredito frmMenu = new FrmNuevoCredito();
        frmMenu.setVisible(true);

    }
        
        
    }
    
    
    
    

