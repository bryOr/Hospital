/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import model.Caracteristics.Patient;
import model.DB.QueryPatient;

/**
 *
 * @author Oscar
 */
public class ControllerPatient {
    private QueryPatient q_p;
    
    public ControllerPatient(){
        q_p=new QueryPatient();
    }
    public boolean patient_inserted(Patient p){
        boolean res=q_p.insertPatient(p);
        return res;
    }
    public boolean validate_patient(Patient p){
        boolean res=true;
        if(p.getName().isEmpty() || 
                p.getLastname().isEmpty() || 
                p.getAddress().isEmpty() || 
                p.getCI()<10000 || 
                p.getRegistrationNumber()<0 || 
                p.getBednumber()<0 || 
                p.isSex().equals("Escoja una opcion")){
            res=false;
        }
        return res;
    }
    public boolean checkCI(String x){
        boolean res=true;
        char[] character=x.toCharArray();
        for(int c=0;c<character.length;c++){
            if( !(Character.isDigit(character[c])) ){
                res=false;
                break;
            }
        }
        return res;
    }
}
