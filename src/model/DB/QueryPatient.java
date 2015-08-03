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

    

    public Object[][] obtainInfo(String patName){
        Object[][] res=null;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int filas=0;
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT p.name, v.diagnosis "
                        + "FROM patient p, visit v, doctor d "
                        + "WHERE d.id_d=v.id_d and p.id_p=v.id_p AND p.name LIKE '%"+patName+"%'";
            
            rs=stmt.executeQuery(query);
            res=new Object[16][2];
            try{
                while(rs.next()){
                    
                    res[filas][0]=rs.getString("name");
                    res[filas][1]=rs.getString("diagnosis");
                    filas++;
                }
            }catch(Exception e){}
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return res;
    }
    public int giveNumberOfVisits(int id){
        int filas=0;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT  count(*) as numero_filas "
                        + "FROM patient p,visit v, sucursalroom sr, sucursal s "
                        + "WHERE sr.id_r=p.id_r AND s.id_s=sr.id_s AND p.id_p=v.id_p "
                        + "AND p.ci='"+id+"'";
            rs=stmt.executeQuery(query);
            rs.next();
            filas=rs.getInt("numero_filas");
            
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.err.println(e);
        }
        return filas;
    }
    public Object[][] recieveHistorial(int id,int filas){
        Object[][] matriz=null;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int x=0;
        
        try{
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT p.name, p.ci, sr.nameroom, v.visitdate "
                        + "FROM patient p, visit v, sucursalroom sr, sucursal s "
                        + "WHERE sr.id_r=p.id_r AND s.id_s=sr.id_s AND p.id_p=v.id_p "
                        + "AND p.ci='"+id+"'";
            rs=stmt.executeQuery(query);
            matriz=new Object[filas][5];
            while(rs.next()){
                matriz[x][0]=x+1;
                matriz[x][1]=rs.getString("name");
                matriz[x][2]=rs.getInt("ci");
                matriz[x][3]=rs.getString("nameroom");
                matriz[x][4]=rs.getDate("visitdate");
                x++;
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.err.print(e);
        }
        return matriz;
    }
    public void insertPatient(Patient p){
        
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
            stmt.setString(8, String.valueOf(p.isSex()));
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
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
    public List<String> getPatients(String patientName,String sucName){
        List<String> list=new ArrayList<String>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT p.name "
                         + "FROM patient p, sucursal s, sucursalroom sr "
                         + "WHERE sr.id_r=p.id_r AND sr.id_s=s.id_s AND  "
                         + "s.name='"+sucName+"' AND p.name LIKE '%"+patientName+"%'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                String patName=rs.getString("name");
                list.add(patName);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    public int getID(String patName){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT id_p "
                    + "FROM patient "
                    + "WHERE name='"+patName+"'";
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
