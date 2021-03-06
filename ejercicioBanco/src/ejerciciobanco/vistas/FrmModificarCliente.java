package ejerciciobanco.vistas;

import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class FrmModificarCliente extends JInternalFrame{

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
    JButton btnModificar;
    JButton btnBuscar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;
    Cliente cliente;

    public FrmModificarCliente() {
        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("Modificar Cliente");
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
       
        btnModificar = new JButton("MODIFICAR");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnModificarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnLimpiarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
         btnBuscar = new JButton("BUSCAR");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnBuscarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
        pnlBotones = new JPanel(new GridLayout(3, 5, 10, 10));
        
        pnlBotones.add(btnBuscar);
        
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setClosable(true);
        //  this.setClosable(true);
    }

    public void btnModificarActionListener(ActionEvent e) {
        // Cliente nCliente = new Cliente();
        ICliente clienteDao = new ClienteImpl();
        try {
            cliente.setCedula(txCedula.getText());
            cliente.setNombre(txNombre.getText());
            cliente.setApellido(txApellido.getText());
            cliente.setTelefono(txTelefono.getText());
            cliente.setEmail(txEmail.getText());
            if (clienteDao.modificar(cliente) > 0) {
                JOptionPane.showMessageDialog(this, "Cliente Modificado Con Exito",
                        "Transacción", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error de Modificacion",
                        "Transacción", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Transacción", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnBuscarActionListener(ActionEvent e) {
        cliente = new Cliente();
        ICliente clienteDao = new ClienteImpl();
        try {
            cliente = clienteDao.obtener(txCedula.getText());
            // if (cliente != null) {
            txNombre.setText(cliente.getNombre());
            txApellido.setText(cliente.getApellido());
            txTelefono.setText(cliente.getTelefono());
            txEmail.setText(cliente.getEmail());

            // }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar el cliente",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnLimpiarActionListener(ActionEvent e) {
        txCedula.setText("");
        txNombre.setText("");
        txApellido.setText("");
        txTelefono.setText("");
        txEmail.setText("");
    }

    public static void main(String[] args) {

        FrmModificarCliente frmMenu = new FrmModificarCliente();
        frmMenu.setVisible(true);
    }
}
