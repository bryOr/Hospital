/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.Hospital;

import control.Hospital.ControllerHospital;
import javax.swing.DefaultListModel;

/**
 *
 * @author Oscar
 */

public class LookForHospital extends javax.swing.JInternalFrame {

    /**
     * Creates new form addPatient
     */
    private String hospital_Name;
    private int hospital_id;
    private ControllerHospital c_h;
    public LookForHospital() {
        initComponents();
        c_h=new ControllerHospital();
        getAllHospitalNames();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        botonIngresar = new javax.swing.JButton();
        option_hospitalName = new javax.swing.JComboBox();

        jLabel1.setText("jLabel1");

        jLabel9.setText("Nombre del Hospital para Verificar:");

        botonIngresar.setText("Ingresar a Hospital");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        option_hospitalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option_hospitalNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(option_hospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIngresar)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(option_hospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonIngresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        // TODO add your handling code here:
        
        addPatient patient=new addPatient();
        patient.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void option_hospitalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option_hospitalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option_hospitalNameActionPerformed

    public int numberOfHospitalNames(){
        return c_h.List_Size_();
    }
    public void getAllHospitalNames(){
        for(int c=0;c<numberOfHospitalNames();c++){
            String name=c_h.getAllHospitalNames().get(c);
            option_hospitalName.addItem(name);
        }
    }
    public String getHospitalName(){
        hospital_Name=(String)option_hospitalName.getSelectedItem();
        return this.hospital_Name;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox option_hospitalName;
    // End of variables declaration//GEN-END:variables
}
