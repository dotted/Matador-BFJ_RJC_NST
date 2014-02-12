/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

import java.util.ArrayList;
import views.GameView;

/**
 *
 * @author Nicolai
 */
public class Game {
    
    
    public void start()
    {
        int playerCount = 0;
        ArrayList<String> playerNames;
        GameView gView = new GameView();
        do {            
            try 
            {
                playerCount = gView.askNumberOfPlayers();
                if (playerCount > 4)
                    throw new UnsupportedOperationException();
            } catch (UnsupportedOperationException e) 
            {
               System.out.println("Number of players has to be from 2-4 players");
            } catch (NumberFormatException e)
            {
                System.out.println("The number of players has to be a number");
            }
        } while (playerCount == 0 || playerCount > 4);
        playerNames = gView.getNamesOfPlayers(playerCount);
        
    }
    
    public void nextTurn()
    {
        
    }
    
}
