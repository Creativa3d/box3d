/** clase generada con metaGenerador ** Creado el 5/2/2006*/package generadorClases.modulosCodigo;import generadorClases.*;import utiles.*;public class ZZZGeneradorJFormLogin implements IModuloProyecto {    private JConexionGeneradorClass moConex;  //Conexion a la base de datos    private JUtiles moUtiles;   //Clase de utilidades    public ZZZGeneradorJFormLogin(JProyecto poProyec) {        moUtiles = new JUtiles(poProyec);        moConex = poProyec.getConex();    }    public String getCodigo() {        StringBuffer lsText = new StringBuffer(100);        //CABECERA*********************************        JDateEdu loDate = new JDateEdu();        lsText.append("/*");lsText.append(JUtiles.msRetornoCarro);        lsText.append("* JFormLogin.java");lsText.append(JUtiles.msRetornoCarro);        lsText.append("*");lsText.append(JUtiles.msRetornoCarro);        lsText.append("* Creado el " + loDate.getDia() + "/" + loDate.getMes() + "/" + loDate.getAno());lsText.append(JUtiles.msRetornoCarro);        lsText.append("*/");lsText.append(JUtiles.msRetornoCarro);        lsText.append(JUtiles.msRetornoCarro);        //*****************************************                //IMPORTACION***************************************        lsText.append("package "+moConex.getDirPadre()+".forms;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import ListDatos.*;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import "+ moConex.getDirPadre()+".*;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import utiles.JDepuracion;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import utiles.IListaElementos;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import utiles.xml.dom.Element;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("import utiles.config.JDatosGeneralesXML;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("public class JFormLogin extends javax.swing.JDialog {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private static final String mcsUltUsuario = \"UltUsuario\";");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private static final String mcsUltTipoConexion = \"UltTipoConexion\";");lsText.append(JUtiles.msRetornoCarro);                lsText.append("    /** Creates new form JFormLogin */");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    public JFormLogin(java.awt.Frame parent, boolean modal) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        super(parent, modal);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        initComponents();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        recargarCombo();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private void recargarCombo(){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jComboBoxCZ1.borrarTodo();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jComboBoxCZ1.addLinea(\"Directo\", \"1\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        Element loServidores = JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getElemento(JDatosGeneralesXML.mcsCONEXIONSERVIDOR);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        IListaElementos loElem =  loServidores.getChildren();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        for(int i = 0 ; i < loElem.size(); i++){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            Element loAux = (Element)loElem.get(i);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            jComboBoxCZ1.addLinea(");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                    loAux.getName(), ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                    loAux.getValue());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }");lsText.append(JUtiles.msRetornoCarro);                lsText.append("        jComboBoxCZ1.setSelectedIndex(0);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jTextLogin.setText(getUltUsuario());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jComboBoxCZ1.setSelectedIndex(getUltTipoConexion());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private String getUltUsuario(){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        return JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(mcsUltUsuario);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private int getUltTipoConexion(){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        try{");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            return Integer.valueOf(JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().getPropiedad(mcsUltTipoConexion)).intValue();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }catch(Exception e){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            return 0;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    /** This method is called from within the constructor to");lsText.append(JUtiles.msRetornoCarro);        lsText.append("     * initialize the form.");lsText.append(JUtiles.msRetornoCarro);        lsText.append("     * WARNING: Do NOT modify this code. The content of this method is");lsText.append(JUtiles.msRetornoCarro);        lsText.append("     * always regenerated by the Form Editor.");lsText.append(JUtiles.msRetornoCarro);        lsText.append("     */");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private void initComponents() {//"+invertir("NIGEB-NEG")+":initComponents");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        java.awt.GridBagConstraints gridBagConstraints;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel1 = new javax.swing.JPanel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel3 = new javax.swing.JPanel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2 = new javax.swing.JPanel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel1 = new javax.swing.JLabel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jTextLogin = new utilesGUIx.JTextFieldCZ();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel2 = new javax.swing.JLabel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jTextPassWord = new javax.swing.JPasswordField();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel5 = new javax.swing.JLabel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jComboBoxCZ1 = new utilesGUIx.JComboBoxCZ();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jBtnConexionesBD = new utilesGUIx.JButtonCZ();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones = new javax.swing.JPanel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonAceptar = new javax.swing.JButton();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel4 = new javax.swing.JLabel();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonCancelar = new javax.swing.JButton();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        setTitle(\"Login\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel1.setLayout(new java.awt.BorderLayout());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel3.setLayout(new java.awt.BorderLayout());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel3.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.setLayout(new java.awt.GridBagLayout());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel1.setText(\"Login\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridx = 0;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridy = 0;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jLabel1, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridx = 1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridy = 0;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.weightx = 0.3;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jTextLogin, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel2.setText(\"PassWord\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridy = 1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jLabel2, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridx = 1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridy = 1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jTextPassWord, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel5.setText(\"Servidor\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jLabel5, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints = new java.awt.GridBagConstraints();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jComboBoxCZ1, gridBagConstraints);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jBtnConexionesBD.setText(\"...\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jBtnConexionesBD.addActionListener(new java.awt.event.ActionListener() {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            public void actionPerformed(java.awt.event.ActionEvent evt) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                jBtnConexionesBDActionPerformed(evt);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        });");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel2.add(jBtnConexionesBD, new java.awt.GridBagConstraints());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones.setBackground(new java.awt.Color(175, 181, 186));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones.setBorder(new javax.swing.border.EtchedBorder());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/images/Import16.gif\")));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonAceptar.setText(\"Login  \");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            public void actionPerformed(java.awt.event.ActionEvent evt) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                jButtonAceptarActionPerformed(evt);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        });");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones.add(jButtonAceptar);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jLabel4.setText(\"        \");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones.add(jLabel4);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource(\"/images/Stop16bis.gif\")));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonCancelar.setText(\"Cancelar\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            public void actionPerformed(java.awt.event.ActionEvent evt) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                jButtonCancelarActionPerformed(evt);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        });");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanelBotones.add(jButtonCancelar);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        jPanel3.add(jPanelBotones, java.awt.BorderLayout.SOUTH);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        setBounds((screenSize.width-807)/2, (screenSize.height-162)/2, 807, 162);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }//"+invertir("DNE-NEG")+":initComponents");lsText.append(JUtiles.msRetornoCarro);        lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//"+invertir("TSRIF-NEG")+":event_jButtonAceptarActionPerformed");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        try{");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            if(jComboBoxCZ1.getFilaActual().msCampo(0).compareTo(\"1\")==0){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                JDatosGeneralesP.getDatosGenerales().setServidor(JServerServidorDatos.mclTipoBD,\"\");");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }else{");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                JDatosGeneralesP.getDatosGenerales().setServidor(JServerServidorDatos.mclTipoInternetComprimido,jComboBoxCZ1.getFilaActual().msCampo(0));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(mcsUltTipoConexion, String.valueOf(jComboBoxCZ1.getSelectedIndex()));");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().setPropiedad(mcsUltUsuario, jTextLogin.getText());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            try {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                JDatosGeneralesP.getDatosGenerales().getDatosGeneralesXML().guardarFichero();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            } catch (Exception ex) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("                JDepuracion.anadirTexto(getClass().getName(), ex);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            JDatosGeneralesP.getDatosGenerales().hacerLogin(jTextLogin.getText(),jTextPassWord.getText());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            dispose();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }catch(Exception e){");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            JDepuracion.anadirTexto(getClass().getName(), e);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }//"+invertir("TSAL-NEG")+":event_jButtonAceptarActionPerformed");lsText.append(JUtiles.msRetornoCarro);        lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//"+invertir("TSRIF-NEG")+":event_jButtonCancelarActionPerformed");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        JDatosGeneralesP.getDatosGenerales().moServer = null;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        dispose();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }//"+invertir("TSAL-NEG")+":event_jButtonCancelarActionPerformed");lsText.append(JUtiles.msRetornoCarro);        lsText.append(JUtiles.msRetornoCarro);                lsText.append("    private void jBtnConexionesBDActionPerformed(java.awt.event.ActionEvent evt) {//"+invertir("TSRIF-NEG")+":event_jBtnConexionesBDActionPerformed)");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        try {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        JDatosGeneralesP.getDatosGenerales().mostrarPropiedadesConexionBD();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            recargarCombo();");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        } catch(Exception e) {");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            JDepuracion.anadirTexto(getClass().getName(), e);");lsText.append(JUtiles.msRetornoCarro);        lsText.append("            utilesGUIx.msgbox.JMsgBox.mensajeError(this, e.toString());");lsText.append(JUtiles.msRetornoCarro);        lsText.append("        }");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    }//"+invertir("TSRIF-NEG")+":event_jBtnConexionesBDActionPerformed)");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    // Variables declaration - do not modify//"+invertir("NIGEB-NEG")+":variables");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private utilesGUIx.JButtonCZ jBtnConexionesBD;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JButton jButtonAceptar;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JButton jButtonCancelar;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private utilesGUIx.JComboBoxCZ jComboBoxCZ1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JLabel jLabel1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JLabel jLabel2;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JLabel jLabel4;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JLabel jLabel5;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JPanel jPanel1;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JPanel jPanel2;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JPanel jPanel3;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JPanel jPanelBotones;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private utilesGUIx.JTextFieldCZ jTextLogin;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    private javax.swing.JPasswordField jTextPassWord;");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    // End of variables declaration//"+invertir("DNE-NEG")+":variables");lsText.append(JUtiles.msRetornoCarro);        lsText.append("    ");lsText.append(JUtiles.msRetornoCarro);        lsText.append("}");lsText.append(JUtiles.msRetornoCarro);        return lsText.toString();    }        //invertir una cadena de texto    private String invertir(String cad) {        int i;        String sol = "";                for(i=0;i<=cad.length()-1;i++) {            sol += cad.substring((cad.length()-1)-i,(cad.length())-i);        }                return sol;    }        public String getRutaRelativa() {        return "forms";    }    public String getNombre() {        return "JFormLogin.java";    }    public boolean isGeneral() {        return true;    }    public String getNombreModulo() {        return getNombre();    }    public JModuloProyectoParametros getParametros() {        return new JModuloProyectoParametros();    }}