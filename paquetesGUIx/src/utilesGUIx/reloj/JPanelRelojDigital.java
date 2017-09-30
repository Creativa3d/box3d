/*
 * JPanelRelojDigital.java
 *
 * Created on 5 de junio de 2005, 16:09
 */

package utilesGUIx.reloj;

/**
 *
 * @author  chema
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import javax.swing.*;
import java.beans.*;
import utiles.timer.*;

public class JPanelRelojDigital extends javax.swing.JPanel implements BeanInfo, ITemporizador {
    
    private JTimer loTimer;    
    
    //inicializar la hora
    public void init() { 
        loTimer = new JTimer(this);         
        loTimer.start();
    }   

    /** Creates new form JPanelRelojDigital */
    public JPanelRelojDigital() {
        initComponents();
        init();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        horaActual = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        add(horaActual, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    public BeanInfo[] getAdditionalBeanInfo() {
        return null;
    }    
    
    public BeanDescriptor getBeanDescriptor() {
        return null;
    }    
    
    public int getDefaultEventIndex() {
        return -1;
    }
    
    public int getDefaultPropertyIndex() {
        return -1;
    }
    
    public EventSetDescriptor[] getEventSetDescriptors() {
        return null;
    }
    
    public java.awt.Image getIcon(int iconKind) {
        return null;
    }
    
    public MethodDescriptor[] getMethodDescriptors() {
        return null;
    }
    
    public PropertyDescriptor[] getPropertyDescriptors() {
        return null;
    }
    
    public void timerArrancado(JTimer JTimer) {
    }
    
    public void timerIntervalo(JTimer JTimer) {
        Date loActual = new Date();
        int horas = loActual.getHours();
        int minutos = loActual.getMinutes();
        int segundos = loActual.getSeconds();
        int hora;
        String tiempo = "";

        if( horas > 12 ) 
            hora = horas - 12;
        else
            hora = horas;
        if( hora < 10 ){
            tiempo += "0";
        }
        tiempo += hora;
        tiempo += ":";

        if( minutos < 10 ){
            tiempo += "0";
        }
        tiempo += minutos + ":";

        if( segundos < 10 ){
            tiempo += "0";
        }
        tiempo += segundos;

        if( horas > 12 )
            tiempo += " pm";
        else
            tiempo += " am";

        horaActual.setText(tiempo);
    }
    
    public void timerMuerto(JTimer JTimer) {
    }
    
    public void timerParado(JTimer JTimer) {
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel horaActual;
    // End of variables declaration//GEN-END:variables
    
}
