
package ejerciciobanco.rnegocio.implementacion;
import ejerciciobanco.accesodatos.Conexion;
import ejerciciobanco.accesodatos.Parametro;
import ejerciciobanco.rnegocio.dao.IInspector;
import ejerciciobanco.rnegocio.entidades.Inspector;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

public class InspectorImpl implements IInspector {

    @Override
    public int insertar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sqlC = "INSERT INTO Inspector (CodigoI, Nombre, Apellido, Direccion, Titulo) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, inspector.getCodigoI()));
        lisParametros.add(new Parametro(2, inspector.getNombre()));
        lisParametros.add(new Parametro(3, inspector.getApellido()));
        lisParametros.add(new Parametro(4, inspector.getDireccion()));
        lisParametros.add(new Parametro(5, inspector.getTitulo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            String sql = null;
            numFilasAfectadas = con.ejecutaComando(sql, lisParametros);
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
    public int modificar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE inspector"
                + "   SET CodigoI=?, Nombre=?, Apellido=?, direccion=?, Titulo=?"
                + " where idinspector=?";
        List<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, inspector.getCodigoI()));
        lisParametros.add(new Parametro(2, inspector.getNombre()));
        lisParametros.add(new Parametro(3, inspector.getApellido()));
        lisParametros.add(new Parametro(4, inspector.getDireccion()));
        lisParametros.add(new Parametro(5, inspector.getTitulo()));
        
   
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lisParametros);
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
    public int eliminar(Inspector inspector) throws Exception {
         int numFilasAfectadas = 0;
        String sqlC="DELETE FROM Inspector WHERE CodigoI=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, inspector.getCodigoI()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Inspector obtener(int CodigoI) throws Exception {
        Inspector inspector = null;
        String sql = "SELECT * FROM inspector where CodigoI=?;";
        List<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, CodigoI));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lisParametros);
            while (rst.next()) {
                inspector = new Inspector();
                inspector.setCodigoI(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setApellido(rst.getString(3));
                inspector.setDireccion(rst.getString(4));
                inspector.setTitulo(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return inspector;
    }

    @Override
    public ArrayList<Inspector> obtener() throws Exception {
         List<Inspector> lista = new ArrayList<>();
         String sql = "SELECT *   FROM inspector ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Inspector inspector=null;
            while (rst.next()) {
                inspector=new Inspector();
                inspector.setCodigoI(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setApellido(rst.getString(3));
                inspector.setDireccion(rst.getString(4));
                inspector.setTitulo(rst.getString(5));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return (ArrayList<Inspector>) lista;
    }
    
    
    
}
