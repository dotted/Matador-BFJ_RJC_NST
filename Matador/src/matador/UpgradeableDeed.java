/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

import java.util.HashMap;

/**
 *
 * @author Nicolai
 */
public class UpgradeableDeed extends Deed {
    
    private HashMap housePrice;
    
    public UpgradeableDeed(int purchasePrice, int pawnPrice, Player owner, HashMap housePrice)
    {
        super(purchasePrice, pawnPrice, owner);
        this.housePrice = housePrice;
    }
    
    public int getHousePrice()
    {
        return 1;
    }
    
}
