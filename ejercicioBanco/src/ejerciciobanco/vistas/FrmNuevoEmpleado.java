
package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.IEmpleado;
import ejerciciobanco.rnegocio.dao.ISucursal;
import ejerciciobanco.rnegocio.entidades.Empleado;
import ejerciciobanco.rnegocio.entidades.Sucursal;
import ejerciciobanco.rnegocio.implementacion.EmpleadoImpl;
import ejerciciobanco.rnegocio.implementacion.SucursalImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmNuevoEmpleado extends JInternalFrame {
   List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblTitulo0;
    JLabel lblCodigoE;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblDireccion;
    JLabel lblTelefono;
    JLabel lblEmail;
    JLabel lblSucursal;
    
    
    JTextField txtCodigoE;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtDireccion;
    JTextField txtTelefono;
    JTextField txtEmail;    
 
   
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie; 
    
     public FrmNuevoEmpleado() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Empleado");
        
        lblCodigoE = new JLabel("Código:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblDireccion = new JLabel(" Direccion:");
        lblTelefono = new JLabel("Telefono:");
        lblEmail= new JLabel("Email:");
        lblSucursal= new JLabel("Sucursal:");

        txtCodigoE = new JTextField(2);
        txtNombre = new JTextField(2);
        txtApellido = new JTextField(2);
        txtDireccion = new JTextField(2);
        txtTelefono = new JTextField(2);        
        txtEmail = new JTextField(2);
        cargarSucursales();
        cmbSucursal = new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoE);
        pnlCentral.add(txtCodigoE);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblTelefono);
        pnlCentral.add(txtTelefono);
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);
        pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
      
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
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoEmpleado frmMenu= new FrmNuevoEmpleado();
        frmMenu.setVisible(true);
    } 
    public void cargarSucursales(){
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Sucursales!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IEmpleado empleadoDao = new EmpleadoImpl();
        Empleado empleado = new Empleado();
        empleado.setCodigoE(Integer.parseInt(txtCodigoE.getText()));
        empleado.setNombre(txtNombre.getText());
        empleado.setApellido(txtApellido.getText());
        empleado.setDireccion(txtDireccion.getText());
        empleado.setTelefono(txtTelefono.getText());
        empleado.setEmail(txtEmail.getText());
        empleado.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        
        try {
            if(empleadoDao.insertar(empleado)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
