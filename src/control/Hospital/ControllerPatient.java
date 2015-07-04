/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import java.util.ArrayList;
import java.util.StringTokenizer;
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
        String arr1[]={},arr2[]={};
        int i=0,tam;
        int id=0;
        StringTokenizer st=new StringTokenizer(fullName);
        while(st.hasMoreElements()){
            arr1[i]=st.nextElement().toString();
        }
        tam=arr1.length;
        switch(tam){
            case 3:
                arr2[0]=arr1[0];
                arr2[1]=arr1[1]+" "+arr1[2];
                break;
            case 4:
                arr2[0]=arr1[0]+" "+arr1[1];
                arr2[1]=arr2[2]+" "+arr2[3];
                break;
        }
        id=q_p.getID(arr2[0], arr2[1]);
        return id;
    }
}
