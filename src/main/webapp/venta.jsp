<%@ page import="modelo.ProductoEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.ProductoEntity" %><%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 1/6/2023
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Venta</title>
</head>
<body>
    <h2 style="text-align: center;">Lista de Productos</h2>
    <table style="margin: auto;">
        <thead>
            <tr>
                <b><th style="margin:auto" ;>Nombre</th></b>
                <b><th style="margin:auto" ;>Precio</th></b>
                <b><th style="margin:auto" ;>Unidades</th></b>
            </tr>
        </thead>
        <tbody>
        <%
            List<ProductoEntity> listaProductos = (List) request.getSession().getAttribute("listaProductos");
            if(listaProductos != null){
                for (ProductoEntity producto : listaProductos) {
                    String nombre = producto.getNombre();
                    double precio = producto.getPrecio();
                    int unidades = producto.getUnidades();

                    out.println("<tr>");
                    out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
                    out.println("<td style=\"text-align: center;\">" + precio + "</td>");
                    out.println("<td style=\"text-align: center;\">" + unidades + "</td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>
    <br>
    <br>
    <h2>Agregar Producto</h2>
    <form action="SvDetalleVenta" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="cantidad">Cantidad:</label>
        <input type="text" id="cantidad" name="cantidad" required><br><br>
        <div align="center">
            <button type="submit">Agregar Producto</button>
        </div>
    </form>
    <br>
    <form action="SvDetalleVenta" method="GET">
        <label for="cedula">Cedula:</label>
        <input type="text" id="cedula" name="cedula" required><br><br>
        <div class="left">
            <br><button type="submit">Finalizar Venta</button>
        </div>
    </form>
</body>
</html>
