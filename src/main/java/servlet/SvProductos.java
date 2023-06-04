package servlet;

import controller.ProductosController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.ProductoEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "SvProductos", value = "/SvProductos")
public class SvProductos extends HttpServlet {

    ProductosController pc = new ProductosController();
    List<ProductoEntity> listaProductos = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listaProductos = pc.listarProductos();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaProductos",listaProductos);

        response.sendRedirect("inventario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoEntity producto = new ProductoEntity();
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String distribuidor = request.getParameter("distribuidor");
        int unidades = Integer.parseInt(request.getParameter("unidades"));

        if(distribuidor != ""){
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setDistribuidor(distribuidor);
            producto.setUnidades(unidades);
            producto.setPrecio(precio);
            pc.createProducto(producto);
            response.sendRedirect("inventario.jsp");
        } else {
            producto.setListaProductos(pc.listarProductos());
            producto.actualizarNombreProducto(codigo, nombre);
            response.sendRedirect("inventario.jsp");
        }

    }

}