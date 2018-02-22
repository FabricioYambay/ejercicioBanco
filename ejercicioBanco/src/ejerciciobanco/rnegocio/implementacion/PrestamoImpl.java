
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamoImpl implements IPrestamo {
    @Override
    public int insertar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Prestamo  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getRegistroImporte()));
        lstPar.add(new Parametro(2, prestamo.getPagos()));
        lstPar.add(new Parametro(3, prestamo.getAhorros()));
        lstPar.add(new Parametro(4, prestamo.getCodigoPr()));
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
    public int modificar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Prestamo"
                + "   SET RegistroImporte, Paagos=?, Ahorros=?, CodigoPr=? "
                + " where CodigoPr=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getRegistroImporte()));
        lstPar.add(new Parametro(2, prestamo.getPagos()));
        lstPar.add(new Parametro(3, prestamo.getAhorros()));
        lstPar.add(new Parametro(4, prestamo.getCodigoPr()));  
        
              
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
    public int eliminar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM Prestamo  where CodigoPr=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getCodigoPr()));       
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
    public Prestamo obtener(int CodigoPr) throws Exception {
        Prestamo prestamo = null;
        String sql = "SELECT RegistroImporte, Pagos, Ahorros, CodigoPr"
                + " FROM Prestamo where CodigoPr=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodigoPr));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setRegistroImporte(rst.getString(1));
                prestamo.setPagos(rst.getDouble(2));
                prestamo.setAhorros(rst.getDouble(3));
                prestamo.setCodigoPr(rst.getInt(4));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return prestamo;
    }

    @Override
    public List<Prestamo> obtener() throws Exception {
        List<Prestamo> lista = new ArrayList<>();
         String sql = "SELECT RegistroImporte, Pagos, Ahorros, CodigoPr FROM Prestamo ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Prestamo prestamo=null;
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setRegistroImporte(rst.getString(1));
                prestamo.setPagos(rst.getDouble(2));
                prestamo.setAhorros(rst.getDouble(3));
                prestamo.setCodigoPr(rst.getInt(4));             
                lista.add(prestamo);
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
