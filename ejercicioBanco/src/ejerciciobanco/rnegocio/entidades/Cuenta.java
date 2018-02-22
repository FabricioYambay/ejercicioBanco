
package ejerciciobanco.rnegocio.entidades;


public class Cuenta {
    private Cliente cliente;
    private Sucursal sucursal;
    private Prestamo prestamo;
    private String numerocuenta;
    private  String tipocuenta;
    private double saldo;
    private double movimiento;

    public Cuenta() {
    }

    public Cuenta(Cliente cliente, Sucursal sucursal, Prestamo prestamo, String numerocuenta, String tipocuenta, double saldo, double movimiento) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.prestamo = prestamo;
        this.numerocuenta = numerocuenta;
        this.tipocuenta = tipocuenta;
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

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
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
