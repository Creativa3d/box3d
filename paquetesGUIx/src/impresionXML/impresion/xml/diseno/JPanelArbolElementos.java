/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impresionXML.impresion.xml.diseno;

import impresionXML.impresion.xml.IxmlObjetos;
import impresionXML.impresion.xml.JxmlCuadrado;
import impresionXML.impresion.xml.JxmlImagen;
import impresionXML.impresion.xml.JxmlInforme;
import impresionXML.impresion.xml.JxmlLinea;
import impresionXML.impresion.xml.JxmlTexto;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import utiles.JCadenas;

/**
 *
 * @author eduardo
 */
public class JPanelArbolElementos extends javax.swing.JPanel implements PropertyChangeListener, TreeSelectionListener {

    private final DefaultMutableTreeNode motop;
    private JPanelDESIGN moPanelDesign;

    /**
     * Creates new form JPanelArbolElementos
     */
    public JPanelArbolElementos() {
        initComponents();
        jTree1.addTreeSelectionListener(this);
        motop = new DefaultMutableTreeNode("Informe");
        jTree1.setModel(new DefaultTreeModel(motop));
    }

    public void setDatos(JxmlInforme poInforme, JPanelDESIGN poDesign) {
        moPanelDesign = poDesign;
        poInforme.getBanda(0).addPropertyChangeListener(this);
        for (int i = 0; i < poInforme.getBanda(0).size(); i++) {
            IxmlObjetos loObj = poInforme.getBanda(0).get(i);
            DefaultMutableTreeNode book = new DefaultMutableTreeNode(new UserObject(loObj));
            motop.add(book);
        }
        jTree1.setModel(new DefaultTreeModel(motop));
        jTree1.expandPath(new TreePath(motop));
        jTree1.validate();
    }

    private DefaultMutableTreeNode getTreeNode(DefaultMutableTreeNode poNodo, IxmlObjetos poObj) {
        DefaultMutableTreeNode loResult = null;
        for (int i = 0; i < poNodo.getChildCount() && loResult == null; i++) {
            DefaultMutableTreeNode loObj = (DefaultMutableTreeNode) poNodo.getChildAt(i);
            UserObject loU = (UserObject) loObj.getUserObject();
            if (loU.moObj == poObj) {
                loResult = loObj;
            }
        }

        return loResult;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("remove")) {
            DefaultMutableTreeNode loNode = getTreeNode(motop, (IxmlObjetos) evt.getNewValue());
            if(loNode!=null){
                ((DefaultTreeModel)jTree1.getModel()).removeNodeFromParent(loNode);
            }
        }
        if (evt.getPropertyName().equalsIgnoreCase("add")) {
            DefaultMutableTreeNode book = new DefaultMutableTreeNode(new UserObject((IxmlObjetos) evt.getNewValue()));
            ((DefaultTreeModel)jTree1.getModel()).insertNodeInto(book, motop, motop.getChildCount());
            jTree1.expandPath(new TreePath(book));
            jTree1.validate();
        }
    }

    public void valueChanged(TreeSelectionEvent e) {
        
        TreePath[] loSelec = jTree1.getSelectionModel().getSelectionPaths();

        moPanelDesign.getSeleccion().clear();
        for(int i = 0 ; i < loSelec.length;i++){
            TreePath loObj = loSelec[i];
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode)(loObj.getLastPathComponent());
            addSelect(node);
        }
        

    }

    private void addSelect(DefaultMutableTreeNode node){
        if (node == null) //Nothing is selected.     
        {
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            UserObject book = (UserObject) nodeInfo;
            moPanelDesign.getSeleccion().add(book.moObj);
//           } else {
//               displayURL(helpURL); 
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTree1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}

class UserObject {

    public IxmlObjetos moObj;

    public UserObject(IxmlObjetos poObj) {
        moObj = poObj;
    }

    @Override
    public String toString() {
        String lsTipo = "";
        String lsNombre = "";
        String lsTitulo = "";
        if(moObj instanceof JxmlTexto){
            lsTipo = "Texto";
            JxmlTexto loT = (JxmlTexto) moObj;
            lsNombre = loT.getNombre();
            lsTitulo = loT.getTexto();
        }
        if(moObj instanceof JxmlImagen){
            lsTipo = "Imagen";
            JxmlImagen loT = (JxmlImagen) moObj;
            lsNombre = loT.getNombre();
        }
        if(moObj instanceof JxmlLinea){
            lsTipo = "Linea";
            JxmlLinea loT = (JxmlLinea) moObj;
            lsNombre = loT.getNombre();
        }
        if(moObj instanceof JxmlCuadrado){
            lsTipo = "Cuadrado";
            JxmlCuadrado loT = (JxmlCuadrado) moObj;
            lsNombre = loT.getNombre();
        }
        StringBuilder ls = new StringBuilder(20);
        ls.append(lsTipo);
        if(!JCadenas.isVacio(lsNombre)){
            ls.append('-');
            ls.append(lsNombre);
        }
        if(!JCadenas.isVacio(lsTitulo)){
            ls.append(' ');
            ls.append('(');
            ls.append(lsTitulo);
            ls.append(')');
        }
        return ls.toString();
    }
}
