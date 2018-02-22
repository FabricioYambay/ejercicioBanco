/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobanco.rnegocio.entidades;

public class CuentaAhorro {
    private int codigoca;
    private double interes;

    public CuentaAhorro(int codigoca, double interes) {
        this.codigoca = codigoca;
        this.interes = interes;
    }

    public CuentaAhorro() {
    }

    public int getCodigoca() {
        return codigoca;
    }

    public void setCodigoca(int codigoca) {
        this.codigoca = codigoca;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
}
