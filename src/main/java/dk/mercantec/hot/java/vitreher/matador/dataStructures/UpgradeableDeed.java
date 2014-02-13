package dk.mercantec.hot.java.vitreher.matador.dataStructures;

import java.util.HashMap;

/**
 *
 * @author Nicolai
 */
public class UpgradeableDeed extends Deed {

    private HashMap housePrice;

    public UpgradeableDeed(int purchasePrice, int pawnPrice, int[] housePrice)
    {
        super(purchasePrice, pawnPrice);
        this.housePrice = housePrice;
    }

    public int getHousePrice()
    {
        return 1;
    }

}
