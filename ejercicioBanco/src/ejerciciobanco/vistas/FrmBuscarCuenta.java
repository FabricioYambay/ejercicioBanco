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

public class FrmBuscarCuenta extends JFrame{
    
    JLabel lblTitulo;
    JLabel lblNumeroC;
    JLabel lblSaldo;
    JLabel lblCodigoC;
    JLabel lblMovimeinto;
    JLabel lblCodigoS;

    JTextField txNumeroC;
    JTextArea txSaldo;
    JTextArea txCodigoC;
    JTextArea txMovimeinto;
    JTextArea txECodigoS;

    JButton btnBuscar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    public FrmBuscarCuenta() {
        
        
         this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("NUEVA CUENTA");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblNumeroC = new JLabel("NUMERO DE CUENTA: ");
        lblSaldo = new JLabel("SALDO: ");
        lblCodigoC = new JLabel("CODIGO CLIENTE: ");
        lblMovimeinto = new JLabel("MOVIMIENTO: ");
        lblCodigoS = new JLabel("CODIGO SUCURSSAL: ");
        txNumeroC = new JTextField("");
        txSaldo = new JTextArea("");
        txCodigoC = new JTextArea("");
        txMovimeinto = new JTextArea("");
        txECodigoS = new JTextArea("");
        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblNumeroC);
        pnlInterno.add(txNumeroC);
        pnlInterno.add(lblSaldo);
        pnlInterno.add(txSaldo);
        pnlInterno.add(lblCodigoC);
        pnlInterno.add(txCodigoC);
        pnlInterno.add(lblMovimeinto);
        pnlInterno.add(txMovimeinto);
        pnlInterno.add(lblCodigoS);
        pnlInterno.add(txECodigoS);

        this.add(pnlInterno, BorderLayout.CENTER);
        btnBuscar = new JButton("Insertar");
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
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnLimpiarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
        pnlBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlBotones.add(btnBuscar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        //   this.setClosable(true);
    }
    
    public void btnLimpiarActionListener(ActionEvent e){
        txCodigoC.setText("");
        txECodigoS.setText("");
        txMovimeinto.setText("");
        txNumeroC.setText("");
        txSaldo.setText("");
    }
    
     public void btnBuscarActionListener(ActionEvent e){
        Cuenta nCuenta=new Cuenta();
        ICuenta cuentaDao=new CuentaImpl();
     
        
        try {
            nCuenta = cuentaDao.obtener(Integer.parseInt(txNumeroC.getText()));
            txSaldo.setText(String.valueOf(nCuenta.getSaldo()));
            txCodigoC.setText(nCuenta.getNumerocuenta());
            txMovimeinto.setText(String.valueOf(nCuenta.getMovimiento()));
            txECodigoS.setText(String.valueOf(nCuenta.getSaldo())); 
          
            if(cuentaDao.insertar(nCuenta)>0){
                JOptionPane.showMessageDialog(this,"Cuenta Ingresado Correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this,"Error de Insercion",
                "Transacción", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage(),
                "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }
        public static void main(String[] args) {

        FrmBuscarCuenta frmMenu = new FrmBuscarCuenta();
        frmMenu.setVisible(true);

    }
        
        
    }
    
    
    
    
    
    
    

