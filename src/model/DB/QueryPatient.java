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
            stmt=conn.prepareStatement("INSERT INTO patient(id_r,ci,registrationnumber,name,bednumber,address,dateofbirth,sex)"
                    + " VALUES "
                    + "(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId_r());
            stmt.setInt(2, p.getCI());
            stmt.setInt(3, p.getRegistrationNumber());
            stmt.setString(4, p.getName());
            stmt.setInt(5, p.getBednumber());
            stmt.setString(6, p.getAddress());
            stmt.setDate(7, new java.sql.Date(p.getDateofBirth().getTime()));
            stmt.setString(8, p.isSex());
            
            stmt.executeUpdate();
            res=true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return res;
    }
    
    public int getID_Room(String sucursal,String room){
        int id=0;
        Connection conn=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            String query="SELECT sr.id_r "
                       + "FROM sucursalroom sr, sucursal s "
                       + "WHERE s.id_s=sr.id_s AND sr.nameroom='"+room+"' AND s.name='"+sucursal+"'";
            rs=stmt.executeQuery(query);
            rs.next();
            id=rs.getInt("id_r");
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return id;
    }
    public List<String> getPatients(String lastName){
        List<String> list=new ArrayList<String>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT name,lastname "
                         + "FROM patient "
                         + "WHERE lastname LIKE '%"+lastName+"%'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                String fullName=rs.getString("name")+" "+rs.getString("lastname");
                list.add(fullName);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    public int getID(String name,String lastname){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT id_p "
                    + "FROM patient "
                    + "WHERE name='"+name+"' and lastname='"+lastname+"'";
            rs=stmt.executeQuery(query);
            rs.next();
            id=rs.getInt("id_p");
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
        
    }
}
