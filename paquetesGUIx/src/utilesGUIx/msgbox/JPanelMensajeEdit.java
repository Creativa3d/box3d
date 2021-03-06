/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelMensajeEdit.java
 *
 * Created on 14-ene-2011, 22:15:17
 */

package utilesGUIx.msgbox;

import utiles.JComunicacion;
import utilesGUIx.JGUIxConfigGlobal;


public class JPanelMensajeEdit extends javax.swing.JPanel {
    private JComunicacion moComu;

    /** Creates new form JPanelMensajeEdit */
    public JPanelMensajeEdit() {
        initComponents();
        btnAceptar.requestFocusInWindow();
    }

    public void setDatos(JComunicacion poComu){
        moComu=poComu;
        jTextAreaCZ1.setText(moComu.moObjecto.toString());
        btnAceptar.requestFocusInWindow();
        btnAceptar.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new utilesGUIx.JButtonCZ();
        btnCancelar = new utilesGUIx.JButtonCZ();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCZ1 = new utilesGUIx.JTextAreaCZ();

        setLayout(new java.awt.BorderLayout());

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/accept.gif"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/cancel.gif"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jTextAreaCZ1.setColumns(20);
        jTextAreaCZ1.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCZ1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        moComu.moObjecto = jTextAreaCZ1.getText();
        JGUIxConfigGlobal.getInstancia().getMostrarPantalla().cerrarForm(this);

}//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        moComu.moObjecto = null;
        JGUIxConfigGlobal.getInstancia().getMostrarPantalla().cerrarForm(this);

}//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ btnAceptar;
    private utilesGUIx.JButtonCZ btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilesGUIx.JTextAreaCZ jTextAreaCZ1;
    // End of variables declaration//GEN-END:variables

}
