/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.vistas;
import ejerciciobanco.rnegocio.implementacion.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
public class FrmInspectorNuevo extends JInternalFrame{
    JLabel  lblTituloO;
    JLabel lblCodigoI;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblDireccion;
    JLabel lblTitulo;
    JTextField txtCodigoI,txtNombre,txtApellido,txtDireccion,txtTitulo;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
        public FrmInspectorNuevo(){
        this.setSize(400,600);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("DATOS DEL INSPECTOR");
                
        lblCodigoI= new JLabel("CODIGO:");
        lblNombre= new JLabel(" NOMBRE:");
        lblApellido= new JLabel("APELLIDO:");
        lblDireccion=new JLabel("DIRECCION");
        lblTitulo=new JLabel("TITULO");
       
        
        txtCodigoI = new JTextField(2);
        txtNombre= new JTextField(2);
        txtApellido= new JTextField(2);
        txtDireccion= new JTextField(2);
        txtTitulo= new JTextField(2);
        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblCodigoI);
        pnlCentral.add(txtCodigoI);
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
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
                      
        pnlInferior.add(btnLimpiar);
        pnlInferior.add(btnAceptar);
        pnlSuperior.setBackground(Color.getHSBColor(100,60,270).brighter());
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(pnlSuperior, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);  
        this.setClosable(true);
    }
        public static void main(String[] args) {
        FrmInspectorNuevo frmMenu= new FrmInspectorNuevo();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        
        try {
                     
            Inspector inspector = new Inspector();
            inspector.setCodigoI(Integer.parseInt(txtCodigoI.getText()));
            inspector.setNombre(txtNombre.getText());
            inspector.setApellido(txtApellido.getText());
            inspector.setDireccion(txtDireccion.getText());
            inspector.setTitulo(txtTitulo.getText());
            IInspector inpectorDao = new InspectorImpl();
            
            if(inpectorDao.insertar(inspector)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
      
    }        
}

