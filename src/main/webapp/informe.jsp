<%@ page import="modelo.ProductoEntity" %>
<%@ page import="modelo.VentaEntity" %>
<%@ page import="modelo.Informe" %>
<%@ page import="controller.VentaController" %>
<%@ page import="controller.ProductosController" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.DetalleVentaController" %>
<%@ page import="modelo.DetalleventaEntity" %>
<%@ page import="java.text.DecimalFormat"%>
<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 1/6/2023
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informe</title>
</head>
<body>
<%
    VentaController vc = new VentaController();
    ProductosController pc = new ProductosController();
    DetalleVentaController dc = new DetalleVentaController();
    List<VentaEntity> ventass = new ArrayList<>();
    List<DetalleventaEntity> detalles = new ArrayList<>();
    String usuario = request.getParameter("usuario");
    String contrasena = request.getParameter("contrasenia");
    if(usuario != null && contrasena != null){
        if (usuario.equalsIgnoreCase("admin") && contrasena.equalsIgnoreCase("1234")) {
            response.sendRedirect("informe.jsp");
        }else{
            response.sendRedirect("index.jsp?error=1");
        }
    }

%>
<h4>REPRESENTACIÓN PORCENTUAL DE LAS VENTAS POR PRODUCTO:</h4>
<%
    ventass = vc.listarVentas();
    detalles = dc.listarDetalleVenta();
    Informe informe = new Informe(ventass,detalles);
    informe.calcularPorcentajesVenta();
    double  porcentaje = 0.0;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    for(int i = 0; i < informe.productosDisponibles.size(); i++){
        porcentaje = informe.porcentajeVentaProductos.get(i);
        String resultado = decimalFormat.format(porcentaje);
        resultado = resultado.replace(",", ".");
        double porcentajeRedondeado = Double.valueOf(resultado);
       out.println("</p>"+ informe.productosDisponibles.get(i).getNombreprod() +" "+ porcentajeRedondeado+"</p><br>");
        /*
        for(int j = 1; j <= informe.porcentajeVentaProductos.get(i); j++){
            //    System.out.print("*");
            if(j % 10 == 0){
                out.println();
            }
        }*/
        out.println("<p>\n" + porcentajeRedondeado + "%.\n</p><br>------------------------------------------------" );
    }
    Double totalVendido = informe.totalVendido;
    String r = decimalFormat.format(totalVendido);
    r = r.replace(",", ".");
    double totalRedondeado = Double.valueOf(r);
    out.println("<p> Total Vendido: $" + totalRedondeado + "</p>");
%>
</body>
</html>
