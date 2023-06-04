package modelo;

import controller.DetalleVentaController;
import controller.VentaController;

import java.util.ArrayList;
import java.util.List;

public class Informe {
    public List<Double> porcentajeVentaProductos = new ArrayList<>();
    public List<DetalleventaEntity> productosDisponibles = new ArrayList<>();
    public List<VentaEntity> ventas = new ArrayList<>();
    public DetalleventaEntity detalleVenta = new DetalleventaEntity();
    public double totalVendido;
    private DetalleVentaController dc = new DetalleVentaController();
    private VentaController vc = new VentaController();

    public List<Double> getPorcentajeVentaProductos() {
        return porcentajeVentaProductos;
    }

    public void setPorcentajeVentaProductos(List<Double> porcentajeVentaProductos) {
        this.porcentajeVentaProductos = porcentajeVentaProductos;
    }

    public List<DetalleventaEntity> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void setProductosDisponibles(List<DetalleventaEntity> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    public List<VentaEntity> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public DetalleventaEntity getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleventaEntity detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public Informe(List<VentaEntity> ventas, List<DetalleventaEntity> detalles){
        this.ventas = ventas;
        for(DetalleventaEntity d : detalles){
            this.productosDisponibles.add(d);
        }
    }

    private void almacenarDetallesVenta(){
        List<DetalleventaEntity> totalProductos = new ArrayList();

        for(VentaEntity v : ventas){
            for(DetalleventaEntity dv : productosDisponibles ){
                if(v.getId() == dv.getCodigoventa()) {
                    totalProductos.add(dv);
                }
            }
        }
        actualizarCantidad(totalProductos);
    }

    private void actualizarCantidad(List<DetalleventaEntity> totalProductos) {
        for(int i = 0; i < productosDisponibles.size(); i++){
            for(int j = 0; j < totalProductos.size(); j++){
                String nombreProdVenta = productosDisponibles.get(i).getNombreprod();
                String nombreProd = totalProductos.get(j).getNombreprod();
                if(nombreProdVenta.equalsIgnoreCase(nombreProd)){
                    productosDisponibles.get(i).setCantidad(productosDisponibles.get(i).getCantidad() +
                            totalProductos.get(j).getCantidad());
                }
            }
        }
    }

    public void calcularPorcentajesVenta(){
        almacenarDetallesVenta();
        int counter = 0;
        double total = 0.0;
        for(DetalleventaEntity dv : productosDisponibles){
            total = dv.getPrecio() * dv.getCantidad();
            porcentajeVentaProductos.add(total);
        }
        for(VentaEntity v : ventas){
            totalVendido += v.getTotal();
        }
        //Guadar los porcentajes calculados
        guardarPorcentajes();
    }

    private void guardarPorcentajes() {
        for(int i = 0; i < porcentajeVentaProductos.size(); i++){
            porcentajeVentaProductos.set(i, porcentajeVentaProductos.get(i) / totalVendido * 100);
        }
    }

}
