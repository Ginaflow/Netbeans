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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fiets stadsfiets = new Fiets(100, "Gazelle", "Stadsfiets");
        Fiets mountainbike = new Fiets(250, "Impala", "Mountainbike");
        Fiets racefiets = new Fiets(375, "Gazelle", "Racefiets");
        Fiets tandem = new Fiets(350, "Budget", "Tandem");
        FietsBestand aantalFietsen = new FietsBestand();
          
        aantalFietsen.nieuweFiets(stadsfiets);
        aantalFietsen.nieuweFiets(mountainbike);
        aantalFietsen.nieuweFiets(racefiets);
        aantalFietsen.nieuweFiets(tandem);
        aantalFietsen.Print();
        
        Koper piet = new Koper("Piet");
        Koper klaas = new Koper("Klaas");
        Koper henk = new Koper("Henk");
        Koper jan = new Koper("Jan");
        
        piet.koop(stadsfiets);
        klaas.koop(mountainbike);
        henk.koop(mountainbike);
        jan.koop(tandem);
        
        stadsfiets.verkoopAan(piet);
        mountainbike.verkoopAan(klaas);
        mountainbike.verkoopAan(henk);
        tandem.verkoopAan(jan);
        
    }
    
   }
