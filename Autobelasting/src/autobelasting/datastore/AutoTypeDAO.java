/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autobelasting.datastore;

import autobelasting.domain.AutoType;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Robin
 */
public class AutoTypeDAO {
    
    public AutoTypeDAO()
    {
        
    }
        
        public static ArrayList<AutoType> geefAutoType()
    {
        ArrayList<AutoType> autotypes = new ArrayList<>();
        //Open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet result = connection.executeSQLSelectStatement("SELECT * FROM autotype");
            if(result != null)
            {
                try
                {
                    while(result.next())
                    {
                        AutoType autotype = null;
                        autotype = new AutoType(result.getInt("bouwjaar"), result.getInt("nieuwPrijs"), result.getInt("gewicht"), result.getInt("motorinhoud"), result.getString("brandstof"), result.getInt("CO2Uitstoot"), result.getString("naam"));
                        autotypes.add(autotype);
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e.getErrorCode());
                }
            }
        }
        return autotypes;
    }
}

