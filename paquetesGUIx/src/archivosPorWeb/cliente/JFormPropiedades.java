/*
 * JFormPropiedades2.java
 *
 * Created on 18 de septiembre de 2004, 11:28
 */

package archivosPorWeb.cliente;

import archivosPorWeb.cliente.*;
import ListDatos.*;
import java.awt.Frame;
import utilesGUI.tabla.*;

import java.util.*;
import java.io.*;
import java.net.*;

import utiles.config.*;
import utiles.*;

public class JFormPropiedades extends java.awt.Dialog implements java.awt.event.FocusListener, java.awt.event.ActionListener, java.awt.event.ItemListener, RowColChangeListener  {
    
    Properties moPropiedades = null;
    JTablaMotorProp moMotor = null;
    boolean mbEsNuevo = false;
        
    /** Creates new form JFormPropiedades2 */
    public JFormPropiedades(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        inicializar();
        
        moPropiedades = (Properties) ConfigurationParametersManager.getTodasPropiedades();
        moMotor = new JTablaMotorProp(moPropiedades);
        jTabla1.setTabla(moMotor);
        jTabla1.setAncho(1, 200);
    }
  
    private void inicializar(){
        AsignarEventos();
    }
    /**
     * Asignamos a los controles el listener que recibir� los eventos lanzados por estos
     * El listener ser� este objeto que implementar� los interfaces necesarios
     */
    private void AsignarEventos(){
        buttonNuevo.addActionListener(this);
        buttonCancelar.addActionListener(this);
        buttonGuardar.addActionListener(this);
        jTabla1.addRowColChangeListener(this);
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabla1 = new utilesGUI.tabla.JTabla();
        panel2 = new java.awt.Panel();
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        textNombre = new utilesGUI.TextFieldCZ();
        label2 = new java.awt.Label();
        textValor = new utilesGUI.TextFieldCZ();
        panel3 = new java.awt.Panel();
        buttonNuevo = new utilesGUI.ButtonCZ();
        buttonGuardar = new utilesGUI.ButtonCZ();
        buttonCancelar = new utilesGUI.ButtonCZ();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        add(jTabla1, java.awt.BorderLayout.CENTER);

        panel2.setLayout(new java.awt.BorderLayout());

        panel1.setLayout(new java.awt.GridLayout(2, 2));

        label1.setText("Nombre:");
        panel1.add(label1);

        panel1.add(textNombre);

        label2.setText("Valor:");
        panel1.add(label2);

        panel1.add(textValor);

        panel2.add(panel1, java.awt.BorderLayout.CENTER);

        buttonNuevo.setLabel("Nuevo");
        panel3.add(buttonNuevo);

        buttonGuardar.setLabel("Guardar");
        panel3.add(buttonGuardar);

        buttonCancelar.setLabel("Cancelar");
        panel3.add(buttonCancelar);

        panel2.add(panel3, java.awt.BorderLayout.SOUTH);

        add(panel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-515)/2, (screenSize.height-363)/2, 515, 363);
    }
    // </editor-fold>//GEN-END:initComponents
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        dispose();
    }//GEN-LAST:event_exitForm

 private void jTabla1ComponentResized(java.awt.event.ComponentEvent evt) {
        // Add your handling code here:
        if(moMotor!=null) jTabla1.setTabla(moMotor);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonCancelar){
            IFilaDatos loFila =(IFilaDatos)moMotor.moList.get(jTabla1.getRowSelTabla());
            textNombre.setText(loFila.msCampo(0));
            textValor.setText(loFila.msCampo(1));
        }
        if (source == buttonNuevo){
            mbEsNuevo = true;
            textNombre.setText("");
            textValor.setText("");
        }
        if (source == buttonGuardar){
            if(mbEsNuevo){
                IFilaDatos loFila = new JFilaDatosDefecto(
                    textNombre.getText() + JFilaDatosDefecto.mcsSeparacion1 +
                    textValor.getText() + JFilaDatosDefecto.mcsSeparacion1);
                moMotor.moList.add(loFila);
                jTabla1.setFilaSelec(moMotor.moList.size()-1);
                jTabla1.setVisibleFilaPrimera(moMotor.moList.size()-1);
            }else{
                IFilaDatos loFila =(IFilaDatos)moMotor.moList.get(jTabla1.getRowSelTabla());
                loFila.setArray(new String[]{textNombre.getText() ,
                                 textValor.getText() + JFilaDatosDefecto.mcsSeparacion1});
                jTabla1.setFilaSelec(jTabla1.getRowSelTabla());
            }
            mbEsNuevo = false;
            try{
                moPropiedades.put(JDatosGeneralesP.getDatosGenerales().mcsDireccionServidor, JDatosGeneralesP.getDatosGenerales().getDireccionServidor());
                moPropiedades.put(JDatosGeneralesP.getDatosGenerales().mcsLookAndFeel, JDatosGeneralesP.getDatosGenerales().getLookAndFeel());
                moPropiedades.put(JDatosGeneralesP.getDatosGenerales().mcsLookAndFeelTema, JDatosGeneralesP.getDatosGenerales().getLookAndFeelTema());

                Iterator loEnum = moMotor.moList.iterator();
                for(;loEnum.hasNext();){
                    IFilaDatos loFila = (IFilaDatos)loEnum.next();
                    moPropiedades.put(loFila.msCampo(0), loFila.msCampo(1));
                }
                
                ConfigurationParametersManager.setTodasPropiedades(moPropiedades);
                ConfigurationParametersManager.guardarPropiedades();
                moMotor = new JTablaMotorProp(moPropiedades);
                jTabla1.setTabla(moMotor);

            }catch(Exception e1){
                utilesGUI.msgbox.JDialogo.showDialog(this, e1.toString());
            }
        }
        
        
    }    
    
    public void focusGained(java.awt.event.FocusEvent e) {
    }    
    
    public void focusLost(java.awt.event.FocusEvent e) {
    }
    
    public void itemStateChanged(java.awt.event.ItemEvent e) {
    }
    
    public void setClave(String psClave, String psTabla) {
    }
    
    public void CambioFila(RowColChangeEvent e) {
        try{
            IFilaDatos loFila= (IFilaDatos)moMotor.moList.get(jTabla1.getRowSelTabla());
            textNombre.setText(loFila.msCampo(0));
            textValor.setText(loFila.msCampo(1));
            mbEsNuevo = false;
        }catch(Exception e2){
            e2.printStackTrace();
        }
        
    }
        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilesGUI.ButtonCZ buttonCancelar;
    private utilesGUI.ButtonCZ buttonGuardar;
    private utilesGUI.ButtonCZ buttonNuevo;
    private utilesGUI.tabla.JTabla jTabla1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private utilesGUI.TextFieldCZ textNombre;
    private utilesGUI.TextFieldCZ textValor;
    // End of variables declaration//GEN-END:variables
    
}

