/*
 * JFormBuscar.java
 *
 * Created on 4 de septiembre de 2003, 19:39
 */
package utilesGUI.buscar;
/**
 *
 * @author  portatiledu
 */
import ListDatos.*;
import utilesGUI.*;
import utilesGUI.tabla.*;

/**Formulario para buscar datos*/
public class JFormBuscar extends java.awt.Dialog implements java.awt.event.ActionListener, java.awt.event.TextListener{
    JSBuscar moBuscar=null;
    /**
     * Creates new form JFormBuscar
     * @param parent padre
     * @param modal si es modal
     * @param poBuscar objeto buscar
     */
    public JFormBuscar(java.awt.Frame parent, boolean modal, JSBuscar poBuscar) {
        super(parent, modal);
        initComponents();
        setSize(450, 400);
        setBounds(getLocation().x,getLocation().y, 450, 400);
        jBtnCancelar.addActionListener(this);
        jBtnGuardar.addActionListener(this);
        txtBuscar.addTextListener(this);
        moBuscar = poBuscar;
        ITablaAntig loModel = new JTablaMotor(poBuscar.moTabla);
        jTabla1.setTabla(loModel);
        rellenarCampos();
     }
    private void rellenarCampos(){
        cmbCampos.removeAll();
        for (int i = 0;i< moBuscar.moTabla.getFields().count();i++){
            cmbCampos.add(moBuscar.moTabla.getFields().get(i).getCaption());
        }
        cmbCampos.select(0);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new java.awt.Panel();
        label1 = new java.awt.Label();
        cmbCampos = new utilesGUI.ChoiceCZ();
        txtBuscar = new utilesGUI.TextFieldCZ();
        jPanel1 = new java.awt.Panel();
        jBtnGuardar = new utilesGUI.ButtonCZ();
        jBtnCancelar = new utilesGUI.ButtonCZ();
        jTabla1 = new utilesGUI.tabla.JTabla();

        setTitle("Buscar");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridBagLayout());

        label1.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(label1, gridBagConstraints);

        cmbCampos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCamposItemStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.3;
        jPanel2.add(cmbCampos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.weightx = 0.8;
        jPanel2.add(txtBuscar, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jBtnGuardar.setLabel("Aceptar");
        jPanel1.add(jBtnGuardar);

        jBtnCancelar.setLabel("Cancelar");
        jPanel1.add(jBtnCancelar);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        add(jTabla1, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // Add your handling code here:
        jTabla1.refrescar();
    }//GEN-LAST:event_formComponentResized

    private void cmbCamposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCamposItemStateChanged
        // Add your handling code here:
        moBuscar.moTabla.ordenar(new int[]{cmbCampos.getSelectedIndex()});
        jTabla1.refrescar();
    }//GEN-LAST:event_cmbCamposItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Add your handling code here:
        if (evt != null){
            moBuscar.mbCancelado=true;
        }
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_formWindowClosing

    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if (source == jBtnGuardar){
            moBuscar.moTabla.setIndex(jTabla1.getRowSelTabla());
            moBuscar.mbCancelado=false;
        }
        if (source == jBtnCancelar){
            moBuscar.moTabla.setIndex(jTabla1.getRowSelTabla());
            moBuscar.mbCancelado=true;
        }
        
        formWindowClosing(null);
    }    
    
    public void textValueChanged(java.awt.event.TextEvent e) {
        if (moBuscar.moTabla.buscar(JListDatos.mclTMayorIgual, 
              new int[]{cmbCampos.getSelectedIndex()},
              new String[]{txtBuscar.getText()})){
              jTabla1.setFilaSelec(moBuscar.moTabla.getIndex());
              jTabla1.setVisibleFilaPrimera(moBuscar.moTabla.getIndex());
              jTabla1.refrescar();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUI.ChoiceCZ cmbCampos;
    private utilesGUI.ButtonCZ jBtnCancelar;
    private utilesGUI.ButtonCZ jBtnGuardar;
    private java.awt.Panel jPanel1;
    private java.awt.Panel jPanel2;
    private utilesGUI.tabla.JTabla jTabla1;
    private java.awt.Label label1;
    private utilesGUI.TextFieldCZ txtBuscar;
    // End of variables declaration//GEN-END:variables
    
}
