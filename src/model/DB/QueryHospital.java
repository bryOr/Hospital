/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
