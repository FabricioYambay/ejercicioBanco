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
    private int codigoS;
    private String ciudad;
    private String direccion;
    private Prestamo prestamo;

    public Sucursal() {
    }

    public Sucursal(int codigoS, String ciudad, String direccion, Prestamo prestamo) {
        this.codigoS = codigoS;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.prestamo = prestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
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

    @Override
    public String toString() {
        return ciudad;
    }
    
}
