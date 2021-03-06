/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelPasarDatos.java
 *
 * Created on 25-sep-2010, 21:20:20
 */

package visualizarDiferenciasBD;

import ListDatos.JSelect;
import ListDatos.JSelectCampo;
import utilesBD.pasarDatos.JPasarDatos;
import utilesBD.pasarDatos.JProcesoPasarDatos;
import main.JDatosGeneralesP;
import ListDatos.JServerServidorDatosBD;
import ListDatos.estructuraBD.JTableDef;
import ListDatos.estructuraBD.JTableDefs;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import paquetesGeneradorInf.gui.JGuiConsulta;
import paquetesGeneradorInf.gui.JGuiConsultaDatos;
import utiles.JConversiones;
import utilesGUI.tabla.ITabla;
import utilesGUIx.formsGenericos.JMostrarPantalla;
import utilesGUIx.formsGenericos.JMostrarPantallaParam;

/**
 *
 * @author eduardo
 */
public class JPanelPasarDatos extends javax.swing.JPanel {

    private JTableModelTablas moTablaModelTablas;

    private JPasarDatos moPasar;
    /** Creates new form JPasarDatos */
    public JPanelPasarDatos(JPasarDatos poPAsar) {
        initComponents();

        moPasar = poPAsar;

        moTablaModelTablas = new JTableModelTablas(moPasar);
        jTableCZ2.setModel(moTablaModelTablas);
        TXTTroceo.setText(String.valueOf(moPasar.getNumReg()));
        TXTTransaccionCada.setText(String.valueOf(moPasar.getTransaccionCada()));
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCZ2 = new utilesGUIx.JTableCZ();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnIgualar = new utilesGUIx.JButtonCZ();
        btnNumeroRegistros = new utilesGUIx.JButtonCZ();
        btnBorrarTodosDatosDesitno = new utilesGUIx.JButtonCZ();
        btnDatosOrigen = new utilesGUIx.JButtonCZ();
        btnDatosDestino = new utilesGUIx.JButtonCZ();
        jPanel2 = new javax.swing.JPanel();
        jLabelCZ1 = new utilesGUIx.JLabelCZ();
        TXTApartirDe = new utilesGUIx.JTextFieldCZ();
        jLabelCZ2 = new utilesGUIx.JLabelCZ();
        TXTTroceo = new utilesGUIx.JTextFieldCZ();
        chkIgnoraErrores = new utilesGUIx.JCheckBoxCZ();
        jLabelCZ3 = new utilesGUIx.JLabelCZ();
        TXTTransaccionCada = new utilesGUIx.JTextFieldCZ();

        setLayout(new java.awt.BorderLayout());

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTableCZ2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCZ2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCZ2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCZ2);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(482, 65));
        jPanel3.setPreferredSize(new java.awt.Dimension(482, 65));

        btnIgualar.setText("A�adir datos desde origen a destino");
        btnIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualarActionPerformed(evt);
            }
        });
        jPanel3.add(btnIgualar);

        btnNumeroRegistros.setText("N� registros");
        btnNumeroRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumeroRegistrosActionPerformed(evt);
            }
        });
        jPanel3.add(btnNumeroRegistros);

        btnBorrarTodosDatosDesitno.setText("Borrar Datos tabla destino");
        btnBorrarTodosDatosDesitno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTodosDatosDesitnoActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrarTodosDatosDesitno);

        btnDatosOrigen.setText("Ver datos origen");
        btnDatosOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosOrigenActionPerformed(evt);
            }
        });
        jPanel3.add(btnDatosOrigen);

        btnDatosDestino.setText("Ver datos destino");
        btnDatosDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosDestinoActionPerformed(evt);
            }
        });
        jPanel3.add(btnDatosDestino);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabelCZ1.setText("A PARTIR DE");
        jPanel2.add(jLabelCZ1, new java.awt.GridBagConstraints());

        TXTApartirDe.setMinimumSize(new java.awt.Dimension(87, 19));
        TXTApartirDe.setPreferredSize(new java.awt.Dimension(87, 19));
        jPanel2.add(TXTApartirDe, new java.awt.GridBagConstraints());

        jLabelCZ2.setText("Recuperar trozos de ");
        jPanel2.add(jLabelCZ2, new java.awt.GridBagConstraints());

        TXTTroceo.setMinimumSize(new java.awt.Dimension(87, 19));
        TXTTroceo.setPreferredSize(new java.awt.Dimension(87, 19));
        jPanel2.add(TXTTroceo, new java.awt.GridBagConstraints());

        chkIgnoraErrores.setText("Ignora errores y \"p�alante\"");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        jPanel2.add(chkIgnoraErrores, gridBagConstraints);

        jLabelCZ3.setText("Transacci�n cada ");
        jPanel2.add(jLabelCZ3, new java.awt.GridBagConstraints());

        TXTTransaccionCada.setMinimumSize(new java.awt.Dimension(87, 19));
        TXTTransaccionCada.setPreferredSize(new java.awt.Dimension(87, 19));
        jPanel2.add(TXTTransaccionCada, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCZ2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCZ2MousePressed
        if(evt.getClickCount()>=2){
            btnIgualarActionPerformed(null);
        }
    }//GEN-LAST:event_jTableCZ2MousePressed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked

}//GEN-LAST:event_jScrollPane2MouseClicked

    private void btnIgualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualarActionPerformed
        try{
            if(jTableCZ2.getSelectedRow()>=0){
                int[] lRows = jTableCZ2.getSelectedRows();
                
                int lAPartirDe = (int) JConversiones.cdbl(TXTApartirDe.getText());
                if(lAPartirDe>0 && lRows.length>1){
                    throw new Exception("No se puede poner A Partir de cuando seleccionas mas de una tabla");
                }
                
                String[] lasTablas = new String[lRows.length];
                for(int i = 0 ; i < lRows.length;i++){
                    String lsTabla = moTablaModelTablas.getValueAt(lRows[i],0).toString();
                    lasTablas[i] = lsTabla;
                }
                moPasar.setNumReg(Integer.valueOf(TXTTroceo.getText()).intValue());
                JProcesoPasarDatos loPasar = new JProcesoPasarDatos(moPasar, lasTablas, lAPartirDe, chkIgnoraErrores.isSelected());
                loPasar.setTransaccionCada((int)JConversiones.cdbl(TXTTransaccionCada.getText()));
                JDatosGeneralesP.getDatosGenerales().getThreadGroup().addProcesoYEjecutar(loPasar);

            }else{
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, "no hay tabla seleccionada");
            }
        }catch(Throwable e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
}//GEN-LAST:event_btnIgualarActionPerformed

    private void btnNumeroRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumeroRegistrosActionPerformed
        try{
            if(jTableCZ2.getSelectedRow()>=0){
                int[] lRows = jTableCZ2.getSelectedRows();
                int lRegistros = 0;
                int lRegistros2 = 0;
                for(int i = 0 ; i < lRows.length;i++){
                    String lsTabla = moTablaModelTablas.getValueAt(lRows[i],0).toString();
                    lRegistros += moPasar.getRegistrosTablaBD1(lsTabla);
                    lRegistros2 += moPasar.getRegistrosTablaBD2(lsTabla);
                }


                utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this,
                        "Registros BD origen = " + String.valueOf(lRegistros) + " " +
                        "Registros BD destino = " + String.valueOf(lRegistros2) );
            }else{
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, "no hay tabla seleccionada");
            }
        }catch(Exception e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_btnNumeroRegistrosActionPerformed

    private void btnBorrarTodosDatosDesitnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTodosDatosDesitnoActionPerformed
        try{
            if(jTableCZ2.getSelectedRow()>=0){
                int[] lRows = jTableCZ2.getSelectedRows();
                for(int i = 0 ; i < lRows.length;i++){
                    String lsTabla = moTablaModelTablas.getValueAt(lRows[i],0).toString();
                    JTableDef loTabla = moPasar.getTable2(lsTabla);
                    if(loTabla==null){
                        utilesGUIx.msgbox.JMsgBox.mensajeError(this, "no existe la tabla en la BD2");
                    }else{
                        int lOrden = JOptionPane.showConfirmDialog(this
                                        ,"�Deseas borrar secuencialmente (si) o todos de golpe (no) los datos de la tabla destino "+lsTabla+"?" ,
                                        "borrado",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        boolean lbSecuen = lOrden==JOptionPane.YES_OPTION;
                        if(lOrden!=JOptionPane.CANCEL_OPTION){
                            if(JOptionPane.showConfirmDialog(
                                    this,
                                    "�Estas seguro de borrar todos los datos ("+String.valueOf(moPasar.getRegistrosTablaBD2(lsTabla))+") de la tabla destino "+lsTabla+"?" ,
                                    "borrado",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE)==JOptionPane.YES_OPTION){
                                moPasar.borrarDatosDestino(
                                        lsTabla
                                        , lbSecuen);
                                utilesGUIx.msgbox.JMsgBox.mensajeInformacion(this, "Proceso terminado");
                            }   
                        }                            
                    }
                }
                
            }else{
                utilesGUIx.msgbox.JMsgBox.mensajeError(this, "no hay tabla seleccionada");
            }
        }catch(Exception e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_btnBorrarTodosDatosDesitnoActionPerformed

    private void mostrarConsulta(boolean pbOrigen) throws Exception{
            if(jTableCZ2.getSelectedRow()>=0){
                int[] lRows = jTableCZ2.getSelectedRows();
                JGuiConsulta loGuiConsulta = new JGuiConsulta();
                JGuiConsultaDatos loDatos;
                JTableDefs loTablas;
                if(pbOrigen){
                    loDatos = new JGuiConsultaDatos(moPasar.getServerBD1());
                    loTablas = moPasar.getServerBD1().getTableDefs();
                }else{
                    loDatos = new JGuiConsultaDatos(moPasar.getServerBD2());
                    loTablas = moPasar.getServerBD2().getTableDefs();
                }
                String lsTabla = moTablaModelTablas.getValueAt(lRows[0],0).toString();
                JSelect loSelect = new JSelect(lsTabla);
                JTableDef loTabla = loTablas.get(lsTabla);
                for(int i = 0; i < loTabla.getCampos().size(); i++){
                    loSelect.addCampo(loTabla.getNombre(), loTabla.getCampos().getListaCampos().get(i).getNombre());
                }
                loDatos.setSelect(loSelect);
                loGuiConsulta.setDatos(loDatos);
                JDatosGeneralesP.getDatosGenerales().getMostrarPantalla().mostrarForm(
                        new JMostrarPantallaParam(
                            loGuiConsulta, 600, 500,
                            JMostrarPantalla.mclEdicionFrame,
                            "Consulta"));             
            }else{
                throw new Exception("ninguna fila seleccionada");
            }
        
    }
    
    private void btnDatosOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosOrigenActionPerformed
        
        try{
            mostrarConsulta(true);
        }catch(Exception e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_btnDatosOrigenActionPerformed

    private void btnDatosDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosDestinoActionPerformed
        try{
            mostrarConsulta(false);
        }catch(Exception e){
            e.printStackTrace();
            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());
        }
    }//GEN-LAST:event_btnDatosDestinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUIx.JTextFieldCZ TXTApartirDe;
    private utilesGUIx.JTextFieldCZ TXTTransaccionCada;
    private utilesGUIx.JTextFieldCZ TXTTroceo;
    private utilesGUIx.JButtonCZ btnBorrarTodosDatosDesitno;
    private utilesGUIx.JButtonCZ btnDatosDestino;
    private utilesGUIx.JButtonCZ btnDatosOrigen;
    private utilesGUIx.JButtonCZ btnIgualar;
    private utilesGUIx.JButtonCZ btnNumeroRegistros;
    private utilesGUIx.JCheckBoxCZ chkIgnoraErrores;
    private utilesGUIx.JLabelCZ jLabelCZ1;
    private utilesGUIx.JLabelCZ jLabelCZ2;
    private utilesGUIx.JLabelCZ jLabelCZ3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private utilesGUIx.JTableCZ jTableCZ2;
    // End of variables declaration//GEN-END:variables

}

/**Para tablas simples y sin edici�n*/
class JTableModelTablas extends AbstractTableModel implements TableModelListener, ITabla {
  public JTableDefs moLista;
  public int mlTipoEstruc;
    private final JPasarDatos moDatos;

  public JTableModelTablas(JPasarDatos poDatos){
    moLista = poDatos.getTablasBD1();
    moDatos=poDatos;
  }

  public int getColumnCount() {
      return 1;
  }

  public int getRowCount() {
      return moLista.getListaTablas().size()+1;
  }

  public String getColumnName(int col) {
      return "Tabla";
  }

  public Object getValueAt(int row, int col) {

     if(row >= moLista.getListaTablas().size()){
        return "";
      }else{
        return moLista.get(row).getNombre();
      }
  }

  public Class getColumnClass(int c) {
    return String.class;
  }
  public void tableChanged(TableModelEvent e) {
    fireTableChanged(e);
  }
  public void sortByColumn(int plColumn, boolean pbAscendente){
  }
   public boolean isCellEditable(int row, int col) {
      return row == moLista.getListaTablas().size();
  }
    public void setValueAt(Object value, int row, int col) {
        if(row == moLista.getListaTablas().size()){
            try {
                moLista.getListaTablas().add(
                        ((JServerServidorDatosBD)moDatos.getServerBD1()).getTableDef(value.toString())
                        );
            } catch (Exception ex) {
                utilesGUIx.msgbox.JMsgBox.mensajeErrorYLog(null, ex, "JFormPAsarDstos");
            }
        }
  }
    public java.awt.Component getComponent(int row, int col) {
        return null;
    }

}
