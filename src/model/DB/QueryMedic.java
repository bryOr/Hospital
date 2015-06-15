/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import control.Hospital.ControllerMedic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Caracteristics.Medic;

/**
 *
 * @author master
 */
public class QueryMedic {
    
    
    
    public List<String> showMedics(String sucursalName){
        List<String> doctors=new ArrayList<String>();
        String name="",lastname="";
        String fullname="";
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT name, lastname "
                        + "FROM  doctor "
                        + "WHERE id_s=(SELECT id_s "
                                    + "FROM sucursal "
                                    + "WHERE name='"+sucursalName+"')";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                name=rs.getString("name");
                lastname=rs.getString("lastname");
                fullname=name+" "+lastname;
                doctors.add(fullname);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                
        return doctors;
    }
    public void registerMedic(Medic m){
        Connection conn=null;
        PreparedStatement ptmt=null;
        ResultSet rs=null;
        int id_s=0;
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            String sucursal=m.getSucursal();
            String firstQuery="SELECT id_s "
                            + "FROM sucursal "
                            + "WHERE name='"+sucursal+"'";
            rs=stmt.executeQuery(firstQuery);
            rs.next();
            id_s=rs.getInt("id_s");
            String secondQuery="INSERT INTO doctor (id_s,name,edad,ci,specialty,lastname) "
                            + "VALUES "
                            + "(?,?,?,?,?,?)";
            
            ptmt=conn.prepareStatement(secondQuery);
            ptmt.setInt(1, id_s);
            ptmt.setString(2, m.getName());
            ptmt.setInt(3, m.getAge());
            ptmt.setInt(4, m.getCI());
            ptmt.setString(5, m.getSpeciality());
            ptmt.setString(6, m.getLastname());
            
            ptmt.executeUpdate();
            
            ptmt.close();
            rs.close();
            stmt.close();
            
            conn.close();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
    }
}