class JTablaMotorProp implements ITablaAntig {
    public IListaElementos moList;

    public JTablaMotorProp(Properties poPropiedades){
        moList = new JListaElementos();
        Enumeration loEnum = poPropiedades.keys();
        moList = new JListaElementos();
        for(;loEnum.hasMoreElements();){
            String lsNombre = (String)loEnum.nextElement();
            moList.add(new JFilaDatosDefecto(lsNombre + JFilaDatosDefecto.mcsSeparacion1 + poPropiedades.getProperty(lsNombre) + JFilaDatosDefecto.mcsSeparacion1));
        }
    }
    
    public Class getColumnClass(int c) {
        return String.class;
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(int col) {
        switch(col){
            case 0: return "Nombre";
            case 1: return "Valor";
        }
        return "";
    }
    
    public int getRowCount() {
        return moList.size();
    }
    
    public Object getValueAt(int row, int col) {
        IFilaDatos loFila = (IFilaDatos)moList.get(row);
        return loFila.msCampo(col);
    }
    
    public boolean isCellEditable(int row, int col) {
//        switch(col) {
//            case 0: return false;
//            case 1: return true;
//        }
        return false;
    }
    
    public void setValueAt(Object value, int row, int col) {
    }
    
    public void sortByColumn(int plColumn, boolean pbAscendente) {
        
    }
    public java.awt.Component getComponent(int x,int y){
        utilesGUI.TextFieldCZ loText = new utilesGUI.TextFieldCZ();
        return loText;
    }
}
