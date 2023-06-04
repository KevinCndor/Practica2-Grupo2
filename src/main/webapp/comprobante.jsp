<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 1/6/2023
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comprobante</title>
</head>
<body>
  <%
    String cedula = (String) request.getParameter("cedula");
  %>
  <h3 style="text-align: center;">Comprobante</h3>
  <p style="text-align: center;">.----------------------------------------------------------------------</p>
  <p style="text-align: center;">Cedula: <%=cedula%></p>
  <table style="margin: auto;">
    <thead>
    <tr>
      <b><th style="text-align: center;">Nombre</th></b>
      <b><th style="text-align: center;">Precio</th></b>
      <b><th style="text-align: center;">Cantidad</th></b>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td style="text-align: center;">Chocolate  </td>
      <td style="text-align: center;">1.00  </td>
      <td style="text-align: center;">2  </td>

    </tr>
    <tr>
      <td style="text-align: center;">Papas  </td>
      <td style="text-align: center;">0.60  </td>
      <td style="text-align: center;">2  </td>

    </tr>
    <tr>
      <td style="text-align: center;">CocaCola  </td>
      <td style="text-align: center;">1.25  </td>
      <td style="text-align: center;">1  </td>

    </tr>
    <%--
    <%
    SvDetalleVenta svdv = new SvDetalleVenta();
    double total = 0.0;
    List<DetalleVenta> listaDetalleVenta = {};
    if(listaDetalleVenta != null) {
        for (DetalleVenta detalleVenta : listaDetalleVenta) {
            String nombre = detalleVenta.getNombre();
            double precio = detalleVenta.getPrecio();
            int cantidad = detalleVenta.getCantidad();
            out.println("<tr>");
            out.println("<td style=\"text-align: center;\">" + nombre + "</td>");
            out.println("<td style=\"text-align: center;\">" + precio + "</td>");
            out.println("<td style=\"text-align: center;\">" + cantidad + "</td>");
            out.println("</tr>");
            total += precio * cantidad;
       }
    }
    %>
    --%>
    </tbody>
  </table>
  <p style="text-align: center;">Total: $3.45</p>
  <!--<p style="text-align: center;">$<%--=total--%></p>-->
  <p style="text-align: center;" >.----------------------------------------------------------------------</p>
</body>
</html>
