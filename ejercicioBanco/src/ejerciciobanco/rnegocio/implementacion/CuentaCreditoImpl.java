/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaCreditoImpl implements ICuentaCredito{
     @Override
    
      public int insertar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into CuentaCredito  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getCodigocc()));
        lstPar.add(new Parametro(2, cuentacredito.getValorsobregiro()));
       
       
     
        Conexion con = null;
        try {
            con = new Conexion();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE CuentaCredito" + "   SET CodigoCC=?,Valorsobregiro=? "  + " where CodigoCC=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getCodigocc()));
        lstPar.add(new Parametro(2, cuentacredito.getValorsobregiro()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
public int eliminar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM CuentaCredito  where CodigoCC=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getCodigocc()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public CuentaCredito obtener(int codigocc) throws Exception {
        CuentaCredito cuentacredito = null;
        String sql = "SELECT *   FROM cuentaCredito where CodigoCC=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigocc));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuentacredito = new CuentaCredito();
                cuentacredito.setCodigocc(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                cuentacredito.setValorsobregiro(rst.getDouble(2));
                Cuenta cuenta=cuentadao.obtener(rst.getInt(3));
                cuentacredito.setCuenta(cuenta);
                
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuentacredito;
    }

    @Override
    
    public List<CuentaCredito> obtener() throws Exception {
        List<CuentaCredito> lista = new ArrayList<>();
         String sql = "SELECT *   FROM CuentaCredito ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            CuentaCredito cuentacredito=null;
            while (rst.next()) {
                cuentacredito = new CuentaCredito();
                cuentacredito.setCodigocc(rst.getInt(1));
                cuentacredito.setValorsobregiro(rst.getInt(2));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(3));
                cuentacredito.setCuenta(cuenta);
                
                lista.add(cuentacredito);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }

   
} 
