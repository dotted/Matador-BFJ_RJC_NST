package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Start extends Field implements IReward {

    private int reward;

    public Start (String name, String zone, int reward)
    {
        super(name, zone);
        this.reward = reward;
    }

    public int getReward()
    {
        return this.reward;
    }

}
