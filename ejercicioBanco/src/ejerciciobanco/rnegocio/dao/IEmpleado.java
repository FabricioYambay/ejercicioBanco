
package ejerciciobanco.rnegocio.dao;

import ejerciciobanco.rnegocio.entidades.Empleado;
import java.util.List;

public interface IEmpleado {
    public int insertar(Empleado empleado) throws Exception;
    public int modificar(Empleado empleado) throws Exception;
    public int eliminar(Empleado empleado) throws Exception;
    public Empleado obtener(int CodigoE) throws Exception;
    public List<Empleado> obtener() throws Exception; 
    
}
