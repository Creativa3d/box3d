/*
 * JPanelPropiedades.java
 *
 * Created on 19 de febrero de 2007, 11:24
 */

package utilesGUIx.configForm.antig;
import utilesGUIx.configForm.*;
import ListDatos.ECampoError;
import ListDatos.JListDatos;
import java.util.Enumeration;
import java.util.Properties;
import utiles.JDepuracion;
import utiles.config.ConfigurationParametersManager;
import utiles.config.JLectorFicherosParametros;
import utilesGUIx.JTableModel;

public class JPanelPropiedades extends javax.swing.JPanel implements java.awt.event.ActionListener {
    
    JTablaMotorProp moMotor;
    Properties moPropiedades;
    JLectorFicherosParametros moLector=null;
    
    /** Creates new form JPanelPropiedades */
    public JPanelPropiedades() {
        super();
        initComponents();
        inicializar(null, null);
    }
    public JPanelPropiedades(final Properties poPropiedadesDefecto) {
        super();
        initComponents();
        inicializar(poPropiedadesDefecto, null);
    }
    public JPanelPropiedades(final boolean pbSinFichero) {
        super();
        initComponents();
        if(pbSinFichero){
            moPropiedades = new Properties();
            moMotor = new JTablaMotorProp(moPropiedades);
            jTableCZ1.setModel(moMotor);
        }else{
            inicializar(null, null);
        }
    }
    public JPanelPropiedades(final Properties poPropiedadesDefecto, final JLectorFicherosParametros poLector) {
        super();
        initComponents();
        inicializar(poPropiedadesDefecto, poLector);
    }
    public void inicializar(final Properties poPropiedadesDefecto, final JLectorFicherosParametros poLector){
        moLector=poLector;
        if(poLector==null){
            moPropiedades = (Properties) ConfigurationParametersManager.getTodasPropiedades();
        }else{
            moPropiedades = (Properties) poLector.getTodasPropiedades();
        }
        if(poPropiedadesDefecto!=null){
            setPropiedadesDefecto(poPropiedadesDefecto);
        }
        moMotor = new JTablaMotorProp(moPropiedades);
        jTableCZ1.setModel(moMotor);
    }
    public void setPropiedadesDefecto(final Properties poPropDefec){
        Enumeration loEnum = poPropDefec.keys();
        for(;loEnum.hasMoreElements();){
            String lsNombre = (String)loEnum.nextElement();
            //si no existe la propiedad la ponemos
            String lsProp = moPropiedades.getProperty(lsNombre);
            if(lsProp==null || lsProp.compareTo("") == 0){
                moPropiedades.put(lsNombre, poPropDefec.getProperty(lsNombre));
            }
        }
    }
    public void refrescarTabla(){
        moMotor.setPropiedades(moPropiedades);
    }
    public Properties getPropiedades(){
        return moMotor.getPropiedades();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCZ1 = new utilesGUIx.JTableCZ();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new utilesGUIx.JButtonCZ();
        btnBorrar = new utilesGUIx.JButtonCZ();
        btnGuardar = new utilesGUIx.JButtonCZ();

        setLayout(new java.awt.BorderLayout());

        jTableCZ1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCZ1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(40, 40));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Add16.gif"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this);
        jPanel1.add(btnNuevo);

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Delete16.gif"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(this);
        jPanel1.add(btnBorrar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Save16.gif"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this);
        jPanel1.add(btnGuardar);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == btnNuevo) {
            JPanelPropiedades.this.btnNuevoActionPerformed(evt);
        }
        else if (evt.getSource() == btnBorrar) {
            JPanelPropiedades.this.btnBorrarActionPerformed(evt);
        }
        else if (evt.getSource() == btnGuardar) {
            JPanelPropiedades.this.btnGuardarActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(moLector==null){
                ConfigurationParametersManager.setTodasPropiedades(moMotor.getPropiedades());
                ConfigurationParametersManager.guardarPropiedades();
            }else{
                moLector.setTodasPropiedades(moMotor.getPropiedades());
                moLector.guardarPropiedades();
            }
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try{
            if(jTableCZ1.getSelectedRow()>=0){
                moMotor.moList.setIndex(jTableCZ1.getSelectedRow());
                moMotor.moList.borrar(false);
                jTableCZ1.updateUI();
            }
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try{
            moMotor.moList.addNew();
            moMotor.moList.getFields(0).setValue("Nuevo");
            moMotor.moList.update(false);
            jTableCZ1.updateUI();
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ btnBorrar;
    public utilesGUIx.JButtonCZ btnGuardar;
    private utilesGUIx.JButtonCZ btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilesGUIx.JTableCZ jTableCZ1;
    // End of variables declaration//GEN-END:variables
    
}
class JTablaMotorProp extends JTableModel {

    public JTablaMotorProp(final Properties poPropiedades){
        super(new JListDatos(null, "", new String[]{"Nombre","Valor"}, new int[]{JListDatos.mclTipoCadena, JListDatos.mclTipoCadena}, new int[]{0}));
        mbEditable = true;
        mbActualizarServidor=false;
        setPropiedades(poPropiedades);
    }
    
    public void setPropiedades(final Properties poPropiedades){
        Enumeration loEnum = poPropiedades.keys();
        for(;loEnum.hasMoreElements();){
            String lsNombre = (String)loEnum.nextElement();
            moList.addNew();
            try {
                moList.getFields(0).setValue(lsNombre);
                moList.getFields(1).setValue(poPropiedades.getProperty(lsNombre));
            } catch (ECampoError ex) {
                JDepuracion.anadirTexto(getClass().getName(), ex);
            }
            moList.update(false);
        }
        
    }
    
    public Properties getPropiedades(){
        Properties loProp = new Properties();
        if(moList.moveFirst()){
            do{
                loProp.put(moList.getFields(0).getString(), moList.getFields(1).getString());
            }while(moList.moveNext());
        }
        return loProp;
    }

}
