/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosPorWeb.cliente;

import archivosPorWeb.comun.IServidorArchivos;
import archivosPorWeb.comun.JServidorArchivos;

/**
 *
 * @author eduardo
 */
public class JPanelDosSistemasArchivos extends javax.swing.JPanel {

    /**
     * Creates new form JPanelDosSistemasArchivos
     */
    public JPanelDosSistemasArchivos() {
        initComponents();
    }
    
    public void setDatos(IServidorArchivos poServer) throws Exception{
        JServidorArchivos loServidor = new JServidorArchivos();
        jPanelArchivos1.setDatos(loServidor);
        jPanelArchivos1.rellenarPantalla();
        
        jPanelArchivos2.setDatos(poServer);
        jPanelArchivos2.rellenarPantalla();
        
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0,0,screenSize.width, screenSize.height-100);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelArchivos1 = new archivosPorWeb.cliente.JPanelArchivos();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelArchivos2 = new archivosPorWeb.cliente.JPanelArchivos();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Local");
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jPanelArchivos1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Remoto");
        jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);
        jPanel2.add(jPanelArchivos2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setBottomComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public archivosPorWeb.cliente.JPanelArchivos jPanelArchivos1;
    public archivosPorWeb.cliente.JPanelArchivos jPanelArchivos2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
