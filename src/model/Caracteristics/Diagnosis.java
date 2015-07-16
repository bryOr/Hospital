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
public class Diagnosis {
    private int id_visita;
    private String complications;
    private String type;
    private Date date;
    
    public Diagnosis(int id_visita,String complications,String type,Date d){
        this.id_visita=id_visita;
        this.complications=complications;
        this.type=type;
        date=d;
    }

    public int getId_visita() {
        return id_visita;
    }

    
    public String getComplications() {
        return complications;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
    
    
}
