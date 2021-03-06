/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilesGUIx.plugin.seguridad.visual;

import ListDatos.IResultado;
import ListDatos.JSTabla;
import java.awt.Rectangle;
import utilesGUIx.Rectangulo;
import utilesGUIx.formsGenericos.edicion.JPanelGENERALBASE;
import utilesGUIx.plugin.seguridad.IPlugInSeguridadRW;
import utilesGUIx.plugin.seguridad.JTPlugInUsuarios;

/**
 *
 * @author eduardo
 */
public class JPanelCambioPassWord extends JPanelGENERALBASE {
    private JTPlugInUsuarios moUsuarios;
    private IPlugInSeguridadRW moRW;
    /**
     * Creates new form JPanelCambioPassWord
     */
    public JPanelCambioPassWord() {
        initComponents();
    }
    
    public void setDatos(IPlugInSeguridadRW poRW, JTPlugInUsuarios poUsuario){
        moUsuarios=poUsuario;
        moRW=poRW;
    }

    @Override
    public JSTabla getTabla() {
        return moUsuarios;
    }


    public void rellenarPantalla() throws Exception {
    }
    
    public void habilitarSegunEdicion() throws Exception {
    }


    public void mostrarDatos() throws Exception {
    }

    public void establecerDatos() throws Exception {
        if(!txtCONFIRMARNUEVA.getText().equalsIgnoreCase(txtNUEVA.getText())){
            throw new Exception("La nueva contraseña y su confirmación no coincide");
        }
        if(!txtACTUAL.getText().equalsIgnoreCase(moUsuarios.getPASSWORD().getString())){
            throw new Exception("La contraseña actual es incorrecta");
        }
        moUsuarios.getPASSWORD().setValue(txtNUEVA.getText());
    }

    public void aceptar() throws Exception {
        IResultado loResult=moUsuarios.moList.update(false);
        moRW.guardarUsuario(moUsuarios.moList.moFila());
    }

    public String getTitulo() {
        return "Cambio contraseña";
    }

    public Rectangulo getTanano() {
        return new Rectangulo(450, 300);
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

        lblACTUAL1 = new utilesGUIx.JLabelCZ();
        lblACTUAL = new utilesGUIx.JLabelCZ();
        txtACTUAL = new javax.swing.JPasswordField();
        lblNUEVA = new utilesGUIx.JLabelCZ();
        txtNUEVA = new javax.swing.JPasswordField();
        lblCONFIRMARNUEVA = new utilesGUIx.JLabelCZ();
        txtCONFIRMARNUEVA = new javax.swing.JPasswordField();
        LBLrELLENO = new utilesGUIx.JLabelCZ();

        setLayout(new java.awt.GridBagLayout());

        lblACTUAL1.setBackground(new java.awt.Color(211, 234, 237));
        lblACTUAL1.setText("Cambio de contraseña");
        lblACTUAL1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblACTUAL1.setMaximumSize(new java.awt.Dimension(159, 25));
        lblACTUAL1.setMinimumSize(new java.awt.Dimension(159, 25));
        lblACTUAL1.setOpaque(true);
        lblACTUAL1.setPreferredSize(new java.awt.Dimension(159, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(lblACTUAL1, gridBagConstraints);

        lblACTUAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblACTUAL.setText("Contraseña actual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(lblACTUAL, gridBagConstraints);

        txtACTUAL.setBackground(new java.awt.Color(255, 255, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(txtACTUAL, gridBagConstraints);

        lblNUEVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNUEVA.setText("Nueva contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(lblNUEVA, gridBagConstraints);

        txtNUEVA.setBackground(new java.awt.Color(255, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(txtNUEVA, gridBagConstraints);

        lblCONFIRMARNUEVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCONFIRMARNUEVA.setText("Confirmar nueva contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(lblCONFIRMARNUEVA, gridBagConstraints);

        txtCONFIRMARNUEVA.setBackground(new java.awt.Color(255, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(txtCONFIRMARNUEVA, gridBagConstraints);

        LBLrELLENO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBLrELLENO.setText("             ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 0, 0);
        add(LBLrELLENO, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JLabelCZ LBLrELLENO;
    private utilesGUIx.JLabelCZ lblACTUAL;
    private utilesGUIx.JLabelCZ lblACTUAL1;
    private utilesGUIx.JLabelCZ lblCONFIRMARNUEVA;
    private utilesGUIx.JLabelCZ lblNUEVA;
    private javax.swing.JPasswordField txtACTUAL;
    private javax.swing.JPasswordField txtCONFIRMARNUEVA;
    private javax.swing.JPasswordField txtNUEVA;
    // End of variables declaration//GEN-END:variables


}
