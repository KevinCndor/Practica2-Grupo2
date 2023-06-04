<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Minimarket</title>
</head>
<body>
<table style="margin: auto;">
    <tr>
        <td colspan="2" style="height: 20vh;"></td>
    </tr>
    <table style="width: 20%; margin: auto;">
        <tr>
            <td colspan="2" style="text-align: center;">
                <h1>MiniMarket</h1>
            </td>
        </tr>
        <tr>
            <td>
                <div style="margin-bottom:45px;">
                    Venta de Productos
                </div>
            </td>
            <form action="venta.jsp" method="GET">
                <td>
                    <div style="margin-bottom: 45px;">
                        <button>Seleccionar</button>
                    </div>
                </td>
            </form>
        </tr>
        <tr>
            <td>
                <div style="margin-bottom: 45px;">
                    Inventario
                </div>
            </td>
            <form action="SvProductos" method="GET">
                <td>
                    <div style="margin-bottom: 45px;">
                        <button>Seleccionar</button>
                    </div>
                </td>
            </form>
        </tr>
        <tr>
            <td>
                <div style="margin-bottom: 45px;">
                    Generar Informe
                    </form>
                </div>
            </td>
            <form action="login.jsp" method="POST">
                <td>
                    <div style="margin-bottom: 45px;">
                        <button>Seleccionar</button>
                    </div>
                </td>
            </form>
        </tr>
    </table>
    <tr>
        <td colspan="2" style="height: 15vh;"></td>
    </tr>
</table>
</body>
</html>