/*
 * JFormTrozear.java
 *
 * Created on 29 de abril de 2005, 9:46
 */

package trozearImages;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

public class JFormTrozear extends javax.swing.JFrame {
    
    /** Creates new form JFormTrozear */
    public JFormTrozear() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtY = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtResolX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtResolY = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTrozoX = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTrozoY = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtArchivo = new javax.swing.JTextField();
        btnExplorar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtArchivo1 = new javax.swing.JTextField();
        btnExplorar1 = new javax.swing.JButton();
        btnTrozear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trocear imagen");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel2, gridBagConstraints);

        txtX.setText("666843");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtX, gridBagConstraints);

        jLabel3.setText("Y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel3, gridBagConstraints);

        txtY.setText("4194018");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtY, gridBagConstraints);

        jLabel5.setText("Resoluci�n X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel5, gridBagConstraints);

        txtResolX.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtResolX, gridBagConstraints);

        jLabel4.setText("Resolucin Y");
        jPanel1.add(jLabel4, new java.awt.GridBagConstraints());

        txtResolY.setText("-1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtResolY, gridBagConstraints);

        jLabel7.setText("Trozo X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel7, gridBagConstraints);

        txtTrozoX.setText("1000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtTrozoX, gridBagConstraints);

        jLabel8.setText("Trozo Y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel8, gridBagConstraints);

        txtTrozoY.setText("1000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtTrozoY, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setText("Fichero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jLabel1, gridBagConstraints);

        txtArchivo.setText("/mnt/win_d/Desarrollo/java/zonasVerdes/servidorZonasVerdes/mapa/H0934-III-IV.jpg");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(txtArchivo, gridBagConstraints);

        btnExplorar.setText("Explorar");
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        getContentPane().add(btnExplorar, gridBagConstraints);

        jLabel6.setText("Fichero sin extensi�n");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jLabel6, gridBagConstraints);

        txtArchivo1.setText("/mnt/win_d/Desarrollo/java/zonasVerdes/servidorZonasVerdes/mapa/H0934-III-IV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(txtArchivo1, gridBagConstraints);

        btnExplorar1.setText("Explorar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        getContentPane().add(btnExplorar1, gridBagConstraints);

        btnTrozear.setText("trocear");
        btnTrozear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrozearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        getContentPane().add(btnTrozear, gridBagConstraints);

        setSize(new java.awt.Dimension(577, 175));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplorarActionPerformed

        try{
            //FileDialog loFileM = new FileDialog(new java.awt.Frame(), "Seleccionar una imagen", FileDialog.LOAD);
            JFileChooser loFileM = new JFileChooser();
            loFileM.setCurrentDirectory(new File(txtArchivo.getText()));
            if(loFileM.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String lsPath = loFileM.getSelectedFile().getPath();
                txtArchivo.setText(lsPath);
                txtArchivo1.setText(lsPath.substring(0,lsPath.length()-4));
                
                File loFile = new File(txtArchivo1.getText() + ".jgw");
                if(loFile.exists()){
                    BufferedReader dis = new BufferedReader(new FileReader(loFile));
                    String lsLinea = dis.readLine().trim();
                    txtResolX.setText(lsLinea);
                    lsLinea = dis.readLine().trim();
                    lsLinea = dis.readLine().trim();
                    lsLinea = dis.readLine().trim();
                    txtResolY.setText(lsLinea);
                    lsLinea = dis.readLine().trim();
                    txtX.setText(lsLinea);
                    lsLinea = dis.readLine().trim();
                    txtY.setText(lsLinea);
                }
                
            }
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
        
    }//GEN-LAST:event_btnExplorarActionPerformed

    private void btnTrozearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrozearActionPerformed

        try{
            Image loImage = getToolkit().getImage(txtArchivo.getText());
            MediaTracker loMedia = new MediaTracker(this);
            loMedia.addImage(loImage, 0);
            loMedia.waitForAll();

            JTrozear loTrozear = new JTrozear();
            loTrozear.trozear(loImage, txtArchivo1.getText(), 
                Integer.valueOf(txtTrozoX.getText()).intValue(), 
                Integer.valueOf(txtTrozoY.getText()).intValue(), 
                Double.valueOf(txtX.getText()).doubleValue(),
                Double.valueOf(txtY.getText()).doubleValue(),
                Double.valueOf(txtResolX.getText()).doubleValue(),
                Double.valueOf(txtResolY.getText()).doubleValue()
                );
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this, "Proceso terminado");
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_btnTrozearActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new JFormTrozear().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnExplorar1;
    private javax.swing.JButton btnTrozear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JTextField txtArchivo1;
    private javax.swing.JTextField txtResolX;
    private javax.swing.JTextField txtResolY;
    private javax.swing.JTextField txtTrozoX;
    private javax.swing.JTextField txtTrozoY;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
    
}
