/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import ejerciciobanco.rnegocio.implementacion.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaAhorroImpl implements ICuentaAhorro{
     @Override
    
      public int insertar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into CuentaAhorros  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getCodigoca()));
        lstPar.add(new Parametro(2, cuentaahorro.getInteres()));
        lstPar.add(new Parametro(3, cuentaahorro.getCuenta().getNumerocuenta()));
       
     
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
    public int modificar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE CuentaAhorro" + "   SET CodigoCA=?,Interes=?, Numerocuenta=? "  + " where CodigoCA=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getCodigoca()));
        lstPar.add(new Parametro(2, cuentaahorro.getInteres()));
        lstPar.add(new Parametro(3, cuentaahorro.getCuenta().getNumerocuenta()));
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
public int eliminar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta_Ahorros  where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getCodigoca()));       
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
    public CuentaAhorro obtener(int codigoca) throws Exception {
        CuentaAhorro cuentaahorro = null;
        String sql = "SELECT *   FROM cuenta_Ahorros where n_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoca));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuentaahorro = new CuentaAhorro();
                cuentaahorro.setCodigoca(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                cuentaahorro.setInteres(rst.getDouble(2));
                Cuenta cuenta=cuentadao.obtener(rst.getInt(3));
                cuentaahorro.setCuenta(cuenta);
                
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuentaahorro;
    }

    @Override
    
    public List<CuentaAhorro> obtener() throws Exception {
        List<CuentaAhorro> lista = new ArrayList<>();
         String sql = "SELECT *   FROM CuentaAhorro ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            CuentaAhorro cuentaahorro=null;
            while (rst.next()) {
                cuentaahorro = new CuentaAhorro();
                cuentaahorro.setCodigoca(rst.getInt(1));
                cuentaahorro.setInteres(rst.getInt(2));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(3));
                cuentaahorro.setCuenta(cuenta);
                
                lista.add(cuentaahorro);
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

