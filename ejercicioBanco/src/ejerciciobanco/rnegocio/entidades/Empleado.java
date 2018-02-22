
package ejerciciobanco.rnegocio.entidades;

import java.util.Date;


public class Empleado {
    private int CodigoE;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Email;
    private Sucursal sucursal;

    public Empleado() {
    }

    public Empleado(int CodigoE, String Nombre, String Apellido, String Direccion, String Telefono, String Email, Sucursal sucursal) {
        this.CodigoE = CodigoE;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.sucursal = sucursal;
    }

    public int getCodigoE() {
        return CodigoE;
    }

    public void setCodigoE(int CodigoE) {
        this.CodigoE = CodigoE;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

  
    @Override
    public String toString(){
        return Nombre;
    }

    
}
