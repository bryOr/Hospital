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
    public boolean  addHospital(Hospital h){
        return q_h.registerHospital(h);
    }
    public boolean compareHospitalNames(String nameH){
        boolean res=false;
        String name_HospitalBD=q_h.getHospitalName(nameH);
        if(nameH.equals(name_HospitalBD)){
            res=true;
        }
        return res;
    }
    public ArrayList<String> getAllHospitalNames(){
        return (ArrayList)q_h.List_of_Hospitals();
    }
    public int List_Size_(){
        return getAllHospitalNames().size();
    }
    
    public ArrayList<String> getAllHospitalRooms(String hosp_name){
        return (ArrayList)q_h.room_list(hosp_name);
    }
}
