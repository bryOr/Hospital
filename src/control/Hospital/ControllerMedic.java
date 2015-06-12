/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import model.Caracteristics.Medic;

/**
 *
 * @author master
 */
public class ControllerMedic {
    public ControllerMedic(){
        
    }
    public boolean verifyInfo(Medic m){
        boolean res=true;
        
        if( m.getName().isEmpty() || 
                m.getLastname().isEmpty() ||
                m.getAge()==0 || 
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
        changeToUpperCase(name);
        changeToUpperCase(lastname);
        
    }
    public void changeToUpperCase(String x){
        char[] caracter=x.toCharArray();
        caracter[0]=Character.toUpperCase(caracter[0]);
        for(int i=0;i<x.length();i++){
            if(caracter[i]==' '){
                caracter[i+1]=Character.toUpperCase(caracter[i+1]);
            }
        }
    }
    
}
