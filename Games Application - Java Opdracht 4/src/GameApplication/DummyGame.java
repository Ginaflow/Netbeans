/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameApplication;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Robin
 */
public class DummyGame extends GameBase{
    
    private JPanel dummyGamePanel;
    private JLabel tekstLabel;

    public DummyGame(String naam) 
    {
        super("DummyGame");
    }
    
    @Override
    public JPanel getPanel()
    {
        dummyGamePanel = new JPanel();
        tekstLabel = new JLabel("Test");
        dummyGamePanel.add(tekstLabel);
        return dummyGamePanel;
    }
    
    @Override
    public void start()
    {
        tekstLabel.setText("Methode goed uitgevoerd");
    }
    
    @Override
    public String getInfo()
    {
        return "Dit is een DummyGame";
    }
    
}
