/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import model.DB.QueryPatient;

/**
 *
 * @author Oscar
 */

public class controlRoom {
    private QueryPatient q_p;
    public int getIdRoom(String hospitalName,String roomName){
        return q_p.getID_Room(hospitalName, roomName);
    }
}
