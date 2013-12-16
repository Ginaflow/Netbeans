/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foxesandrabbitsGame;

import GameApplication.GameBase;
import javax.swing.JPanel;

/**
 *
 * @author Robin
 */
public class FoxesAndRabbits extends GameBase{
    
    private foxesandrabbitsGame.Simulator simulator;
    
    public FoxesAndRabbits(String naam)
    {
        super("Foxes And Rabbits");
        simulator = new foxesandrabbitsGame.Simulator();
    }

    @Override
    public void start() 
    {
        simulator.resetSimulator();
        simulator.runLongSimulation();
    }

    @Override
    public String getInfo() 
    {
        return "Dit is een simulatie van Foxes And Rabbits";
    }

    @Override
    public JPanel getPanel() 
    {
        return simulator;
    }
    
}
