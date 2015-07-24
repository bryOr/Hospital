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
                p.getCI()<1000000 || 
                p.getRegistrationNumber()<=0  ||
                p.getBednumber()<=0 ||
                p.isSex()==0 ||
                p.getDateofBirth()==null){
            res=false;
            
        }
        System.out.println(res);
        return res;
    }
    
    public boolean verifyLastName(String x){
        boolean res=true;
        char[] caracteres=x.toCharArray();
        for(int c=0;c<caracteres.length;c++){
            if(Character.isDigit(caracteres[c])){
                return false;
            }
        }
        return res;
    }
    public ArrayList<String> getPatients(String x){
        return (ArrayList)q_p.getPatients(x);
    }
    public int obtainID(String fullName){
        String arr1[],arr2[]={};
        int tam;
        int id=0;
        arr1=fullName.split(" ");
        tam=arr1.length;
        arr2=new String[2];
        switch(tam){
            case 3:
                arr2[0]=arr1[0];
                arr2[1]=arr1[1]+" "+arr1[2];
                break;
            case 4:
                
                arr2[0]=arr1[0]+" "+arr1[1];
                arr2[1]=arr1[2]+" "+arr1[3];
                break;
        }
        id=q_p.getID(arr2[0], arr2[1]);
        return id;
    }
    public Object[][] obtainInformation(String x){
        return q_p.obtainInfo(x);
    }
}
