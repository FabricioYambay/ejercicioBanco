package ejerciciobanco.rnegocio.implementacion;
import java.sql.*;
import java.util.*;
import ejerciciobanco.accesodatos.*;
import ejerciciobanco.rnegocio.dao.*;
import ejerciciobanco.rnegocio.entidades.*;

/**
 *
 * @author Jhon
 */
public class ClienteImpl implements ICliente{

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int nFilas = 0;
        String sql = "INSERT INTO Cliente (Cedula, Nombre, Apellido, Telefono, Email) VALUES (?, ?, ?, ?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, cliente.getCedula()));
        listParametro.add(new Parametro(2, cliente.getNombre()));
        listParametro.add(new Parametro(3, cliente.getApellido()));
        listParametro.add(new Parametro(4, cliente.getTelefono()));
        listParametro.add(new Parametro(5, cliente.getEmail()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            nFilas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return nFilas;
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        int nFilas = 0;
        String sql = "UPDATE Cliente SET Cedula=?, Nombre=?, Apellido=?, Telefono=?, Email=? WHERE Cedula=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, cliente.getCedula()));
        listParametro.add(new Parametro(2, cliente.getNombre()));
        listParametro.add(new Parametro(3, cliente.getApellido()));
        listParametro.add(new Parametro(4, cliente.getTelefono()));
        listParametro.add(new Parametro(5, cliente.getEmail()));
        listParametro.add(new Parametro(6, cliente.getCedula()));
        Conexion conec=null;
        try {
            conec = new Conexion();
            conec.conectar();
            nFilas=conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec !=null){
            conec.desconectar();}
        }
        return nFilas;
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        int nFilas = 0;
        String sql = "DELETE FROM Cliente WHERE Cedula=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, cliente.getCedula()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            nFilas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return nFilas;
    }

    @Override
    public Cliente obtener(String cedula) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT Cedula, Nombre, Apellido, Telefono, Email FROM Cliente where Cedula = ?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, cedula));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, listadoParametros);
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setCedula(resultado.getString(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellido(resultado.getString(3));
                cliente.setTelefono(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT Cedula, Nombre, Apellido, Telefono, Email FROM Cliente";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setCedula(resultado.getString(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellido(resultado.getString(3));
                cliente.setTelefono(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return lista;
    }
    
}
