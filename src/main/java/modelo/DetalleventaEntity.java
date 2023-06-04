package modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "detalleventa", schema = "public", catalog = "Minimarket")
public class DetalleventaEntity {
    private int id;
    private int codigoventa;
    private int cantidad;
    private String nombreprod;
    private double precio;
    private Collection<ProductoEntity> listaproducto;
    List<DetalleventaEntity> listadetalleventa = new ArrayList<>();
    public DetalleventaEntity() {
    }

    public DetalleventaEntity(int codigoventa, int cantidad, String nombreprod, double precio) {
        this.codigoventa = codigoventa;
        this.precio = precio;
        this.nombreprod = nombreprod;
        if(cantidad > 0){
            this.cantidad = cantidad;
        }else{
            this.cantidad = -cantidad;
        }
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
    @Column(name = "codigoventa")
    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "nombreprod")
    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    @Basic
    @Column(name = "precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @SuppressWarnings("JpaAttributeTypeInspection")
    public List<DetalleventaEntity> getListadetalleventa() {
        return listadetalleventa;
    }

    public void setListadetalleventa(List<DetalleventaEntity> listadetallesventa) {
        this.listadetalleventa = listadetallesventa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleventaEntity that = (DetalleventaEntity) o;

        if (id != that.id) return false;
        if (codigoventa != that.codigoventa) return false;
        if (cantidad != that.cantidad) return false;
        if (Double.compare(that.precio, precio) != 0) return false;
        if (nombreprod != null ? !nombreprod.equals(that.nombreprod) : that.nombreprod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + codigoventa;
        result = 31 * result + cantidad;
        result = 31 * result + (nombreprod != null ? nombreprod.hashCode() : 0);
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "detalleventaByNombre")
    public Collection<ProductoEntity> getListaproducto() {
        return listaproducto;
    }

    public void setListaproducto(Collection<ProductoEntity> listaproducto) {
        this.listaproducto = listaproducto;
    }

    public boolean verificarNombreProd(int codigoVenta, String nombreprod) {
        for (DetalleventaEntity dv : listadetalleventa) {
            String nombreproducto = dv.nombreprod;
            int codigo = dv.getCodigoventa();
            if (dv.getCodigoventa() == codigoVenta && dv.nombreprod.equalsIgnoreCase(nombreprod)) {
                return true;
            }
        }
        return false;
    }

    public List<DetalleventaEntity> verCarrito(int codigoventa){
        return null;
    }

}
