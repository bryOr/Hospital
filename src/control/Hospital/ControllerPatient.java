/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import java.util.ArrayList;

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
    public void patient_inserted(Patient p){
        q_p.insertPatient(p);
    }
    public boolean validate_patient(Patient p){
        boolean res=true;
        if(p.getName().isEmpty() || 
                p.getAddress().isEmpty() || 
                p.getCI()<10000000 || 
                p.getRegistrationNumber()<=0  ||
                p.getBednumber()<=0 ||
                p.isSex()==0 ||
                p.getDateofBirth()==null){
            res=false;
            
        }
        return res;
    }
    
    public boolean verifyPatientName(String x){
        boolean res=true;
        char[] caracteres=x.toCharArray();
        for(int c=0;c<caracteres.length;c++){
            if(Character.isDigit(caracteres[c])){
                return false;
            }
        }
        return res;
    }
    public boolean verifyID(int x){
        boolean res=false;
        if(x>1000000 && x<10000000){
            res=true;
        }
        return res;
    }
    public Object[][] showPatHist(int id){
        int filas=q_p.giveNumberOfVisits(id);
        return q_p.recieveHistorial(id,filas);
    }
    public ArrayList<String> getPatients(String x,String y){
        return (ArrayList)q_p.getPatients(x,y);
    }
    public int obtainID(String fullName){
        int id=0;
        id=q_p.getID(fullName);
        return id;
    }
    public Object[][] obtainInformation(String x){
        return q_p.obtainInfo(x);
    }
}
