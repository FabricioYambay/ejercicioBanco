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
        String sql = "insert into cuenta (NumCuenta, Saldo, Movimiento, CodigoC, CodigoS)  values  (?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerocuenta()));
        lstPar.add(new Parametro(2, cuenta.getSaldo()));
        lstPar.add(new Parametro(3, cuenta.getMovimiento()));
        lstPar.add(new Parametro(4, cuenta.getCliente().getCedula()));
        lstPar.add(new Parametro(5, cuenta.getSucursal().getCodigoS()));

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
        String sql = "update  Cuenta set Numerocuenta=?,Saldo=?,Movimiento=?,CodigoC=?,CodigoS=? where Numerocuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerocuenta()));
        lstPar.add(new Parametro(2, cuenta.getSaldo()));
        lstPar.add(new Parametro(3, cuenta.getMovimiento()));
        lstPar.add(new Parametro(4, cuenta.getCliente().getCedula()));
        lstPar.add(new Parametro(5, cuenta.getSucursal().getCodigoS()));

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
        String sql = "select * from Cuenta where Numerocuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, numerocuenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Cliente cliente = null;
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {

                cuenta.setCliente(cliente);
                cuenta.setNumerocuenta(rst.getString(1));

                cuenta.setSaldo(rst.getDouble(2));
                cuenta.setMovimiento(rst.getDouble(3));
                ICliente clientedao= new ClienteImpl();
                cliente=clientedao.obtener(rst.getString(4));
                ISucursal sucursalDao = new SucursalImpl();
                Sucursal sucursal = sucursalDao.obtener(rst.getInt(5));

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
        String sql = "SELECT * FROM cuenta ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuenta cuenta = null;
            Cliente cliente = null;
            Sucursal sucursal = null;
            while (rst.next()) {
                cuenta = new Cuenta();
                cuenta.setCliente(cliente);
                cuenta.setNumerocuenta(rst.getString(1));
                cuenta.setSaldo(rst.getDouble(2));
                cuenta.setMovimiento(rst.getDouble(3));
                ICliente clientedao= new ClienteImpl();
                cliente=clientedao.obtener(rst.getString(4));
                ISucursal sucursalDao = new SucursalImpl();
                sucursal = sucursalDao.obtener(rst.getInt(5));
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
