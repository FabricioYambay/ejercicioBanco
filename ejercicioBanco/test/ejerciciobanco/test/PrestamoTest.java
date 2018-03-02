
package ejerciciobanco.test;

import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import ejerciciobanco.rnegocio.implementacion.PrestamoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PrestamoTest {

    public PrestamoTest() {
    }
    @Test
     public void pruebageneral() {
        int filasAfectadas = 0;
        IPrestamo prestamoDao = new PrestamoImpl();
        Prestamo prestamo = new Prestamo("ninguno",600,400,4);
        try {
            filasAfectadas = prestamoDao.insertar(prestamo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        prestamo = null;
        try {
            prestamo = prestamoDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        

        try {
            prestamo.setRegistroImporte("Prueba");
            filasAfectadas= prestamoDao.modificar(prestamo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Prestamo> lista = new ArrayList<>();
        try {
            lista = prestamoDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= prestamoDao.eliminar(prestamo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

    
}
