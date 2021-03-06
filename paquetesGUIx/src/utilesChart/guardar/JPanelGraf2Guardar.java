/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilesChart.guardar;

import ListDatos.JFilaDatosDefecto;
import ListDatos.JSTabla;
import java.io.File;
import javax.swing.JFileChooser;
import utiles.JConversiones;
import utilesGUI.tiposTextos.JTipoTextoEstandar;
import utilesGUIx.Rectangulo;
import utilesGUIx.formsGenericos.edicion.JPanelGENERALBASE;
import utilesGUIx.seleccionFicheros.JFileChooserFiltroPorExtension;

/**
 * Pantalla para recoger parametros para el grafico XY
 * @author eduardo
 */
public class JPanelGraf2Guardar extends JPanelGENERALBASE {

    private JDatosGraf2Guardar moDatos;
    /**
     * Creates new form JPanelGraficosXYParam
     */
    public JPanelGraf2Guardar() {
        initComponents();
    }

    public void setDatos(JDatosGraf2Guardar poDatos) {
        moDatos=poDatos;
    }

    public String getTitulo() {
        return "Guardar";
    }

    public JSTabla getTabla(){
        return null;
    }

    public void rellenarPantalla() throws Exception {
        cmbProceso.borrarTodo();
        cmbProceso.addLinea("Guardar gr�fico", String.valueOf(JDatosGraf2Guardar.mclSimple) + JFilaDatosDefecto.mcsSeparacion1);
        cmbProceso.addLinea("Guardar series", String.valueOf(JDatosGraf2Guardar.mclSeries) + JFilaDatosDefecto.mcsSeparacion1);
        
        cmbDestino.borrarTodo();
        cmbDestino.addLinea("Guardar gr�fico", String.valueOf(JDatosGraf2Guardar.mclSimple) + JFilaDatosDefecto.mcsSeparacion1);
        cmbDestino.addLinea("Guardar series en directorio", String.valueOf(JDatosGraf2Guardar.mclDirectorio) + JFilaDatosDefecto.mcsSeparacion1);
        cmbDestino.addLinea("Guardar series en Word", String.valueOf(JDatosGraf2Guardar.mclWord) + JFilaDatosDefecto.mcsSeparacion1);
        
        
    }

    public void habilitarSegunEdicion() throws Exception {
    }

    public void ponerTipoTextos() throws Exception {
        txtAlto.setTipo(JTipoTextoEstandar.mclTextNumeroDoble);
        txtAncho.setTipo(JTipoTextoEstandar.mclTextNumeroDoble);
    }

    public void mostrarDatos() throws Exception {
        cmbProceso.setValueTabla(String.valueOf(moDatos.mlProceso) + JFilaDatosDefecto.mcsSeparacion1);
        cmbProcesoItemStateChanged(null);
        cmbDestino.setValueTabla(String.valueOf(moDatos.mlDestino) + JFilaDatosDefecto.mcsSeparacion1);
        
        txtAlto.setValueTabla(String.valueOf(moDatos.mdAlto));
        txtAncho.setValueTabla(String.valueOf(moDatos.mdAncho));
        txtRuta.setValueTabla(moDatos.msRuta);
        
    }

    public void establecerDatos() throws Exception {
        moDatos.mlDestino=(int)JConversiones.cdbl(cmbDestino.getFilaActual().msCampo(0));
        moDatos.mlProceso=(int)JConversiones.cdbl(cmbProceso.getFilaActual().msCampo(0));
        
        moDatos.mdAlto=JConversiones.cdbl(txtAlto.getText());
        moDatos.mdAncho=JConversiones.cdbl(txtAncho.getText());
        moDatos.msRuta=txtRuta.getText();
               
        moDatos.validar();
    }

    public void aceptar() throws Exception {
        moDatos.ejecutar();
    }

    public void cancelar() throws Exception {
    }
    
