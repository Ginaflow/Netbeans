
package autobelasting.domain;

public class Auto
{
    private Eigenaar eigenaar = null;
    private AutoType autoType;
    private String kenteken;
    private int bijtelling;

    public Auto(String kenteken, Eigenaar eigenaar, AutoType autoType)
    {
        this.kenteken = kenteken;
        this.eigenaar = eigenaar;
        this.autoType = autoType;
    }
    
    public Auto(String kenteken, AutoType autoType)
    {
        this.kenteken = kenteken;
        this.autoType = autoType;
    }
    
    public String geefKenteken()
    {
        return kenteken;
    }

    public AutoType geefAutoType()
    {
        return autoType;
    }

    public Eigenaar geefEigenaar()
    {
        return eigenaar;
    }
    
    public void wijzigEigenaar(Eigenaar nieuweEigenaar)
    {
      eigenaar = nieuweEigenaar;
    }
    
    public int geefleeftijd (int belastingJaar)
    {
        return this.autoType.geefBouwjaar() - belastingJaar;
    }       
           
            
    public int berekenBijtelling()
    {
        int CO2Uitstoot = autoType.geefCO2Uitstoot();
        String Brandstof = autoType.geefBrandstof();
        int WaardeAuto = autoType.geefWaarde();
        
        if(CO2Uitstoot <= 95 && Brandstof == "diesel")
        {
           bijtelling=WaardeAuto/100*14;
           return bijtelling;
        }
        
        else if(CO2Uitstoot >= 110 && Brandstof == "benzine")
        {
           bijtelling=WaardeAuto/100*14;
           return bijtelling;
        }
        
        else if(CO2Uitstoot >= 110 && Brandstof == "hybride")
        {
           bijtelling=WaardeAuto/100*14;
           return bijtelling;
        }
        
        else if(CO2Uitstoot >= 110 && Brandstof == "gas")
        {
           bijtelling=WaardeAuto/100*14;
           return bijtelling;
        }
        
        else
        {
           bijtelling=WaardeAuto/100*25;
           return bijtelling;
        }
            
    }
    
    public int meesteBijtelling()
    {
        return bijtelling;
    }
    
    @Override
    public String toString()
    {
        return "kenteken: " + kenteken + "\nauto: " + autoType + "\neigenaar: " + eigenaar;   
    }

}
