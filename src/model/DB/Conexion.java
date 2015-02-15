/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class Conexion {
    String driverClassName="org.postgresql.Driver";
    String connectionUrl="jdbc:postgresql://localhost:5432/Hospital";
    String user="postgres";
    String password="101";
    
    private static Conexion conexion=null;
    
    private Conexion(){
        try{
            Class.forName(driverClassName);
        }catch (ClassNotFoundException e) {
                        e.printStackTrace();
        }
        
    }
    
        public Connection getConnection() throws SQLException {
                Connection conn = null;
                conn = DriverManager.getConnection(connectionUrl, user, password);
                return conn;
        }

        public static Conexion getInstance() {
                if (conexion == null) {
                        conexion = new Conexion();
                }
                return conexion;
        }
    
}
