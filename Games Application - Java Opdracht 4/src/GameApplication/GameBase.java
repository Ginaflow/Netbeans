/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameApplication;

import javax.swing.JPanel;

/**
 *
 * @author Robin
 */
public abstract class GameBase implements Game {
    
    private String naam;
    
    protected GameBase(String naam)
    {
        this.naam = naam;
    }
    
   public String getName()
   {
       return naam;
   }
}
