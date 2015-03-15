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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Caracteristics.Patient;


/**
 *
 * @author Oscar
 */
public class QueryPatient {
    
    public boolean insertPatient(Patient p){
        boolean res=false;
        PreparedStatement stmt=null;
        Connection conn=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.prepareStatement("INSERT INTO patient(id_r,ci,registrationnumber,name,lastname,bednumber,address,dateofbirth,sex"
                    + " VALUES "
                    + "(?,?,?,?,?,?,?,?,?");
            stmt.setInt(1, p.getId_r());
            stmt.setInt(2, p.getCI());
            stmt.setInt(3, p.getRegistrationNumber());
            stmt.setString(4, p.getName());
            stmt.setString(5, p.getLastname());
            stmt.setInt(6, p.getBednumber());
            stmt.setString(7, p.getAddress());
            stmt.setString(8, p.getDateofBirth());
            stmt.setString(9, p.isSex());
            
            stmt.executeUpdate();
            res=true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
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
