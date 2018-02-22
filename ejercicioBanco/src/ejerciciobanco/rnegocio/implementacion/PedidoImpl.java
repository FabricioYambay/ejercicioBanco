package ejerciciobanco.rnegocio.implementacion;

import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.ICliente;
import ejerciciobanco.rnegocio.dao.IInspector;
import ejerciciobanco.rnegocio.dao.IPedido;
import ejerciciobanco.rnegocio.dao.IPrestamo;
import ejerciciobanco.rnegocio.entidades.Cliente;
import ejerciciobanco.rnegocio.entidades.Inspector;
import ejerciciobanco.rnegocio.entidades.Pedido;
import ejerciciobanco.rnegocio.entidades.Prestamo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ejerciciobanco.rnegocio.implementacion.PedidoImpl;

/**
 *
 * @author eddyf
 */
public class PedidoImpl implements IPedido {

    public int insertar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Pedido  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getCodigoP()));
        lstPar.add(new Parametro(2, pedido.getResultado()));
        lstPar.add(new Parametro(3, pedido.getCliente().getNombre()));
        lstPar.add(new Parametro(4, pedido.getPrestamo().getCodigoPr()));
        lstPar.add(new Parametro(5, pedido.getInspector().getCodigoI()));

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
    public int modificar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE pedido"
                + "   SET codigoP=?, Resultado=?, CodigoC=?, CodigoPr=?,codigoI=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getCodigoP()));
        lstPar.add(new Parametro(2, pedido.getResultado()));
        lstPar.add(new Parametro(3, pedido.getCliente().getNombre()));
        lstPar.add(new Parametro(4, pedido.getPrestamo().getCodigoPr()));
        lstPar.add(new Parametro(5, pedido.getInspector().getCodigoI()));

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
    public int eliminar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM pedido  where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getCodigoP()));
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
    public Pedido obtener(int codigoP) throws Exception {
        Prestamo prestamo = null;
        IPrestamo prestamoDao = new PrestamoImpl();
        Pedido pedido = null;
        IPedido pedidoDao=new PedidoImpl();
        Inspector inspector = null;
        IInspector inspectorDao = new InspectorImpl();
        Cliente cliente = null;
        ICliente clienteDao = new ClienteImpl();

        
        String sql = "SELECT * FROM pedido where codigoP=?;";
        List<Parametro> lstPar = new ArrayList<>();
       
        lstPar.add(new Parametro(1, codigoP));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                pedido = new Pedido();
                pedido = pedidoDao.obtener(rst.getInt(3));
                prestamo = new Prestamo();
                prestamo = prestamoDao.obtener(rst.getInt(5));
                inspector = new Inspector();
                inspector = inspectorDao.obtener(rst.getInt(4));
               
                pedido.setCodigoP(rst.getInt(1));
                pedido.setResultado(rst.getString(2));

                pedido.setCliente(cliente);

                pedido.setPrestamo(prestamo);
                pedido.setInspector(inspector);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return pedido;
    }

    @Override
    public List<Pedido> obtener() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        Cliente cliente = null;
        Prestamo prestamo = null;
        IPrestamo prestamoDao = new PrestamoImpl();
        Inspector inspector = null;
        IInspector inspectorDao = new InspectorImpl();
        ICliente clienteDao = new ClienteImpl();
        Pedido pedido=null;
        IPedido pedDao=new PedidoImpl();
        String sql = "SELECT * FROM Pedido ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()) {
                cliente = new Cliente();
                pedido = new Pedido();
                
                pedido.setCodigoP(rst.getInt(1));
                pedido.setResultado(rst.getString(2));
                pedido.setCliente(cliente);
                pedido.setInspector(inspector);
                pedido.setPrestamo(prestamo);

                lista.add(pedido);
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
