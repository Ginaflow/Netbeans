/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autobelasting.presentation;

import autobelasting.businesslogic.AutoBelasting;
import autobelasting.domain.Auto;
import autobelasting.domain.Eigenaar;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robin
 */
public class EigenarenOverzichtGUI extends JFrame {

    private AutoBelasting manager;
    private JLabel brandstofLabel;
    private JLabel autotypeLabel;
    private JButton brandstofToon;
    private JButton autotypeToon;
    private JPanel panel;
    private JTable lijstEigenaren;
    private JScrollPane scrollPaneEigenaren;
    private JRadioButton benzineRadioButton;
    private JRadioButton dieselRadioButton;
    private ButtonGroup brandstofRadio;
    private JList lijstAutoType;
    
    String geefSelecteerdeRadioButton()
    {
        if(benzineRadioButton.isSelected())
            return "Benzine";
        if(dieselRadioButton.isSelected()) 
            return "Diesel";
        else
            return null;
    }
    
    public void geefEigenarenBrandstof()
    {
        ArrayList<Eigenaar> eigenaren = manager.geefEigenarenVoorBrandstof(geefSelecteerdeRadioButton());
        for(int i=0; i < eigenaren.size(); i++)
        {
            ((DefaultTableModel) lijstEigenaren.getModel()).insertRow(i, new Object[] {eigenaren.get(i).getName(), eigenaren.get(i).getBSN(), eigenaren.get(i).getAdres()});
        }
    }
    
    public void geefEigenarenAutoType()
    {
        ArrayList<Eigenaar> eigenaren = manager.geefEigenarenVoorType(lijstAutoType.getSelectedValue().toString());
        for(int i=0; i < eigenaren.size(); i++)
        {
            ((DefaultTableModel) lijstEigenaren.getModel()).insertRow(i, new Object[] {eigenaren.get(i).getName(), eigenaren.get(i).getBSN(), eigenaren.get(i).getAdres()});
        }
    }
    
    private void nieuweTabel()
    {
        DefaultTableModel model = (DefaultTableModel) lijstEigenaren.getModel();
        model.setRowCount(0);
    }
    
    private String[] geeftAutotype()
    {
        String[] autotypes = new String[manager.aantalVoertuigen()];
        ArrayList<Auto> voertuigen = manager.geefVoertuigen();
        for(int i=0; i < voertuigen.size(); i++)
        {
            autotypes[i] = voertuigen.get(i).geefAutoType().geefNaam();
        }
        return autotypes;
    }
    
    private void groupButton()
    {
        brandstofRadio = new ButtonGroup();
        brandstofRadio.add(benzineRadioButton);
        brandstofRadio.add(dieselRadioButton);
    }
    /**
     * Creates new form EigenarenOverzichtGUI
     */
    public EigenarenOverzichtGUI(AutoBelasting manager) 
    { 
        initComponents();
        groupButton();
        setTitle("EigenarenOverzichtGUI");
        this.manager = manager;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,700,400);
                    
    //Creating Eigenaren gefilterd op brandstof area
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150,100));
        setContentPane(panel);
        panel.setLayout(null);

        //Label Eigenaren gefilterd op brandstof
        brandstofLabel = new JLabel("Eigenaren gefilterd op brandstof");
        brandstofLabel.setBounds(20,25,200,25);
        panel.add(brandstofLabel);
        
        //Benzine Radio Button
        benzineRadioButton = new JRadioButton("Benzine");
        benzineRadioButton.setSelected(false);
        benzineRadioButton.setBounds(20,50,75,25);
        panel.add(benzineRadioButton);
        
        //Diesl Radio Button
        dieselRadioButton = new JRadioButton("Diesel");
        dieselRadioButton.setSelected(false);
        dieselRadioButton.setBounds(20,75,75,25);
        panel.add(dieselRadioButton);
        
        
        //Brandstof Toon Button
        brandstofToon = new JButton("Toon");
        brandstofToon.setBounds(225,60,75,25);
        brandstofToon.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                nieuweTabel();
                geefEigenarenBrandstof();
            }
        });
        panel.add(brandstofToon);
                
    //Creating Eigenaren gefilterd op merk area
        //Label Eigenaren gefilterd op autotype
        autotypeLabel = new JLabel("Eigenaren gefilterd op autotype");
        autotypeLabel.setBounds(20,120,200,25);
        panel.add(autotypeLabel);
        
        //Lijst van autotype
        lijstAutoType = new JList();
        lijstAutoType.setBounds(20,150,180,200);
        lijstAutoType.setModel(new AbstractListModel() 
        {
            String[] values = geeftAutotype();
            public int getSize() 
            {
                return values.length;
            }
            @Override
            public Object getElementAt(int index) 
            {
                return values[index];
            }
        });
        panel.add(lijstAutoType);
        
        //Autotype Toon Button
        autotypeToon = new JButton("Toon");
        autotypeToon.setBounds(225,200,75,25);
        autotypeToon.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                nieuweTabel();
                geefEigenarenAutoType();
            }
        });
        panel.add(autotypeToon);
        
     //Creating lijst van eigenaren
        //Lijst eigenaren
        lijstEigenaren = new JTable();
        lijstEigenaren.setBounds(325,15,350,340);
        lijstEigenaren.setModel(new DefaultTableModel(
                new Object[][]{},
                new String []
                {
                    "Naam", "BSN","Adres"
                }          
        ));
        
        scrollPaneEigenaren = new JScrollPane();
        scrollPaneEigenaren.setBounds(325,15,350,340);
        scrollPaneEigenaren.setViewportView(lijstEigenaren);
        panel.add(scrollPaneEigenaren);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
