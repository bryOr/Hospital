/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Caracteristics;

/**
 *
 * @author Oscar
 */
public class Hospital {
    private int code;
    private String name;
    private String address;
    private int phone;
    private int number_beds;
    
    public Hospital(int code,String name,String address,int phone,int number_beds){
        this.code=code;
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.number_beds=number_beds;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getNumber_beds() {
        return number_beds;
    }

    public void setNumber_beds(int number_beds) {
        this.number_beds = number_beds;
    }
    
}
