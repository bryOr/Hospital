/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.Hospital.Medic;

import control.Hospital.ControllerMedic;
import control.Hospital.ControllerPatient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Caracteristics.Diagnosis;
import model.Caracteristics.Visit;

/**
 *
 * @author master
 */
public class Historial extends javax.swing.JFrame {

    /**
     * Creates new form HistorialMedico
     */
    public String doctorName;
    
    private ControllerPatient ctrlP;
    private ControllerMedic ctrlM;
    public Historial(String doctorName) {
        initComponents();
        
        ctrlP=new ControllerPatient();
        ctrlM=new ControllerMedic();
        this.doctorName=doctorName;
        lblDoctorName.setText(doctorName);
        txtPatientName.setEnabled(false);
        textDiagnosis.setLineWrap(true);
        txtComplications.setLineWrap(true);
        
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, 01);
        cal.set(Calendar.DATE, 01);
        dateAtenttion.setCalendar(cal);
        
        showDiagnosis();
        
        this.cmbDiagnosisType.setEnabled(false);
        this.txtComplications.setEnabled(false);
        this.btnReg.setEnabled(false);
    }

    private Historial() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPatient = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateAtenttion = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDiagnosis = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabData = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        cmbDiagnosisType = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComplications = new javax.swing.JTextArea();
        btnReg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("SELECCION DE PACIENTE PARA PODER REGISTRAR LA ATENCION MEDICA:");

        listPatient.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        listPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPatientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPatient);

        jLabel4.setText("Nombre del Paciente:");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastNameKeyPressed(evt);
            }
        });

        jLabel5.setText("PACIENTES:");

        jLabel6.setText("Fecha de Atencion:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonAgregar.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Paciente:");

        txtPatientName.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setText("DIAGNOSTICO:");

        textDiagnosis.setColumns(20);
        textDiagnosis.setRows(5);
        jScrollPane2.setViewportView(textDiagnosis);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateAtenttion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(dateAtenttion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Atencion", jPanel1);

        tabData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabData.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tabDataMouseMoved(evt);
            }
        });
        tabData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabData);

        jLabel8.setText("Nombre Paciente:");

        txtFullName.setName(""); // NOI18N
        txtFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFullNameKeyPressed(evt);
            }
        });

        cmbDiagnosisType.setName("cmbDiagnosisType"); // NOI18N
        cmbDiagnosisType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiagnosisTypeActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo de Diagnistico:");

        jLabel10.setText("Complicaciones:");

        txtComplications.setColumns(20);
        txtComplications.setRows(5);
        jScrollPane4.setViewportView(txtComplications);

        btnReg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diagnostico.png"))); // NOI18N
        btnReg.setText("CONFIRMAR DIAGNOSTICO");
        btnReg.setBorder(null);
        btnReg.setBorderPainted(false);
        btnReg.setContentAreaFilled(false);
        btnReg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cmbDiagnosisType, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbDiagnosisType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReg)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Diagnostico", jPanel2);

        jLabel1.setText("MEDICO:");

        lblDoctorName.setText("x");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDoctorName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyPressed
        // TODO add your handling code here:
        String lastname=txtLastName.getText();
        boolean flag=ctrlP.verifyPatientName(lastname);
        if(!flag){
            JOptionPane.showMessageDialog(this, "No incluya numeros en este campo de texto");
            txtLastName.setText("");
        }else{
            DefaultListModel list=new DefaultListModel();
            ArrayList<String> lastnameList=ctrlP.getPatients(lastname);
            for(int c=0;c<lastnameList.size();c++){
                list.addElement(lastnameList.get(c));
            }
            listPatient.setModel(list);
            
            
        }
        
        
        
    }//GEN-LAST:event_txtLastNameKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtLastName.setText("");
        txtPatientName.setText("");
        
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, 01);
        c.set(Calendar.DATE, 01);
        dateAtenttion.setCalendar(c);
        
        DefaultListModel emptyList=new DefaultListModel();
        listPatient.setModel(emptyList);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void listPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPatientMouseClicked
        // TODO add your handling code here:
        String patient=listPatient.getSelectedValue().toString();
        txtPatientName.setText(patient);
    }//GEN-LAST:event_listPatientMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id_P=ctrlP.obtainID(txtPatientName.getText());
        int id_D=ctrlM.obtainID(lblDoctorName.getText());
        Date date=new Date();
        date=dateAtenttion.getDate();
        String diagnosis=textDiagnosis.getText();
        
        Visit v=new Visit(id_P, id_D, date,diagnosis);
        ctrlM.takeVisit(v);
        JOptionPane.showMessageDialog(this, "Atencion Registrada");
        vaciarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MedicList ml=new MedicList();
        ml.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        int id_D=ctrlM.obtainID(lblDoctorName.getText());
        String diagnosisType=cmbDiagnosisType.getSelectedItem().toString();
        String complication=txtComplications.getText();
        
        Calendar aux1=new GregorianCalendar();
        int year=aux1.get(Calendar.YEAR);
        int month=aux1.get(Calendar.MONTH);
        int day=aux1.get(Calendar.DATE);
        Date date_=new Date();
        aux1.setTime(date_);
        
        Diagnosis d=new Diagnosis(id_D, complication, diagnosisType, date_);
        boolean band=ctrlM.addDiagnosis(d); 
        if(band){
            System.out.println(id_D+" "+diagnosisType+" "+complication+" "+date_);
            JOptionPane.showMessageDialog(this, "Diagnostico Confirmado");
        }else{
            JOptionPane.showMessageDialog(this, "Verifique su informacion nuevamente.");
        }
    }//GEN-LAST:event_btnRegActionPerformed

    private void cmbDiagnosisTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiagnosisTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDiagnosisTypeActionPerformed

    private void txtFullNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullNameKeyPressed
        // TODO add your handling code here:
        String fullName=txtFullName.getText();
        Object[][] res=ctrlP.obtainInformation(fullName);
        String titles[]={"Persona","Diagnostico"};
        DefaultTableModel newTable=new DefaultTableModel(res,titles){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tabData.setModel(newTable);
        configureTable();
    }//GEN-LAST:event_txtFullNameKeyPressed

    private void tabDataMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDataMouseMoved
        // TODO add your handling code here:
        int rowIndex=tabData.rowAtPoint(evt.getPoint());
        int columnIndex=tabData.columnAtPoint(evt.getPoint());
        if(columnIndex==1){
            try{
                String info=tabData.getValueAt(rowIndex, columnIndex).toString();
                tabData.setToolTipText(info);
        
            }
            catch(Exception E){}
        }
    }//GEN-LAST:event_tabDataMouseMoved

    private void tabDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDataMouseClicked
        // TODO add your handling code here:
        this.cmbDiagnosisType.setEnabled(true);
        this.txtComplications.setEnabled(true);
        this.btnReg.setEnabled(true);
    }//GEN-LAST:event_tabDataMouseClicked

    
    public void configureTable(){
        TableColumnModel newTab=tabData.getColumnModel();
        
        newTab.getColumn(0).setPreferredWidth(2);
        
        tabData.setShowHorizontalLines(false);
        //tabData.setShowVerticalLines(false);
        
        
    }
    public void showDiagnosis(){
        String diagnosis[]={"Seleccionar","Generico","Nosologico","Patogenetico","Lesional, anatomico o topografico",
                            "Sintomatico","Sindromico y Funcional","Individual o clinico","Diferencial","Presuntivo","Certeza"};
        for(String d: diagnosis){
            cmbDiagnosisType.addItem(d);
        }
        
    }
    public void vaciarCampos(){
        txtPatientName.setText("");
        txtLastName.setText("");
        DefaultListModel emptyList=new DefaultListModel();
        listPatient.setModel(emptyList);
        dateAtenttion.setDate(null);
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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReg;
    private javax.swing.JComboBox cmbDiagnosisType;
    private com.toedter.calendar.JDateChooser dateAtenttion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JList listPatient;
    private javax.swing.JTable tabData;
    private javax.swing.JTextArea textDiagnosis;
    private javax.swing.JTextArea txtComplications;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables
}
