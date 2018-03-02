
package ejerciciobanco.vistas;

/**
 *
 * @author Gilda
 */
import ejerciciobanco.rnegocio.entidades.Prestamo;
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

public class FrmNuevoPago extends JInternalFrame{
   
    List<Prestamo> lstPrestamo;
    JComboBox<Prestamo> cmbPrestamo;
    JLabel lblTitulo0; 
    JLabel lblCodigoPa;
    JLabel lblFecha;
    JLabel lblValor;
    JLabel lblPrestamo;
    

    JTextField txtCodigoPa, txtFecha, txtValor;
   
  
    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoPago() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo0 = new JLabel("DATOS DE PAGO");

        lblCodigoPa = new JLabel("CódigoPa:");
        lblFecha= new JLabel("Fecha:");
        lblValor = new JLabel("Valor:");
        lblPrestamo = new JLabel("Prestamo:");

        txtCodigoPa = new JTextField(2);
        txtFecha = new JTextField(2);
        txtValor = new JTextField(2);
        
        cargarPrestamos();
        cmbPrestamo = new JComboBox(lstPrestamo.toArray());
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(lblCodigoPa);
        pnlCentral.add(txtCodigoPa);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblValor);
        pnlCentral.add(txtValor);
        pnlCentral.add(lblPrestamo);
        pnlCentral.add(cmbPrestamo);

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
        FrmNuevoPago frmMenu = new FrmNuevoPago();
        frmMenu.setVisible(true);
    }

    public void cargarPrestamos() {
        IPrestamo prestamoDao = new PrestamoImpl();
        try {
            lstPrestamo = prestamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los cursos!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
       IPago pagoDao = new PagoImpl();
       Pago pago = new Pago();
        pago.setCodigoPa(Integer.parseInt(txtCodigoPa.getText()));
          DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pago.setFecha(formatoFecha.parse(txtFecha.getText()));
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //pago.setValor(Integer.parseDouble(txtValor.getText()));
        
        pago.setPrestamo((Prestamo) cmbPrestamo.getSelectedItem());
        
        try {
            if (pagoDao.insertar(pago) > 0) {
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
