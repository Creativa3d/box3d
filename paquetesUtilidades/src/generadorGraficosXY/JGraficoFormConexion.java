/*
 * JFormConexion.java
 *
 * Created on 5 de agosto de 2005, 18:10
 */

package generadorGraficosXY;

import utilesBD.estructuraBD.JConstructorEstructuraBDConnection;

import java.sql.*;

public class JGraficoFormConexion extends javax.swing.JDialog {
    private JGraficoForm moForm;
    private String msClase = "net.sourceforge.jtds.jdbc.Driver";
    private String msURL = "jdbc:jtds:sqlserver://172.16.0.6/supermercado;user=eduardo;password=eduardo;domain=EDUARDOWINDOWS;TDS=8.0";
    
    /**
     * Creates new form JFormConexion 
     */
    public JGraficoFormConexion(java.awt.Frame parent, boolean modal,JGraficoForm poForm) {
        super(parent, modal);
        moForm = poForm;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cmbBD = new javax.swing.JComboBox();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new utilesGUIx.JTextFieldCZ();
        lblPass = new javax.swing.JLabel();
        txtPassWord = new utilesGUIx.JTextFieldCZ();
        lblBD = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        lblNomBD = new javax.swing.JLabel();
        txtNomBD = new utilesGUIx.JTextFieldCZ();
        lblDominio = new javax.swing.JLabel();
        txtDominio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cmbBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Access", "PostGreSql", "Oracle", "SqlServer" }));
        cmbBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBDActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(cmbBD, gridBagConstraints);

        lblUsuario.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblUsuario, gridBagConstraints);

        txtUsuario.setText("eduardo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtUsuario, gridBagConstraints);

        lblPass.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblPass, gridBagConstraints);

        txtPassWord.setText("eduardo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtPassWord, gridBagConstraints);

        lblBD.setText("Base de Datos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblBD, gridBagConstraints);

        lblIP.setText("IP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblIP, gridBagConstraints);

        txtIP.setText("172.16.0.177");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtIP, gridBagConstraints);

        lblNomBD.setText("Nombre BD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(lblNomBD, gridBagConstraints);

        txtNomBD.setText("BDAServer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtNomBD, gridBagConstraints);

        lblDominio.setText("Dominio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(lblDominio, gridBagConstraints);

        txtDominio.setText("SERVIDOR_PPAL2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(txtDominio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(jPanel3, gridBagConstraints);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(btnAceptar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(btnCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel2, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-336)/2, (screenSize.height-178)/2, 336, 178);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBDActionPerformed
        //Actualizo las variables segun la selecci�n en el combo
        if(cmbBD.getSelectedItem().toString().compareTo("Access") == 0) {
            msClase = "sun.jdbc.odbc.JdbcOdbcDriver";
        }
        if(cmbBD.getSelectedItem().toString().compareTo("PostGreSql") == 0) {
            msClase = "org.postgresql.Driver";
        }
        if(cmbBD.getSelectedItem().toString().compareTo("Oracle") == 0) {
            msClase = "";
        }
        if(cmbBD.getSelectedItem().toString().compareTo("SqlServer") == 0) {
            msClase = "net.sourceforge.jtds.jdbc.Driver";
        }
    }//GEN-LAST:event_cmbBDActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Connection loConex = null;
        //Creamos la cadena URL
        if(cmbBD.getSelectedItem().toString().compareTo("Access") == 0) {
            msURL = "jdbc:odbc:" + txtNomBD.getText();
        }
        if(cmbBD.getSelectedItem().toString().compareTo("PostGreSql") == 0) {
            msURL = "jdbc:postgresql:" + "//" + txtIP.getText() + "/" + txtNomBD.getText() + "?user=" + txtUsuario.getText() + "&password=" + txtPassWord.getText();
        }
        if(cmbBD.getSelectedItem().toString().compareTo("Oracle") == 0) {
            msClase = "";
        }
        if(cmbBD.getSelectedItem().toString().compareTo("SqlServer") == 0) {
            msURL = "jdbc:jtds:sqlserver:" + "//" + txtIP.getText() + "/" + txtNomBD.getText() + ";user=" + txtUsuario.getText() + ";password=" + txtPassWord.getText() + ";domain=" + txtDominio.getText();
        }
        try{
            Class.forName(msClase);
            loConex = DriverManager.getConnection(msURL, txtUsuario.getText(), txtPassWord.getText());
            moForm.crearConexion(loConex);
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbBD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBD;
    private javax.swing.JLabel lblDominio;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblNomBD;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JTextField txtIP;
    private utilesGUIx.JTextFieldCZ txtNomBD;
    private utilesGUIx.JTextFieldCZ txtPassWord;
    private utilesGUIx.JTextFieldCZ txtUsuario;
    // End of variables declaration//GEN-END:variables
    
}
