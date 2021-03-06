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

public class FrmModificarAhorro extends JFrame{

    JLabel lblTitulo;
    JLabel lblNumeroA;
    JLabel lblInteres;

    JTextField txNumeroA;
    JTextArea txInteres;

    JButton btnModificar;
    JButton btnBuscar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;
    CuentaAhorro cu;

    public FrmModificarAhorro() {
        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("NUEVA CUENTA");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblNumeroA = new JLabel("NUMERO DE CUENTA Ahorros: ");
        lblInteres = new JLabel("INTERES: ");

        txNumeroA = new JTextField("");
        txInteres = new JTextArea("");

        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblNumeroA);
        pnlInterno.add(txNumeroA);
        pnlInterno.add(lblInteres);
        pnlInterno.add(txInteres);

        this.add(pnlInterno, BorderLayout.CENTER);
        
        btnModificar= new JButton("Modificar");
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

    public void btnModificarActionListener(ActionEvent e) {
        CuentaAhorro cu = new CuentaAhorro();
        ICuentaAhorro clientDao = new CuentaAhorroImpl();

        try {

            cu.setCodigoca(txNumeroA.getText());
            cu.setInteres(Double.parseDouble(txInteres.getText()));

            if (clientDao.eliminar(cu) > 0) {
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

    public void btnBuscarActionListener(ActionEvent e) {
        cu = new CuentaAhorro();
        ICuentaAhorro clientDao = new CuentaAhorroImpl();

        try {

            cu = clientDao.obtener(Integer.parseInt(txNumeroA.getText()));
            txInteres.setText(String.valueOf(cu.getInteres()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        FrmModificarAhorro frmMenu = new FrmModificarAhorro();
        frmMenu.setVisible(true);

    }

}
