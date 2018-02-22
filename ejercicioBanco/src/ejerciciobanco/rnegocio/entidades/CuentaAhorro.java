package ejerciciobanco.rnegocio.entidades;

public class CuentaAhorro {
    private int codigoca;
    private double interes;
    private Cuenta cuenta;

    public CuentaAhorro(int codigoca, double interes, Cuenta cuenta) {
        this.codigoca = codigoca;
        this.interes = interes;
        this.cuenta = cuenta;
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    

}
