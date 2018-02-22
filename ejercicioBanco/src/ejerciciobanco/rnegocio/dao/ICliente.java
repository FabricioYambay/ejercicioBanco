package ejerciciobanco.rnegocio.dao;
import ejerciciobanco.rnegocio.entidades.*;
import java.util.*;
/**
 *
 * @author Jhon
 */
public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(String cedula) throws Exception;
    public List<Cliente> obtener() throws Exception; 
}
