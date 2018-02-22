/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

/**
 *
 * @author eddyf
 */
public class Pedido {
    
    private int CodigoP;
    private String Resultado;
    private Cuenta cuenta;
   private Inspector inspector;
    private Prestamo prestamo;

    public Pedido() {
    }

    public Pedido(int CodigoP, String Resultado, Cuenta cuenta, Inspector inspector, Prestamo prestamo) {
        this.CodigoP = CodigoP;
        this.Resultado = Resultado;
        this.cuenta = cuenta;
        this.inspector = inspector;
        this.prestamo = prestamo;
    }

    public int getCodigoP() {
        return CodigoP;
    }

    public String getResultado() {
        return Resultado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setCodigoP(int CodigoP) {
        this.CodigoP = CodigoP;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    
    
}
