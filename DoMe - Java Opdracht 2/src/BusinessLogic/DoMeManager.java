/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import domain.*;
import java.util.ArrayList;
import domain.Item;

/**
 *
 * @author Robin
 */
public class DoMeManager 
{
    public ArrayList<Item> items;
    public ArrayList<Item> titles;
    
    public DoMeManager()
            {
                items = new ArrayList<Item>();
                titles = new ArrayList<Item>();
                fillTestData();
            }
    
    public void addItem(Item item)
    {
        items.add(item);
    }
        
    private void fillTestData()
    {
    addItem(new CD("True", 60 , true, "Het nieuwste album van Avicii", "Avicii", 11));
    addItem(new DVD("James Bond", 135, true, "23ste James Bond film","Sam Mendes"));
    addItem(new ComputerGame("GTA V", 10, true, "Het nieuweste spel in de Grand Theft Auto serie", "???", "Xbox 360, PC, PS3"));
    addItem(new BoardGame("Monopoly", 90, true, "Het bekendste bordspel", "???", 6));
    }
        
     /**
     * Druk een lijst af van alle tot nu toe opgeslagen item's op het scherm
     */
    public ArrayList<Item> list()
    {
        return items;
    }
    
    public ArrayList<Item> getTitles()
    {
        for (Item singleItem : items)
        {
          singleItem.getTitle();
          titles.add(singleItem);
          return titles;
        }
        return null;
    }
       
    public String getInformation(String title)
    {
        for (Item singleItem : items)
        {
            if (singleItem.getTitle().equals(title))
            {
            return singleItem.toString();
            }
        }
        return null;
    }
}


