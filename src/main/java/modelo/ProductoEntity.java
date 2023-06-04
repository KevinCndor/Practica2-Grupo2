package modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto", schema = "public", catalog = "Minimarket")
public class ProductoEntity {
    private int id;
    private String codigo;
    private String distribuidor;
    private String nombre;
    private double precio;
    private int unidades;
    private List<ProductoEntity> listaProductos = new ArrayList<>();

    public ProductoEntity() {
    }

    public ProductoEntity(String codigo, String distribuidor, String nombre, double precio, int unidades) {
        this.codigo = codigo;
        this.distribuidor = distribuidor;
        this.nombre = nombre;
        verificarPositivos(precio, unidades);
        listaProductos.add(this);
    }

    private void verificarPositivos(double precio, int unidades) {
        if(precio > 0 && unidades > 0){
            this.precio = precio;
            this.unidades = unidades;
        }else{
            this.precio = -precio;
            this.unidades = -unidades;
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
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "distribuidor")
    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "unidades")
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @SuppressWarnings("JpaAttributeTypeInspection")
    public List<ProductoEntity> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoEntity> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.precio, precio) != 0) return false;
        if (unidades != that.unidades) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (distribuidor != null ? !distribuidor.equals(that.distribuidor) : that.distribuidor != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (distribuidor != null ? distribuidor.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + unidades;
        return result;
    }

    public void actualizarNombreProducto(String codigo, String nombre){
        for(ProductoEntity p : listaProductos){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                this.nombre = nombre;
            }else{
                System.out.println("Error al actualizar los nombres de los productos");
            }
        }
    }

    public void actualizarPrecioProducto(String codigo, double precio){
        for(ProductoEntity p : listaProductos){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                this.precio = precio;
            }
        }
    }

}
