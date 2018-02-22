/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.entidades.Pedido;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eddyf
 */
public class PedidoImpl implents PedidoI{
    @Override
    public int insertar(Pedido sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Pedido  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodigoS()));
        lstPar.add(new Parametro(2, sucursal.getCiudad()));
        lstPar.add(new Parametro(3, sucursal.getDireccion()));
        lstPar.add(new Parametro(4, sucursal.getCuenta().getNumerocuenta()));
        lstPar.add(new Parametro(5, sucursal.getEmpleado().getCdigoE()));
        lstPar.add(new Parametro(6, sucursal.getPrestamo().getNum_prestamo()));

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
    public int modificar(Pedido sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE sucursal"
                + "   SET codigoS=?, ciudad=?, direccion=?, numerocuenta=?, =?,codigoe=?,num_prestamo "
                + " where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodigoS()));
        lstPar.add(new Parametro(2, sucursal.getCiudad()));
        lstPar.add(new Parametro(3, sucursal.getDireccion()));
        lstPar.add(new Parametro(4, sucursal.getCuenta().getNumerocuenta()));
        lstPar.add(new Parametro(5, sucursal.getEmpleado().getCodigoE()));
        lstPar.add(new Parametro(6, sucursal.getPrestamo().getNum_prestamo()));

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
    public int eliminar(Pedido sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM sucursal  where codigoS=?";
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
    public Pedido obtener(int codigoS) throws Exception {
        Pedido sucursal = null;
        Cuenta cuenta = null;
        ICuenta cuentaDao = new CuentaImpl();
        Empleado empleado = null;
        IEmpleado empleadoDao = new EmpleadoImpl();
        Prestamo prestamo = null;
        IPrestamo prestamoDao = new PrestamoImpl();
        String sql = "SELECT * FROM sucursal where codigoS=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoS));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                Cuenta = new Cuenta();
                cuenta = cuentaDao.obtener(rst.getInt(4));
                Empleado = new Empleado();
                empleado = empleadoDao.obtener(rst.getInt(5));
                Prestamo = new Prestamo();
                prestamo = prestamoDao.obtener(rst.getInt(6));
                sucursal = new Pedido();
                sucursal.setCodigoS(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));
                sucursal.setDireccion(rst.getString(3));
                sucursal.setCuenta(cuenta);
                sucursal.setEmpleado(empleado);
                sucursal.setPrestamo(prestamo);

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
    public List<Pedido> obtener() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        Cuenta cuenta = null;
        ICuenta cuentaDao = new CuentaImpl();
        String sql = "SELECT * FROM entrada ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Pedido sucursal = null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor = proveedorDao.obtener(rst.getInt(2));
                Empleado empleado = null;
                IEmpleado empleadoDao = new EmpleadoImpl();
                Prestamo prestamo = null;
                IPrestamo prestamoDao = new PrestamoImpl();
                sucursal = new Pedido();
                sucursal.setCodigoS(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));
                sucursal.setDireccion(rst.getString(3));
                sucursal.setCuenta(cuenta);
                sucursal.setEmpleado(empleado);
                sucursal.setPrestamo(prestamo);

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
