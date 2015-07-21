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
import model.Caracteristics.Diagnosis;
import model.Caracteristics.Medic;
import model.Caracteristics.Visit;


/**
 *
 * @author master
 */
public class QueryMedic {
    
    
    
    public List<String> showMedics(String sucursalName){
        List<String> doctors=new ArrayList<String>();
        
        Connection conn=null;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            Statement stmt=conn.createStatement();
            String query="SELECT d.name as doctor_name, d.lastname as doctor_lastname "
                        + "FROM sucursal s, doctor d "
                        + "WHERE s.id_s=d.id_s AND s.name='"+sucursalName+"'";
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                String name=rs.getString("doctor_name");
                String lastname=rs.getString("doctor_lastname");
                String fullName=name+" "+lastname;
                //System.out.println(name+" "+lastname);
                
                doctors.add(fullName);
            }
            //System.out.println(doctors);
            
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
            String secondQuery="INSERT INTO doctor (id_s,name,edad,ci,specialty) "
                            + "VALUES "
                            + "(?,?,?,?,?);";
            
            ptmt=conn.prepareStatement(secondQuery);
            ptmt.setInt(1, id_s);
            ptmt.setString(2, m.getName());
            ptmt.setInt(3, m.getAge());
            ptmt.setInt(4, m.getCI());
            ptmt.setString(5, m.getSpeciality());
            
            ptmt.executeUpdate();
            
            ptmt.close();
            rs.close();
            stmt.close();
            
            conn.close();
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
    }
    public int obtainMedicID(String name,String lastname){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String query="SELECT id_d "
                    + "FROM doctor "
                    + "WHERE name='"+name+"' and lastname='"+lastname+"'";
            rs=stmt.executeQuery(query);
            rs.next();
            id=rs.getInt("id_d");
            
            rs.close();
            
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    public void addVisit(Visit V){
        Connection conn=null;
        PreparedStatement ptmt=null;
        
        
        try{
            conn=Conexion.getInstance().getConnection();
            String sql="INSERT INTO "
                    + "visit(id_p,id_d,visitdate,diagnosis) "
                    + "VALUES (?,?,?,?)";
            ptmt=conn.prepareStatement(sql);
            
            ptmt.setInt(1, V.getId_d());
            ptmt.setInt(2, V.getId_p());
            ptmt.setDate(3, new java.sql.Date(V.getD().getTime()));
            ptmt.setString(4, V.getDiagnosis());
            ptmt.executeUpdate();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public void confirmDiagnosis(Diagnosis d){
        Connection conn=null;
        PreparedStatement ptmt=null;
        
        try{
            conn=Conexion.getInstance().getConnection();
            String sql="INSERT INTO diagnosis (id_v,diagnosistype,complications,diagnosisdate) "
                    + "VALUES "
                    + "(?,?,?,?)";
            ptmt=conn.prepareStatement(sql);
            
            ptmt.setInt(1, d.getId_visita());
            ptmt.setString(2, d.getType());
            ptmt.setString(3, d.getComplications());
            ptmt.setDate(4, new java.sql.Date(d.getDate().getTime()));
            ptmt.executeUpdate();
            
            //System.out.println("SE HIZO REGISTRO");
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
}
