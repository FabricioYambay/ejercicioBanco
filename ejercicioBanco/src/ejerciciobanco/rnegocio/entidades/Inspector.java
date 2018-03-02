/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

/**
 *
 * @author Gilda
 */
public class Inspector {
    private int CodigoI; 
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Titulo;

    public Inspector(int CodigoI, String Nombre, String Apellido, String Direccion, String Titulo) {
        this.CodigoI = CodigoI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Titulo = Titulo;
    }

    public Inspector() {
    
    }


    public int getCodigoI() {
        return CodigoI;
    }

    public void setCodigoI(int CodigoI) {
        this.CodigoI = CodigoI;
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

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    
 

}