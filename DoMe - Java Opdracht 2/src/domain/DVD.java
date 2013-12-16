package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class DVD extends Item
{
    private String director;
    
    public DVD(String title, int playingTime, boolean gotIt ,String comment, String director)
    {
        super(title, playingTime, gotIt, comment);
        this.director = director;
    }
    
    public String getDirector()
    {
        return director;
    }
   
    @Override
    public String toString()
    {
        return super.toString() + " director: " + director;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
