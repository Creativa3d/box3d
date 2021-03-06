/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * JPanelOpcionesSMS.java
 *
 * Created on 27-oct-2011, 10:36:08
 */
package utilesGUIxAvisos.avisos.forms;

import ListDatos.JFilaDatosDefecto;
import utilesGUIx.Rectangulo;
import ListDatos.JSTabla;
import java.util.Map;

import utilesGUI.tiposTextos.JTipoTextoEstandar;

import utilesGUIx.formsGenericos.edicion.JPanelGENERALBASE;
import utilesGUIxAvisos.avisos.JGUIxAvisosDatosGenerales;

/**
 *
 * @author eduardo
 */
public class JPanelOpcionesSMS extends JPanelGENERALBASE {

    private JGUIxAvisosDatosGenerales moDatos;
    private boolean mbDesactivarEventos = false;

    /**
     * Creates new form JPanelOpcionesGenerales
     */
    public JPanelOpcionesSMS() {
        initComponents();
    }

    public void setDatos(JGUIxAvisosDatosGenerales poDatos) {
        moDatos = poDatos;
    }

    @Override
    public JSTabla getTabla() {
        return null;
    }

    @Override
    public void rellenarPantalla() throws Exception {
        mbDesactivarEventos = true;
        try {
            Map<String, String> loMap = moDatos.getClientesDisponibles();
            cmbSMSTipo.borrarTodo();
            for (String lsClase : loMap.keySet()) {
                cmbSMSTipo.addLinea(loMap.get(lsClase), lsClase + JFilaDatosDefecto.mcsSeparacion1);
            }
        } finally {
            mbDesactivarEventos = false;
        }
    }

    @Override
    public void habilitarSegunEdicion() throws Exception {
    }

    @Override
    public void ponerTipoTextos() throws Exception {
        txtSMSLICENCIA.setTipo(JTipoTextoEstandar.mclTextCadena);
        txtSMSUSUARIO.setTipo(JTipoTextoEstandar.mclTextCadena);
    }

    @Override
    public void mostrarDatos() throws Exception {
        mbDesactivarEventos = true;
        try {
            cmbSMSTipo.setValueTabla(moDatos.getSMSTipo() + JFilaDatosDefecto.mcsSeparacion1);
            txtSMSCLAVE.setText(moDatos.getSMS().getSMSClave());
            txtSMSLICENCIA.setText(moDatos.getSMS().getSMSLicencia());
            txtSMSUSUARIO.setText(moDatos.getSMS().getSMSUsuario());
        } finally {
            mbDesactivarEventos = false;
        }

    }

    public boolean validarDatos() throws Exception {
        return true;
    }

    public void establecerDatos() throws Exception {
        moDatos.setSMSTipo(cmbSMSTipo.getFilaActual().msCampo(0));
        moDatos.getSMS().setSMSClave(txtSMSCLAVE.getText());
        moDatos.getSMS().setSMSLicencia(txtSMSLICENCIA.getText());
        moDatos.getSMS().setSMSUsuario(txtSMSUSUARIO.getText());
    }

    @Override
    public void cancelar() throws Exception {
        moDatos.cancelar();
    }

    @Override
    public void aceptar() throws Exception {
        moDatos.aceptar();
    }

    @Override
    public Rectangulo getTanano() {
        return new Rectangulo(0, 0, 89, 45);
    }

    @Override
    public String getTitulo() {
        return "SMS";
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

        jPanel1 = new javax.swing.JPanel();
        jLabelCZ6 = new utilesGUIx.JLabelCZ();
        cmbSMSTipo = new utilesGUIx.JComboBoxCZ();
        jLabelCZ3 = new utilesGUIx.JLabelCZ();
        txtSMSLICENCIA = new utilesGUIx.JTextFieldCZ();
        jLabelCZ4 = new utilesGUIx.JLabelCZ();
        txtSMSUSUARIO = new utilesGUIx.JTextFieldCZ();
        jLabelCZ5 = new utilesGUIx.JLabelCZ();
        txtSMSCLAVE = new javax.swing.JPasswordField();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SMS"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelCZ6.setText("Cliente SMS:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(jLabelCZ6, gridBagConstraints);

        cmbSMSTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSMSTipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(cmbSMSTipo, gridBagConstraints);

        jLabelCZ3.setText("N�mero de serie:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(jLabelCZ3, gridBagConstraints);

        txtSMSLICENCIA.setMinimumSize(new java.awt.Dimension(100, 19));
        txtSMSLICENCIA.setPreferredSize(new java.awt.Dimension(120, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(txtSMSLICENCIA, gridBagConstraints);

        jLabelCZ4.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(jLabelCZ4, gridBagConstraints);

        txtSMSUSUARIO.setMinimumSize(new java.awt.Dimension(100, 19));
        txtSMSUSUARIO.setPreferredSize(new java.awt.Dimension(120, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(txtSMSUSUARIO, gridBagConstraints);

        jLabelCZ5.setText("Clave:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(jLabelCZ5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 0);
        jPanel1.add(txtSMSCLAVE, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSMSTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSMSTipoActionPerformed
        if (!mbDesactivarEventos) {
            moDatos.setSMSTipo(cmbSMSTipo.getFilaActual().msCampo(0));
        }

    }//GEN-LAST:event_cmbSMSTipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JComboBoxCZ cmbSMSTipo;
    private utilesGUIx.JLabelCZ jLabelCZ3;
    private utilesGUIx.JLabelCZ jLabelCZ4;
    private utilesGUIx.JLabelCZ jLabelCZ5;
    private utilesGUIx.JLabelCZ jLabelCZ6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtSMSCLAVE;
    private utilesGUIx.JTextFieldCZ txtSMSLICENCIA;
    private utilesGUIx.JTextFieldCZ txtSMSUSUARIO;
    // End of variables declaration//GEN-END:variables
}
