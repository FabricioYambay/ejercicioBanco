
package ejerciciobanco.rnegocio.entidades;

 
public class Cuenta {
    private Cliente cliente;
    private Sucursal sucursal;
    private String numerocuenta;
    private double saldo;
    private double movimiento;

    public Cuenta() {
    }

    public Cuenta(Cliente cliente, Sucursal sucursal, String numerocuenta, double saldo, double movimiento) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
        this.movimiento = movimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(double movimiento) {
        this.movimiento = movimiento;
    }

   
    

    
    
}
