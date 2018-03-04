/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.*;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.Cuenta;
import ejerciciobanco.rnegocio.entidades.Empleado;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import ejerciciobanco.rnegocio.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CRISTIAN
 */
public class SucursalImpl implements ISucursal {

    @Override
    public int insertar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Sucursal  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodigoS()));
        lstPar.add(new Parametro(2, sucursal.getNombrebanco()));
        lstPar.add(new Parametro(3, sucursal.getCiudad()));
        lstPar.add(new Parametro(4, sucursal.getDireccion()));
        lstPar.add(new Parametro(5, sucursal.getTelefono()));
        lstPar.add(new Parametro(6, sucursal.getEmail()));

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
    public int modificar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE sucursal"
                + "   SET codigoS=?, NombreBanco=?, ciudad=?, direccion=?,telefono=?,email=? "
                + " where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodigoS()));
        lstPar.add(new Parametro(2, sucursal.getNombrebanco()));
        lstPar.add(new Parametro(3, sucursal.getCiudad()));
        lstPar.add(new Parametro(4, sucursal.getDireccion()));
        lstPar.add(new Parametro(5, sucursal.getTelefono()));
        lstPar.add(new Parametro(6, sucursal.getEmail()));
        lstPar.add(new Parametro(7, sucursal.getCodigoS()));
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
    public int eliminar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Sucursal  where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodigoS()));
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
    public Sucursal obtener(int codigoS) throws Exception {
        Sucursal sucursal = null;
        String sql = "SELECT * FROM Sucursal where CodigoS=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoS));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                sucursal = new Sucursal();
                sucursal.setCodigoS(rst.getInt(1));
                sucursal.setNombrebanco(rst.getString(2));
                sucursal.setCiudad(rst.getString(3));
                sucursal.setDireccion(rst.getString(4));
                sucursal.setTelefono(rst.getString(5));
                sucursal.setEmail(rst.getString(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return sucursal;
    }

    @Override
    public List<Sucursal> obtener() throws Exception {
        List<Sucursal> lista = new ArrayList<>();

        String sql = "SELECT * FROM sucursal ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Sucursal sucursal = null;
            while (rst.next()) {
                sucursal = new Sucursal();
                sucursal.setCodigoS(rst.getInt(1));
                sucursal.setNombrebanco(rst.getString(2));
                sucursal.setCiudad(rst.getString(3));
                sucursal.setDireccion(rst.getString(4));
                sucursal.setTelefono(rst.getString(5));
                sucursal.setEmail(rst.getString(6));
                lista.add(sucursal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lista;
    }

}
