/*
 * JFormMetaGenerador.java
 *
 * Created on 22 de enero de 2006, 16:44
 */

package generadorClases;

import java.io.*;
import generadorClases.modulosCodigo.*;

/**
 *
 * @author  Administrador
 */
public class JFormMetaGenerador extends javax.swing.JFrame {
    
    private File moPathProyecto;
    private File moEntrada;
    private String msRutaArchivo;
    
    /** Creates new form JFormMetaGenerador */
    public JFormMetaGenerador() {
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

        jFC = new javax.swing.JFileChooser();
        jLabel5 = new javax.swing.JLabel();
        txtFichero = new javax.swing.JTextField();
        btnPath = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCodigo = new utilesGUIx.JTextAreaCZ();
        btnGen = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generador de modulos de codigo");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Archivo de Entrada");
        getContentPane().add(jLabel5, new java.awt.GridBagConstraints());

        txtFichero.setMinimumSize(new java.awt.Dimension(200, 20));
        txtFichero.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtFichero, gridBagConstraints);

        btnPath.setText("...");
        btnPath.setMaximumSize(new java.awt.Dimension(20, 23));
        btnPath.setMinimumSize(new java.awt.Dimension(20, 23));
        btnPath.setPreferredSize(new java.awt.Dimension(20, 23));
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });
        getContentPane().add(btnPath, new java.awt.GridBagConstraints());

        jTextCodigo.setColumns(20);
        jTextCodigo.setRows(5);
        jScrollPane1.setViewportView(jTextCodigo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnGen.setText("Generar Codigo");
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        getContentPane().add(btnGen, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        JMetaGenerador loMetaGen;
        try {
            loMetaGen = new JMetaGenerador(moPathProyecto);
            jTextCodigo.setText(loMetaGen.getCodigo());            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGenActionPerformed

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
//Seleccionamos el directorio de trabajo
        int val;
        
        val = jFC.showOpenDialog(this);
        if(val == jFC.APPROVE_OPTION) {
            moPathProyecto = jFC.getSelectedFile();
            txtFichero.setText(moPathProyecto.getAbsolutePath());
            msRutaArchivo = txtFichero.getText();
        }
    }//GEN-LAST:event_btnPathActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFormMetaGenerador().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnPath;
    private javax.swing.JFileChooser jFC;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilesGUIx.JTextAreaCZ jTextCodigo;
    private javax.swing.JTextField txtFichero;
    // End of variables declaration//GEN-END:variables
    
}