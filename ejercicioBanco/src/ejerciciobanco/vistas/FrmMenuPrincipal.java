/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JMenu mnSucursal;
    JMenuItem mniNuevoSucursal;
    JMenuItem mniModificaSucursal;
    JMenuItem mniEliminaSucursal;
    JMenuItem mniBuscarSucursal;
    JMenuItem mniListarSucursal;
    JMenu mnCuenta;
    JMenuItem mniNuevoCuenta;
    JMenuItem mniModificaCuenta;
    JMenuItem mniEliminaCuenta;
    JMenuItem mniBuscaCuenta;
    JMenuItem mniListaCuenta;
    
    //Empleado
    JMenu mnEmpleado;
    JMenuItem mniNuevoEmpleado;
    JMenuItem mniModificaEmpleado;
    JMenuItem mniEliminaEmpleado;
    JMenuItem mniBuscarEmpleado;
    JMenuItem mniListarEmpleado;
    
    //Prestamo
    JMenu mnPrestamo;
    JMenuItem mniNuevoPrestamo;
    JMenuItem mniModificaPrestamo;
    JMenuItem mniEliminaPrestamo;
    JMenuItem mniBuscarPrestamo;
    JMenuItem mniListarPrestamo;
 
    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio = new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Seciòn");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnSucursal = new JMenu("Sucursal");
        mniNuevoSucursal = new JMenuItem("Nuevo");
        mniNuevoSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevaSucursalActionPerformed(e);
            }
        });
        mniModificaSucursal = new JMenuItem("Modificar");
        mniEliminaSucursal = new JMenuItem("Eliminar");
        mniBuscarSucursal = new JMenuItem("Buscar");
        mniListarSucursal = new JMenuItem("Listar");
        mniListarSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaSucursalActionPerdormed(e);
            }
        });
        
        mnSucursal.add(mniNuevoSucursal);
        mnSucursal.add(mniModificaSucursal);
        mnSucursal.add(mniEliminaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniBuscarSucursal);
        mnSucursal.add(mniListarSucursal);
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnSucursal);
        
        
        //Empleado
        mnEmpleado = new JMenu("Empleado");
        mniNuevoEmpleado = new JMenuItem("Nuevo");
        mniNuevoEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEmpleadoActionPerformed(e);
            }
        });
        mniModificaEmpleado = new JMenuItem("Modificar");
        mniEliminaEmpleado = new JMenuItem("Eliminar");
        mniBuscarEmpleado = new JMenuItem("Buscar");
        mniListarEmpleado = new JMenuItem("Listar");
        mniListarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEmpleadoActionPerdormed(e);
            }
        });
        
        mnEmpleado.add(mniNuevoEmpleado);
        mnEmpleado.add(mniModificaEmpleado);
        mnEmpleado.add(mniEliminaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniBuscarEmpleado);
        mnEmpleado.add(mniListarEmpleado);
        
        //Prestamo
        mnPrestamo = new JMenu("Prestamo");
        mniNuevoPrestamo = new JMenuItem("Nuevo");
        mniNuevoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPrestamoActionPerformed(e);
            }
        });
        mniModificaPrestamo = new JMenuItem("Modificar");
        mniEliminaPrestamo = new JMenuItem("Eliminar");
        mniBuscarPrestamo = new JMenuItem("Buscar");
        mniListarPrestamo = new JMenuItem("Listar");
        mniListarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListarPrestamoActionPerdormed(e);
            }
        });
        
        mnPrestamo.add(mniNuevoPrestamo);
        mnPrestamo.add(mniModificaPrestamo);
        mnPrestamo.add(mniEliminaPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniBuscarPrestamo);
        mnPrestamo.add(mniListarPrestamo);
        
        
        mnEmpleado.add(mnInicio);
        mnEmpleado.add(mnSucursal);
        mnEmpleado.add(mnEmpleado);
        
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);

        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, 500, 450);
    }
    public void mniSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    //Prestamo
     public void mniNuevoPrestamoActionPerformed(ActionEvent e) {
        FrmNuevoPrestamo frm = new FrmNuevoPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListarPrestamoActionPerdormed(ActionEvent e) {
        FrmListaPrestamo frm = new FrmListaPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    //Empleado
     public void mniNuevoEmpleadoActionPerformed(ActionEvent e) {
        FrmNuevoEmpleado frm = new FrmNuevoEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaEmpleadoActionPerdormed(ActionEvent e) {
        FrmListaEmpleado frm = new FrmListaEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    
    public void mniNuevaSucursalActionPerformed(ActionEvent e) {
        FrmNuevaSucursal frm = new FrmNuevaSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaSucursalActionPerdormed(ActionEvent e) {
        FrmListaSucursal frm = new FrmListaSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        FrmMenuPrincipal frmMEnu = new FrmMenuPrincipal();
        frmMEnu.setVisible(true);

    }

}
