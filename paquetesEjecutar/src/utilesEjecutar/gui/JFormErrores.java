/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFormErrores.java
 *
 * Created on 27-feb-2009, 10:31:30
 */

package utilesEjecutar.gui;

import javax.swing.ImageIcon;
import utiles.JDateEdu;
import utiles.timer.ITemporizador;
import utiles.timer.JTimer;
import utilesEjecutar.JControladorCoordinadorEjecutar;

/**
 * Muestra los errores producidos
 */
public class JFormErrores extends javax.swing.JFrame implements ITemporizador{
    private int mlSegundosAbiertos = 5;
    private JControladorCoordinadorEjecutar moCoordinador;
    private JTimer moTimer;
    private int mlcuenta=0;

    /** Creates new form JFormErrores */
    public JFormErrores(JControladorCoordinadorEjecutar poCoordinador) {
        moCoordinador=poCoordinador;
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/utilesEjecutar/gui/Stop16.gif")).getImage());
        StringBuffer lsErrores = new StringBuffer();
        for(int i = 0 ; i < poCoordinador.getErrores().size(); i++){
            lsErrores.append(poCoordinador.getErrores().get(i).toString());
            lsErrores.append('\n');
        }
        jTextArea1.setText(lsErrores.toString());
        setBounds(0, 0,
                (int)getBounds().getWidth(),
                (int)getBounds().getHeight());
        if(moTimer==null){
            moTimer = new JTimer(this);
            moTimer.start();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSegundosACerrar = new javax.swing.JLabel();
        btnMantener = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Errores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("se cerrar� en ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jLabel1, gridBagConstraints);

        lblSegundosACerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSegundosACerrar.setText(" ");
        lblSegundosACerrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(lblSegundosACerrar, gridBagConstraints);

        btnMantener.setText("Mantener abierto");
        btnMantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenerActionPerformed(evt);
            }
        });
        jPanel2.add(btnMantener, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel2);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesEjecutar/gui/Stop16.gif"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-408)/2, (screenSize.height-337)/2, 408, 337);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        moTimer.stop();
        moCoordinador.finalizar();
        if(moCoordinador.isSalirAlFinalizar()){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(moTimer==null){
            moTimer = new JTimer(this);
            moTimer.start();
        }

    }//GEN-LAST:event_formWindowActivated

    private void btnMantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenerActionPerformed
        moTimer.stop();
        lblSegundosACerrar.setText("");
}//GEN-LAST:event_btnMantenerActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMantener;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblSegundosACerrar;
    // End of variables declaration//GEN-END:variables

    public void timerArrancado(JTimer poTimer) {
    }

    public void timerParado(JTimer poTimer) {
    }

    public void timerMuerto(JTimer poTimer) {
    }

    public void timerIntervalo(JTimer poTimer) {
        JDateEdu loDateIni = new JDateEdu(poTimer.inicio);
        JDateEdu loDateAhora = new JDateEdu();
        try {
            int lDateDiff = (int) loDateIni.diff(loDateIni.mclSegundos, loDateAhora, loDateIni);
            if (lDateDiff > mlSegundosAbiertos) {
                poTimer.stop();
                dispose();
            }else{
                lblSegundosACerrar.setText(String.valueOf(mlSegundosAbiertos-lDateDiff));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
