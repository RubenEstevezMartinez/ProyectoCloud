/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estevez.rubendb;

import estevez.ruben.ConexionDB;
import estevez.ruben.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estev
 */
public class ReservaDAO {

    private ConexionDB db;

    public ReservaDAO() {
        this.db = ConexionDB.getInstance();

    }

    public ArrayList<Reserva> getReservas() {

        ArrayList<Reserva> datos = new ArrayList();
        String sql = "select * from reservas";
        try {
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                float abono = rs.getFloat("abono");
                Reserva res = new Reserva(id, cedula, nombre, apellido, abono);
                datos.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return datos;
    }

    public void addReserva(Reserva res) {
        String sql = "insert into reservas values (NULL, ?,?,?,?);";
        try {
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, res.getCedula());
            ps.setString(2, res.getNombre());
            ps.setString(3, res.getApellido());
            ps.setFloat(4, res.getAbono());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteReserva(int id) {

        String sql = "DELETE FROM reservas WHERE id = ?";
        try {
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reserva getReserva(int id) {
        Reserva dato = null;
        String sql = "select * from reservas where id = ?";

        try {
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                float abono = rs.getFloat("abono");
                dato = new Reserva(id, cedula, nombre, apellido, abono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dato;// Lo hizo hasta aqui despues hizo el tercer paso abajo modificar estudiante.
    }

    public void updateReserva(int id, Reserva res) {
      String sql = "UPDATE reservas "
                + "SET cedula=?, nombre=?, apellido=?, "
                + "abono=? WHERE id=?";
        try {
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, res.getCedula());
            ps.setString(2, res.getNombre());
            ps.setString(3, res.getApellido());
            ps.setFloat(4, res.getAbono());
            ps.setInt(5, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    //hasta aqui llego y despues se fue para Estudiante controller hacer las acciones.
    
}
