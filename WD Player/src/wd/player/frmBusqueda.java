/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wd.player;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import static wd.player.GlobalVariables.biblioteca;

/**
 *
 * @author DIEGO
 */
public class frmBusqueda extends javax.swing.JFrame {

    /**
     * Creates new form frmBusqueda
     */
    public frmBusqueda() {
        initComponents();
        
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/wd_logo.png"));
        return retValue;
    }
    
    public void limpiarTabla(){
        remove(jTable1);
        
        jTable1 = new javax.swing.JTable();
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Artista", "Album", "Genero", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxBusqueda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Búsqueda Avanzada");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WD_Player.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 10, 300, 60);

        jComboBoxBusqueda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Artista", "Álbum", "Género" }));
        getContentPane().add(jComboBoxBusqueda);
        jComboBoxBusqueda.setBounds(280, 100, 170, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Búsqueda:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 100, 150, 40);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(480, 100, 220, 40);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Artista", "Album", "Genero", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 180, 820, 360);

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 570, 120, 40);

        setSize(new java.awt.Dimension(922, 706));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //programación del boton volver
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide(); this.dispose();
        frmPrincipal f1 = new frmPrincipal(); f1.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        limpiarTabla();
        if (!jTextField1.getText().equals("")){
        if (jComboBoxBusqueda.getSelectedIndex()==0){
            ListaDoble biblio = biblioteca.buscarCancion(jTextField1.getText());
            for(int i=0;i<biblio.tamano(); i++){
                Nodo nodo = biblio.buscarNodo(i);
                jTable1.setValueAt(nodo.getNombre(), i, 0);
                jTable1.setValueAt(nodo.getArtista(), i, 1);
                jTable1.setValueAt(nodo.getAlbum(), i, 2);
                jTable1.setValueAt(nodo.getGenero(), i, 3);
                jTable1.setValueAt(Integer.toString(nodo.getDuracion()), i, 4);
            }
        }
        if (jComboBoxBusqueda.getSelectedIndex()==1){
            ListaDoble biblio = biblioteca.buscarArtista(jTextField1.getText());
            for(int i=0;i<biblio.tamano(); i++){
                Nodo nodo = biblio.buscarNodo(i);
                jTable1.setValueAt(nodo.getNombre(), i, 0);
                jTable1.setValueAt(nodo.getArtista(), i, 1);
                jTable1.setValueAt(nodo.getAlbum(), i, 2);
                jTable1.setValueAt(nodo.getGenero(), i, 3);
                jTable1.setValueAt(Integer.toString(nodo.getDuracion()), i, 4);
            }
        }
        if (jComboBoxBusqueda.getSelectedIndex()==2){
            ListaDoble biblio = biblioteca.buscarAlbum(jTextField1.getText());
            for(int i=0;i<biblio.tamano(); i++){
                Nodo nodo = biblio.buscarNodo(i);
                jTable1.setValueAt(nodo.getNombre(), i, 0);
                jTable1.setValueAt(nodo.getArtista(), i, 1);
                jTable1.setValueAt(nodo.getAlbum(), i, 2);
                jTable1.setValueAt(nodo.getGenero(), i, 3);
                jTable1.setValueAt(Integer.toString(nodo.getDuracion()), i, 4);
            }
        }
        if (jComboBoxBusqueda.getSelectedIndex()==3){
            ListaDoble biblio = biblioteca.buscarGenero(jTextField1.getText());
            for(int i=0;i<biblio.tamano(); i++){
                Nodo nodo = biblio.buscarNodo(i);
                jTable1.setValueAt(nodo.getNombre(), i, 0);
                jTable1.setValueAt(nodo.getArtista(), i, 1);
                jTable1.setValueAt(nodo.getAlbum(), i, 2);
                jTable1.setValueAt(nodo.getGenero(), i, 3);
                jTable1.setValueAt(Integer.toString(nodo.getDuracion()), i, 4);
            }
        }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

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
                new frmBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
