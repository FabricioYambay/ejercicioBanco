
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
        String sql = "insert into pago  values "
                + "(?,?,?,?)";
 
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCodigoPa()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getPrestamo().getCodigoPr()));
  
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
        String sql = "UPDATE pago"
                + "  SET CodigoPa=?, Fecha=?, Valor=?, CodigoPr=?"
                + " where idpago=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(4, pago.getCodigoPa()));
        lstPar.add(new Parametro(1, pago.getFecha()));
        lstPar.add(new Parametro(2, pago.getValor()));
        lstPar.add(new Parametro(3, pago.getPrestamo().getCodigoPr()));
   
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
         String sql = "DELETE FROM pago  where CodigoPa=?";
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
    public Pago obtener(int idpago) throws Exception {
        Pago pago = null;
        String sql = "SELECT * FROM pago where CodigoPa=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idpago));
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
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(rst.getInt(4));
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
    
    public List<Pago> obtener() throws Exception {
        List<Pago> lista = new ArrayList<>();
         String sql = "SELECT *   FROM pago ";        
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
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(rst.getInt(4));
                pago.setPrestamo(prestamo);

                lista.add(pago);
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