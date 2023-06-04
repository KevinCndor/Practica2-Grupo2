<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 1/6/2023
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="modelo.ProductoEntity"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventario</title>
</head>
<body>
<h2 style="text-align: center;">Lista de Productos</h2>
<table style="margin: auto;">
  <thead>
  <tr>
    <b><th style="margin:auto" ;>Código</th></b>
    <b><th style="margin:auto" ;>Nombre</th></b>
    <b><th style="margin:auto" ;>Precio</th></b>
    <b><th style="margin:auto" ;>Distribuidor</th></b>
    <b><th style="margin:auto" ;>Unidades</th></b>
  </tr>
  </thead>
  <tbody>
  <%
    List<ProductoEntity> listaProductos = (List) request.getSession().getAttribute("listaProductos");
    if (listaProductos != null){
      for (ProductoEntity producto : listaProductos) {
        String codigo = producto.getCodigo();
        String nombre = producto.getNombre();
        double precio =  producto.getPrecio();
        String distribuidor = producto.getDistribuidor();
        int unidades = producto.getUnidades();

        out.println("<tr>");
        out.println("<td style=\"text-align: center;\">" + codigo + "</td>");
        out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
        out.println("<td style=\"text-align: center;\">" + precio + "</td>");
        out.println("<td style=\"text-align: center;\">" + distribuidor + "</td>");
        out.println("<td style=\"text-align: center;\">" + unidades + "</td>");
        out.println("</tr>");
      }
    }
  %>
  </tbody>
</table>
<form action="SvProductos" method="GET">
  <div align="center">
    <br><button type="submit">Actualizar</button>
  </div>
</form>
<br>
<br>
<h2>Registro Nuevo Producto</h2>
<form action="SvProductos" method="POST">
  <label for="codigo">Código:</label>
  <input type="text" id="codigo" name="codigo" required><br><br>

  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required><br><br>

  <label for="precio">Precio:</label>
  <input type="number" id="precio" name="precio" step="0.01" required><br><br>

  <label for="distribuidor">Distribuidor:</label>
  <input type="text" id="distribuidor" name="distribuidor" required><br><br>

  <label for="unidades">Unidades:</label>
  <input type="number" id="unidades" name="unidades" required><br><br>
  <div class="center">
    <button type="submit">Registrar</button>
  </div>
</form>
<form action="index.jsp" method="GET">
  <div align="right">
    <button type="submit">Volver</button>
  </div>
</form>
</body>
</html>
