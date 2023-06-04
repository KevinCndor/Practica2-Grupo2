package modelo;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "venta", schema = "public", catalog = "Minimarket")
public class VentaEntity {
    private int id;
    private String cicliente;
    private Date fecha;
    private double total;

    public VentaEntity() {
    }

    public VentaEntity(String cicliente, Date fecha, double total) {
        this.cicliente = cicliente;
        this.fecha = fecha;
        this.total = total;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cicliente")
    public String getCicliente() {
        return cicliente;
    }

    public void setCicliente(String cicliente) {
        this.cicliente = cicliente;
    }

    @Basic
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "total")
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentaEntity that = (VentaEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.total, total) != 0) return false;
        if (cicliente != null ? !cicliente.equals(that.cicliente) : that.cicliente != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (cicliente != null ? cicliente.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean verificarCedula(String cedula){
        if(!cedula.matches("\\d{10}$")){
            return false;
        }
        return true;
    }

    public boolean esCedulaEcuatoriana(String cedula){
        int numero;
        int suma = 0;
        int resultado = 0;
        suma = getSuma(cedula, suma);
        if (suma%10 != 0){
            resultado = 10 - (suma%10);
            if (resultado == cedula.charAt(9)){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    private static int getSuma(String cedula, int suma) {
        int numero;
        for (int i = 0; i < cedula.length(); i++){
            numero = Integer.parseInt(String.valueOf(cedula.charAt(i)));
            if (i%2 == 0){
                numero = numero * 2;
                if (numero > 9){
                    numero = numero - 9;
                }
            }
            suma = suma + numero;
        }
        return suma;
    }

}
