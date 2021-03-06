/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilesGUIx.aplicacion.avisosGUI;

import utilesGUIx.JGUIxConfigGlobal;
import utilesGUIx.aplicacion.avisos.JAviso;
import utilesGUIx.aplicacion.avisos.JAvisosConj;
import utilesGUIx.msgbox.JMsgBox;

/**
 *
 * @author eduardo
 */
public class JPanelAviso extends javax.swing.JPanel {
    private JAviso moAviso;
    private JAvisosConj moAvisosConj;

    /**
     * Creates new form JPanelAviso
     */
    public JPanelAviso() {
        initComponents();
    }
    
    public void setDatos(JAviso poAviso, JAvisosConj poAvisosConj){
        moAviso = poAviso;
        moAvisosConj=poAvisosConj;
        mostrarDatos();
    }
    public void mostrarDatos() {
        lblMensaje.setText(moAviso.getMensaje());
        btnAccion.setVisible(moAviso.getAccion()!=null);
        btnAccion.setText(moAviso.getAccionCaption());
    }
    public JAviso getAviso(){
        return moAviso;
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccion = new utilesGUIx.JButtonCZ();
        lblMensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setOpaque(false);
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        btnAccion.setText("Acci�n");
        btnAccion.setFocusable(false);
        btnAccion.setOpaque(false);
        btnAccion.setRequestFocusEnabled(false);
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });
        add(btnAccion, java.awt.BorderLayout.NORTH);

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMensaje.setFocusable(false);
        lblMensaje.setRequestFocusEnabled(false);
        add(lblMensaje, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        try{
            moAviso.getAccion().actionPerformed(null);
            moAvisosConj.remove(moAviso);
            JGUIxConfigGlobal.getInstancia().getMostrarPantalla().cerrarForm(this);
        }catch(Throwable e){
            JGUIxConfigGlobal.getInstancia().getMostrarPantalla().mensajeErrorYLog(this, e, null);
        }
    }//GEN-LAST:event_btnAccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ btnAccion;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}
