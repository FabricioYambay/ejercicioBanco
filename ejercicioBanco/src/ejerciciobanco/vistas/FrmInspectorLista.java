
package ejerciciobanco.vistas;
import ejerciciobanco.rnegocio.implementacion.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.MouseEvent;


public class FrmInspectorLista extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmInspectorLista(){
        this.setSize(852,600);
        this.setLayout(new BorderLayout());

        this.setBackground(Color.BLACK);
        lblTitulo=new JLabel("INSPECTORES REGISTRADOS ");
        tabla= new JTable();
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(tabla,BorderLayout.NORTH);
        

        cargarTabla();  
    }
        public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");

        modelo.addRow(new Object[]{"CodigoI","Nombre","Apellido","Direccion","Titulo"});
     
        
        List<Inspector> list = new ArrayList<>();
        try {
            IInspector inspectorDao= new InspectorImpl();
            list = inspectorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        for(Inspector clt : list){
            modelo.addRow(new Object[]{clt.getCodigoI(),clt.getNombre(),clt.getApellido(),clt.getDireccion(),
                clt.getTitulo()});
        }
        tabla.setModel(modelo);
            
}}
