
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


    public class CuentaImpl implements ICuenta {
        
@Override
    public int insertar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into curso (descripcion) values (?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerocuenta()));
        lstPar.add(new Parametro(2, cuenta.getTipocuenta()));
        lstPar.add(new Parametro(3, cuenta.getSaldo()));
        lstPar.add(new Parametro(4, cuenta.getMovimiento()));
        lstPar.add(new Parametro(5, cuenta.getCliente().getCedula()));
        lstPar.add(new Parametro(6, cuenta.getSucursal().getCodigoS()));
        lstPar.add(new Parametro(7, cuenta.getPrestamo().getCodigopr()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }
@Override
    public int modificar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  curso set descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerocuenta()));
        lstPar.add(new Parametro(2, cuenta.getTipocuenta()));
        lstPar.add(new Parametro(3, cuenta.getSaldo()));
        lstPar.add(new Parametro(4, cuenta.getMovimiento()));
        lstPar.add(new Parametro(5, cuenta.getCliente().getCedula()));
        lstPar.add(new Parametro(6, cuenta.getSucursal().getCodigoS()));
        lstPar.add(new Parametro(7, cuenta.getPrestamo().getCodigopr()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }


    @Override
    public Cuenta obtener(int numerocuenta) throws Exception {
        Cuenta cuenta = null;
         String sql = "select codigo, descripcion from curso where codigo=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, numerocuenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                cuenta= new Cuenta();
                cuenta.setNumerocuenta(rst.getString(1));
                cuenta.setTipocuenta(rst.getString(2));
                cuenta.setSaldo(rst.getDouble(3));
                cuenta.setMovimiento(rst.getDouble(4));
               // cuenta.setCedula(rst.getInt(5));
                
                cuenta.setSaldo(rst.getInt(2));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cuenta;
    }

   
    @Override
    public List<Cuenta> obtener() throws Exception {
        List<Cuenta> lista = new ArrayList<>();
         String sql = "select codigo, descripcion from curso";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuenta cuenta= null;
            while(rst.next()){
                cuenta= new Cuenta();
                cuenta.setNumerocuenta(rst.getString(1));
                cuenta.setSaldo(rst.getInt(2));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}


