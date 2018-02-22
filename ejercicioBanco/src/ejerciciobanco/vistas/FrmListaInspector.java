
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IInspector;
import ejerciciobanco.rnegocio.entidades.Inspector;
import ejerciciobanco.rnegocio.implementacion.InspectorImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gilda
 */
public class FrmListaInspector extends JInternalFrame {
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaInspector() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Lista de Inspectores");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("CódigoI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
         modelo.addColumn("Direccion");
          modelo.addColumn("Titulo");
     
        List<Inspector> lista = new ArrayList<>();
        try {
            IInspector inspectorDao = new InspectorImpl();
            lista = inspectorDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Inspector est : lista){
            modelo.addRow(new Object[]{ est.getCodigoI(),
            est.getNombre(), est.getApellido() , est.getDireccion() , est.getTitulo()});            
        }
        tabla.setModel(modelo);        
    }
}

