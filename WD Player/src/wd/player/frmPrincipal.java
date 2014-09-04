<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wd.player;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.tag.*;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author DIEGO
 */
public class frmPrincipal extends javax.swing.JFrame {

    boolean abrir = false;
    boolean play = true;
    ImageIcon izquierda = new ImageIcon(getClass().getResource("/Images/izquierda.png"));
    ImageIcon derecha = new ImageIcon(getClass().getResource("/Images/derecha.png"));
    ImageIcon imgPlay = new ImageIcon(getClass().getResource("/Images/play.png"));
    ImageIcon imgPause = new ImageIcon(getClass().getResource("/Images/pausa.png"));
    File file; 
    String url = null;
    AudioFile audioFile = null;
    Tag tag = null;
    AudioHeader audioHeader = null;
    
    String nom = "";
    String art = "";
    String alb = "";
    String tra = "";
    String gen = "";
    String ano = "";
    int dur = 0;
    
    DefaultListModel modeloLista = new DefaultListModel();
    
    public void IniciarObjetos() {
       setBounds(150, 100, 1025, 550);
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de audio", "mp3");
       jFileChooser1.setFileFilter(filter);
       jButtonAceptar.setVisible(false);
       bloquearDesbloquearObjetos(false);
       
       jList1.setModel(modeloLista);
    }
    
    public void bloquearDesbloquearObjetos(boolean a){
       jButtonCancelar.setVisible(a);
       jTextFieldAlb.setEditable(a);
       jTextFieldAno.setEditable(a);
       jTextFieldArt.setEditable(a);
       jTextFieldDur.setEditable(a);
       jTextFieldGen.setEditable(a);
       jTextFieldNom.setEditable(a);
       jTextFieldTrack.setEditable(a);
    }
    
    public void procesarInfo() throws TagException, IOException {
        String nom = tag.getFirst(FieldKey.TITLE);
        String art = tag.getFirst(FieldKey.ARTIST);
        String alb = tag.getFirst(FieldKey.ALBUM);
        String tra = tag.getFirst(FieldKey.TRACK);
        String gen = tag.getFirst(FieldKey.GENRE);
        String ano = tag.getFirst(FieldKey.YEAR);
        int dur = audioHeader.getTrackLength();
        TagField binaryField = tag.getFirstField(FieldKey.COVER_ART);
        
        jTextFieldNom.setText(nom);
        jTextFieldArt.setText(art);
        jTextFieldAlb.setText(alb);
        jTextFieldTrack.setText(tra);
        jTextFieldGen.setText(gen);
        jTextFieldAno.setText(ano);
        jTextFieldDur.setText(Integer.toString(dur));
        
        System.out.println("Nombre:" + nom);
        System.out.println("Artista:" + art);
        System.out.println("Album:" + alb);
        System.out.println("Número:" + tra);
        System.out.println("Genero:" + gen);
        System.out.println("Año:" + ano);
        System.out.println("Duracion:" + dur + "s");
    }
    
    public void procesarTamañoVentana() {
        if (abrir == false)
        {
            setBounds(150, 100, 1300, 550);
            jButtonAbrir.setIcon(izquierda);
            abrir = true;
        }
        else
        if (abrir == true)
        {
            setBounds(150, 100, 1025, 550);
            jButtonAbrir.setIcon(derecha);
            abrir = false;
        }
    }
    
    public void procesarPlayPause() {
        if (play == false)
        {
            jButtonPlayPause.setIcon(imgPlay);
            play = true;
        }
        else
        if (play == true)
        {
            jButtonPlayPause.setIcon(imgPause);
            play = false;
        }
    }
    
    public void agregarCancionLista(){
        modeloLista.addElement(jFileChooser1.getSelectedFile().getName());
    }
    
    public void procesarJfileChooser1() {
        int seleccion = jFileChooser1.showOpenDialog(this); 

        if (seleccion == JFileChooser.APPROVE_OPTION) { 
            file = jFileChooser1.getSelectedFile(); 
            try { 
                //Obteniendo la direccion del archivo
                url = file.getPath();
                
                audioFile = AudioFileIO.read(file);
                tag = audioFile.getTag();
                audioHeader = audioFile.getAudioHeader();
                
                procesarInfo();
                agregarCancionLista();
                
                if (abrir == false)
                    procesarTamañoVentana();
                
            }
            catch(Exception es) {
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo"+ es);
            }
        } 
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/wd_logo.png"));
        return retValue;
    }
    
