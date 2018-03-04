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

public class FrmNuevaCuenta extends JFrame {

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

    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    public FrmNuevaCuenta() {

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
        btnIngresar = new JButton("Insertar");
//        btnIngresar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    btnIngresarActionListener(e);
//                } catch (Exception ex) {
//                    System.out.println("Error:" + ex.getMessage());
//                }
//            }
//        });
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

        FrmNuevaCuenta frmMenu = new FrmNuevaCuenta();
        frmMenu.setVisible(true);

    }

}
