package autobelasting.domain;

import java.util.ArrayList;

public class Eigenaar
{
    private int bsn;
    private String naam;
    private String adres;
    
    private ArrayList<String> berichten; 

    public Eigenaar(int bsn, String naam, String adres)
    {
        this.bsn = bsn;
        this.naam = naam;
        this.adres = adres;
        
        berichten = new ArrayList();
    }
    
    public String getName()
    {
        return naam;
    }
    
    public String getAdres()
    {
        return adres;
    }
    
    public int getBSN()
    {
        return bsn;
    }
           
    public void stuurBericht(String bericht)
    {
     berichten.add(bericht);
    }
    
    @Override
    public String toString()
    {
        return bsn + " " + naam + " " + adres + " " + berichten;
    }
}
