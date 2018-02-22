
package ejerciciobanco.test;

import ejerciciobanco.rnegocio.dao.IPago;
import ejerciciobanco.rnegocio.entidades.Pago;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import ejerciciobanco.rnegocio.implementacion.PagoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Gilda
 */
public class PagoTest {
      public PagoTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IPago pagoDao = new PagoImpl();
        Prestamo prestamo = new Prestamo( "RegistroImporte", "Pagos", "Ahorros", 1);
        Pago pago = new Pago( 1, new Date(), 8.8,  prestamo);
        try {
            filasAfectadas = pagoDao.insertar(pago);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        pago = null;
        try {
            pago = pagoDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(pago != null);

        try {
            pago.setCodigoPa(1);
            filasAfectadas= pagoDao.modificar(pago);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Pago> lista = new ArrayList<>();
        try {
            lista = pagoDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= pagoDao.eliminar(pago);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }
    
}
