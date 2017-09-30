/*

 * JFormAyuda.java

 *

 * Created on 31 de enero de 2005, 11:41

 */



package utilesGUIx.navegadorWeb;





import javax.swing.event.*; 

import javax.swing.text.html.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*;
import javax.swing.ImageIcon;
import utiles.JListaElementos;

public class JFormNavegador extends javax.swing.JFrame implements javax.swing.event.HyperlinkListener {
    

    private URL moURL;
    private JListaElementos masListaURL;
    private int mlUltimaURL;
    
    /** Creates new form JFormAyuda */
    public JFormNavegador(String lsURL) throws MalformedURLException {
        this(new URL(lsURL));
    }
    public JFormNavegador(URL poURL) {
        initComponents();
        if(utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()!=null){
            this.setIconImage(((ImageIcon) utilesGUIx.JGUIxConfigGlobal.getInstancia().getMostrarPantalla().getImagenIcono()).getImage());
        }          
        moURL = poURL;
        mlUltimaURL = 0;
        masListaURL = new JListaElementos(1); //Creo la lista de URL;
        masListaURL.add(moURL);
        
        if(moURL != null) { 
            jEditorPane.setEditable(false); 
            jEditorPane.addHyperlinkListener(createHyperLinkListener()); 
            try {
                jEditorPane.setPage(moURL);
            } catch(IOException ioe) {
                System.out.println("No se puede seguir el link " + ioe);
            }
        } 

        jAtras.setEnabled(false);
        jAlante.setEnabled(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane = new javax.swing.JEditorPane();
        jToolBar = new javax.swing.JToolBar();
        jAtras = new javax.swing.JButton();
        jHome = new javax.swing.JButton();
        jAlante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ayuda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jEditorPane.setContentType("text/html");
        jEditorPane.setMinimumSize(new java.awt.Dimension(800, 600));
        jEditorPane.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(jEditorPane);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Back16.gif"))); // NOI18N
        jAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtrasActionPerformed(evt);
            }
        });
        jToolBar.add(jAtras);

        jHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/WebComponent16.gif"))); // NOI18N
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });
        jToolBar.add(jHome);

        jAlante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilesGUIx/images/Forward16.gif"))); // NOI18N
        jAlante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlanteActionPerformed(evt);
            }
        });
        jToolBar.add(jAlante);

        jPanel1.add(jToolBar, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-802)/2, (screenSize.height-526)/2, 802, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            jScrollPane1.repaint();            
    }//GEN-LAST:event_formWindowActivated

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed
        try {
            jEditorPane.setPage(moURL);
        } catch(IOException ioe) {
            System.out.println("No se puede seguir el link " + ioe);
        }
        masListaURL.clear();
        mlUltimaURL = 0;
        masListaURL.add(moURL);        
        jAlante.setEnabled(false);
        jAtras.setEnabled(false);
    }//GEN-LAST:event_jHomeActionPerformed

    private void jAlanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlanteActionPerformed
        try {
            jEditorPane.setPage(masListaURL.get(mlUltimaURL+1).toString());
            mlUltimaURL++;
        } catch(IOException ioe) {
            System.out.println("No se puede seguir el link " + ioe);
        }
        comprobarBotones();
    }//GEN-LAST:event_jAlanteActionPerformed

    private void comprobarBotones() {
        if (mlUltimaURL == 0) {
            jAtras.setEnabled(false);
            jAlante.setEnabled(true);
        }
        else if (mlUltimaURL == (masListaURL.size()-1)) {
            jAlante.setEnabled(false);
            jAtras.setEnabled(true);
        }
        else {
            jAlante.setEnabled(true);
            jAtras.setEnabled(true);
        }
    }
    
    private void jAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtrasActionPerformed
        try {
            jEditorPane.setPage(masListaURL.get(mlUltimaURL-1).toString());
            mlUltimaURL--;
        } catch(IOException ioe) {
            System.out.println("No se puede seguir el link " + ioe);
        }
        comprobarBotones();
    }//GEN-LAST:event_jAtrasActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
//        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    
    public void actionPerformed(ActionEvent event) {
    }
    
     public HyperlinkListener createHyperLinkListener() { 
 	return new HyperlinkListener() { 
 	    public void hyperlinkUpdate(HyperlinkEvent e) { 
 		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) { 
 		    if (e instanceof HTMLFrameHyperlinkEvent) { 
 			((HTMLDocument)jEditorPane.getDocument()).processHTMLFrameHyperlinkEvent( 
 			    (HTMLFrameHyperlinkEvent)e); 
 		    } else { 
 			try { 
                            mlUltimaURL++;
                            masListaURL.add(e.getURL());
 			    jEditorPane.setPage(e.getURL()); 
                            comprobarBotones();                        
 			} catch (IOException ioe) { 
 			    System.out.println("IOE: " + ioe); 
 			} 
 		    } 
 		} 
 	    } 
 	}; 
     } 
     
     public void hyperlinkUpdate(HyperlinkEvent e) {

     }

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlante;
    private javax.swing.JButton jAtras;
    private javax.swing.JEditorPane jEditorPane;
    private javax.swing.JButton jHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables

    

}
