/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autobelasting.datastore;

import autobelasting.domain.Eigenaar;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Robin
 */
public class EigenaarDAO {
    
    public EigenaarDAO()
    {
        
    }
    
    public static ArrayList<Eigenaar> geefEigenaar()
    {
        ArrayList<Eigenaar> eigenaren = new ArrayList<>();
        //Open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet result = connection.executeSQLSelectStatement("SELECT * FROM eigenaar");
            if(result != null)
            {
                try
                {
                    while(result.next())
                    {
                        Eigenaar eigenaar = null;
                        eigenaar = new Eigenaar(result.getInt("BSN"), result.getString("naam"), result.getString("adres"));
                        eigenaren.add(eigenaar);
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e.getErrorCode());
                }
            }
        }
        return eigenaren;
    }
}
