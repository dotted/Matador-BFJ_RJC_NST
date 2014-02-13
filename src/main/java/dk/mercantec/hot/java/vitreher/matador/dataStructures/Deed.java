package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Deed {

    private int purchasePrice;
    private int pawnPrice;

    public Deed(int purchasePrice, int pawnPrice)
    {
        this.purchasePrice = purchasePrice;
        this.pawnPrice = pawnPrice;
    }

    public int getPurchasePrice()
    {
        return this.purchasePrice;
    }

    public int getPawnPrice()
    {
        return this.pawnPrice;
    }
}
