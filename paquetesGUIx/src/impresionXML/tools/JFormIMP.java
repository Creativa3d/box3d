package impresionXML.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import javax.swing.*;
import java.awt.*;

import utiles.JConversiones;
import utiles.JDepuracion;

public class JFormIMP extends javax.swing.JDialog {
    public static final int mclVistaPreliminar=0;
    public static final int mclPDF=1;
    public static final int mclRTF=2;
    public static final int mclImpresionDirecta=3;
    
    private InputStream moDatos;
    private InputStream moInforme;
    
    private InputStream moXSLFO;
    
    /** Creates new form JFormIMP */
    public JFormIMP(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        cmbDestino.borrarTodo();
        cmbDestino.addLinea("Vista preliminar",String.valueOf(mclVistaPreliminar));
        cmbDestino.addLinea("Fichero PDF",String.valueOf(mclPDF));
        cmbDestino.addLinea("Fichero RTF",String.valueOf(mclRTF));
        cmbDestino.addLinea("Impresión directa",String.valueOf(mclImpresionDirecta));
        
    }
    
    public void setDatos(InputStream poXSLFO) {
        moXSLFO = poXSLFO;
    }

    public void setDatos(InputStream poDatos, InputStream poInforme) throws Exception {
        moDatos=poDatos;
        moInforme=poInforme;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDestino = new utilesGUIx.JComboBoxCZ();
        lblFinca1 = new javax.swing.JLabel();
        txtCamino = new utilesGUIx.JTextFieldCZ();
        btnBuscar = new utilesGUIx.JButtonCZ();
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new utilesGUIx.JButtonCZ();
        btnCancelar = new utilesGUIx.JButtonCZ();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Destino"));
        jLabel1.setText("Destino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        cmbDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel2.add(cmbDestino, gridBagConstraints);

        lblFinca1.setText("Camino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel2.add(lblFinca1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel2.add(txtCamino, gridBagConstraints);

        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        jPanel2.add(btnBuscar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/accept.gif")));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jPanel1.add(btnAceptar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/cancel.gif")));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.add(btnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-405)/2, (screenSize.height-168)/2, 405, 168);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        File loFile = null;
        try{
            JFileChooser loFileM = new JFileChooser();
            if(loFileM.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                loFile = loFileM.getSelectedFile();
                txtCamino.setText(loFile.getAbsolutePath());
            }
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private File getFile(){
        return new File(txtCamino.getText());
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            
            int llTipo = (int)JConversiones.cdbl(cmbDestino.getFilaActual().msCampo(0));
            
            JVistaPreliminar loVista = new JVistaPreliminar();
            
            if(llTipo == mclVistaPreliminar){
                if(moXSLFO==null){
                    loVista.vistaPreliminar(moDatos, moInforme);
                }else{
                    loVista.vistaPreliminar(moXSLFO);
                }
            }else{
                java.io.InputStream loin;
                OutputStream loOut;
                if(moXSLFO!=null){
                    loin=moXSLFO;
                }else{
                    File loFile = new File("/tmp");
                    loFile.mkdirs();
                    loFile = new File("/tmp/TmpFo.fo");
                    loOut = new FileOutputStream(loFile);
                    try{
                        loVista.transformarAFo(
                                moDatos,
                                moInforme, loOut);
                    }finally{
                        loOut.close();
                    }

                    loin = new java.io.FileInputStream(loFile);
                }
                try{
                    if(llTipo==mclPDF){
                        loOut = new FileOutputStream(getFile());
                        loVista.transformarAPDF(loin, loOut);
                        utilesGUIx.msgbox.JMsgBox.mensajeInformacion(new java.awt.Frame(),"Documento generado");
                    }else{
                        if(llTipo == mclImpresionDirecta){
                            loVista.impresionDirecta(loin);
                        }else{
                            loVista.transformarARTF(loin, getFile());
                            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(new java.awt.Frame(),"Documento generado");
                        }
                    }
                        
                }finally{
                    loin.close();
                }
            }
            
            dispose();
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ btnAceptar;
    private utilesGUIx.JButtonCZ btnBuscar;
    private utilesGUIx.JButtonCZ btnCancelar;
    private utilesGUIx.JComboBoxCZ cmbDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFinca1;
    private utilesGUIx.JTextFieldCZ txtCamino;
    // End of variables declaration//GEN-END:variables
    
}
