/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import java.util.ArrayList;
import model.Caracteristics.Hospital;
import model.DB.QueryHospital;

/**
 *
 * @author Oscar
 */
public class ControllerHospital {
    
    private QueryHospital q_h;
    
    public ControllerHospital(){
        q_h=new QueryHospital();
    }
    
    
    public ArrayList<String> getAllHospitalNames(){
        return (ArrayList)q_h.ListofHospitals();
    }
    
    
    public String getHospital_Name(String hosp_name){
        return hosp_name;
    }
    
}
