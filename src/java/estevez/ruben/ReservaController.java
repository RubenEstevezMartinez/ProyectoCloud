/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estevez.ruben;

import estevez.rubendb.ReservaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author estev
 */
public class ReservaController extends HttpServlet {
    private ReservaDAO resDAO = new ReservaDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String action = ((request.getParameter("action") != null) ? request.getParameter("action") : "list");

        // Declaro para que no saliera el error que estaba sobre declarando, solamente para hacer uso de las variables abajo
        String txtId;
        String txtNum;
        String nombre;
        String apellido;
        String txtAbon;
        int id;
        int cedula;
        float abono;

        switch (action) {
            case "list":
                ArrayList<Reserva> data = resDAO.getReservas();
                request.setAttribute("data", data);
                request.getRequestDispatcher("reserva/index.jsp").forward(request, response);
                break;

            case "add":
                request.getRequestDispatcher("reserva/create.jsp").forward(request, response);
                break;

            case "save":
                txtNum = request.getParameter("cedula");
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                txtAbon = request.getParameter("abono");
                cedula = Integer.parseInt(txtNum);
                abono = Float.parseFloat(txtAbon);
                Reserva res = new Reserva(cedula, nombre, apellido);
                res.setAbono(abono);
                resDAO.addReserva(res);
                response.sendRedirect("MainApp?obj=reserva");
                break;
             
                
            case "delete": // aqui agrego otro caso lo que hizo en DAO el metodo eliminar
                txtId = request.getParameter("id");
                id = Integer.parseInt(txtId);
                resDAO.deleteReserva(id);
                response.sendRedirect("MainApp?obj=reserva");
                break;

            case "edit":
                txtId = request.getParameter("id");
                id = Integer.parseInt(txtId);
                res = resDAO.getReserva(id);
                if (res == null) {
                    response.sendRedirect("MainApp?obj=reserva");
                    return;
                }
                request.setAttribute("res", res);
                request.getRequestDispatcher("reserva/edit.jsp").forward(request, response);
                break;

            case "update":
                txtId = request.getParameter("id");
                id = Integer.parseInt(txtId);
                res = resDAO.getReserva(id);
                if (res == null) {
                    response.sendRedirect("MainApp?obj=reserva");
                    return;
                }

                txtNum = request.getParameter("cedula");
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                txtAbon = request.getParameter("abono");
                cedula = Integer.parseInt(txtNum);
                abono = Float.parseFloat(txtAbon);
                res.setCedula(cedula);
                res.setNombre(nombre);
                res.setApellido(apellido);
                res.setAbono(abono);
                resDAO.updateReserva(id, res);
                response.sendRedirect("MainApp?obj=reserva");
                break; // hasta aqui hizo los botones elimnar y editar y depues se fue a crear el jsp de edit

            // Tercera fase ahora para hacer la accion VER  con show   
            case "show":
                txtId = request.getParameter("id");
                id = Integer.parseInt(txtId);
                res = resDAO.getReserva(id);// Aqui falta colocar Con Medicamentos para que conecte a la base con show
                if (res == null) {
                    response.sendRedirect("MainApp?obj=reserva");
                    return;
                }
                request.setAttribute("res", res);
                request.getRequestDispatcher("reserva/show.jsp").forward(request, response);
                break;
                               
            case "back":
                response.sendRedirect("index.jsp");
                break;
            default:
                response.sendRedirect("index.jsp");
                break;

        }

        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
