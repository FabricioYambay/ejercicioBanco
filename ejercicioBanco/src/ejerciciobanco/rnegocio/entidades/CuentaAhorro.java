package ejerciciobanco.rnegocio.entidades;

public class CuentaAhorro {
    private String codigoca;
    private double interes;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String codigoca, double interes) {
        this.codigoca = codigoca;
        this.interes = interes;
    }

    public String getCodigoca() {
        return codigoca;
    }

    public void setCodigoca(String codigoca) {
        this.codigoca = codigoca;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    


  

}
