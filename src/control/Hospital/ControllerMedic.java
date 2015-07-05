/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Caracteristics.Medic;
import model.DB.QueryMedic;
import sun.util.locale.StringTokenIterator;

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
    public int obtainID(String fullName){
        String arr1[],arr2[]={};
        int tam;
        int id=0;
        arr1=fullName.split(" ");
        tam=arr1.length;
        
        arr2=new String[2];
        switch(tam){
            case 2:
            case 3:
                arr2[0]=arr1[0];
                arr2[1]=arr1[1]+" "+arr1[2];
                break;
            case 4:
                
                arr2[0]=arr1[0]+" "+arr1[1];
                arr2[1]=arr1[2]+" "+arr1[3];
                break;
        }
        id=ctrlM.obtainMedicID(arr2[0], arr2[1]);
        return id;
    }
    
}
