
package ejerciciobanco.rnegocio.entidades;

import java.util.Date;


public class Empleado {
    private int CodigoE;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String CodigoS;

    public Empleado() {
    }

    public Empleado(int CodigoE, String Nombre, String Apellido, String Direccion, String Telefono, String Email, String CodigoS) {
        this.CodigoE = CodigoE;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.CodigoS = CodigoS;
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

    public String getCodigoS() {
        return CodigoS;
    }

    public void setCodigoS(String CodigoS) {
        this.CodigoS = CodigoS;
    }
    
    @Override
    public String toString(){
        return Nombre;
    }

    
}
