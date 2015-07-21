/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Caracteristics;

/**
 *
 * @author master
 */
public class Medic {
    private String name;
    
    private int age;
    private int CI;
    private String speciality;
    private String sucursal;

    public Medic(String name, int age, int CI, String speciality, String sucursal) {
        this.name = name;
        
        this.age = age;
        this.CI = CI;
        this.speciality = speciality;
        this.sucursal = sucursal;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    

    public int getAge() {
        return age;
    }

    public int getCI() {
        return CI;
    }

    
    public String getSpeciality() {
        return speciality;
    }

    public String getSucursal() {
        return sucursal;
    }
    
    
}