    public frmPrincipal() {
        initComponents();
        IniciarObjetos();
        
        try {
        } 
        catch (Exception e) {
            e.printStackTrace();
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonAbrir = new javax.swing.JButton();
        jPanelInfo = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelNom = new javax.swing.JLabel();
        jLabelArt = new javax.swing.JLabel();
        jLabelAlb = new javax.swing.JLabel();
        jLabelTrack = new javax.swing.JLabel();
        jLabelAno = new javax.swing.JLabel();
        jLabelDur = new javax.swing.JLabel();
        jLabelGen = new javax.swing.JLabel();
        jTextFieldDur = new javax.swing.JTextField();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldArt = new javax.swing.JTextField();
        jTextFieldAlb = new javax.swing.JTextField();
        jTextFieldTrack = new javax.swing.JTextField();
        jTextFieldGen = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jPanelPlayer = new javax.swing.JPanel();
        jLabelImg = new javax.swing.JLabel();
        jButtonPlayPause = new javax.swing.JButton();
        jSliderVol = new javax.swing.JSlider();
        jLabelVol = new javax.swing.JLabel();
        jButtonStop = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelList = new javax.swing.JPanel();
        jLabelLista = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jFileChooser1.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WD Media Player");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/derecha.png"))); // NOI18N
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAbrir);
        jButtonAbrir.setBounds(990, 190, 20, 121);

        jPanelInfo.setBackground(new java.awt.Color(144, 210, 147));
        jPanelInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelInfo.setLayout(null);

        jLabelInfo.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabelInfo.setText("Info. del Fichero");
        jPanelInfo.add(jLabelInfo);
        jLabelInfo.setBounds(10, 10, 220, 30);

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelInfo.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 250, 2);

        jLabelNom.setText("Nombre:");
        jPanelInfo.add(jLabelNom);
        jLabelNom.setBounds(10, 70, 80, 20);

        jLabelArt.setText("Artista:");
        jPanelInfo.add(jLabelArt);
        jLabelArt.setBounds(10, 100, 80, 20);

        jLabelAlb.setText("Álbum:");
        jPanelInfo.add(jLabelAlb);
        jLabelAlb.setBounds(10, 130, 80, 20);

        jLabelTrack.setText("Track:");
        jPanelInfo.add(jLabelTrack);
        jLabelTrack.setBounds(10, 160, 80, 20);

        jLabelAno.setText("Año:");
        jPanelInfo.add(jLabelAno);
        jLabelAno.setBounds(10, 220, 60, 20);

        jLabelDur.setText("Duración:");
        jPanelInfo.add(jLabelDur);
        jLabelDur.setBounds(10, 250, 80, 20);

        jLabelGen.setText("Género:");
        jPanelInfo.add(jLabelGen);
        jLabelGen.setBounds(10, 190, 80, 20);

        jTextFieldDur.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldDur.setText("-");
        jTextFieldDur.setBorder(null);
        jPanelInfo.add(jTextFieldDur);
        jTextFieldDur.setBounds(90, 250, 150, 26);

        jTextFieldNom.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldNom.setText("-");
        jTextFieldNom.setBorder(null);
        jPanelInfo.add(jTextFieldNom);
        jTextFieldNom.setBounds(90, 70, 150, 26);

        jTextFieldArt.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldArt.setText("-");
        jTextFieldArt.setBorder(null);
        jPanelInfo.add(jTextFieldArt);
        jTextFieldArt.setBounds(90, 100, 150, 26);

        jTextFieldAlb.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldAlb.setText("-");
        jTextFieldAlb.setBorder(null);
        jPanelInfo.add(jTextFieldAlb);
        jTextFieldAlb.setBounds(90, 130, 150, 26);

        jTextFieldTrack.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldTrack.setText("-");
        jTextFieldTrack.setBorder(null);
        jPanelInfo.add(jTextFieldTrack);
        jTextFieldTrack.setBounds(90, 160, 150, 26);

        jTextFieldGen.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldGen.setText("-");
        jTextFieldGen.setBorder(null);
        jPanelInfo.add(jTextFieldGen);
        jTextFieldGen.setBounds(90, 190, 150, 26);

        jTextFieldAno.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldAno.setText("-");
        jTextFieldAno.setBorder(null);
        jPanelInfo.add(jTextFieldAno);
        jTextFieldAno.setBounds(90, 220, 150, 26);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonCancelar);
        jButtonCancelar.setBounds(70, 340, 110, 29);

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jPanelInfo.add(jButtonAceptar);
        jButtonAceptar.setBounds(70, 300, 110, 29);

        getContentPane().add(jPanelInfo);
        jPanelInfo.setBounds(1020, 20, 250, 470);

        jPanelPlayer.setBackground(new java.awt.Color(153, 153, 255));
        jPanelPlayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelPlayer.setLayout(null);

        jLabelImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/multimedia.png"))); // NOI18N
        jLabelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelPlayer.add(jLabelImg);
        jLabelImg.setBounds(217, 97, 230, 220);

        jButtonPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play.png"))); // NOI18N
        jButtonPlayPause.setBorderPainted(false);
        jButtonPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayPauseActionPerformed(evt);
            }
        });
        jPanelPlayer.add(jButtonPlayPause);
        jButtonPlayPause.setBounds(300, 359, 70, 60);
        jPanelPlayer.add(jSliderVol);
        jSliderVol.setBounds(500, 380, 120, 30);

        jLabelVol.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelVol.setText("Vol");
        jPanelPlayer.add(jLabelVol);
        jLabelVol.setBounds(470, 380, 30, 30);

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stop.png"))); // NOI18N
        jButtonStop.setBorderPainted(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        jPanelPlayer.add(jButtonStop);
        jButtonStop.setBounds(80, 370, 50, 50);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next.png"))); // NOI18N
        jButtonNext.setBorderPainted(false);
        jPanelPlayer.add(jButtonNext);
        jButtonNext.setBounds(380, 380, 70, 30);

        jButtonPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prev.png"))); // NOI18N
        jButtonPrev.setBorderPainted(false);
        jPanelPlayer.add(jButtonPrev);
        jButtonPrev.setBounds(220, 380, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WD_Player.png"))); // NOI18N
        jPanelPlayer.add(jLabel1);
        jLabel1.setBounds(180, 10, 300, 60);

        getContentPane().add(jPanelPlayer);
        jPanelPlayer.setBounds(340, 20, 640, 470);

        jPanelList.setBackground(new java.awt.Color(144, 119, 174));
        jPanelList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelList.setLayout(null);

        jLabelLista.setText("Lista de Reproducción");
        jPanelList.add(jLabelLista);
        jLabelLista.setBounds(10, 10, 290, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton1);
        jButton1.setBounds(130, 40, 40, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mas.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton2);
        jButton2.setBounds(10, 40, 40, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/consultar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton3);
        jButton3.setBounds(190, 40, 40, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menos.png"))); // NOI18N
        jPanelList.add(jButton4);
        jButton4.setBounds(70, 40, 40, 40);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanelList.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 280, 340);

        getContentPane().add(jPanelList);
        jPanelList.setBounds(10, 19, 320, 470);

        setBounds(150, 100, 1302, 558);
    }// </editor-fold>//GEN-END:initComponents

    //Aqui se programan todos los eventos de los botones
    
    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        procesarTamañoVentana();
    }//GEN-LAST:event_jButtonAbrirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        procesarJfileChooser1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayPauseActionPerformed
        procesarPlayPause();
    }//GEN-LAST:event_jButtonPlayPauseActionPerformed

    
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        
    }//GEN-LAST:event_jButtonStopActionPerformed

    //programacion del boton modiifcar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (abrir == false)
            procesarTamañoVentana();
        jButtonAceptar.setVisible(true);
        jButtonCancelar.setVisible(true);
        bloquearDesbloquearObjetos(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //programacion del boton cancelar
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonAceptar.setVisible(false);
        jButtonCancelar.setVisible(false);
        bloquearDesbloquearObjetos(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    //programacion del jlist
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        int index= jList1.getSelectedIndex();
        //JOptionPane.showMessageDialog(null, "click "+Integer.toString(index));
    }//GEN-LAST:event_jList1MouseClicked

    //programación del boton consultar
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide(); this.dispose();
        frmBusqueda f1 = new frmBusqueda(); f1.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        //Esta instruccion aplica el skin
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPlayPause;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAlb;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelArt;
    private javax.swing.JLabel jLabelDur;
    private javax.swing.JLabel jLabelGen;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelTrack;
    private javax.swing.JLabel jLabelVol;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelList;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSliderVol;
    private javax.swing.JTextField jTextFieldAlb;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldArt;
    private javax.swing.JTextField jTextFieldDur;
    private javax.swing.JTextField jTextFieldGen;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldTrack;
    // End of variables declaration//GEN-END:variables
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wd.player;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.tag.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import java.io.File; 
import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author DIEGO
 */
public class frmPrincipal extends javax.swing.JFrame {
    PlayerD reproductor = new PlayerD();     

    JFileChooser fileChooser = new JFileChooser(); 
   
    File file; 
    boolean running= false;

    boolean abrir = false;
    ImageIcon izquierda = new ImageIcon(getClass().getResource("/Images/izquierda.png"));
    ImageIcon derecha = new ImageIcon(getClass().getResource("/Images/derecha.png"));
    String url = null;
    AudioFile audioFile = null;
    Tag tag = null;
    AudioHeader audioHeader = null;
    
    String nom = "";
    String art = "";
    String alb = "";
    String tra = "";
    String gen = "";
    String ano = "";
    int dur = 0;
    
    DefaultListModel modeloLista = new DefaultListModel();
    
    public void IniciarObjetos() {
       setBounds(150, 100, 1025, 550);
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de audio", "mp3");
       jFileChooser1.setFileFilter(filter);
       jButtonAceptar.setVisible(false);
       bloquearDesbloquearObjetos(false);
       
       jList1.setModel(modeloLista);
    }
    
    public void bloquearDesbloquearObjetos(boolean a){
       jButtonCancelar.setVisible(a);
       jTextFieldAlb.setEditable(a);
       jTextFieldAno.setEditable(a);
       jTextFieldArt.setEditable(a);
       jTextFieldDur.setEditable(a);
       jTextFieldGen.setEditable(a);
       jTextFieldNom.setEditable(a);
       jTextFieldTrack.setEditable(a);
    }
    
    public void procesarInfo() throws TagException, IOException {
        String nom = tag.getFirst(FieldKey.TITLE);
        String art = tag.getFirst(FieldKey.ARTIST);
        String alb = tag.getFirst(FieldKey.ALBUM);
        String tra = tag.getFirst(FieldKey.TRACK);
        String gen = tag.getFirst(FieldKey.GENRE);
        String ano = tag.getFirst(FieldKey.YEAR);
        int dur = audioHeader.getTrackLength();
        TagField binaryField = tag.getFirstField(FieldKey.COVER_ART);
        
        jTextFieldNom.setText(nom);
        jTextFieldArt.setText(art);
        jTextFieldAlb.setText(alb);
        jTextFieldTrack.setText(tra);
        jTextFieldGen.setText(gen);
        jTextFieldAno.setText(ano);
        jTextFieldDur.setText(Integer.toString(dur));
        
        System.out.println("Nombre:" + nom);
        System.out.println("Artista:" + art);
        System.out.println("Album:" + alb);
        System.out.println("Número:" + tra);
        System.out.println("Genero:" + gen);
        System.out.println("Año:" + ano);
        System.out.println("Duracion:" + dur + "s");
    }
    
    public void procesarTamañoVentana() {
        if (abrir == false)
        {
            setBounds(150, 100, 1300, 550);
            jButtonAbrir.setIcon(izquierda);
            abrir = true;
        }
        else
        if (abrir == true)
        {
            setBounds(150, 100, 1025, 550);
            jButtonAbrir.setIcon(derecha);
            abrir = false;
        }
    }
    
    public void agregarCancionLista(){
        modeloLista.addElement(jFileChooser1.getSelectedFile().getName());
    }
    
    public void procesarJfileChooser1() {
        int seleccion = jFileChooser1.showOpenDialog(this); 

        if (seleccion == JFileChooser.APPROVE_OPTION) { 
            file = jFileChooser1.getSelectedFile(); 
            try { 
                //Obteniendo la direccion del archivo
                url = file.getPath();
                
                audioFile = AudioFileIO.read(file);
                tag = audioFile.getTag();
                audioHeader = audioFile.getAudioHeader();
                           
                reproductor.control.open(file);//Le decimos al control del player que abra el archivo 
            
                
                
                procesarInfo();
                agregarCancionLista();
                
                if (abrir == false)
                    procesarTamañoVentana();
                
            }
            catch(Exception es) {
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo"+ es);
            }
        } 
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/wd_logo.png"));
        return retValue;
    }
    
    public frmPrincipal() {
        initComponents();
        IniciarObjetos();
        
        try {
        } 
        catch (Exception e) {
            e.printStackTrace();
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonAbrir = new javax.swing.JButton();
        jPanelInfo = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelNom = new javax.swing.JLabel();
        jLabelArt = new javax.swing.JLabel();
        jLabelAlb = new javax.swing.JLabel();
        jLabelTrack = new javax.swing.JLabel();
        jLabelAno = new javax.swing.JLabel();
        jLabelDur = new javax.swing.JLabel();
        jLabelGen = new javax.swing.JLabel();
        jTextFieldDur = new javax.swing.JTextField();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldArt = new javax.swing.JTextField();
        jTextFieldAlb = new javax.swing.JTextField();
        jTextFieldTrack = new javax.swing.JTextField();
        jTextFieldGen = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jPanelPlayer = new javax.swing.JPanel();
        jLabelImg = new javax.swing.JLabel();
        jButtonPlayPause = new javax.swing.JButton();
        jSliderVol = new javax.swing.JSlider();
        jLabelVol = new javax.swing.JLabel();
        jButtonStop = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelList = new javax.swing.JPanel();
        jLabelLista = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jFileChooser1.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WD Media Player");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/derecha.png"))); // NOI18N
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAbrir);
        jButtonAbrir.setBounds(990, 190, 20, 121);

        jPanelInfo.setBackground(new java.awt.Color(144, 210, 147));
        jPanelInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelInfo.setLayout(null);

        jLabelInfo.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabelInfo.setText("Info. del Fichero");
        jPanelInfo.add(jLabelInfo);
        jLabelInfo.setBounds(10, 10, 220, 30);

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelInfo.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 250, 2);

        jLabelNom.setText("Nombre:");
        jPanelInfo.add(jLabelNom);
        jLabelNom.setBounds(10, 70, 80, 14);

        jLabelArt.setText("Artista:");
        jPanelInfo.add(jLabelArt);
        jLabelArt.setBounds(10, 100, 80, 14);

        jLabelAlb.setText("Álbum:");
        jPanelInfo.add(jLabelAlb);
        jLabelAlb.setBounds(10, 130, 80, 14);

        jLabelTrack.setText("Track:");
        jPanelInfo.add(jLabelTrack);
        jLabelTrack.setBounds(10, 160, 80, 14);

        jLabelAno.setText("Año:");
        jPanelInfo.add(jLabelAno);
        jLabelAno.setBounds(10, 220, 60, 14);

        jLabelDur.setText("Duración:");
        jPanelInfo.add(jLabelDur);
        jLabelDur.setBounds(10, 250, 80, 14);

        jLabelGen.setText("Género:");
        jPanelInfo.add(jLabelGen);
        jLabelGen.setBounds(10, 190, 80, 14);

        jTextFieldDur.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldDur.setText("-");
        jTextFieldDur.setBorder(null);
        jPanelInfo.add(jTextFieldDur);
        jTextFieldDur.setBounds(90, 250, 150, 26);

        jTextFieldNom.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldNom.setText("-");
        jTextFieldNom.setBorder(null);
        jPanelInfo.add(jTextFieldNom);
        jTextFieldNom.setBounds(90, 70, 150, 26);

        jTextFieldArt.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldArt.setText("-");
        jTextFieldArt.setBorder(null);
        jPanelInfo.add(jTextFieldArt);
        jTextFieldArt.setBounds(90, 100, 150, 26);

        jTextFieldAlb.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldAlb.setText("-");
        jTextFieldAlb.setBorder(null);
        jPanelInfo.add(jTextFieldAlb);
        jTextFieldAlb.setBounds(90, 130, 150, 26);

        jTextFieldTrack.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldTrack.setText("-");
        jTextFieldTrack.setBorder(null);
        jPanelInfo.add(jTextFieldTrack);
        jTextFieldTrack.setBounds(90, 160, 150, 26);

        jTextFieldGen.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldGen.setText("-");
        jTextFieldGen.setBorder(null);
        jPanelInfo.add(jTextFieldGen);
        jTextFieldGen.setBounds(90, 190, 150, 26);

        jTextFieldAno.setBackground(new java.awt.Color(144, 210, 147));
        jTextFieldAno.setText("-");
        jTextFieldAno.setBorder(null);
        jPanelInfo.add(jTextFieldAno);
        jTextFieldAno.setBounds(90, 220, 150, 26);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonCancelar);
        jButtonCancelar.setBounds(70, 340, 110, 29);

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jPanelInfo.add(jButtonAceptar);
        jButtonAceptar.setBounds(70, 300, 110, 29);

        getContentPane().add(jPanelInfo);
        jPanelInfo.setBounds(1020, 20, 250, 470);

        jPanelPlayer.setBackground(new java.awt.Color(153, 153, 255));
        jPanelPlayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelPlayer.setLayout(null);

        jLabelImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/multimedia.png"))); // NOI18N
        jLabelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelPlayer.add(jLabelImg);
        jLabelImg.setBounds(217, 97, 230, 220);

        jButtonPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play.png"))); // NOI18N
        jButtonPlayPause.setBorderPainted(false);
        jButtonPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayPauseActionPerformed(evt);
            }
        });
        jPanelPlayer.add(jButtonPlayPause);
        jButtonPlayPause.setBounds(300, 359, 70, 60);

        jSliderVol.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderVolStateChanged(evt);
            }
        });
        jPanelPlayer.add(jSliderVol);
        jSliderVol.setBounds(500, 380, 120, 30);

        jLabelVol.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelVol.setText("Vol");
        jPanelPlayer.add(jLabelVol);
        jLabelVol.setBounds(470, 380, 30, 30);

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stop.png"))); // NOI18N
        jButtonStop.setBorderPainted(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        jPanelPlayer.add(jButtonStop);
        jButtonStop.setBounds(80, 370, 50, 50);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next.png"))); // NOI18N
        jButtonNext.setBorderPainted(false);
        jPanelPlayer.add(jButtonNext);
        jButtonNext.setBounds(380, 380, 70, 30);

        jButtonPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prev.png"))); // NOI18N
        jButtonPrev.setBorderPainted(false);
        jPanelPlayer.add(jButtonPrev);
        jButtonPrev.setBounds(220, 380, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WD_Player.png"))); // NOI18N
        jPanelPlayer.add(jLabel1);
        jLabel1.setBounds(180, 10, 300, 60);

        getContentPane().add(jPanelPlayer);
        jPanelPlayer.setBounds(340, 20, 640, 470);

        jPanelList.setBackground(new java.awt.Color(144, 119, 174));
        jPanelList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanelList.setLayout(null);

        jLabelLista.setText("Lista de Reproducción");
        jPanelList.add(jLabelLista);
        jLabelLista.setBounds(10, 10, 290, 14);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton1);
        jButton1.setBounds(130, 40, 40, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mas.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton2);
        jButton2.setBounds(10, 40, 40, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/consultar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanelList.add(jButton3);
        jButton3.setBounds(190, 40, 40, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menos.png"))); // NOI18N
        jPanelList.add(jButton4);
        jButton4.setBounds(70, 40, 40, 40);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanelList.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 280, 340);

        getContentPane().add(jPanelList);
        jPanelList.setBounds(10, 19, 320, 470);

        setBounds(150, 100, 1302, 558);
    }// </editor-fold>//GEN-END:initComponents

    //Aqui se programan todos los eventos de los botones
    
    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        procesarTamañoVentana();
    }//GEN-LAST:event_jButtonAbrirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        procesarJfileChooser1();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayPauseActionPerformed
        
        
    }//GEN-LAST:event_jButtonPlayPauseActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        
    }//GEN-LAST:event_jButtonStopActionPerformed

    //programacion del boton modiifcar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (abrir == false)
            procesarTamañoVentana();
        jButtonAceptar.setVisible(true);
        jButtonCancelar.setVisible(true);
        bloquearDesbloquearObjetos(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //programacion del boton cancelar
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonAceptar.setVisible(false);
        jButtonCancelar.setVisible(false);
        bloquearDesbloquearObjetos(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    //programacion del jlist
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        int index= jList1.getSelectedIndex();
        //JOptionPane.showMessageDialog(null, "click "+Integer.toString(index));
    }//GEN-LAST:event_jList1MouseClicked

    //programación del boton consultar
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide(); this.dispose();
        frmBusqueda f1 = new frmBusqueda(); f1.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSliderVolStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderVolStateChanged
        // TODO add your handling code here:
         try { 
            reproductor.control.setGain((double)jSliderVol.getValue()/100); 
        } catch (BasicPlayerException ex) { 
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        jLabel1.setText(jSliderVol.getValue()+"%"); 
    }//GEN-LAST:event_jSliderVolStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        //Esta instruccion aplica el skin
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPlayPause;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAlb;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelArt;
    private javax.swing.JLabel jLabelDur;
    private javax.swing.JLabel jLabelGen;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelTrack;
    private javax.swing.JLabel jLabelVol;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelList;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSliderVol;
    private javax.swing.JTextField jTextFieldAlb;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldArt;
    private javax.swing.JTextField jTextFieldDur;
    private javax.swing.JTextField jTextFieldGen;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldTrack;
    // End of variables declaration//GEN-END:variables
}
>>>>>>> origin/master
