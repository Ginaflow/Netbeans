package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class CD extends Item
{
    private String artist;
    private int numberOfTracks;
    
    public CD(String title, int playingTime, boolean gotIt, String comment, String artist, int numberOfTracks)
    {
        super(title, playingTime, gotIt, comment);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public int getNrTracks()
    {
        return numberOfTracks;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " " + artist + "\n tracks: " + numberOfTracks + "\n";
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
