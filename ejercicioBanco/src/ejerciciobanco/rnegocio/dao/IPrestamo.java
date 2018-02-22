
package ejerciciobanco.rnegocio.dao;


import ejerciciobanco.rnegocio.entidades.Prestamo;
import java.util.List;


public interface IPrestamo {
    public int insertar(Prestamo prestamo) throws Exception;
    public int modificar(Prestamo prestamo) throws Exception;
    public int eliminar(Prestamo prestamo) throws Exception;
    public Prestamo obtener(int CodigoPr) throws Exception;
    public List<Prestamo> obtener() throws Exception; 
    
}
