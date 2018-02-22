
package ejerciciobanco.rnegocio.entidades;

public class Prestamo {
    private String RegistroImporte;
    private String Pagos;
    private String Ahorros;
    private int CodigoPr;

    public Prestamo() {
    }

    public Prestamo(String RegistroImporte, String Pagos, String Ahorros, int CodigoPr) {
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

    public String getPagos() {
        return Pagos;
    }

    public void setPagos(String Pagos) {
        this.Pagos = Pagos;
    }

    public String getAhorros() {
        return Ahorros;
    }

    public void setAhorros(String Ahorros) {
        this.Ahorros = Ahorros;
    }

    public int getCodigoPr() {
        return CodigoPr;
    }

    public void setCodigoPr(int CodigoPr) {
        this.CodigoPr = CodigoPr;
    }
   
    @Override
    public String toString(){
        return Ahorros;
    }
}
