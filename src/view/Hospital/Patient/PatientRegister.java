/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.Hospital.Patient;


import control.Hospital.ControllerPatient;
import control.Hospital.ControllerRoom;
import control.Hospital.ControllerSucursal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Caracteristics.Patient;
import view.Hospital.Sucursal.Sucursal;

/**
 *
 * @author Oscar
 */
public class PatientRegister extends javax.swing.JFrame {

    /**
     * Creates new form PatientRegister
     */
    
    
    
    private  ControllerRoom controlRoom;
    private  ControllerPatient controlPatient;
    private  ControllerSucursal controlSucursal;
    
    
    public String name;
    public String address;
    
    public PatientRegister(String name,String address) {
        initComponents();
        this.name=name;
        this.address=address;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
        
        controlRoom=new ControllerRoom();
        controlPatient=new ControllerPatient();
        controlSucursal=new ControllerSucursal();
        
        this.addOptionsSex();
        this.getRooms();
        
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,2000);
        cal.set(Calendar.MONTH, 01);
        cal.set(Calendar.DATE, 01);
        dateFecha.setCalendar(cal);
        
        
        lblName.setText(name);
        lblAddress.setText(address);
    }

    private PatientRegister() {
       
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtRegistration = new javax.swing.JTextField();
        txtBedNumber = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbRoom = new javax.swing.JComboBox();
        dateFecha = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        cmbSex = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("CI:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Dirección:");

        jLabel7.setText("Registro:");

        jLabel8.setText("Numero de Cama:");

        jLabel9.setText("Sexo:");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        txtRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistrationActionPerformed(evt);
            }
        });

        btnRegister.setText("Registrar Paciente");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel10.setText("Cuarto:");

        dateFecha.setDateFormatString("yyyy-MM-dd");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Sucursal:");

        jLabel12.setText("Direccion:");

        lblName.setText("X");

        lblAddress.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName)
                                    .addComponent(txtLastName)
                                    .addComponent(txtID)
                                    .addComponent(txtAddress)
                                    .addComponent(txtRegistration)
                                    .addComponent(txtBedNumber)
                                    .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnRegister)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblAddress))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBedNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistrationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistrationActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        int ci;
        int registration_number;
        int bedNumber;
        int idRoom;
        try {
            String sucursalName=name;
            
            String name=txtName.getText()+" "+txtLastName.getText();
            String address=txtAddress.getText();
            
            char sex=giveOption(String.valueOf(cmbSex.getSelectedItem()));
            String room=String.valueOf(cmbRoom.getSelectedItem());
            
            Date date=dateSelected();
            
            ci=Integer.parseInt(txtID.getText());
            registration_number=Integer.parseInt(txtRegistration.getText());
            bedNumber=Integer.parseInt(txtBedNumber.getText());
            idRoom=controlRoom.getIdRoom(sucursalName, room);
            Patient p=new Patient(idRoom, ci, registration_number, name, bedNumber, address, date, sex);
            controlPatient.patient_inserted(p);
            JOptionPane.showMessageDialog(this, "Paciente ha sido registrado a la habitacion");
        } catch (Exception e) {
            ci=0;
            registration_number=0;
            bedNumber=0;
            idRoom=0;
            JOptionPane.showMessageDialog(this, "Ingreso mal los datos");
        }/*
            String sucursalName=name;
            String name=txtName.getText();
            String lastname=txtLastName.getText();
            String fullName=name+" "+lastname;
            
            String address=txtAddress.getText();
            char sex=giveOption(String.valueOf(cmbSex.getSelectedItem()));
            
            String room=String.valueOf(cmbRoom.getSelectedItem());
            Date date=dateSelected();
            
            int idRoom=controlRoom.getIdRoom(sucursalName, room);
            
            Patient p=new Patient(idRoom, ci, registration_number, fullName, bedNumber, address, date, sex);
            if(controlPatient.validate_patient(p) || room.equals("--") || cmbSex.equals("Escoja una opcion")){
                controlPatient.patient_inserted(p);
                JOptionPane.showMessageDialog(this, "Paciente ha sido registrado a la habitacion");
            }else{
                JOptionPane.showMessageDialog(this, "Ingreso mal los datos...");
            }
        */
            vaciarCampos();
            
        /*Date date=new Date();
        DateFormat var=new SimpleDateFormat("yyyy-MM-dd");
        date=dateFecha.getDate();
        String aux_date=var.format(date);
        */
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Sucursal m=new Sucursal(name,address);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    public char giveOption(String x){
        char res = 0;
        switch(x){
            case "Masculino":
                res='M';
                break;
            case "Femenino":
                res='F';
                break;
                
        }
        return res;
    }
    public void vaciarCampos(){
        txtName.setText("");
        txtLastName.setText("");
        txtID.setText("");
        txtAddress.setText("");
        dateFecha.setDate(null);
        txtRegistration.setText("");
        txtBedNumber.setText("");
        cmbRoom.setSelectedIndex(0);
        cmbSex.setSelectedIndex(0);
    }
    public Date dateSelected(){
        Date date=new Date();
        
        date=dateFecha.getDate();
        return date;
    }
    
    public void getRooms(){
        cmbRoom.addItem("--");
        int numberOfRooms=controlSucursal.getRooms(name).size();
        ArrayList<String> rooms=controlSucursal.getRooms(name);
        for(int c=0;c<numberOfRooms;c++){
            cmbRoom.addItem(rooms.get(c));
        }
    }
    
    public void addOptionsSex(){
        cmbSex.addItem("Escoja una opcion");
        cmbSex.addItem("Masculino");
        cmbSex.addItem("Femenino");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientRegister().setVisible(true);
            }
        });
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox cmbRoom;
    private javax.swing.JComboBox cmbSex;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBedNumber;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRegistration;
    // End of variables declaration//GEN-END:variables
}
