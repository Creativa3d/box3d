/*
 * JFormGeneradorClases.java
 *
 * Created on 5 de agosto de 2005, 17:52
 */

package generadorClases;

import ListDatos.estructuraBD.JTableDef;
import generadorClases.modulosCodigo.*;
import java.io.IOException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import utilesGUIx.*;

public class JFormGeneradorClases extends javax.swing.JFrame {
    
    private JProyecto moProyecto;
    private String msTabla;
    private JFormVisor moVisor;
    
    /** Creates new form JFormGeneradorClases */
    public JFormGeneradorClases() {
        initComponents();
        jTabbedPane1.setVisible(false);
        moProyecto = new JProyecto();
        int lNumeroGeneral = 0;
        int lNumeroTabla = 0;
        for(int i = 0 ; i < moProyecto.getListaModulos().size(); i++){
            IModuloProyecto loModulo = (IModuloProyecto) moProyecto.getListaModulos().get(i);
            final String lsnombre = loModulo.getNombreModulo();
            //a�adimos el menu
            JMenuItem loMenu = new JMenuItem("Generar " + (loModulo.isGeneral() ? "" : "Todas las ") + lsnombre);
            loMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        moProyecto.generarCodigo(lsnombre);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        utilesGUIx.msgbox.JMsgBox.mensajeError(JFormGeneradorClases.this, ex);
                    }
                }
            });
            jMenuProyecto.add(loMenu);

            JLabelCZ lblLabel = new JLabelCZ();
            JButtonCZ btnBoton = new JButtonCZ();
            lblLabel.setText(lsnombre);
            java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            if(loModulo.isGeneral()){
                jPanelGeneral.add(lblLabel, gridBagConstraints);
                lNumeroGeneral++;
            }else{
                jPanelporTabla.add(lblLabel, gridBagConstraints);
                lNumeroTabla++;
            }

            btnBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generadorClases/images/Zoom16.gif")));
            btnBoton.setToolTipText("Ver c�digo generado");
            btnBoton.setMaximumSize(new java.awt.Dimension(20, 20));
            btnBoton.setMinimumSize(new java.awt.Dimension(20, 20));
            btnBoton.setPreferredSize(new java.awt.Dimension(20, 20));
            btnBoton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        visualizarCodigoComun(lsnombre);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        utilesGUIx.msgbox.JMsgBox.mensajeError(JFormGeneradorClases.this, ex);
                    }
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            if(loModulo.isGeneral()){
                if(lNumeroGeneral % 3 == 0){
                    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                }
                jPanelGeneral.add(btnBoton, gridBagConstraints);
            }else{
                if(lNumeroTabla % 3 == 0){
                    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                }
                jPanelporTabla.add(btnBoton, gridBagConstraints);
            }

        }
        moProyecto=null;

    }

    private void visualizarCodigoComun(String psNombreModulo) throws IOException {
        msTabla = cmbTablas.getFilaActual().msCampo(0);
        moProyecto.setTablaActual(msTabla);
        if (moVisor == null) {
            moVisor = new JFormVisor(this,false);
        }
        moVisor.setCodigo(moProyecto.getCodigoTabla(psNombreModulo, msTabla));
        moVisor.setVisible(true);
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jFC = new javax.swing.JFileChooser();
        jToolBar2 = new javax.swing.JToolBar();
        btnNUEVO = new utilesGUIx.JButtonCZ();
        btnGENERARCOMPLETO = new utilesGUIx.JButtonCZ();
        btnGENERARTABLA = new utilesGUIx.JButtonCZ();
        btnSalir = new utilesGUIx.JButtonCZ();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbTablas = new utilesGUIx.JComboBoxCZ();
        btnADDSelect = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanelporTabla = new javax.swing.JPanel();
        jPanelGeneral = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuNuevo = new javax.swing.JMenuItem();
        jMenuOpciones = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuFormatoAntiguo = new javax.swing.JMenuItem();
        jMenuProyecto = new javax.swing.JMenu();
        jMenuGenerarCompleto = new javax.swing.JMenuItem();
        jMenuGenerarTabla = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generador de proyectos");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generadorClases/images/Add16.gif"))); // NOI18N
        btnNUEVO.setToolTipText("Nuevo proyecto");
        btnNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNUEVOActionPerformed(evt);
            }
        });
        jToolBar2.add(btnNUEVO);

        btnGENERARCOMPLETO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generadorClases/images/Export16.gif"))); // NOI18N
        btnGENERARCOMPLETO.setToolTipText("Generar proyecto completo");
        btnGENERARCOMPLETO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGENERARCOMPLETOActionPerformed(evt);
            }
        });
        jToolBar2.add(btnGENERARCOMPLETO);

        btnGENERARTABLA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generadorClases/images/ColumnInsertBefore16.gif"))); // NOI18N
        btnGENERARTABLA.setToolTipText("Generar tabla seleccionada");
        btnGENERARTABLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGENERARTABLAActionPerformed(evt);
            }
        });
        jToolBar2.add(btnGENERARTABLA);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generadorClases/images/Stop16.gif"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSalir);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(jToolBar2, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Selecciona la tabla de trabajo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(jLabel4, gridBagConstraints);

        cmbTablas.setPreferredSize(new java.awt.Dimension(200, 22));
        cmbTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTablasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(cmbTablas, gridBagConstraints);

        btnADDSelect.setText("Add Select");
        btnADDSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDSelectActionPerformed(evt);
            }
        });
        jPanel5.add(btnADDSelect, new java.awt.GridBagConstraints());

        jPanel8.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(jPanel8, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanelporTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Capa Fisica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 204)));
        jPanelporTabla.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(jPanelporTabla, gridBagConstraints);

        jPanelGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clases Comunes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 204)));
        jPanelGeneral.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(jPanelGeneral, gridBagConstraints);

        jPanel9.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(jPanel7, gridBagConstraints);

        jTabbedPane1.addTab("Clases Proyecto", jPanel5);

        jPanel6.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Def. Pesta�as", jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jTabbedPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jMenuArchivo.setText("Archivo");

        jMenuNuevo.setText("Nuevo Proyecto");
        jMenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuNuevo);

        jMenuOpciones.setText("Opciones");
        jMenuOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcionesActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuOpciones);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed1(evt);
            }
        });
        jMenuArchivo.add(jMenuSalir);

        jMenuFormatoAntiguo.setText("Formato Antoguo");
        jMenuFormatoAntiguo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFormatoAntiguoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuFormatoAntiguo);

        jMenuBar2.add(jMenuArchivo);

        jMenuProyecto.setText("Generar");

        jMenuGenerarCompleto.setText("Generar Proyecto Completo");
        jMenuGenerarCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGenerarCompletoActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuGenerarCompleto);

        jMenuGenerarTabla.setText("Generar Tabla Seleccionada");
        jMenuGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGenerarTablaActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuGenerarTabla);

        jMenuBar2.add(jMenuProyecto);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(698, 553));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuFormatoAntiguoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFormatoAntiguoActionPerformed
        JGeneradorJCTable.mclTipo = 1;
    }//GEN-LAST:event_jMenuFormatoAntiguoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    private void cmbTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTablasActionPerformed
        msTabla = cmbTablas.getFilaActual().msCampo(0);
    }//GEN-LAST:event_cmbTablasActionPerformed

    
    private void btnGENERARTABLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGENERARTABLAActionPerformed
        if(moProyecto == null) {
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,"Debes iniciar primero un nuevo proyecto");
        } else {
            try {
                moProyecto.generarCodigoTabla(msTabla);
            } catch (Exception ex) {
                ex.printStackTrace();
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, ex);
            }
        }        
    }//GEN-LAST:event_btnGENERARTABLAActionPerformed
    
    private void jMenuGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGenerarTablaActionPerformed
        if(moProyecto == null) {
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,"Debes iniciar primero un nuevo proyecto");
        } else {
            try {
                moProyecto.generarCodigoTabla(msTabla);
            } catch (Exception ex) {
                ex.printStackTrace();
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, ex);
            }
            
        }        
    }//GEN-LAST:event_jMenuGenerarTablaActionPerformed

    private void btnGENERARCOMPLETOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGENERARCOMPLETOActionPerformed
        if(moProyecto == null) {
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,"Debes iniciar primero un nuevo proyecto");
        } else {
            try {
                moProyecto.generarProyectoCompleto();
            } catch (IOException ex) {
                ex.printStackTrace();
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, ex);
            }
        }        
    }//GEN-LAST:event_btnGENERARCOMPLETOActionPerformed

    private void jMenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoActionPerformed
        nuevoProyecto();
    }//GEN-LAST:event_jMenuNuevoActionPerformed

    private void btnNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNUEVOActionPerformed
        nuevoProyecto();
    }//GEN-LAST:event_btnNUEVOActionPerformed

    private void nuevoProyecto() {
        try{
            if(moProyecto == null) {
                moProyecto = new JProyecto();
            }
            moProyecto.nuevo();
            this.setTitle("Generador de proyectos:  " + moProyecto.getConex().getRutaProyectoRaiz());
            jTabbedPane1.setVisible(true);

            recargarTablas();
        }catch(Throwable e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.getMessage());
        }
    }
    private void recargarTablas(){
        cmbTablas.borrarTodo();
        cmbTablas.addLinea("","");

        for(int i = 0; i < moProyecto.getListaTablas().size(); i++ ){
            JTableDef loTabla = (JTableDef)moProyecto.getListaTablas().get(i);
            cmbTablas.addLinea(loTabla.getNombre(), loTabla.getNombre());
        }
    }
    
    private void jMenuGenerarCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGenerarCompletoActionPerformed
        if(moProyecto == null) {
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,"Debes iniciar primero un nuevo proyecto");
        } else {
            try {
                moProyecto.generarProyectoCompleto();
            } catch (IOException ex) {
                ex.printStackTrace();
                utilesGUIx.msgbox.JMsgBox.mensajeError(this,ex);
            }
        }        
    }//GEN-LAST:event_jMenuGenerarCompletoActionPerformed
    
    private void jMenuOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcionesActionPerformed
        if(moProyecto == null) {
            utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,"Debes iniciar primero un nuevo proyecto");
        } else {
            moProyecto.mostraOpciones();            
        }
    }//GEN-LAST:event_jMenuOpcionesActionPerformed
    
    //Selecciona la ruta de trabajo    
    //Creo la conexion a la base de datos
    private void jMenuSalirActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed1
        dispose();
    }//GEN-LAST:event_jMenuSalirActionPerformed1

    private void btnADDSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDSelectActionPerformed
            try {
                String lsSelect = JOptionPane.showInputDialog("Select");
                String lsNombre = JOptionPane.showInputDialog("Nombre");
                moProyecto.getConex().addSelect(lsSelect, lsNombre);
                recargarTablas();

            } catch (Exception ex) {
                utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(this,ex,getClass().getName());
            }
    }//GEN-LAST:event_btnADDSelectActionPerformed
    

    //Guarda en bloque todas las tablas como JTables    
    //Guarda una sola tabla como JTable   
    //Cuando selecciono una tabla, genero el codigo de cada modulo    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFormGeneradorClases().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADDSelect;
    private utilesGUIx.JButtonCZ btnGENERARCOMPLETO;
    private utilesGUIx.JButtonCZ btnGENERARTABLA;
    private utilesGUIx.JButtonCZ btnNUEVO;
    private utilesGUIx.JButtonCZ btnSalir;
    private utilesGUIx.JComboBoxCZ cmbTablas;
    private javax.swing.JFileChooser jFC;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuFormatoAntiguo;
    private javax.swing.JMenuItem jMenuGenerarCompleto;
    private javax.swing.JMenuItem jMenuGenerarTabla;
    private javax.swing.JMenuItem jMenuNuevo;
    private javax.swing.JMenuItem jMenuOpciones;
    private javax.swing.JMenu jMenuProyecto;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelporTabla;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
    
}
