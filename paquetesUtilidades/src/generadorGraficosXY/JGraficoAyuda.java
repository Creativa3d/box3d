/*
 * JGrarficoAyuda.java
 *
 * Created on 10 de enero de 2006, 12:52
 */

package generadorGraficosXY;

/**
 *
 * @author  eduardo
 */
public class JGraficoAyuda extends java.awt.Frame {
    
    /** Creates new form JGrarficoAyuda */
    public JGraficoAyuda() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        setLayout(new java.awt.GridLayout(0, 1));

        setTitle("Ayuda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        label1.setText("En la base de datos hay que tener una consulta/tabla llamada ");
        add(label1);

        label2.setText("\"consultagraficos\" y esta debe tener los campos: \"Codigo\", \"Grupo\",\"Fecha\",\"Valor\"");
        add(label2);

        label3.setText("El campo \"Grupo\" indica las series y puede ser un campo vac\u00edo");
        add(label3);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-501)/2, (screenSize.height-110)/2, 501, 110);
    }// </editor-fold>//GEN-END:initComponents
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        dispose();
    }//GEN-LAST:event_exitForm
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
    
}
