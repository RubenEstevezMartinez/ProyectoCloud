<%-- 
    Document   : edit
    Created on : 19/11/2023, 2:16:13 p. m.
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
        <title>Editar Reserva</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>           
        <div class="container">
        <form action="MainApp?obj=reserva&action=update&id=<%=res.getId() %>" method="POST">
            <table class="table table-hover">
                <tr>
                  <td><label>Cedula Cliente</label></td>
                  <td><input type="number" name="cedula" 
                             value="<%=res.getCedula() %>" readonly="readonly" /><br></td> <!reandonly para que el documento no se pueda cambiar>
                </tr>

                <tr>
                  <td><label>Nombre Cliente</label></td>
                  <td><input type="text" name="nombre" 
                             value = "<%=res.getNombre() %>" /><br></td>
                </tr>

                <tr>
                  <td><label>Apellido Cliente</label></td>
                  <td><input type="text" name="apellido" 
                             value = "<%=res.getApellido() %>" /><br></td>
                </tr>


                <tr>
                  <td><label>Dinero Abonado</label></td>
                  <td><input type="number" name="abono" 
                             value = "<%=res.getAbono() %>" 
                             class="form-control" /><br></td>
                </tr>

                <tr>
                  <td><button class="btn btn-primary">Enviar</button></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
