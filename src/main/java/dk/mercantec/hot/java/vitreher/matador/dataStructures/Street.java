package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Street extends Field implements ILease {

    private final int[] leasePrices; // Index 2 in this array is equal to having 2 Houses etc.
    private final int maxHouses = 5; // Value of field can't be changed
    private final UpgradeableDeed deed;

    private int numberOfHouses = 0;

    public Street(String name, String zone, UpgradeableDeed deed, int[] rent)
    {
        super(name, zone);
        this.deed = deed;
        this.leasePrices = rent;
    }

    public void addHouse()
    {
        if (this.numberOfHouses > this.maxHouses)
            throw new UnsupportedOperationException();
        this.numberOfHouses += 1;
    }

    public int getNumberOfHouses()
    {
        return this.numberOfHouses;
    }

    public int getLease()
    {
        return this.leasePrices[this.numberOfHouses];
    }

    public Deed getDeed()
    {
        return this.deed;
    }
}
