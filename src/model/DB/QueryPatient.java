/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Oscar
 */
public class QueryPatient {
    
    public int getID_Room(String hospital,String room){
        int id=0;
        Connection conn=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            String query="SELECT hr.id_r "
                       + "FROM hospitalroom hr, hospital h "
                       + "WHERE h.id_h=hr.id_h AND hr.nameroom='"+room+"' AND h.name='"+hospital+"'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                id=rs.getInt("id_r");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return id;
    }
}
