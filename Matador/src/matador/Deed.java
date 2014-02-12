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
public class Deed extends java.util.Observable {
    
    private int purchasePrice;
    private int pawnPrice;
    private Player owner;
    
    public Deed(int purchasePrice, int pawnPrice, Player owner)
    {
        this.purchasePrice = purchasePrice;
        this.pawnPrice = pawnPrice;
        this.owner = owner;
    }
    
    public int getPurchasePrive()
    {
        return this.purchasePrice;
    }
    
    public int getPawnPrice()
    {
        return this.pawnPrice;
    }
    
    public Player getOwner()
    {
        return this.owner;
    }    
}
