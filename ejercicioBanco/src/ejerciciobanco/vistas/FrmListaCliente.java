package ejerciciobanco.vistas;

import javax.swing.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JhonPC
 */
public class FrmListaCliente extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;

    public FrmListaCliente() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Clientes");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
    }
    
      public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        
        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente empleadoDao = new ClienteImpl();
            lista = empleadoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al cargar la Musica",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente est : lista){
            modelo.addRow(new Object[] { est.getCedula(),est.getNombre(), est.getApellido(),est.getTelefono(),est.getEmail()});
            }
           tabla.setModel(modelo); 
        }

}
