/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Caracteristics.Hospital;

/**
 *
 * @author Oscar
 */
public class QueryHospital {
    
    
    public List<String> ListofHospitals(){
        Connection conn=null;
        ResultSet rs=null;
        List<String> names=new ArrayList<String>();
        
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            String query="SELECT name FROM hospital";
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                String name=rs.getString("name");
                names.add(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return names;
    }
    
}
