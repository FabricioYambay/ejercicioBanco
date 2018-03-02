
package ejerciciobanco.Test;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class InspectorTest {
    
     public InspectorTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        IInspector inspectorDao = new InspectorImpl();
        Inspector inspector  = new Inspector(2, "Juan","Perez",  "Riobamba", "Ing" );
    
        try{
            filasAfectadas = inspectorDao.insertar(inspector);
            System.out.println("Inspector ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE etiqueta
        List<Inspector> lista = new ArrayList<>();
        try {
            lista = inspectorDao.obtener();
            for (Inspector c:lista){
                System.out.println("---Datos de Inspector---");
                System.out.println("Codigo :"+c.getCodigoI());
                System.out.println("Nombres :"+c.getNombre());
                System.out.println("Apellidos :"+c.getApellido());
                System.out.println("Direccion :"+c.getDireccion());
                System.out.println("Ttulo  :"+c.getTitulo());          
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
