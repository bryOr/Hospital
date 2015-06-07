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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author master
 */
public class QuerySucursal {
    
    public List<String> getRooms(String sucursalName){
        List<String> rooms=new ArrayList<String>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ResultSet rs2=null;
        int id_sucursalName=0;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String ID="SELECT id_s "
                    + "FROM sucursal "
                    + "WHERE name='"+sucursalName+"'";
            rs=stmt.executeQuery(ID);
            rs.next();
            id_sucursalName=rs.getInt("id_s");
            
            String query="SELECT nameroom "
                    + "FROM sucursalroom "
                    + "WHERE id_s='"+id_sucursalName+"'";
            rs2=stmt.executeQuery(query);
            while(rs2.next()){
                String room_name=rs2.getString("nameroom");
                
                rooms.add(room_name);
            }
            rs.close();
            rs2.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rooms;
    }
    public int getNumberOfRooms(String sucursalName){
        Connection conn=null;
        Statement stmt=null;
        int quantity=0;
        ResultSet rs=null;
        
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String queryQuantity="SELECT count(*) as quantity "
                               + "FROM sucursalroom "
                               + "WHERE nameroom='"+sucursalName+"'";
            
            rs=stmt.executeQuery(queryQuantity);
            rs.next();
            quantity=rs.getInt("quantity");
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return quantity;
    }
    public Object[][] showSucursals(){
        Connection conn=null;
        ResultSet rs=null;
        ResultSet rs2=null;
        Statement stmt=null;
        Object[][] res=null;
        int filas=0;
        try {
            conn=Conexion.getInstance().getConnection();
            stmt=conn.createStatement();
            String cantidad="SELECT count(*) as total "
                    + "FROM sucursal";
            rs=stmt.executeQuery(cantidad);
            rs.next();
            filas=rs.getInt("total");
            res=new Object[filas][3];
            String query="SELECT name,address "
                    + "FROM sucursal";
            rs2=stmt.executeQuery(query);
            int i=0;
            while(rs2.next()){
                res[i][0]=i+1;
                res[i][1]=rs2.getString("name");
                res[i][2]=rs2.getString("address");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return res;
    }
}
