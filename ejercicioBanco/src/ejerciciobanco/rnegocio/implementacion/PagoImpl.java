
package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.IPago;
import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Pago;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PagoImpl implements IPago {

    @Override
    public int insertar(Pago pago) throws Exception {
    int numFilasAfectadas = 0;
        String sql = "insert into Pago  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCodigoPa()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getPrestamo().getRegistroImporte()));
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
    public int modificar(Pago pago) throws Exception {
       int numFilasAfectadas = 0;
        String sql = "UPDATE Pago"
                + "   SET codigoPa=?, Fecha=?, Valor=?, RegistroImporte=?"
                + " where CodigoPa=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCodigoPa()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getRegistroImporte()));
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
    public int eliminar(Pago pago) throws Exception {
     int numFilasAfectadas = 0;
         String sql = "DELETE FROM Pago  where RegistroImporte=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCodigoPa()));       
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
    public Pago obtener(int CodigoPa) throws Exception {
     Pago pago = null;
        String sql = "SELECT CodigoPa, Fecha, Valor, RegistroImporte  FROM Pago where CodigoPa=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodigoPa));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                pago = new Pago();
                pago.setCodigoPa(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setValor(rst.getDouble(3));
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(4));
                pago.setPrestamo(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return pago;
    }

    @Override
    public ArrayList<Pago> obtener() throws Exception {
    List<Pago> lista = new ArrayList<>();
         String sql = "SELECT CodigoPa, Fecha, Valor, RegistroImporte  FROM pago ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Pago pago=null;
            while (rst.next()) {
                pago = new Pago();
                pago.setCodigoPa(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setValor(rst.getDouble(3));
               IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(4));
                pago.setPrestamo(prestamo);
                lista.add(pago);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return (ArrayList<Pago>) lista;
    }    
    
}
