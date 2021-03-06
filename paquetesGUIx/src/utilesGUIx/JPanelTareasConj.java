/*
 * JPanelTareasConj.java
 *
 * Created on 9 de abril de 2007, 20:49
 */

package utilesGUIx;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utiles.IListaElementos;
import utiles.JListaElementos;

public class JPanelTareasConj extends javax.swing.JPanel implements ActionListener, ChangeListener {
    private final IListaElementos moTareas = new JListaElementos();
    private int mlHeightMinimo = 26;
    private int mlHeightAux;
    private JLabel moLabelUlt = new JLabel();
    
//    private Dimension moPreference;
    /** Creates new form JPanelTareasConj */
    public JPanelTareasConj() {
        initComponents();
        jScrollPane1.getViewport().addChangeListener(this);
    }
    public JPanelTareas addTarea(utilesGUIx.JPanelTareas jPanelTareas1){
        moTareas.add(jPanelTareas1);
        jPanelTareas1.addActionListener(this);
//        moPreference = new Dimension((int)this.getPreferredSize().getWidth(), (int)this.getPreferredSize().getHeight());
//        moPreference.setSize(moPreference.getWidth(), moPreference.getHeight() - 27 * moTareas.size());

        jPanel1.remove(moLabelUlt);
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanelTareas1, gridBagConstraints);
        jPanelTareas1.setAmpliado(true);
        mlHeightMinimo = jPanelTareas1.getHeightMinimo();
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(moLabelUlt, gridBagConstraints);
        
        validate();
        return jPanelTareas1;
    }
    public JPanelTareas addTarea(final String psGrupo){
        utilesGUIx.JPanelTareas jPanelTareas1 = new utilesGUIx.JPanelTareas();
        jPanelTareas1.setText(psGrupo);
        return addTarea(jPanelTareas1);
    }
    private Dimension getSizeTotal(){
        Dimension loDim = new Dimension(getPreferredSize().width, getPreferredSize().height);
        if(getSize().height > loDim.height){
            loDim.height = getSize().height;
        }
        mlHeightAux = loDim.height;
        loDim.height = loDim.height - mlHeightMinimo * moTareas.size()+14;//no se pq es 14 , pero ahora mismo no me importa
        return loDim;
    }

    public Component add(Component comp) {
        if(comp instanceof JPanelTareas){
            return addTarea((JPanelTareas)comp);
        } else {
            return super.add(comp);
        }
    }

    private void setSizeTotal(int plWidth, int plHeight){
        setPreferredSize(new Dimension(plWidth, plHeight));
    }
    private boolean establecerPreferencias(){
        int lActivos = 0;
        Dimension loDim = getSizeTotal();
        for(int i = 0; i < moTareas.size();i++){
            JPanelTareas jPanelTareas1 = (JPanelTareas)moTareas.get(i);
            if(jPanelTareas1.getAmpliado()){
                lActivos++;
            }
        }
        if(lActivos>0){
            loDim.height=loDim.height/lActivos;
        }
        for(int i = 0; i < moTareas.size();i++){
            JPanelTareas jPanelTareas1 = (JPanelTareas)moTareas.get(i);
            jPanelTareas1.setMaximumSizeTotal(loDim);
            jPanelTareas1.refrescarPreferenceSize();//refresca los preferencesize
        }
        return lActivos>0;
    }
    public void actionPerformed(final ActionEvent e) {
        validate();
    }

    public void removeAll() {
        jPanel1.removeAll();
        validate();
        moTareas.clear();
        
    }

    public void validate() {
        if(!establecerPreferencias() && moTareas.size()>0){
            JPanelTareas jPanelTareas1 = (JPanelTareas)moTareas.get(moTareas.size()-1);
            jPanelTareas1.setPreferredSize(getSizeTotal());
        }
        super.validate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    public void stateChanged(ChangeEvent e) {
        if(jScrollPane1!=null){
            if(mlHeightAux!=jScrollPane1.getHeight()){
                setSizeTotal(
                        getSizeTotal().width, 
                        jScrollPane1.getHeight());
                validate();
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
