package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class BoardGame extends Game
{
    private int nrOfPlayers;
    
    public BoardGame(String title, int playingTime, boolean gotIt, String comment, String hint, int nrOfPlayers)
    {
        super(title, playingTime, gotIt, comment, hint);
        this.nrOfPlayers = nrOfPlayers;
    }
    
    public int getNrPlayers()
    {
        return nrOfPlayers;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " Nunmber of Players: " + nrOfPlayers;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
