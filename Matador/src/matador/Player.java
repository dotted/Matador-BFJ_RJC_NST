/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

/**
 *
 * @author Nicolai
 */
class Player extends java.util.Observable {
        private String name;
    
    public Player (String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
}
