
package ejerciciobanco.rnegocio.entidades;

public class Cuenta {
    
    private int numerocuenta;
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(int numerocuenta, int saldo) {
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
