package ejerciciobanco.vistas;

import javax.swing.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FrmNuevoInspector extends JFrame {

    private JPanel centro;
    private JPanel botones;
    private JLabel lblTituloP;
    private JLabel lblCodigoI;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDireccion;
    private JLabel lblTitulo;
    private JTextField tfCodigoI;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfDireccion;
    private JTextField tfTitulo;
    private JButton btnIngresar;
    private JButton btnLimpiar;

    public FrmNuevoInspector() {
        this.setLayout(new BorderLayout());
        lblTituloP = new JLabel("Nuevo Inspector");
        lblCodigoI = new JLabel("Codigo: ");
        lblNombre = new JLabel("Nombre: ");
        lblApellido = new JLabel("Apellido: ");
        lblDireccion = new JLabel("Direccion: ");
        lblTitulo = new JLabel("Titulo: ");
        tfCodigoI = new JTextField("");
        tfNombre = new JTextField("");
        tfApellido = new JTextField("");
        tfDireccion = new JTextField("");
        tfTitulo = new JTextField("");
        centro = new JPanel(new GridLayout(5, 2));
        centro.add(lblCodigoI);
        centro.add(tfCodigoI);
        centro.add(lblNombre);
        centro.add(tfNombre);
        centro.add(lblApellido);
        centro.add(tfApellido);
        centro.add(lblDireccion);
        centro.add(tfDireccion);
        centro.add(lblTitulo);
        centro.add(tfTitulo);
        btnIngresar=new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btningresarActionListener(e);
            }
        });
        btnLimpiar=new JButton("Limpiar");
        botones=new JPanel(new GridLayout(1, 2));
        botones.add(btnIngresar);
        botones.add(btnLimpiar);
        this.add(lblTituloP, BorderLayout.NORTH);
        this.add(centro, BorderLayout.CENTER);
        this.add(botones, BorderLayout.SOUTH);
        this.setSize(300, 300);
    } 

    public static void main(String[] args) {
        FrmNuevoInspector frm = new FrmNuevoInspector();
        frm.setVisible(true);
    }
    
    public void btningresarActionListener(ActionEvent e){
        IInspector inspectorDao=new InspectorImpl();
        Inspector nInspector=new Inspector();
        nInspector.setCodigoI(Integer.parseInt(tfCodigoI.getText()));
        nInspector.setNombre(tfNombre.getText());
        nInspector.setApellido(tfApellido.getText());
        nInspector.setDireccion(tfDireccion.getText());
        nInspector.setTitulo(tfTitulo.getText());
        try {
            if(inspectorDao.insertar(nInspector)>0)
            JOptionPane.showMessageDialog(this,"Mensaje de sistema","Ingreso de Inspector Correcto", JOptionPane.ERROR_MESSAGE);
            else
            JOptionPane.showMessageDialog(this,"Mensaje de sistema","Error al ingresar Inspector", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error de sistema","Error"+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnLimpiarActionListener(ActionEvent e){
        tfCodigoI.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfDireccion.setText("");
        tfTitulo.setText("");
    }
    
}
