/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velofiets.domain;

import java.util.ArrayList;
import velofiets.domain.Fiets;
/**
 *
 * @author Robin
 */
public class Koper {
    
    private String naam;
    private ArrayList<Fiets> fietsen;
    
    public Koper(String naam)
    {
        this.naam = naam;
        
        fietsen = new ArrayList();
    }
    
        public void koop(Fiets newFiets)
    {
        fietsen.add(newFiets);
    }
        
        public String getName()
        {
            return naam;
        }

}
