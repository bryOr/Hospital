/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.Hospital.Sucursal;

import view.Hospital.Sucursal.Sucursal;
import control.Hospital.ControllerSucursal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author master
 */
public class SucursalFinder extends javax.swing.JFrame {

    /**
     * Creates new form SucursalFinder
     */
    private ControllerSucursal ctrlS;
    
   
    public SucursalFinder() {
        initComponents();
        
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/Sucursals.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(imagen);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ctrlS=new ControllerSucursal();
        
        generateInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabSucursals = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblInfo.setText("Haga Clic en alguna Sucursal que quiera administrar:");

        tabSucursals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabSucursals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabSucursalsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabSucursals);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInfo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabSucursalsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSucursalsMouseClicked
        // TODO add your handling code here:
        int opcion=this.tabSucursals.getSelectedRow();
        
        String name=this.tabSucursals.getValueAt(opcion, 1).toString();
        String address=this.tabSucursals.getValueAt(opcion, 2).toString();
        
        Sucursal s=new Sucursal(name,address);
        s.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_tabSucursalsMouseClicked

    
    public void generateInfo(){
        String[] columnas={"#","Nombre","Direccion"};
        Object[][] info=ctrlS.getSucursalInformation();
        DefaultTableModel table=new DefaultTableModel(info, columnas){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        };
        this.tabSucursals.setModel(table);
        modifyTableStructure();
    }
    public void modifyTableStructure(){
        TableColumnModel column=tabSucursals.getColumnModel();
        column.getColumn(0).setPreferredWidth(2);
        
        DefaultTableCellRenderer t=new DefaultTableCellRenderer();
        t.setHorizontalAlignment(SwingConstants.CENTER);
        for(int c=0;c<3;c++){
            tabSucursals.getColumnModel().getColumn(c).setCellRenderer(t);
        }
        tabSucursals.setShowHorizontalLines(false);
        tabSucursals.setShowVerticalLines(false);
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
            java.util.logging.Logger.getLogger(SucursalFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SucursalFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SucursalFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SucursalFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SucursalFinder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tabSucursals;
    // End of variables declaration//GEN-END:variables
}