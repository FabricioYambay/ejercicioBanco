/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Gilda
 */
public class Pago {
    private int CodigoPa;
    private Date Fecha;
    private Double  Valor; 
    private Prestamo prestamo; 

    public Pago(int CodigoPa, Date Fecha, Double Valor, Prestamo prestamo) {
        this.CodigoPa = CodigoPa;
        this.Fecha = Fecha;
        this.Valor = Valor;
        this.prestamo = prestamo;
    }

    public Pago() {
        
    }

    public int getCodigoPa() {
        return CodigoPa;
    }

    public void setCodigoPa(int CodigoPa) {
        this.CodigoPa = CodigoPa;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Object getRegistroImporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
