package autobelasting.domain;

public class AutoType
{
    private int bouwjaar;
    private int nieuwPrijs;
    private int gewicht;
    private int motorinhoud;
    private String brandstof;
    private int CO2Uitstoot;
    private String naam;

    public AutoType(int bouwjaar, int nieuwPrijs, int gewicht, int motorinhoud, String brandstof, int CO2Uitstoot, String naam)
    {
        this.bouwjaar = bouwjaar;
        this.nieuwPrijs = nieuwPrijs;
        this.gewicht = gewicht;
        this.motorinhoud = motorinhoud;
        this.brandstof = brandstof;
        this.CO2Uitstoot = CO2Uitstoot;
        this.naam = naam;
    }

    public String geefBrandstof()
    {
        return brandstof;
    }

    public int geefCO2Uitstoot()
    {
        return CO2Uitstoot;
    }
    
    public void wijzigBouwjaar(int bouwjaar)
    {
        this.bouwjaar = bouwjaar;
    }
    
    
    public int geefBouwjaar()
    {
        return bouwjaar;
    }
    
    public String geefNaam()
    {
        return naam;
    }
    
    public int geefWaarde()
    {
        return nieuwPrijs;
    }
    
    @Override
    public String toString()
    {
        return brandstof + " " + bouwjaar + naam;
    }
}
