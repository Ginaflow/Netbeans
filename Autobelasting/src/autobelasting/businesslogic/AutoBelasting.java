package autobelasting.businesslogic;

import autobelasting.domain.Auto;
import autobelasting.domain.Eigenaar;
import java.util.*;

public class AutoBelasting
{

    private ArrayList<Auto> voertuigen;
    private ArrayList<Eigenaar> eigenaren;
    
    public AutoBelasting()
    {
        voertuigen = new ArrayList<Auto>();
        eigenaren = new ArrayList<Eigenaar>();
    }
    
    public int aantalVoertuigen()
    {
        return voertuigen.size();
    }
    
    public ArrayList<Auto> geefVoertuigen()
    {
        return voertuigen;
    }
    
    public void voegAutoToe(Auto nieuweAuto)
    {
        voertuigen.add(nieuweAuto);
    }
    
    public ArrayList<String> geefEigenaren()
    {
        ArrayList<String> eigenaarNaam = new ArrayList<String>();
        for(Eigenaar eigenaar : eigenaren)
        {
            eigenaarNaam.add(eigenaar.getName());
        }
        return eigenaarNaam;
    }
    
    public Eigenaar geefEigenaarNaam(String naam)
    {
        for(int i = 0; i<eigenaren.size(); i++)
        {
            if(eigenaren.get(i).getName() == naam)
            {
                return eigenaren.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Eigenaar> geefEigenarenVoorBrandstof(String brandstof)
    {
        ArrayList<Eigenaar> eigenaarBrandstof = new ArrayList<Eigenaar>();
        String brandstofnaam = "";
        
        for (Auto voertuig : voertuigen)
        {
            brandstofnaam = voertuig.geefAutoType().geefBrandstof();
            
            if 
                    
                    (brandstofnaam == brandstof)
                    {
                    eigenaarBrandstof.add(voertuig.geefEigenaar());
                    }
        else
        {}
        }
        return eigenaarBrandstof;
        }
            
        public void printEigarenVoorBrandstof (String brandstof)
        {
            System.out.println(eigenaren);
        }
     
    public ArrayList<Eigenaar> geefEigenarenVoorType(String typeNaam)
    {
        ArrayList<Eigenaar> eigenaarType = new ArrayList<Eigenaar>();
        String type = "";
        
        for (Auto voertuig : voertuigen)
        {
            type = voertuig.geefAutoType().geefNaam();
            
            if(type == typeNaam)
                    {
                        eigenaarType.add(voertuig.geefEigenaar());
                    }
        else
        {}
        }
        return eigenaarType;
        }
            
        public void printEigarenVoorType(String typeNaam)
        {
            System.out.println(eigenaren);
        }
        
        public void addOwner(Eigenaar nieuweEigenaar)
        {
            eigenaren.add(nieuweEigenaar);
        }
        
        public void addCar(Auto newCar)
        {
            voertuigen.add(newCar);
        }
        
            public Auto findKenteken(String kenteken)
    {
        Auto kentekenNu = null;
        
        int index = 0;
        
        while(kentekenNu == null && index < voertuigen.size())
        {
            Auto currentKenteken = voertuigen.get(index);
            
            if(currentKenteken.geefKenteken().equals(kenteken))
                    {
                        kentekenNu = currentKenteken;
                    }
            else
            {
                index++;
            }
        }
        
        return kentekenNu;
    }
        
     }
