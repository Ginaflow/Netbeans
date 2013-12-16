package domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Robin
 */
public class Item {
    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;

public Item (String title, int playingTime, boolean gotIt, String comment)
{
  this.title = title;
  this.playingTime = playingTime;
  this.gotIt = gotIt;
  this.comment = comment;
}

public String getTitle()
{
    return title;
}

public int getPlayingTime()
{
    return playingTime;
}
        
public void setComment(String comment)
{
    this.comment = comment;
}

public String getComment()
{
    return comment;
}

public void setOwn(boolean ownIt)
{
    gotIt = ownIt;
}

public boolean getOwn()
{
    return gotIt;
}

public String toString()
    {
        if(getOwn()== true)
        {return "Titel: " + title + "\n" + "Speelduur: " + playingTime + "\n" + "Comment: " + comment + "\n" + "Got it: YES! :D" + "\n";}
        else{return "Titel: " + title + "\n" + "Speelduur: " + playingTime + "\n" + "Comment: " + comment + "\n" + "Got it: No :(" + "\n";}
    }

public void print()
{
    System.out.println(toString());
}
}

