/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class QueryPatient {
    public boolean registerPatient(String room){
        boolean registrado=false;
        
        PreparedStatement stmt=null;
        Connection conn=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return registrado;
        
    }
}
