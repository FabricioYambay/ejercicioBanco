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

public class FrmBuscarCliente extends JInternalFrame {

    JLabel lblTitulo;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblTelefono;
    JLabel lblEmail;
    JTextField txCedula;
    JTextArea txNombre;
    JTextArea txApellido;
    JTextArea txTelefono;
    JTextArea txEmail;
    JButton btnBuscar;
    JButton btnLimpiar;
    JPanel pnlInterno;
    JPanel pnlBotones;
    JPanel pnlPrincipal;

    //Cliente cliente;

    public FrmBuscarCliente() {

        this.setSize(420, 680);
        this.setLayout(new BorderLayout());
        lblTitulo = new JLabel("Buscar Cliente");
        this.add(lblTitulo, BorderLayout.NORTH);
        lblCedula = new JLabel("Cedula: ");
        lblNombre = new JLabel("Nombre: ");
        lblApellido = new JLabel("Apellido: ");
        lblTelefono = new JLabel("Telefono: ");
        lblEmail = new JLabel("E-mail: ");
        txCedula = new JTextField("");
        txNombre = new JTextArea("");
        txApellido = new JTextArea("");
        txTelefono = new JTextArea("");
        txEmail = new JTextArea("");
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
        btnBuscar = new JButton("Buscar");
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
        btnLimpiar = new JButton("Limpiar");
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
        pnlBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlBotones.add(btnBuscar);
        pnlBotones.add(btnLimpiar);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setClosable(true);
    }

    public void btnBuscarActionListener(ActionEvent e) {
        Cliente nCliente = new Cliente();
        ICliente clienteDao = new ClienteImpl();
        try {
            nCliente = clienteDao.obtener(txCedula.getText());
           // if (cliente != null) {
                txNombre.setText(nCliente.getNombre());
                txApellido.setText(nCliente.getApellido());
                txTelefono.setText(nCliente.getTelefono());
                txEmail.setText(nCliente.getEmail());

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

        FrmBuscarCliente frmMenu = new FrmBuscarCliente();
        frmMenu.setVisible(true);
    }

}
