/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Wen
 */
public class Pago {
    private int codigopa;
    private Date fecha;
    private double valor;
    private Prestamo prestamo;

    public Pago() {
    }

    public Pago(int codigopa, Date fecha, double valor, Prestamo prestamo) {
        this.codigopa = codigopa;
        this.fecha = fecha;
        this.valor = valor;
        this.prestamo = prestamo;
    }

    public int getCodigopa() {
        return codigopa;
    }

    public void setCodigopa(int codigopa) {
        this.codigopa = codigopa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
