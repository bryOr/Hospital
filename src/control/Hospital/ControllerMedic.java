/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import java.util.ArrayList;
import model.Caracteristics.Medic;
import model.DB.QueryMedic;

/**
 *
 * @author master
 */
public class ControllerMedic {
    
    public QueryMedic ctrlM;
    public ControllerMedic(){
        ctrlM=new QueryMedic();
    }
    public ArrayList<String> giveDoctorNames(String sucursalName){
        ArrayList medics=new ArrayList<String>();
        if(!(sucursalName.equals("Seleccione Sucursal"))){
            medics=(ArrayList)ctrlM.showMedics(sucursalName);
        }
        return medics;
    }
    public boolean verifyInfo(Medic m){
        boolean res=true;
        
        if( m.getName().isEmpty() || 
                m.getLastname().isEmpty() ||
                m.getAge()<25 || 
                m.getCI()<10000 || 
                m.getSpeciality().isEmpty() || 
                m.getSucursal().isEmpty() ){
            
            res=false;
            
        }        
        return res;        
    }
    public void sendInfo(Medic m){
        String name=m.getName();
        String lastname=m.getLastname();
        
        name=changeToUpperCase(name);
        lastname=changeToUpperCase(lastname);
        
        m.setName(name);
        m.setLastName(lastname);
        
        ctrlM.registerMedic(m);
        
    }
    public String changeToUpperCase(String x){
        String res="";
        char[] caracter=x.toCharArray();
        caracter[0]=Character.toUpperCase(caracter[0]);
        for(int i=0;i<x.length();i++){
            if(caracter[i]==' '){
                caracter[i+1]=Character.toUpperCase(caracter[i+1]);
            }
        }
        res=String.valueOf(caracter);
        return res;
        
    }
    
}
