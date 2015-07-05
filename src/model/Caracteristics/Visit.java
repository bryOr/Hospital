/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Caracteristics;

import java.util.Date;

/**
 *
 * @author master
 */
public class Visit {
    private int id_d;
    private int id_p;
    private Date d;
    
    public Visit(int id1,int id2,Date d){
        id_d=id1;
        id_p=id2;
        this.d=d;
    }

    public int getId_d() {
        return id_d;
    }

    public int getId_p() {
        return id_p;
    }

    public Date getD() {
        return d;
    }
    
}
