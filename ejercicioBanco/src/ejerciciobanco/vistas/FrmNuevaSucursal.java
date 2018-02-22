/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevaSucursal extends JInternalFrame {

    List<Prestamo> lstPrestamo;
    JComboBox<Prestamo> cmbPrestamo;
    JLabel lblCodigoS;
    JLabel lblCiudad;
    JLabel lblDireccion;
    JLabel lblPrestamo;
    JLabel lblTitulo;

    JTextField txtCodigoS;
    JTextField txtCiudad;
    JTextField txtDireccion;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevaSucursal() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo = new JLabel("    Sucursal");

        lblCodigoS = new JLabel("Código:");
        lblCiudad = new JLabel("Ciudad:");
        lblDireccion = new JLabel("Direccion:");
        lblPrestamo = new JLabel("Prestamo:");
        
        txtCodigoS = new JTextField(2);
        txtCiudad = new JTextField(2);
        txtDireccion = new JTextField(2);
        cargarPrestamo();
        cmbPrestamo = new JComboBox(lstPrestamo.toArray());
    
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(lblCodigoS);
        pnlCentral.add(txtCodigoS);
        pnlCentral.add(lblCiudad);
        pnlCentral.add(txtCiudad);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblPrestamo);
        pnlCentral.add(cmbPrestamo);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });

        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);

        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        FrmNuevaSucursal frmMenu= new FrmNuevaSucursal();
        frmMenu.setVisible(true);
    } 
 
    public void cargarPrestamo(){
        IPrestamo prestamoDao = new PrestamoImpl();
        try {
            lstPrestamo = prestamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Prestamo!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        Sucursal sucursal = new Sucursal();
        ISucursal sucursalDao = new SucursalImpl();
        sucursal.setCodigoS(Integer.parseInt(txtCodigoS.getText()));
        sucursal.setCiudad(txtCiudad.getText());
        sucursal.setDireccion(txtDireccion.getText());
        sucursal.setPrestamo((Prestamo) cmbPrestamo.getSelectedItem());
        
        try {
            if (sucursalDao.insertar(sucursal) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
}

}
