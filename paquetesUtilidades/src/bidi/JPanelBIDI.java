/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidi;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utiles.JConversiones;
import utilesGUIx.imgTrata.JIMGTrata;
import utilesGUIx.msgbox.JMsgBox;

/**
 *
 * @author eduardo
 */
public class JPanelBIDI extends javax.swing.JPanel {

    /**
     * Creates new form JPanelBIDI
     */
    public JPanelBIDI() {
        initComponents();
    }

    private Image getImage(){
        return JBarCodeUTIL.getQR(txtTexto.getText()
                , (int)(JConversiones.cdbl(txtAncho.getText()) *2.54*72.0)
                , (int)(JConversiones.cdbl(txtAncho.getText()) *2.54*72.0));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabelCZ1 = new utilesGUIx.JLabelCZ();
        txtTexto = new utilesGUIx.JTextFieldCZ();
        jLabelCZ2 = new utilesGUIx.JLabelCZ();
        txtAncho = new utilesGUIx.JTextFieldCZ();
        jLabelCZ3 = new utilesGUIx.JLabelCZ();
        txtAlto = new utilesGUIx.JTextFieldCZ();
        btnRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabelCZ1.setText("Texto");
        jPanel2.add(jLabelCZ1, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(txtTexto, gridBagConstraints);

        jLabelCZ2.setText("Ancho");
        jPanel2.add(jLabelCZ2, new java.awt.GridBagConstraints());

        txtAncho.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        jPanel2.add(txtAncho, gridBagConstraints);

        jLabelCZ3.setText("Alto");
        jPanel2.add(jLabelCZ3, new java.awt.GridBagConstraints());

        txtAlto.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        jPanel2.add(txtAlto, gridBagConstraints);

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefrescar, new java.awt.GridBagConstraints());

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
        add(jLabel1, java.awt.BorderLayout.CENTER);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        jLabel1.setIcon(new ImageIcon(getImage()));
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        JFileChooser loFileC = new JFileChooser();
        
        int val = loFileC.showSaveDialog(this);
//        loFileC.setFileFilter(new utilesGUIx.seleccionFicheros.JFileChooserFiltroPorExtension("tiff", "tiff"));
        if(val == loFileC.APPROVE_OPTION) {
            try {
                JIMGTrata.getIMGTrata().guardarImagenTIFF(
                        JIMGTrata.getIMGTrata().getBufferedImage(new ImageIcon(getImage()))
                        , loFileC.getSelectedFile().getAbsolutePath()
                );
            } catch (Exception ex) {
                JMsgBox.mensajeErrorYLog(this, ex);
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JLabel jLabel1;
    private utilesGUIx.JLabelCZ jLabelCZ1;
    private utilesGUIx.JLabelCZ jLabelCZ2;
    private utilesGUIx.JLabelCZ jLabelCZ3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private utilesGUIx.JTextFieldCZ txtAlto;
    private utilesGUIx.JTextFieldCZ txtAncho;
    private utilesGUIx.JTextFieldCZ txtTexto;
    // End of variables declaration//GEN-END:variables
}
