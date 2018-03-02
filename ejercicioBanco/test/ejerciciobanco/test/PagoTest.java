
package ejerciciobanco.test;

import ejerciciobanco.rnegocio.dao.IPago;
import ejerciciobanco.rnegocio.Implementacion.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
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
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IPago pagoDao = new PagoImpl();
         IPrestamo  prestamoDao = new  PrestamoImpl();
        Prestamo prestamo = prestamoDao.obtener(1);
        Pago pago  = new Pago(1, new Date(), 20.15 ,prestamo );
      
        try{
            filasAfectadas = pagoDao.insertar(pago);
            System.out.println("Pago ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE etiqueta
        List<Pago> lista = new ArrayList<>();
        try {
            lista = pagoDao.obtener();
            for (Pago c:lista){
                
                System.out.println("---Datos de Pago---");
                 System.out.println("Codido  :"+c.getCodigoPa());
                System.out.println("Fecha:"+c.getFecha());
                System.out.println("Valor:"+c.getValor());
                System.out.println("Prestamo :"+c.getPrestamo().getRegistroImporte());
}
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
