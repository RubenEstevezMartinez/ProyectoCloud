<%-- 
    Document   : show
    Created on : 19/11/2023, 2:21:53 p. m.
    Author     : estev
--%>

<%@page import="estevez.ruben.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

Reserva res = (Reserva) request.getAttribute("res");
if (res==null) {
    response.sendRedirect("MainApp?obj=reserva&action=list");
    return;
}
 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Reserva</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>           
        <div class="container">
        
            <table class="table table-hover mt-3">
                <tr>
                  <td><label>Cedula Cliente</label></td>
                  <td><%=res.getCedula() %></td>
                </tr>

                <tr>
                  <td><label>Nombre Cliente</label></td>
                  <td><%=res.getNombre() %></td>
                </tr>

                <tr>
                  <td><label>Apellido Cliente</label></td>
                  <td><%=res.getApellido() %></td>
                </tr>

                <tr>
                  <td><label>Dinero Abonado</label></td>
                  <td><%=res.getAbono() %></td>
                </tr>

            </table>
                <br>
                <a class="btn btn-primary" href="MainApp?obj.jsp">Volver</a>
        </div>
    </body>
</html>
