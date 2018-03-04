
package ejerciciobanco.test;
import static org.junit.Assert.assertEquals;
import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class SucursalTest {
    
    public SucursalTest() {
    }
     @Test
    public void TestGeneral(){
        ISucursal sucDao=new SucursalImpl();
        Sucursal nSuc=null;
         try {
             nSuc=new Sucursal();
             nSuc=sucDao.obtener(1);
             System.out.println(nSuc.getNombrebanco()+" "+nSuc.getCodigoS()+" "+nSuc.getCiudad()+" "+nSuc.getDireccion()+" "+nSuc.getTelefono()+" "+nSuc.getEmail());
         } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
         }
         assertTrue(nSuc!=null);
    }
    
}
