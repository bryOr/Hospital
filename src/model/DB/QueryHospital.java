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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Caracteristics.Hospital;

/**
 *
 * @author Oscar
 */
public class QueryHospital {
    public boolean registerHospital(Hospital h){
        boolean res=false;
        PreparedStatement stmt=null;
        Connection conn=null;
        try {
            conn=Conexion.getInstance().getConnection();
       
        stmt=conn.prepareStatement("INSERT INTO hospital(cod_hospital,name,address,phone,numberofbeds) "
                                 + "VALUES "
                                 + "(?,?,?,?,?)");
        stmt.setInt(1, h.getCode());
        stmt.setString(2, h.getName());
        stmt.setString(3, h.getAddress());
        stmt.setInt(4, h.getPhone());
        stmt.setInt(5, h.getNumber_beds());
        
        stmt.executeUpdate();
        res=true;
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return res;
    }
    public String getHospitalName(String hospital_name){
        String aux_name_hospital="";
        Connection conn=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT name "
                               + "FROM hospital "
                               + "WHERE name='"+hospital_name+"'");
            while(rs.next()){
                aux_name_hospital=rs.getString("name");
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return aux_name_hospital;
    }
}
