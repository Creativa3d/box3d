/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JGuiSQL.java
 *
 * Created on 17-may-2010, 11:24:55
 */

package paquetesGeneradorInf.gui;

import ListDatos.JFilaDatosDefecto;
import ListDatos.JSelect;
//import ListDatos.JSelectMotor;
import ListDatos.JSelectMotorFactory;
import paquetesGeneradorInf.gui.util.JSelectMotorCODIGO;
import paquetesGeneradorInf.gui.util.JSelectMotorCODIGOJConsul;
import paquetesGeneradorInf.gui.util.JSelectMotorNeutro;
import utiles.IListaElementos;

public class JGuiSQL extends javax.swing.JPanel {
    public static final String mcsNeutro = "neutro";
    public static final String mcsJava = "Java";
    public static final String mcsJavaConsulta = "JavaConsulta";

    private JSelect moSelect;


    /** Creates new form JGuiSQL */
    public JGuiSQL() {
        initComponents();
        if(JSelectMotorFactory.getInstance().getSelectMotor(mcsNeutro)==null){
            JSelectMotorFactory.getInstance().registrarMotor(mcsNeutro, new JSelectMotorNeutro(true), mcsNeutro);
        }
        if(JSelectMotorFactory.getInstance().getSelectMotor(mcsJava)==null){
            JSelectMotorFactory.getInstance().registrarMotor(mcsJava, new JSelectMotorCODIGO(), mcsJava);
        }
        if(JSelectMotorFactory.getInstance().getSelectMotor(mcsJavaConsulta)==null){
            JSelectMotorFactory.getInstance().registrarMotor(mcsJavaConsulta, new JSelectMotorCODIGOJConsul(), mcsJavaConsulta);
        }
        
        cmbTipoSQL.borrarTodo();
//        cmbTipoSQL.addLinea(mcsJava, mcsJava + JFilaDatosDefecto.mcsSeparacion1);
        
        IListaElementos loLista = JSelectMotorFactory.getInstance().getListaMotoresSQL();
        for(int i = 0 ; i < loLista.size(); i++ ){
            JSelectMotorFactory.JSelectMotorFactElem loElem =  (JSelectMotorFactory.JSelectMotorFactElem) loLista.get(i);
            cmbTipoSQL.addLinea(loElem.getCaption(), loElem.getTipo() + JFilaDatosDefecto.mcsSeparacion1);
        }
        cmbTipoSQL.setSelectedIndex(0);
    }
    public void setTipoSQL(String psTipo){
        cmbTipoSQL.setValueTabla(psTipo + JFilaDatosDefecto.mcsSeparacion1);
        refrescar();
    }

    public void setSelect(JSelect poSelect){
        moSelect=poSelect;
        refrescar();
    }
    private void refrescar() {
        if(moSelect==null){
            jTextSQL.setText("");
        }else{
            String lsTipo = cmbTipoSQL.getFilaActual().msCampo(0);
            jTextSQL.setText(moSelect.msSQL(JSelectMotorFactory.getInstance().getSelectMotor(lsTipo)));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTextSQL = new javax.swing.JScrollPane();
        jTextSQL = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        cmbTipoSQL = new utilesGUIx.JComboBoxCZ();

        setLayout(new java.awt.BorderLayout());

        jTextSQL.setColumns(20);
        jTextSQL.setEditable(false);
        jTextSQL.setLineWrap(true);
        jTextSQL.setRows(5);
        jTextSQL.setWrapStyleWord(true);
        jScrollPaneTextSQL.setViewportView(jTextSQL);

        add(jScrollPaneTextSQL, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout());

        cmbTipoSQL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoSQL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoSQLItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbTipoSQL);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoSQLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoSQLItemStateChanged
        try{
            refrescar();
        }catch(Throwable e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, this.getClass().getName());
        }
    }//GEN-LAST:event_cmbTipoSQLItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JComboBoxCZ cmbTipoSQL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneTextSQL;
    private javax.swing.JTextArea jTextSQL;
    // End of variables declaration//GEN-END:variables


}
