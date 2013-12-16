/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velofiets.domain;

import java.util.ArrayList;
/**
 *
 * @author Robin
 */
public class Fiets {
    
    private int prijs;
    private String merk;
    private String type;
    private ArrayList<Koper> kopers;
    
    public Fiets(int prijs, String merk, String type)
    {
        this.prijs = prijs;
        this.merk = merk;
        this.type = type;
        
        kopers = new ArrayList();
    }
    
    public void verkoopAan(Koper newKoper)
    {
        kopers.add(newKoper);
    }
    
    public int getPrijs()
    {
        return prijs;
    }
    
    public String getMerk()
    {
        return merk;
    }
    
    public String getType()
    {
        return type;
    }
    
    public ArrayList<Koper> getKopers()
    {
        return kopers;
    }
    
}
