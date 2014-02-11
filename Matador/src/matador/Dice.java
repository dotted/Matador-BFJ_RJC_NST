package matador;

/**
 * Created by BFJ on 11-02-14.
 */
public class Dice implements IDice {
    private double eyes;

    /**
     * Roll the dice on object creation to make sure we have proper internal state
     */
    public Dice() {
        roll();
    }

    /**
     * Roll the dice
     */
    @Override
    public void roll() {
        this.eyes = Math.random() * 6 + 1;
    }

    /**
     * @return the last dice roll result
     */
    @Override
    public int getEyes() {
        return (int)this.eyes;
    }

    /**
     * @return the last dice roll result
     */
    @Override
    public String toString() {
        return String.valueOf(this.eyes);
    }
}
