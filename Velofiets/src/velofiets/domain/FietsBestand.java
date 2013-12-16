/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velofiets.domain;

import java.util.ArrayList;
import velofiets.domain.Koper;
import velofiets.domain.Fiets;
/**
 *
 * @author Robin
 */
public class FietsBestand {
    
    private ArrayList<Fiets> aantalFietsen;
    
    public FietsBestand()
    {
        aantalFietsen = new ArrayList();
    }
    
        public void nieuweFiets(Fiets newFiets)
    {
        aantalFietsen.add(newFiets);
    }
        public void Print() 
        {
        
        for(Fiets fiets :aantalFietsen){
                 System.out.println("fietsmerk:" + fiets.getMerk());
    }
    
        

    }
}
