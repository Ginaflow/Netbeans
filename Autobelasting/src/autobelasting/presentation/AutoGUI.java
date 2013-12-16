package autobelasting.presentation;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import autobelasting.businesslogic.AutoBelasting;
import autobelasting.domain.Auto;
import autobelasting.domain.Eigenaar;
import java.awt.PopupMenu;
import java.util.ArrayList;

/**
 *
 * @author Robin
 */
public class AutoGUI
{

    private JFrame frame;
    private JTextField textFieldKenteken;
    private JTextPane textAreaCarInfo;
    private JButton searchButton;
    private JButton modifyButton;
    private JComboBox eigenarenBox;
    private AutoBelasting manager;
       
    /**
     * Creates new form AutoGUI
     */
    public AutoGUI(AutoBelasting manager) 
    {
        this.manager = manager;     
    }

    public void setupFrame()
    {
        frame = new JFrame();
        frame.setTitle("AutoGUI");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // The layout is a Borderlayouy with
        // North: JPanel with FlowLayout with a label, textfield and SearchButton
        // Center: A Multiline TextPane used to display information about the cars
        // South: JPanel with FlowLayout with a Button and a combobox with the 
        //        names of the CarOwners
        // East + West: Not Used

        // Setup of the north-area panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));   
               
        // Setup of the center-area panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        
        //Setup of the south-area panel
        JPanel modifyPanel = new JPanel();
        modifyPanel.setLayout(new BoxLayout(modifyPanel, BoxLayout.X_AXIS));
            
        //North-Area
            //Kenteken label
            searchPanel.add(new JLabel("Kenteken:")); 
            
            //Kenteken textField
            textFieldKenteken = new JTextField(10);
            textFieldKenteken.setText("");
            searchPanel.add(textFieldKenteken);
            
            //Kenteken Zoek button
            searchButton = new JButton("Zoek");
            searchButton.setSize(new Dimension(73, 23));
            searchButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    doFindKenteken(textFieldKenteken.getText());
                }
            });
            searchPanel.add(searchButton);
            
        //Center-Area
            //Car+Owner Information area
            textAreaCarInfo = new JTextPane();
            textPanel.add(textAreaCarInfo);
            
        //South-Area
            //Wijzig Eigenaar Button
            modifyButton = new JButton("WijzigEigenaar");
            modifyButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    modifyOwner(textFieldKenteken.getText());
                }
            });
            modifyPanel.add(modifyButton);
            
            //Combobox Eigenaren
            eigenarenBox = new JComboBox(manager.geefEigenaren().toArray());
            modifyPanel.add(eigenarenBox);     
            
            frame.add(searchPanel, BorderLayout.NORTH);
            frame.add(textPanel, BorderLayout.CENTER);
            frame.add(modifyPanel, BorderLayout.SOUTH);
            frame.pack();
            
   }
    
    private void doFindKenteken(String kenteken)
    {
        Auto auto = manager.findKenteken(kenteken);
        
        if(auto != null)
        {
            textAreaCarInfo.setText(auto.geefEigenaar() + "\n" + auto.geefAutoType());
            
            if(auto.geefEigenaar() != null)
            {
                eigenarenBox.setSelectedItem(auto.geefEigenaar().getName());
            }
        }
        else{
            textAreaCarInfo.setText("Niks Gevonden!");
        }
    }
         
    private void modifyOwner(String kenteken)
    {
        Auto auto = manager.findKenteken(kenteken);
        Eigenaar eigenaar = manager.geefEigenaarNaam(eigenarenBox.getSelectedItem().toString());
        auto.wijzigEigenaar(eigenaar);
    }
}