    public Rectangulo getTanano() {
        return new Rectangulo(600, 250);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabelCZ8 = new utilesGUIx.JLabelCZ();
        cmbProceso = new utilesGUIx.JComboBoxCZ();
        jPanel3 = new javax.swing.JPanel();
        jLabelCZ3 = new utilesGUIx.JLabelCZ();
        cmbDestino = new utilesGUIx.JComboBoxCZ();
        jPanelOpciones = new javax.swing.JPanel();
        jLabelCZ4 = new utilesGUIx.JLabelCZ();
        txtRuta = new utilesGUIx.JTextFieldCZ();
        btnSeleccionar = new utilesGUIx.JButtonCZ();
        jPanel5 = new javax.swing.JPanel();
        jLabelCZ5 = new utilesGUIx.JLabelCZ();
        txtAncho = new utilesGUIx.JTextFieldCZ();
        jLabelCZ6 = new utilesGUIx.JLabelCZ();
        txtAlto = new utilesGUIx.JTextFieldCZ();
        jLabelCZ7 = new utilesGUIx.JLabelCZ();
        jLabelCZ1 = new utilesGUIx.JLabelCZ();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabelCZ8.setText("Proceso");
        jLabelCZ8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCZ8.setMaximumSize(new java.awt.Dimension(89, 15));
        jLabelCZ8.setMinimumSize(new java.awt.Dimension(89, 15));
        jLabelCZ8.setPreferredSize(new java.awt.Dimension(89, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel4.add(jLabelCZ8, gridBagConstraints);

        cmbProceso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProcesoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel4.add(cmbProceso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel4, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabelCZ3.setText("Destino");
        jLabelCZ3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCZ3.setMaximumSize(new java.awt.Dimension(89, 15));
        jLabelCZ3.setMinimumSize(new java.awt.Dimension(89, 15));
        jLabelCZ3.setPreferredSize(new java.awt.Dimension(89, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel3.add(jLabelCZ3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel3.add(cmbDestino, gridBagConstraints);

        jPanelOpciones.setLayout(new java.awt.GridBagLayout());

        jLabelCZ4.setText("Ruta");
        jLabelCZ4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCZ4.setMaximumSize(new java.awt.Dimension(89, 15));
        jLabelCZ4.setMinimumSize(new java.awt.Dimension(89, 15));
        jLabelCZ4.setPreferredSize(new java.awt.Dimension(89, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelOpciones.add(jLabelCZ4, gridBagConstraints);

        txtRuta.setMinimumSize(new java.awt.Dimension(120, 19));
        txtRuta.setPreferredSize(new java.awt.Dimension(120, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanelOpciones.add(txtRuta, gridBagConstraints);

        btnSeleccionar.setText("...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        jPanelOpciones.add(btnSeleccionar, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabelCZ5.setText("Ancho");
        jLabelCZ5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCZ5.setMaximumSize(new java.awt.Dimension(89, 15));
        jLabelCZ5.setMinimumSize(new java.awt.Dimension(89, 15));
        jLabelCZ5.setPreferredSize(new java.awt.Dimension(89, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel5.add(jLabelCZ5, gridBagConstraints);

        txtAncho.setMinimumSize(new java.awt.Dimension(120, 19));
        txtAncho.setPreferredSize(new java.awt.Dimension(120, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel5.add(txtAncho, gridBagConstraints);

        jLabelCZ6.setText("Alto");
        jLabelCZ6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel5.add(jLabelCZ6, gridBagConstraints);

        txtAlto.setMinimumSize(new java.awt.Dimension(120, 19));
        txtAlto.setPreferredSize(new java.awt.Dimension(120, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel5.add(txtAlto, gridBagConstraints);

        jLabelCZ7.setText("   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jLabelCZ7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOpciones.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanelOpciones, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel3, gridBagConstraints);

        jLabelCZ1.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jLabelCZ1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser loCh = new JFileChooser();

        int lDest = (int)JConversiones.cdbl(cmbDestino.getFilaActual().msCampo(0));
        switch(lDest){
            case JDatosGraf2Guardar.mclFichero:
            loCh.setFileFilter(new JFileChooserFiltroPorExtension("png", "png"));
            break;
            case JDatosGraf2Guardar.mclWord:
            loCh.setFileFilter(new JFileChooserFiltroPorExtension("doc", new String[]{"doc", "docx"}));
            break;
            case JDatosGraf2Guardar.mclDirectorio:
            loCh.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            break;
        }
        if (loCh.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtRuta.setText(loCh.getSelectedFile().getAbsolutePath());
            String lsFile = loCh.getSelectedFile().getAbsolutePath();
            switch(lDest){
                case JDatosGraf2Guardar.mclSimple:
                if(lsFile.length()>4){
                    int lIndex = lsFile.lastIndexOf('.');
                    if(lIndex < 0){
                        lsFile=lsFile + "." + "png";
                    }
                }
                txtRuta.setText(lsFile);
                break;
                case JDatosGraf2Guardar.mclWord:
                if(lsFile.length()>4){
                    int lIndex = lsFile.lastIndexOf('.');
                    if(lIndex < 0){
                        lsFile=lsFile + "." + "doc";
                    }
                }
                txtRuta.setText(lsFile);
                break;
                case JDatosGraf2Guardar.mclDirectorio:
                if(!new File(lsFile).exists()){
                    new File(lsFile).mkdir();
                }
                break;
            }

        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void cmbProcesoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProcesoItemStateChanged
        cmbDestino.borrarTodo();

        if(cmbProceso.getFilaActual().msCampo(0).equals(String.valueOf(JDatosGraf2Guardar.mclSimple))){
            cmbDestino.addLinea("Guardar gr�fico", String.valueOf(JDatosGraf2Guardar.mclFichero) + JFilaDatosDefecto.mcsSeparacion1);
        }else{
            cmbDestino.addLinea("Guardar series en directorio", String.valueOf(JDatosGraf2Guardar.mclDirectorio) + JFilaDatosDefecto.mcsSeparacion1);
            cmbDestino.addLinea("Guardar series en Word", String.valueOf(JDatosGraf2Guardar.mclWord) + JFilaDatosDefecto.mcsSeparacion1);
        }
    }//GEN-LAST:event_cmbProcesoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private utilesGUIx.JComboBoxCZ cmbDestino;
    private utilesGUIx.JComboBoxCZ cmbProceso;
    private utilesGUIx.JLabelCZ jLabelCZ1;
    private utilesGUIx.JLabelCZ jLabelCZ3;
    private utilesGUIx.JLabelCZ jLabelCZ4;
    private utilesGUIx.JLabelCZ jLabelCZ5;
    private utilesGUIx.JLabelCZ jLabelCZ6;
    private utilesGUIx.JLabelCZ jLabelCZ7;
    private utilesGUIx.JLabelCZ jLabelCZ8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelOpciones;
    private utilesGUIx.JTextFieldCZ txtAlto;
    private utilesGUIx.JTextFieldCZ txtAncho;
    private utilesGUIx.JTextFieldCZ txtRuta;
    // End of variables declaration//GEN-END:variables


}
