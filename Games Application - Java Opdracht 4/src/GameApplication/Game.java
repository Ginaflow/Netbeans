package GameApplication;

import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robin
 */
public interface Game {
    
    public void start();
    public String getInfo();
    public JPanel getPanel();

}
