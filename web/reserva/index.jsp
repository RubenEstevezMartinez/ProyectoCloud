<%-- 
    Document   : index
    Created on : 19/11/2023, 12:20:23 p. m.
    Author     : estev
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="estevez.ruben.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  ArrayList<Reserva> data = (ArrayList<Reserva>)request.getAttribute("data");
    if(data==null){
        data=new ArrayList();
        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Reservas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <a class="btn btn-primary" href="MainApp?obj=reserva&action=add">Agregar Reserva</a><br>
        <%
            if(data.size()==0){
            out.print("No Data");
            
          } else {
                 %>
                 <table class="table">
                     <thead>
                         <tr>
                             <th>Id</th>
                             <th>Cedula Cliente</th>
                             <th>Nombre Cliente</th>
                             <th>Apellido Cliente</th>
                             <th>Dinero Abonado</th>
                             <th>Acciones</th>
                         </tr>
                     </thead>
                     <tbody>
                 <%
               for (Reserva res: data){
                   %>
                   <tr>
                       <td><%=res.getId() %></td>
                       <td><%=res.getCedula() %></td>
                       <td><%=res.getNombre() %></td>
                       <td><%=res.getApellido() %></td>
                       <td><%=res.getAbono() %></td>
                       <td>
                           <a class="btn btn-danger" 
                              href="MainApp?obj=reserva&action=delete&id=<%=res.getId() %>">
                               Eliminar</a>
                            <a class="btn btn-warning" 
                              href="MainApp?obj=reserva&action=edit&id=<%=res.getId() %>">
                               Editar</a>
                            <a class="btn btn-primary" 
                              href="MainApp?obj=reserva&action=show&id=<%=res.getId() %>">
                               Ver</a>
                       </td>
                       
                   </tr>
                   <%
               }
               %>
                     </tbody>
                 </table>
               <%
             }
         %>
         <br>
         <a class="btn btn-primary" href="index.jsp">Volver</a>
         </div>
    </body>
</html>
