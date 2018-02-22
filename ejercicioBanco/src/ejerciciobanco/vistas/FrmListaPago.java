
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IPago;
import ejerciciobanco.rnegocio.entidades.Pago;
import ejerciciobanco.rnegocio.implementacion.PagoImpl;
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
public class FrmListaPago extends JInternalFrame {
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaPago() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Lista de Pagos");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("CódigoPa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Valor");
     
        List<Pago> lista = new ArrayList<>();
        try {
            IPago pagoDao = new PagoImpl();
            lista = pagoDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Pago est : lista){
            modelo.addRow(new Object[]{ est.getCodigoPa(),est.getFecha().toString(), 
            est.getValor()});            
        }
        tabla.setModel(modelo);        
    }
}

