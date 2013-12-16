package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class Game extends Item
{
    private String hint;
    
    public Game(String title, int playingTime, boolean gotIt, String comment, String hint)
    {
        super(title, playingTime, gotIt, comment);
        this.hint = hint;
    }
    
    public String getHint()
    {
        return hint;
    }
   
    @Override
    public String toString()
    {
        return super.toString() + " Hint: " + hint;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
