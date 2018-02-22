
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IEmpleado;
import ejerciciobanco.rnegocio.entidades.Empleado;
import ejerciciobanco.rnegocio.implementacion.EmpleadoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaEmpleado extends JInternalFrame {
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaEmpleado(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Empleados");
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
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        
        List<Empleado> lista = new ArrayList<>();
        try {
            IEmpleado empleadoDao = new EmpleadoImpl();
            lista = empleadoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Empleado est : lista){
            modelo.addRow(new Object[] { est.getCodigoE(),
                est.getNombre(), est.getApellido(),est.getDireccion(),est.getTelefono(),est.getEmail()});
            }
           tabla.setModel(modelo); 
        }
    
}
