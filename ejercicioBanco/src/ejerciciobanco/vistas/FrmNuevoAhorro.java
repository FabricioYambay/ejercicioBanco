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
public class FrmNuevoAhorro extends JFrame{
    
    JLabel lblTitulo;
    JLabel lblNumeroA;
    JLabel lblInteres;
    
    JTextField txNumeroA;
    JTextField txInteres;
    
    
    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    public FrmNuevoAhorro() {
        
        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("NUEVA CUENTA");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblNumeroA = new JLabel("NUMERO DE CUENTA Ahorros: ");
        lblInteres = new JLabel("INTERES: ");
       
        txNumeroA = new JTextField("");
        txInteres = new JTextField("");
       
        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblNumeroA);
        pnlInterno.add(txNumeroA);
        pnlInterno.add(lblInteres);
        pnlInterno.add(txInteres);
      

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
        public static void main(String[] args) {

        FrmNuevoAhorro frmMenu = new FrmNuevoAhorro();
        frmMenu.setVisible(true);

    }
         public void btnIngresarActionListener(ActionEvent e){
        CuentaAhorro nCuenta=new CuentaAhorro();
        ICuentaAhorro clientDao=new CuentaAhorroImpl();
        
        
        try {
            
           
            nCuenta.setCodigoca(Integer.parseInt(txNumeroA.getText()));
            nCuenta.setInteres(Double.parseDouble(txInteres.getText()));
          
            if(clientDao.insertar(nCuenta)>0){
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
    }
    
    
    
    

