/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameApplication;

import foxesandrabbitsGame.FoxesAndRabbits;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Robin
 */
public class GameCatalog {
   private HashMap<String, Game> gameCatalog;
   private ArrayList gameNames;

   public GameCatalog() {
       this.gameCatalog = new HashMap<>();
       this.gameCatalog.put("DummyGame", new DummyGame("DummyGame"));
       this.gameCatalog.put("Foxes And Rabbits", new FoxesAndRabbits("Foxes And Rabbits"));
       gameNames = new ArrayList<String>();
   }
   
   public void addGame(String naam, Game game)
   {
       gameCatalog.put(naam, game);
   }
   
   public ArrayList getGameNames()
   {
       for(String gameNaam : gameCatalog.keySet())
       {
           gameNames.add(gameNaam);
       }
       return gameNames;
   }
   
   public Game getGame(String gameName)
   {
       try{
           return this.gameCatalog.get(gameName);
       }
       catch(NullPointerException ex){
           System.out.println("Deze game is helaas niet gevonden");
       }
       return null;
   }
}

