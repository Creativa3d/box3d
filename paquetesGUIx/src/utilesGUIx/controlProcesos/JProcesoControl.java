/*
 * JProcesoControl.java
 *
 * Created on 25 de julio de 2008, 17:13
 */

package utilesGUIx.controlProcesos;


import javax.swing.SwingUtilities;
import utilesGUI.procesar.JProcesoAccionParam;

public class JProcesoControl extends javax.swing.JPanel {
    private JProcesoElemento moAccion;

    /** Creates new form JProcesoControl */
    public JProcesoControl(final JProcesoElemento poAccion) {
        initComponents();
        moAccion=poAccion;

    }
    public JProcesoElemento getElemento(){
        return moAccion;
    }
    private void procesar(final int plnumeroRegistro, final int plnumeroRegistros,final String psTituloVentana, final String pstitulo, final JProcesoAccionParam poParam){
        jProgressBar1.setMinimum(0);
        if(psTituloVentana.equalsIgnoreCase(pstitulo)){
            jProgressBar1.setString(psTituloVentana);
        }else{
            jProgressBar1.setString(psTituloVentana + " - " +  pstitulo);
        }
        jProgressBar1.setStringPainted(true);
        lblNumero.setText(String.valueOf(plnumeroRegistro));

        if(plnumeroRegistros<plnumeroRegistro){
            jProgressBar1.setIndeterminate(true);
            lblTotal.setText("Indeterminado");
        }else{
            jProgressBar1.setIndeterminate(false);
            jProgressBar1.setMaximum(plnumeroRegistros);
            jProgressBar1.setValue(plnumeroRegistro);
            lblTotal.setText(String.valueOf(plnumeroRegistros));
        }
        if(poParam!=null){
            btnCancelar.setVisible(poParam.isTieneCancelado());
        }
    }
    public void establecer(final int plnumeroRegistro, final int plnumeroRegistros,final String psTituloVentana, final String pstitulo, final JProcesoAccionParam poParam) {
        if(SwingUtilities.isEventDispatchThread()){
            procesar(plnumeroRegistro, plnumeroRegistros,psTituloVentana, pstitulo, poParam);
        }else{
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    procesar(plnumeroRegistro, plnumeroRegistros,psTituloVentana, pstitulo, poParam);
                }
            });
        }
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnCancelar = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Elementos procesados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jLabel3, gridBagConstraints);

        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumero.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(lblNumero, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("de");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jLabel5, gridBagConstraints);

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("indefinido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(lblTotal, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jProgressBar1, gridBagConstraints);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Stop16.gif"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar proceso");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        moAccion.getProceso().setCancelado(true);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
    
}
