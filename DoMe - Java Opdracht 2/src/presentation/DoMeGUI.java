/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import BusinessLogic.DoMeManager;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Robin
 */
public class DoMeGUI extends javax.swing.JFrame {
    
    DoMeManager manager = new DoMeManager();
    DefaultListModel listModel = new DefaultListModel();
    JTextArea output = new JTextArea();
    JLabel selected = new JLabel();
    final JList titleList = new JList(listModel);
        
    /**
     * Creates new form DoMeGUI
     */
    public DoMeGUI() {
        initComponents();
        this.setVisible(true);
        setupFrame();
    }
    
    private void setupFrame()
    {
        setTitle("DoMeGUI");
        
        JPanel contentPane = (JPanel)getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));
        
        //Setup East Area
        JTextArea eastPanel = createEastPanel();
                
        //Setup West Area
        JPanel westPanel = createWestPanel();
        
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(westPanel, BorderLayout.WEST);
    }
    
    private JPanel createWestPanel()
    {
            JPanel westPanel = new JPanel();
            titleList.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    String item = manager.getInformation(titleList.getSelectedValue().toString());
                    output.setText(item.toString());
                }
            });
            for(int x = 0; x < manager.list().size(); x++){
            listModel.addElement(manager.list().get(x).getTitle());}
            
            titleList.setSize(10, 10);
            titleList.setVisible(true);
            westPanel.add(titleList);
            westPanel.add(selected);
            return westPanel;
    }
            
    private JTextArea createEastPanel()
    {
        output.setEditable(false);
        output.setVisible(true);
        return output;
    }
    
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoMeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoMeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoMeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoMeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoMeGUI().setVisible(true);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}