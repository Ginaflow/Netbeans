/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autobelasting.datastore;

import autobelasting.domain.Auto;
import autobelasting.domain.AutoType;
import autobelasting.domain.Eigenaar;
import java.sql.*;

/**
 *
 * @author Robin
 */
public class AutoDAO {
    
    public AutoDAO()
    {
        
    }
    
    public static Auto geefAuto(String kenteken)
    {
        Auto auto = null;
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            ResultSet result = connection.executeSQLSelectStatement("SELECT * FROM auto LEFT JOIN autotype ON auto.autotypeNaam = autotype.naam LEFT JOIN eigenaar ON auto.eigenaarBSN = eigenaar.BSN WHERE auto.kenteken = " + kenteken + ";");
            if(result != null)
            {
                try
                {
                    if(result.next())
                    {
                        int eigenaarBSN = result.getInt("eigenaar.BSN");
                        Eigenaar eigenaar = null;
                        if(eigenaarBSN !=0)
                        {
                            eigenaar = new Eigenaar(result.getInt("eigenaar.BSN"), result.getString("eigenaar.naam"), result.getString("eigenaar.adres"));
                        }
                        auto = new Auto(result.getString("kenteken"), eigenaar, new AutoType(result.getInt("bouwjaar"), result.getInt("nieuwPrijs"), result.getInt("gewicht"), result.getInt("motorinhoud"), result.getString("brandstof"), result.getInt("CO2Uitstoot"), result.getString("naam")));
                    }
                }
                catch(SQLException e)
                {                
                    System.out.println(e.getErrorCode());
                }
            }
        }
        return auto;
    }
    
    public static boolean updateEigenaar(Auto auto, Eigenaar eigenaar)
    {
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            if(connection.executeSQLDeleteStatement("UPDATE auto SET auto = " + Auto + " WHERE eigenaar = " + eigenaar + ";" ))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}
