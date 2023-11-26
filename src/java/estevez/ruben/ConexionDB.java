/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estevez.ruben;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estev
 */
public class ConexionDB {
    
    
    private String host="dbproyecto.ccmq9zribhw7.us-east-1.rds.amazonaws.com";
    //private String host="localhost";
    private int port=3306;
    private String db = "proyectocloud";
    private String user="admin";
    //private String user="root";
    private String password= "Atento2018";
    //private String password= "Atento2018*";
    private String url = "jdbc:mysql://"+host+":"+port+"/"+db+"?useSSL=false&serverTimezone=UTC";
    
    private Connection conexion;
    
    private static ConexionDB dbInstance;
    
    private ConexionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion=DriverManager.getConnection(url, user, password);
            System.out.println("LA CONEXION A LA BD FUE EXITOSA");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                   
        }
    }
    
    public static ConexionDB getInstance(){
        if (dbInstance==null) {
            dbInstance=new ConexionDB();
        }
        return dbInstance;
    }
    
    public Connection getConexion() {
        return conexion;
    }
    public void closed (){
        if (conexion!=null) {
            try{
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      public static void main(String[] args){
       ConexionDB db = ConexionDB.getInstance();
   }
    
}

