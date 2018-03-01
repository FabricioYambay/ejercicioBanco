
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.IEmpleado;
import ejerciciobanco.rnegocio.dao.ISucursal;
import ejerciciobanco.rnegocio.entidades.Empleado;
import ejerciciobanco.rnegocio.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoImpl implements IEmpleado{
    
     @Override
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into empleado  values "
                +"(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodigoE()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getDireccion()));
        lstPar.add(new Parametro(5, empleado.getTelefono()));
        lstPar.add(new Parametro(6, empleado.getEmail()));
        lstPar.add(new Parametro(7, empleado.getSucursal().getCodigoS()));
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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE empleado"
                + "   SET codigoE=?, nombre=?,apellido=?, direccion=?, "
                + "telefono=?, email=?, codigoS=?"
                + " where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodigoE()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getDireccion()));
        lstPar.add(new Parametro(5, empleado.getTelefono()));
        lstPar.add(new Parametro(6, empleado.getEmail()));
        lstPar.add(new Parametro(7, empleado.getSucursal().getCodigoS()));
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
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM empleado  where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodigoE()));       
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
    public Empleado obtener(int codigoE) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT codigoE, nombres, apellido, direccion, "
                + "telefono,  email, codigoS   FROM empleado where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoE));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodigoE(rst.getInt(1));
                empleado.setNombre(rst.getString(2));
                empleado.setApellido(rst.getString(3));
                empleado.setDireccion(rst.getString(4));
                empleado.setTelefono(rst.getString(5));
                empleado.setEmail(rst.getString(6));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(7));
                empleado.setSucursal(sucursal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
         String sql = "SELECT codigoE, nombres, apellido,direccion,"
                + "telefono, email, codigoS  FROM empleado ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Empleado empleado=null;
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodigoE(rst.getInt(1));
                empleado.setNombre(rst.getString(2));
                empleado.setApellido(rst.getString(3));
                empleado.setDireccion(rst.getString(4));
                empleado.setTelefono(rst.getString(5));
                empleado.setEmail(rst.getString(6));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(10));
                empleado.setSucursal(sucursal);
                lista.add(empleado);
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
