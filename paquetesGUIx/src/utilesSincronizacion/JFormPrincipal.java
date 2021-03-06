/*
 * JFormPrincipal.java
*
* Creado el 2/10/2008
*/

package utilesSincronizacion;

import utilesSincronizacion.tablasControladoras.JT2TABLASINCRONIZACIONBORRADOS;
import utilesSincronizacion.tablasControladoras.JT2TABLASINCRONIZACIONGENERAL;
import utilesSincronizacion.forms.JFormLogin;
import ListDatos.*;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import utiles.JDepuracion;
import utiles.config.*;
import utilesBD.estructuraBD.JConstructorEstructuraBDConnection;
import utilesGUIx.configForm.JConexion;
import utilesGUIx.configForm.antig.JFormConexion;
import utilesGUIx.formsGenericos.JTablaConfig;
import utilesGUIx.formsGenericos.edicion.*;
import utilesGUIx.plugin.IContainer;
import utilesGUIx.plugin.IPlugInFrame;
import utilesGUIx.plugin.toolBar.IComponenteAplicacion;
import utilesGUIx.plugin.toolBar.JComponenteAplicacionGrupo;
import utilesSincronizacion.forms.*;
import utilesSincronizacion.sincronizacion.JSincronizacionCrear;
import utilesSincronizacion.sincronizacion.JSincronizar;
import utilesSincronizacion.sincronizacion.JSincronizarParam;
import utilesSincronizacion.tablasControladoras.*;

public class JFormPrincipal extends javax.swing.JFrame implements IPlugInFrame, IContainer {
    private JFormEdicionParametros moParametros = new JFormEdicionParametros();

    // Add your handling code here:
    
    /** Creates new form JFormPrincipal */
    public JFormPrincipal() {
        super();
        initComponents();
        if(utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()!=null){
            this.setIconImage(((ImageIcon) utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()).getImage());
        }          
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JDatosGeneralesP.getDatosGenerales().setDesktopPane1(jDesktopPane1, jProcesoThreadGroup1);
        jMenuLoginNuevoActionPerformed(null);
    }

    public JMenuBar getMenu() {
        return jMenuBar1;
    }

    public String getIdentificador() {
        return getClass().getName();
    }

    public Container getContenedor() {
        return getContentPane();
    }

    public IContainer getContenedorI() {
        return this;
    }

    public IComponenteAplicacion getListaComponentesAplicacion() {
        return null;
    }

    public void aplicarListaComponentesAplicacion() {
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProcesoThreadGroup1 = new utilesGUIx.controlProcesos.JProcesoThreadGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuASalir = new javax.swing.JMenuItem();
        jMenuAPropiedades = new javax.swing.JMenuItem();
        jMenuConexion = new javax.swing.JMenuItem();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuMTABLASINCRONIZACIONBORRADOS = new javax.swing.JMenuItem();
        jMenuMTABLASINCRONIZACIONGENERAL = new javax.swing.JMenuItem();
        jMenuLogin = new javax.swing.JMenu();
        jMenuLoginNuevo = new javax.swing.JMenuItem();
        jMenuSincronizacion = new javax.swing.JMenu();
        jMenuSincronizacionTunear = new javax.swing.JMenuItem();
        jMenuSincronizar = new javax.swing.JMenuItem();

        setTitle("Gestión utilesSincronizacion");
        setName("Gestión utilesSincronizacion"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jDesktopPane1.setAutoscrolls(true);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jLabel1, gridBagConstraints);

        jProcesoThreadGroup1.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jProcesoThreadGroup1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jMenuArchivo.setText("Archivo");

        jMenuASalir.setText("Salir");
        jMenuASalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuASalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuASalir);

