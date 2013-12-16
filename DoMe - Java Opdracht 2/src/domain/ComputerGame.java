package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class ComputerGame extends Game
{
    private String platform;
    
    public ComputerGame(String title, int playingTime, boolean gotIt, String comment, String hint, String platform)
    {
        super(title, playingTime, gotIt, comment, hint);
        this.platform = platform;
    }
    
    public String getPlatform()
    {
        return platform;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " Platform: " + platform;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
