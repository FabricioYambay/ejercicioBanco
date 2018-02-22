/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

/**
 *
 * @author CRISTIAN
 */
public class Sucursal {
    int codigoS;
    String ciudad;
    String direccion;
    Cuenta cuenta;
    Empleado empleado;
    Prestamo prestamo;

    public Sucursal() {
    }

    public Sucursal(int codigoS, String ciudad, String direccion, Cuenta cuenta, Empleado empleado, Prestamo prestamo) {
        this.codigoS = codigoS;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cuenta = cuenta;
        this.empleado = empleado;
        this.prestamo = prestamo;
    }

    public int getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(int codigoS) {
        this.codigoS = codigoS;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    
}
