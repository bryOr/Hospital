/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Caracteristics;

import java.util.Date;

/**
 *
 * @author Oscar
 */
public class Patient {
    private int id_r;
    
    private int CI;
    private int registrationNumber;
    private String name;
    private String lastname;
    private  int bednumber;
    private String address;
    private Date dateofBirth;
    private String sex;
    
    public Patient(int id_r,int CI, int registrationNumber, String name, String lastname, int bednumber, String address, Date dateofBirth, String sex) {
        this.id_r=id_r;
        
        this.CI = CI;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.lastname = lastname;
        this.bednumber = bednumber;
        this.address = address;
        this.dateofBirth = dateofBirth;
        this.sex = sex;
    }

    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }
    
    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBednumber() {
        return bednumber;
    }

    public void setBednumber(int bednumber) {
        this.bednumber = bednumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
}
