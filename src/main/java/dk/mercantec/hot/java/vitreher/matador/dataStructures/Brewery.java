package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Brewery extends Field implements ILease {

    private Deed deed;

    public Brewery(String name, String zone, Deed deed)
    {
        super(name,zone);
        this.deed = deed;
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
