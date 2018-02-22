
package ejerciciobanco.vistas;

/**
 *
 * @author Gilda
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.implementacion.*;
import ejerciciobanco.rnegocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrmNuevoInspector extends JInternalFrame{
   
   
    JLabel lblTitulo0; 
    JLabel lblCodigoI,lblNombre,lblApellido,lblDireccion,lblTitulo ;
    JTextField txtCodigoI,txtNombre,txtApellido,txtDireccion,txtTitulo;
   
    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoInspector() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo0 = new JLabel("DATOS DEL INSPECTOR");

        lblCodigoI = new JLabel("CódigoI:");
        lblNombre= new JLabel("Nombre:");
        lblApellido= new JLabel("Apellido:");
        lblDireccion= new JLabel("Direccion:");
        lblTitulo= new JLabel("Titulo:");
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add( lblCodigoI);
        pnlCentral.add( txtCodigoI);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblTitulo);
        pnlCentral.add(txtTitulo);
        
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

        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        FrmNuevoInspector frmMenu = new FrmNuevoInspector();
        frmMenu.setVisible(true);
    }

  
    public void btnAceptarActionListener(ActionEvent e) {
       IInspector inspectorDao = new InspectorImpl();
       Inspector inspector = new Inspector();
        inspector.setCodigoI(Integer.parseInt(txtCodigoI.getText()));
        inspector.setNombre(txtNombre.getText());
        inspector.setApellido(txtApellido.getText());
        inspector.setDireccion(txtDireccion.getText());
        inspector.setTitulo(txtTitulo.getText());
         
       
        
        try {
            if (inspectorDao.insertar(inspector) > 0) {
                JOptionPane.showMessageDialog(this, "Guardado Correctamente!!",
                        "Transacción", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error desconocido: ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar!!: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
