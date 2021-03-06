/*
 * JFormProcesoControl.java
 *
 * Created on 25 de julio de 2008, 18:09
 */

package utilesGUIx.controlProcesos;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import utiles.JDepuracion;

public class JFormProcesoControl extends javax.swing.JFrame {
    private JProcesoThreadGroup moPadre;
    /** Creates new form JFormProcesoControl */
    public JFormProcesoControl(JProcesoThreadGroup poPadre) {
        initComponents();
        try{
        if(utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()!=null){
            this.setIconImage(((ImageIcon) utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()).getImage());
        }   
        }catch(Throwable e){
            JDepuracion.anadirTexto(getClass().getName(), e);
        }
        setFocusableWindowState(false);
        moPadre = poPadre;
        actualizar();

    }
    private JProcesoControl getControl(JProcesoElemento poElem){
        JProcesoControl loControl = null;
        for(int i = 0 ; i < jPanelProcesos.getComponentCount() && loControl==null; i++){
            Component loAux=jPanelProcesos.getComponent(i);
            if(loAux.getClass().isAssignableFrom(JProcesoControl.class)){
                JProcesoControl loAuxC = (JProcesoControl) loAux;
                if(loAuxC.getElemento() == poElem){
                    loControl=loAuxC;
                }
            }
        }
        if(loControl==null){
            loControl=new JProcesoControl(poElem);
            jPanelProcesos.add(loControl);
        }
        return loControl;
    }
    private void procesar(){
        try{
        if(utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()!=null){
            this.setIconImage(((ImageIcon) utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()).getImage());
        }   
        }catch(Throwable e){
            JDepuracion.anadirTexto(getClass().getName(), e);
        }
        //borramos los componenetes visuales q nohagan falta
        for(int i = 0 ; i < jPanelProcesos.getComponentCount(); i++){
            Component loAux=jPanelProcesos.getComponent(i);
            if(loAux.getClass().isAssignableFrom(JProcesoControl.class)){
                JProcesoControl loAuxC = (JProcesoControl) loAux;
                if(moPadre.getIndice(loAuxC.getElemento())<0 ){
                    jPanelProcesos.remove(loAux);
                }
            }
        }

        //actualizamos/a�adimos los componenetes visuales
        for(int i = 0 ; i < moPadre.getListaElementos().size(); i++){
            JProcesoElemento loElem = (JProcesoElemento)moPadre.getListaElementos().get(i);
            JProcesoControl loControl = (JProcesoControl)getControl(loElem);

            if(loElem.getError() != null){
                loControl.establecer(
                        loElem.getProceso().getNumeroRegistro(),
                        loElem.getProceso().getNumeroRegistros(),
                        loElem.getProceso().getTitulo(),
                        loElem.getError().toString(),
                        loElem.getProceso().getParametros());
            }else{
                loControl.establecer(
                        loElem.getProceso().getNumeroRegistro(),
                        loElem.getProceso().getNumeroRegistros(),
                        loElem.getProceso().getTitulo(),
                        loElem.getProceso().getTituloRegistroActual(),
                        loElem.getProceso().getParametros());
            }
        }
        jPanelProcesos.updateUI();
    }
    void actualizar() {
        if(SwingUtilities.isEventDispatchThread()){
            procesar();
        }else{
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    procesar();
                }
            });
        }


    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelProcesos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setTitle("Procesos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelProcesos.setLayout(new java.awt.GridLayout(0, 1));

        jScrollPane1.setViewportView(jPanelProcesos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Stop16bis.gif")));
        btnSalir.setText("Ocultar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.add(btnSalir);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-529)/2, (screenSize.height-240)/2, 529, 240);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
        moPadre.formSalir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        moPadre.formSalir();
    }//GEN-LAST:event_formWindowClosing
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelProcesos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
