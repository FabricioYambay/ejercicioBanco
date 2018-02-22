/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.ISucursal;
import ejerciciobanco.rnegocio.entidades.Sucursal;
import ejerciciobanco.rnegocio.implementacion.SucursalImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaSucursal extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;

    public FrmListaSucursal() {
        this.setSize(800, 700);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Sucursal");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Cuenta");
        modelo.addColumn("Empleado");
        modelo.addColumn("Prestamo");
                
        List<Sucursal> lista = new ArrayList<>();
        try {
            ISucursal sucursalDao = new SucursalImpl();
            lista = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Sucursal est : lista) {
            modelo.addRow(new Object[]{est.getCodigoS(), est.getCiudad(),
                est.getDireccion(), est.getCuenta(), est.getEmpleado(),est.getPrestamo().toString()});
        }
        tabla.setModel(modelo);
    }

}
