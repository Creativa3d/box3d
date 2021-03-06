/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilesGUIxAvisos.forms.util;

import ListDatos.JListDatos;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import utiles.JDateEdu;
import utilesGUIx.msgbox.JMsgBox;
import utilesGUIxAvisos.consultas.JTFORMGUIXEVENTOS;
import utilesGUIxAvisos.tablasControladoras.JT2GUIXEVENTOS;

/**
 *
 * @author eduardo
 */
public class JPanelDIA  extends JPanel {
  
    private static final long serialVersionUID = 1L;
    private JDateEdu moDate;
    private JTFORMGUIXEVENTOS moEventos;
    private JT2GUIXEVENTOS moControlador;
    private JTableModelEVENTOSDIA moModeloDatosEventos;
    private boolean mbHoy=false;
    private JPanel jPanelTableRenderPopUp;
    private JPopupMenu jPopupMenuEvento;
    private JPanel jPanelVerPopUp;
    private JPanelTableRender jPanelTableRenderPopup;

    /**
     * Creates new form JPanelDIA
     */
    public JPanelDIA() {
        initComponents();
        jTableDatos.getTableHeader().setVisible(false);
        jTableDatos.setDefaultRenderer(JTableRenderEventoParam.class, new JTableRenderEventoDIA());
        jTableDatos.setRowHeight(25);
        
    }
    public void setPopUp(JPopupMenu poPopupMenuEvento, JPanel poPanelver, JPanelTableRender poRednerPopUp) {
        jPanelVerPopUp=poPanelver;
        jPopupMenuEvento=poPopupMenuEvento;
        jPanelTableRenderPopup=poRednerPopUp;
        
    }
    public void setHoy(boolean b) {
        mbHoy = b;
        if(mbHoy){
            lblDia.setBackground(Color.YELLOW);
//            lblDia.setBorder(new javax.swing.border.EtchedBorder(Color.RED, Color.BLUE));
        }else{
            lblDia.setBackground(jPanel1.getBackground());
//            lblDia.setBorder(null);
        }
    }
    public void setModel(JDateEdu poDate, JTFORMGUIXEVENTOS poEventos, JT2GUIXEVENTOS poControlador) throws Exception {
        moDate = poDate;
        lblDia.setText(String.valueOf(poDate.getDia()));
        moEventos = poEventos;
        moControlador = poControlador;
        moModeloDatosEventos = new JTableModelEVENTOSDIA(poEventos, poDate);
        jTableDatos.setModel(moModeloDatosEventos);
    }

    @Override
    public void setVisible(boolean aFlag) {
        jPanel1.setVisible(aFlag);
        jScrollPaneTablaDatos.setVisible(aFlag);
//        super.setVisible(aFlag);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblDia = new utilesGUIx.JLabelCZ();
        jBtnAnadir = new utilesGUIx.JButtonCZ();
        jScrollPaneTablaDatos = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 2));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblDia.setBackground(new java.awt.Color(255, 255, 255));
        lblDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDia.setText("31");
        lblDia.setToolTipText("");
        lblDia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDia.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(lblDia, gridBagConstraints);

        jBtnAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/New16.gif"))); // NOI18N
        jBtnAnadir.setMaximumSize(new java.awt.Dimension(26, 26));
        jBtnAnadir.setMinimumSize(new java.awt.Dimension(26, 26));
        jBtnAnadir.setPreferredSize(new java.awt.Dimension(26, 26));
        jBtnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnadirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAnadir, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPaneTablaDatos.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneTablaDatos.setBorder(null);

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDatos.setToolTipText("");
        jTableDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableDatos.setEditingColumn(0);
        jTableDatos.setEditingRow(0);
        jTableDatos.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDatos.setOpaque(false);
        jTableDatos.setRowHeight(50);
        jTableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosMouseClicked(evt);
            }
        });
        jScrollPaneTablaDatos.setViewportView(jTableDatos);

        add(jScrollPaneTablaDatos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnadirActionPerformed
        try {
            moControlador.setFechaDefecto(moDate.msFormatear("dd/MM/yyyy"));
            moControlador.anadir();
            
        } catch (Exception ex) {
            JMsgBox.mensajeError(this, ex);
        }
    }//GEN-LAST:event_jBtnAnadirActionPerformed

    public int[] getSelectedRows() {
//        return getTabla().getSelectedRows();        
        int[] lalRows = jTableDatos.getSelectedRows();
        try{
            for(int i = 0 ; i<lalRows.length; i++){
                lalRows[i] = jTableDatos.convertRowIndexToModel(lalRows[i]);
            }
        }catch(Throwable e){
//            JDepuracion.anadirTexto(getClass().getName(), e);
        }
        return lalRows;
    }
    public int getSelectedRow() {
        int lIndice = -1;
        int [] lalIndices = getSelectedRows();
        if(lalIndices!=null && lalIndices.length>0){
            lIndice = lalIndices[0];
        }
        return lIndice;
    }


    private void jTableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosMouseClicked
        try {
            int lSelect = getSelectedRow();
            if (lSelect>=0 &&
                lSelect<moModeloDatosEventos.getRowCount()){
                if (evt.getClickCount()==1){
                    jPanelTableRenderPopup.setValue((JTableRenderEventoParam) moModeloDatosEventos.getValueAt(lSelect, 0), false);
                    jPopupMenuEvento.setVisible(true);
                    jPopupMenuEvento.setLocation(
                            evt.getXOnScreen()-jPanelVerPopUp.getWidth()/3
                            , evt.getYOnScreen()-jPanelVerPopUp.getHeight()-10);
                    
                }else if (evt.getClickCount()>1){
                    JTableRenderEventoParam loDia = (JTableRenderEventoParam) moModeloDatosEventos.getValueAt(lSelect, 0);
                    if(moEventos.moList.buscar(
                            JListDatos.mclTIgual
                            , new int[]{moEventos.lPosiCALENDARIO, moEventos.lPosiCODIGO}
                            ,new String[]{
                                loDia.getCalendario(), loDia.getCodigo()
                            })){
                        moControlador.editar(moEventos.moList.getIndex());
                    }else{
                        JOptionPane.showMessageDialog(this, "No existe una fila actual");
                    }
                }
            }else {
                JOptionPane.showMessageDialog(this, "No existe una fila actual");
            }    
            
        } catch (Exception ex) {
            JMsgBox.mensajeError(this, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_jTableDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JButtonCZ jBtnAnadir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneTablaDatos;
    private javax.swing.JTable jTableDatos;
    private utilesGUIx.JLabelCZ lblDia;
    // End of variables declaration//GEN-END:variables




}
