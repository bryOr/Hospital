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

import model.Caracteristics.Patient;


/**
 *
 * @author Oscar
 */
public class QueryPatient {

    public Object[] findPatiend(int ci){
        Object[] p=null;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int total=0;
        int contador=0;
        String name="",address="";
        String fullName="";
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            /*String query="SELECT count(*) as total "
                        + "FROM patient "
                        + "WHERE ci='"+ci+"'";
            rs=stmt.executeQuery(query);
            rs.next();
            total=rs.getInt("total");
            rs.close();
            p=new Object[total];
            */
            String query="SELECT name, lastname "
                + "FROM patient "
                + "WHERE ci LIKE '%"+ci+"%'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                name=rs.getString("name");
                address=rs.getString("lastname");
                fullName=(contador+1)+" "+name+" "+address;
                p[contador]=fullName;
                contador++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return p;
    }
    public boolean insertPatient(Patient p){
        boolean res=false;
        PreparedStatement stmt=null;
        Connection conn=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.prepareStatement("INSERT INTO patient(id_r,ci,registrationnumber,name,lastname,bednumber,address,dateofbirth,sex)"
                    + " VALUES "
                    + "(?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId_r());
            stmt.setInt(2, p.getCI());
            stmt.setInt(3, p.getRegistrationNumber());
            stmt.setString(4, p.getName());
            stmt.setString(5, p.getLastname());
            stmt.setInt(6, p.getBednumber());
            stmt.setString(7, p.getAddress());
            stmt.setDate(8, new java.sql.Date(p.getDateofBirth().getTime()));
            stmt.setString(9, p.isSex());
            
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
}
