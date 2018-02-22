/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CuentaCredito {
    
    private int codigocc ;
    private double Valorsobregiro;
    private Cuenta cuenta;

    public CuentaCredito() {
    }

    public CuentaCredito(int codigocc, double Valorsobregiro, Cuenta cuenta) {
        this.codigocc = codigocc;
        this.Valorsobregiro = Valorsobregiro;
        this.cuenta = cuenta;
    }

    public int getCodigocc() {
        return codigocc;
    }

    public void setCodigocc(int codigocc) {
        this.codigocc = codigocc;
    }

    public double getValorsobregiro() {
        return Valorsobregiro;
    }

    public void setValorsobregiro(double Valorsobregiro) {
        this.Valorsobregiro = Valorsobregiro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    
}
