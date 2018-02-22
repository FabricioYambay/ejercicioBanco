package ejerciciobanco.vistas;

import javax.swing.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 * @author Jhon
 */
public class FrmNuevoCliente extends JInternalFrame {

    JLabel lblTitulo;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblTelefono;
    JLabel lblEmail;
    JTextField txCedula;
    JTextField txNombre;
    JTextField txApellido;
    JTextField txTelefono;
    JTextField txEmail;
    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    public FrmNuevoCliente() {
        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("Nuevo Cliente");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblCedula = new JLabel("Cedula: ");
        lblNombre = new JLabel("Nombre: ");
        lblApellido = new JLabel("Apellido: ");
        lblTelefono = new JLabel("Telefono: ");
        lblEmail = new JLabel("E-mail: ");
        txCedula = new JTextField("");
        txNombre = new JTextField("");
        txApellido = new JTextField("");
        txTelefono = new JTextField("");
        txEmail = new JTextField("");
        pnlInterno = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlInterno.add(lblCedula);
        pnlInterno.add(txCedula);
        pnlInterno.add(lblNombre);
        pnlInterno.add(txNombre);
        pnlInterno.add(lblApellido);
        pnlInterno.add(txApellido);
        pnlInterno.add(lblTelefono);
        pnlInterno.add(txTelefono);
        pnlInterno.add(lblEmail);
        pnlInterno.add(txEmail);
        this.add(pnlInterno, BorderLayout.CENTER);
        btnIngresar = new JButton("Insertar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnIngresarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnLimpiarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        pnlBotones=new JPanel(new GridLayout(1, 2, 10, 10));
        pnlBotones.add(btnIngresar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setClosable(true);
    }
    
    public void btnIngresarActionListener(ActionEvent e){
        Cliente nCliente=new Cliente();
        ICliente clienteDao=new ClienteImpl();
        try {
            nCliente.setCedula(txCedula.getText());
            nCliente.setNombre(txNombre.getText());
            nCliente.setApellido(txApellido.getText());
            nCliente.setTelefono(txTelefono.getText());
            nCliente.setEmail(txEmail.getText());
            if(clienteDao.insertar(nCliente)>0){
                JOptionPane.showMessageDialog(this,"Cliente Ingresado Correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this,"Error de Insercion",
                "Transacción", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage(),
                "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void btnLimpiarActionListener(ActionEvent e){
        txCedula.setText("");
        txNombre.setText("");
        txApellido.setText("");
        txTelefono.setText("");
        txEmail.setText("");
    }

}
