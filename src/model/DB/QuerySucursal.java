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
 * @author master
 */
public class QuerySucursal {
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
