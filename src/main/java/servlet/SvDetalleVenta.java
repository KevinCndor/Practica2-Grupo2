package servlet;


import controller.DetalleVentaController;
import controller.ProductosController;
import controller.VentaController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DetalleventaEntity;
import modelo.ProductoEntity;
import modelo.VentaEntity;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvDetalleVenta", value = "/SvDetalleVenta")
public class SvDetalleVenta extends HttpServlet {
    VentaController vc = new VentaController();
    ProductosController pc = new ProductosController();
    DetalleVentaController dc;
    DetalleventaEntity dv = new DetalleventaEntity();
    List<DetalleventaEntity> listaDetalles;
    private double total = 0.0;

    public SvDetalleVenta() {
        dc = new DetalleVentaController();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DetalleventaEntity> listaDetalleVenta = new ArrayList<>();
        listaDetalleVenta = dc.listarDetalleVenta();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaDetalleVenta", listaDetalleVenta);

        List<ProductoEntity> listaProductos = new ArrayList<>();
        listaProductos = pc.listarProductos();

        misesion.setAttribute("listaProductos", listaProductos);

        String cicliente = request.getParameter("cedula");

        if(cicliente != ""){
            VentaEntity venta = new VentaEntity();
            String cedula = request.getParameter("cedula");
            Date fechaActual = new Date();
            // Formatear la fecha en el formato "yyyy-MM-dd"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = sdf.format(fechaActual);
            venta.setCicliente(cedula);
            venta.setFecha(java.sql.Date.valueOf(fechaFormateada));
            venta.setTotal(total);
            boolean aux = vc.createVenta(venta);
            response.sendRedirect("comprobante.jsp");
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double precio = 0.0;
        List<ProductoEntity> listaProductos = (List) request.getSession().getAttribute("listaProductos");
        if (listaProductos != null) {
            for (ProductoEntity producto : listaProductos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    precio = producto.getPrecio();
                    total += precio * cantidad;
                }
            }
        }
        int codeVent = vc.readLastVenta().getId()+1;
        dv.verificarNombreProd(codeVent,nombre);
        dv.setCodigoventa(codeVent);
        dv.setCantidad(cantidad);
        dv.setNombreprod(nombre);
        dv.setPrecio(precio);
        dc.createDetalleVenta(dv);
        dv.setListadetalleventa(dc.listarDetalleVenta());
        response.sendRedirect("venta.jsp");
    }
}
