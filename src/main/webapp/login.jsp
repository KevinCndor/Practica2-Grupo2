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
    <title>Login</title>
</head>
<body>
    <form action="informe.jsp" method="GET">
        <fieldset>
            Usuario:
            <!-- Caja de texto-->
            <input type="text" name="usuario"/><br><br>
            Contraseña:
            <!-- Caja de texto tipo Password-->
            <input type="password" name="contrasenia"/><br><br>
            <!-- Botón para enviar el formulario-->
            <input type="submit" name="Iniciar Sesión"/>
        </fieldset>
    </form>
</body>
</html>
