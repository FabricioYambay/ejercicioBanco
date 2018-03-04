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
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class FrmEliminarCuenta extends JFrame {

    JLabel lblTitulo;
    JLabel lblNumeroC;
    JLabel lblSaldo;
    JLabel lblCodigoC;
    JLabel lblMovimeinto;
    JLabel lblCodigoS;

    JTextField txNumeroC;
    JTextField txSaldo;
    JTextField txCodigoC;
    JTextField txMovimeinto;
    JTextField txECodigoS;

    JButton btnEliminar;
    JButton btnBuscar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;
    
    Cuenta cuenta;

    public FrmEliminarCuenta() {

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
        txSaldo = new JTextField("");
        txCodigoC = new JTextField("");
        txMovimeinto = new JTextField("");
        txECodigoS = new JTextField("");
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
        btnEliminar = new JButton("Elominar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnEliminarActionListener(e);
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
        btnBuscar = new JButton("BUSCAR");
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
        pnlBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);

    }

    public void btnLimpiarActionListener(ActionEvent e) {
        txCodigoC.setText("");
        txECodigoS.setText("");
        txMovimeinto.setText("");
        txNumeroC.setText("");
        txSaldo.setText("");
    }

    public void btnBuscarActionListener(ActionEvent e) {
        
        ICuenta cuentaDao = new CuentaImpl();
        cuenta = new Cuenta();

        try {
            cuenta = cuentaDao.obtener(Integer.parseInt(txNumeroC.getText()));
            txSaldo.setText(String.valueOf(cuenta.getSaldo()));
            txCodigoC.setText(cuenta.getNumerocuenta());
            txMovimeinto.setText(String.valueOf(cuenta.getMovimiento()));
            txECodigoS.setText(String.valueOf(cuenta.getSaldo()));

            if (cuentaDao.insertar(cuenta) > 0) {
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

    public void btnEliminarActionListener(ActionEvent e) {
       
        ICuenta cuentaDao = new CuentaImpl();
        Cliente nCliente = new Cliente();
        ICliente clienteDao = new ClienteImpl();
        Sucursal nSur = new Sucursal();
        ISucursal surdao = new SucursalImpl();

        try {
            cuenta = new Cuenta();
            nCliente = new Cliente();
            nSur = new Sucursal();
            cuenta.setNumerocuenta(txNumeroC.getText());
            cuenta.setSaldo(Double.parseDouble(txSaldo.getText()));
            cuenta.setMovimiento(Double.parseDouble(txMovimeinto.getText()));
            nCliente = clienteDao.obtener(txCodigoC.getText());
            cuenta.setCliente(nCliente);
            nSur = surdao.obtener(Integer.parseInt(txECodigoS.getText()));
            cuenta.setSucursal(nSur);

            if (cuentaDao.eliminar(cuenta) > 0) {
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

        FrmEliminarCuenta frmMenu = new  FrmEliminarCuenta ();
        frmMenu.setVisible(true);

    }

}
