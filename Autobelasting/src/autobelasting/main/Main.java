/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autobelasting.main;

import autobelasting.presentation.AutoGUI;
import autobelasting.businesslogic.AutoBelasting;
import autobelasting.domain.*;
import autobelasting.presentation.EigenarenOverzichtGUI;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Eigenaar Henk = new Eigenaar(1000, "Henk", "Boterstraat 1");
        Eigenaar Piet = new Eigenaar(2000, "Piet", "Spoorstraat 128");
        Eigenaar Klaas = new Eigenaar(3000, "Klaas", "Kerkstraat 8");
        
        Auto BMW = new Auto("KN-89-HK", Henk, new AutoType(2003, 21500, 1050, 1800, "Diesel", 50, "BMW")); 
        Auto Volvo = new Auto("HG-45-YG", Piet, new AutoType(1999, 25890, 1010, 1500, "Benzine", 80, "Volvo"));
        Auto Ford = new Auto("BF-38-AD", Klaas, new AutoType(2001, 22995, 1180, 1900, "Benzine", 95, "Ford"));
        Auto Peugeot = new Auto("PA-29-LZ", new AutoType(2005, 23450, 1100, 1850, "Diesel", 75, "Peugeot"));
                       
        AutoBelasting manager = new AutoBelasting();
        
        manager.addOwner(Henk);
        manager.addOwner(Piet);
        manager.addOwner(Klaas);
        manager.addCar(BMW);
        manager.addCar(Volvo);
        manager.addCar(Ford);
        manager.addCar(Peugeot);
        
        //EigenarenOverzichtGUI overzicht = new EigenarenOverzichtGUI(manager);
        //overzicht.setVisible(true);
        //EigenarenOverzichtenGUI overzicht = new EigenarenOverzichtenGUI();
        AutoGUI ui = new AutoGUI(manager);
        ui.setupFrame();
        


    }
 
}
