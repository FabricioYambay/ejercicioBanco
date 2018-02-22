
package ejerciciobanco.rnegocio.entidades;

public class Prestamo {
    private String RegistroImporte;
    private double Pagos;
    private double Ahorros;
    private int CodigoPr;

    public Prestamo() {
    }

    public Prestamo(String RegistroImporte, double Pagos, double Ahorros, int CodigoPr) {
        this.RegistroImporte = RegistroImporte;
        this.Pagos = Pagos;
        this.Ahorros = Ahorros;
        this.CodigoPr = CodigoPr;
    }

    public String getRegistroImporte() {
        return RegistroImporte;
    }

    public void setRegistroImporte(String RegistroImporte) {
        this.RegistroImporte = RegistroImporte;
    }

    public double getPagos() {
        return Pagos;
    }

    public void setPagos(double Pagos) {
        this.Pagos = Pagos;
    }

    public double getAhorros() {
        return Ahorros;
    }

    public void setAhorros(double Ahorros) {
        this.Ahorros = Ahorros;
    }

    public int getCodigoPr() {
        return CodigoPr;
    }

    public void setCodigoPr(int CodigoPr) {
        this.CodigoPr = CodigoPr;
    }

     @Override
    public String toString() {
        return RegistroImporte; 
    }
}
