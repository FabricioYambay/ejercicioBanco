
package ejerciciobanco.rnegocio.implementacion;
import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;
import java.util.*;
import java.sql.*;

public  class InspectorImpl implements IInspector {
       @Override
    public int insertar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into inspector  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodigoI()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(3, inspector.getApellido()));
        lstPar.add(new Parametro(4, inspector.getDireccion()));
        lstPar.add(new Parametro(5, inspector.getTitulo()));
   
  
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
    
    public int modificar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        
        String sql = "UPDATE inspector"
                + "   SET Nombre=?, Apellido=?, Direccion=?, Titulo=?"
                + " where CodigoI=?";
                List<Parametro> lstPar = new ArrayList<>();
                 lstPar.add(new Parametro(5, inspector.getCodigoI()));
        lstPar.add(new Parametro(1, inspector.getNombre()));
        lstPar.add(new Parametro(2, inspector.getApellido()));
        lstPar.add(new Parametro(3, inspector.getDireccion()));
        lstPar.add(new Parametro(4, inspector.getTitulo()));
       
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
    public int eliminar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM inspector  where CodigoI=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodigoI()));       
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
    public Inspector obtener(int CodigoI) throws Exception {
        Inspector inspector = null;
        String sql = "SELECT * FROM inspector where CodigoI=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodigoI));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
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
    public Inspector obtener_x_nombre(String Nombre) throws Exception {
        Inspector inspector = null;
        String sql = "SELECT * FROM inspector where Nombre =?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, Nombre));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
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
                lista.add(inspector);
           
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

