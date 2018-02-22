
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import ejerciciobanco.rnegocio.implementacion.PrestamoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaPrestamo extends JInternalFrame {
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaPrestamo(){
        
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Prestamos");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        
        modelo.addColumn("RegistroImportes");
        modelo.addColumn("Pagos");
        modelo.addColumn("Ahorros");
        modelo.addColumn("Codigo");
        
        List<Prestamo> lista = new ArrayList<>();
        try {
            IPrestamo prestamoDao = new PrestamoImpl();
            lista = prestamoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Prestamo est : lista){
            modelo.addRow(new Object[] { est.getRegistroImporte(), est.getPagos(),
                est.getAhorros(),est.getCodigoPr()});
            }
           tabla.setModel(modelo); 
        }
    
}
