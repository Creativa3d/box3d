/*
 * JPlugInPrincipal.java
*
* Creado el 19/10/2016
*/

package utilesDoc;
import utilesDoc.tablasControladoras.JT2DOCUMENTOS;
import utilesDoc.tablasExtend.JTEEDOCUMTIPOS;
import utilesDoc.tablasExtend.JTEEDOCUMCLASIF;
import utilesDoc.tablasControladoras.*;
import utilesDoc.tablasExtend.*;
import utilesDoc.tablas.*;
import utilesGUIx.JGUIxConfigGlobalModelo;
import utilesGUIx.formsGenericos.edicion.JT2GENERICO;
import utilesGUIx.formsGenericos.IPanelControlador;
 
import utilesGUIx.plugin.*;

public class JPlugInPrincipal extends javax.swing.JFrame implements IPlugIn {
    public void procesarInicial(IPlugInContexto poContexto) {
        initComponents();
        establecerNombresMenus();
        
        JPlugInUtilidades.addBotones(
                poContexto.getFormPrincipal(),
                jToolBar1,
                false);
        JPlugInUtilidades.addMenusFrame(poContexto.getFormPrincipal(), jMenuBar1);
    }
    private void establecerNombresMenus(){
        jMenuMDOCUMCLASIF.setText(JDocDatosGeneralesModelo.getTextosForms().getTexto(JTDOCUMCLASIF.msCTabla) );
        jMenuMDOCUMENTOS.setText(JDocDatosGeneralesModelo.getTextosForms().getTexto(JTDOCUMENTOS.msCTabla) );
        jMenuMDOCUMTIPOS.setText(JDocDatosGeneralesModelo.getTextosForms().getTexto(JTDOCUMTIPOS.msCTabla) );
    }

    public void procesarConsulta(IPlugInContexto poContexto, IPlugInConsulta poConsulta) {
    }

    public void procesarEdicion(IPlugInContexto poContexto, IPlugInFrame poFrame) {
    }

    public void procesarControlador(IPlugInContexto poContexto, IPanelControlador poControlador) {
    }
    public void procesarFinal(IPlugInContexto poContexto) {
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        jToolBar1 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuMDOCUMCLASIF = new javax.swing.JMenuItem();
        jMenuMDOCUMENTOS = new javax.swing.JMenuItem();
        jMenuMDOCUMTIPOS = new javax.swing.JMenuItem();

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        
        jMenuMantenimiento.setText("Mantenimiento");
        jMenuMDOCUMCLASIF.setText("DOCUMCLASIF");
        jMenuMDOCUMCLASIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMDOCUMCLASIFActionPerformed(evt);
            }
        });

        jMenuMantenimiento.add(jMenuMDOCUMCLASIF);

        jMenuMDOCUMENTOS.setText("DOCUMENTOS");
        jMenuMDOCUMENTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMDOCUMENTOSActionPerformed(evt);
            }
        });

        jMenuMantenimiento.add(jMenuMDOCUMENTOS);

        jMenuMDOCUMTIPOS.setText("DOCUMTIPOS");
        jMenuMDOCUMTIPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMDOCUMTIPOSActionPerformed(evt);
            }
        });

        jMenuMantenimiento.add(jMenuMDOCUMTIPOS);


        jMenuBar1.add(jMenuMantenimiento);

        setJMenuBar(jMenuBar1);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void jMenuMDOCUMCLASIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMDOCUMCLASIFActionPerformed
        try{
            JTEEDOCUMCLASIF loDOCUMCLASIF = new JTEEDOCUMCLASIF(JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getServer());
            JTEEDOCUMCLASIF loDOCUMCLASIFC = new JTEEDOCUMCLASIF(JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getServer());
            JT2GENERICO loGenerico = new JT2GENERICO(
                    JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getMostrarPantalla(),
                    loDOCUMCLASIF,
                    loDOCUMCLASIFC,
                    loDOCUMCLASIFC.getPasarACache()
                    );
            loGenerico.mostrarFormPrinci();
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_jMenuMDOCUMCLASIFActionPerformed

    private void jMenuMDOCUMENTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMDOCUMENTOSActionPerformed
        try{
            JT2DOCUMENTOS loDOCUMENTOS = new JT2DOCUMENTOS(JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getServer(), JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getMostrarPantalla());
            loDOCUMENTOS.mostrarFormPrinci();
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_jMenuMDOCUMENTOSActionPerformed

    private void jMenuMDOCUMTIPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMDOCUMTIPOSActionPerformed
        try{
            JTEEDOCUMTIPOS loDOCUMTIPOS = new JTEEDOCUMTIPOS(JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getServer());
            JTEEDOCUMTIPOS loDOCUMTIPOSC = new JTEEDOCUMTIPOS(JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getServer());
            JT2GENERICO loGenerico = new JT2GENERICO(
                    JGUIxConfigGlobalModelo.getInstancia().getGestorDocumental().getMostrarPantalla(),
                    loDOCUMTIPOS,
                    loDOCUMTIPOSC,
                    loDOCUMTIPOSC.getPasarACache()
                    );
            loGenerico.mostrarFormPrinci();
        }catch(Exception e){
            utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this, e, getClass().getName());
        }
    }//GEN-LAST:event_jMenuMDOCUMTIPOSActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuMDOCUMCLASIF;
    private javax.swing.JMenuItem jMenuMDOCUMENTOS;
    private javax.swing.JMenuItem jMenuMDOCUMTIPOS;
    private javax.swing.JMenu jMenuMantenimiento;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
}
