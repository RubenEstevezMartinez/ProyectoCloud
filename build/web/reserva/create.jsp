<%-- 
    Document   : create
    Created on : 19/11/2023, 1:44:29 p. m.
    Author     : estev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Reserva</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    </head>
    <body>
        <form method="post" action="MainApp?obj=reserva&action=save">
                <table class="table table-hover">
                <tr>
                  <td><label>Cedula Cliente</label></td>
                  <td><input type="number" name="cedula" /><br></td>
                </tr>

                <tr>
                  <td><label>Nombre Cliente</label></td>
                  <td><input type="text" name="nombre" /><br></td>
                </tr>

                <tr>
                  <td><label>Apellido Cliente</label></td>
                  <td><input type="text" name="apellido" /><br></td>
                </tr>

                <tr>
                  <td><label>Dinero Abonado</label></td>
                  <td><input type="number" name="abono" /><br></td>
                </tr>

                <tr>
                  <td><button class="btn btn-primary">Enviar</button></td>
                </tr>

            </table>
        </form>
        
    </body>
</html>

