package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Deed {

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
