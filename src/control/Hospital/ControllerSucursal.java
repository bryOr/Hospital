/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.Hospital;

import model.DB.QuerySucursal;

/**
 *
 * @author master
 */
public class ControllerSucursal {
    public QuerySucursal ctrl;
    
    public ControllerSucursal(){
        ctrl=new QuerySucursal();
    }
    public Object[][] getSucursalInformation(){
        return ctrl.showSucursals();
    }
}
