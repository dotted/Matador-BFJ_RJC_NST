package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Shipping extends Field implements ILease,IDeed {

    private static int[] leasePrices;
    private Deed deed;

    public Shipping(String name, String zone, Deed deed, int[] leasePrices)
    {
        super(name, zone);
        this.deed = deed;
        this.leasePrices = leasePrices;
    }

    public int getLease()
    {
        return 1;
    }

    public Deed getDeed()
    {
        return this.deed;
    }

}

