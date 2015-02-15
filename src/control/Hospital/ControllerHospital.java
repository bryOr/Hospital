/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import model.DB.QueryHospital;
import model.Caracteristics.Hospital;

/**
 *
 * @author Oscar
 */
public class ControllerHospital {
    
    private QueryHospital q_h;
    
    public ControllerHospital(){
        q_h=new QueryHospital();
    }
    public boolean  addHospital(Hospital h){
        return q_h.registerHospital(h);
    }
}
