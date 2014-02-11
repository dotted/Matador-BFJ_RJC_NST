/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

import java.util.ArrayList;

/**
 *
 * @author Nicolai
 */
public class Jail extends Field {
   
    private ArrayList<Player> usersInJail;
    
    public Jail(String name, Zone zone) 
    {
        super(name,zone);
    }
    
    public boolean isUserInJail(Player player)
    {
        if (this.usersInJail.contains(player))
          return true;
        else
          return false;        
    }
    
    public void addJailUser(Player player)
    {
        this.usersInJail.add(player);
    }
    
    public void removeJailUser(Player player)
    {
        this.usersInJail.remove(player);
    }
    
}
