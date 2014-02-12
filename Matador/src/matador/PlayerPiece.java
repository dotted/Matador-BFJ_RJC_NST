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
public class PlayerPiece extends java.util.Observable {
    private Player owner;
    
    /**
     * This will create a PlayerPiece
     * with an Player owner.
     * @param player
     */
    public PlayerPiece(Player player)
    {
        this.owner = player;
    }
    
    /**
     * This will return the Player which
     * is the owner of the PlayerPiece.
     * @return owner
     */
    public Player getOwner()
    {
        return this.owner;
    }
    
}