        jMenuAPropiedades.setText("Propiedades");
        jMenuAPropiedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAPropiedadesActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuAPropiedades);

        jMenuConexion.setText("Config. Conexión BD");
        jMenuConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConexionActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuConexion);

        jMenuBar1.add(jMenuArchivo);

        jMenuMantenimiento.setText("Mantenimiento");

        jMenuMTABLASINCRONIZACIONBORRADOS.setText("TABLASINCRONIZACIONBORRADOS");
        jMenuMTABLASINCRONIZACIONBORRADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMTABLASINCRONIZACIONBORRADOSActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuMTABLASINCRONIZACIONBORRADOS);

        jMenuMTABLASINCRONIZACIONGENERAL.setText("TABLASINCRONIZACIONGENERAL");
        jMenuMTABLASINCRONIZACIONGENERAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMTABLASINCRONIZACIONGENERALActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuMTABLASINCRONIZACIONGENERAL);

        jMenuBar1.add(jMenuMantenimiento);

        jMenuLogin.setText("Login");

        jMenuLoginNuevo.setText("Nuevo login");
        jMenuLoginNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLoginNuevoActionPerformed(evt);
            }
        });
        jMenuLogin.add(jMenuLoginNuevo);

        jMenuBar1.add(jMenuLogin);

        jMenuSincronizacion.setText("Sincronización");

        jMenuSincronizacionTunear.setText("Sincronización Tunear Servidor");
        jMenuSincronizacionTunear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSincronizacionTunearActionPerformed(evt);
            }
        });
        jMenuSincronizacion.add(jMenuSincronizacionTunear);

        jMenuSincronizar.setText("Sincronizar");
        jMenuSincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSincronizarActionPerformed(evt);
            }
        });
        jMenuSincronizacion.add(jMenuSincronizar);

        jMenuBar1.add(jMenuSincronizacion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSincronizarActionPerformed
        JConexion loConex = new JConexion();

        loConex.getConexion().setClase(JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(
                            JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                JDatosGeneralesXML.PARAMETRO_DRIVER_CLASS_NAME));
        loConex.getConexion().setURL(JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(
                            JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                JDatosGeneralesXML.PARAMETRO_Conexion));
        loConex.getConexion().setUSUARIO(JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(
                            JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                JDatosGeneralesXML.PARAMETRO_Usuario));
        loConex.getConexion().setPASSWORD(JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(
                            JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                JDatosGeneralesXML.PARAMETRO_Password));
        try{
            loConex.getConexion().setTipoBD(Integer.valueOf(
                            JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(
                            JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                JDatosGeneralesXML.PARAMETRO_TipoSQL)).intValue());
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            JFormConexion loConexForm = new JFormConexion(this, true, loConex);
            loConexForm.setTitle("Conexión cliente");
            loConexForm.setVisible(true);

            if(!loConex.mbCancelado){

                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(
                                    JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                        JDatosGeneralesXML.PARAMETRO_DRIVER_CLASS_NAME,loConex.getConexion().getClase());
                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(
                                    JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                        JDatosGeneralesXML.PARAMETRO_Conexion,loConex.getConexion().getURL());
                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(
                                    JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                        JDatosGeneralesXML.PARAMETRO_Usuario,loConex.getConexion().getUSUARIO());
                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(
                                    JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                        JDatosGeneralesXML.PARAMETRO_Password,loConex.getConexion().getPASSWORD());
                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(
                                    JDatosGeneralesXML.mcsCONEXIONDIRECTA + "Cliente/" + 
                                        JDatosGeneralesXML.PARAMETRO_TipoSQL, String.valueOf(loConex.getConexion().getTipoBD()));
                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().guardarFichero();
            

                JServerServidorDatosBD loServer = new JServerServidorDatosBD(
                        loConex.getConexion().getClase(),
                        loConex.getConexion().getURL(),
                        loConex.getConexion().getUSUARIO(),
                        loConex.getConexion().getPASSWORD(),
                        String.valueOf(loConex.getConexion().getTipoBD())
                        );
                loServer.setConstrucEstruc(new JConstructorEstructuraBDConnection(loServer.getConec()));

                JSincronizarParam loParam = new JSincronizarParam(new JFormConflictos());
                JSincronizar loSincronizar = new JSincronizar(
                        loServer, 
                        JDatosGeneralesP.getDatosGenerales().moServer, 
                        loParam);

                JDatosGeneralesP.getDatosGenerales().getThreadGroup().addProcesoYEjecutar(loSincronizar);
                
            }
        } catch (Throwable ex) {
            JDepuracion.anadirTexto(getClass().getName(), ex);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, ex);
        }

    }//GEN-LAST:event_jMenuSincronizarActionPerformed

    private void jMenuMTABLASINCRONIZACIONBORRADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMTABLASINCRONIZACIONBORRADOSActionPerformed
        try{
            JT2TABLASINCRONIZACIONBORRADOS loTABLASINCRONIZACIONBORRADOS = new JT2TABLASINCRONIZACIONBORRADOS(JDatosGeneralesP.getDatosGenerales().moServer, JDatosGeneralesP.getDatosGenerales());
            loTABLASINCRONIZACIONBORRADOS.mostrarFormPrinci();
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_jMenuMTABLASINCRONIZACIONBORRADOSActionPerformed

    private void jMenuMTABLASINCRONIZACIONGENERALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMTABLASINCRONIZACIONGENERALActionPerformed
        try{
            JT2TABLASINCRONIZACIONGENERAL loTABLASINCRONIZACIONGENERAL = new JT2TABLASINCRONIZACIONGENERAL(JDatosGeneralesP.getDatosGenerales().moServer, JDatosGeneralesP.getDatosGenerales());
            loTABLASINCRONIZACIONGENERAL.mostrarFormPrinci();
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_jMenuMTABLASINCRONIZACIONGENERALActionPerformed

    private void jMenuSincronizacionTunearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSincronizacionTunearActionPerformed
        try{
            JSincronizacionCrear loEstru = new  JSincronizacionCrear(JDatosGeneralesP.getDatosGenerales().moServer);
            jProcesoThreadGroup1.addProcesoYEjecutar(loEstru);
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }

    }//GEN-LAST:event_jMenuSincronizacionTunearActionPerformed
    private void jMenuConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConexionActionPerformed
        try{
            JDatosGeneralesP.getDatosGenerales().mostrarPropiedadesConexionBD();
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }

    }//GEN-LAST:event_jMenuConexionActionPerformed

    private void jMenuAPropiedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAPropiedadesActionPerformed
        try{
            JDatosGeneralesP.getDatosGenerales().mostrarPropiedades();
        }catch(Exception e){
            JDepuracion.anadirTexto(getClass().getName(), e);
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_jMenuAPropiedadesActionPerformed

    private void jMenuLoginNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLoginNuevoActionPerformed
        // TODO add your handling code here:
        JFormLogin loLogin = new JFormLogin(this, true);
        loLogin.show();
    }//GEN-LAST:event_jMenuLoginNuevoActionPerformed

    private void jMenuASalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuASalirActionPerformed
        // TODO add your handling code here:
        exitForm(null);
    }//GEN-LAST:event_jMenuASalirActionPerformed

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        try {
            JTablaConfig.guardarConfig();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new JFormPrincipal().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuAPropiedades;
    private javax.swing.JMenuItem jMenuASalir;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConexion;
    private javax.swing.JMenu jMenuLogin;
    private javax.swing.JMenuItem jMenuLoginNuevo;
    private javax.swing.JMenuItem jMenuMTABLASINCRONIZACIONBORRADOS;
    private javax.swing.JMenuItem jMenuMTABLASINCRONIZACIONGENERAL;
    private javax.swing.JMenu jMenuMantenimiento;
    private javax.swing.JMenu jMenuSincronizacion;
    private javax.swing.JMenuItem jMenuSincronizacionTunear;
    private javax.swing.JMenuItem jMenuSincronizar;
    private javax.swing.JPanel jPanel1;
    private utilesGUIx.controlProcesos.JProcesoThreadGroup jProcesoThreadGroup1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public JFormEdicionParametros getParametros() {
        return moParametros;
    }

    
}
