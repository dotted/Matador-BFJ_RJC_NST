package matador;

/**
 * Created by BFJ on 11-02-14.
 */
public class DiceCup implements IDice {

    private IDice[] dices;

    /**
     * @param dices array of dice held by the dice cup
     */
    public DiceCup(IDice... dices) {
        this.dices = dices;
    }

    /**
     * roll all dice
     */
    @Override
    public void roll() {
        for (IDice dice : this.dices) {
            dice.roll();
        }
    }

    /**
     * @return the total number of eyes rolled by the dice
     */
    @Override
    public int getEyes() {
        int eyes = 0;
        for (IDice dice : this.dices) {
            eyes += dice.getEyes();
        }
        return eyes;
    }

    /**
     * @return true if all dice have same value
     */
    public boolean isDiceEqual() {
        int lastValue = 0;
        for (IDice dice : this.dices) {
            if (lastValue == 0) {
                lastValue = dice.getEyes();
            }
            else {
                if (dice.getEyes() != lastValue)
                    return false;
            }
        }
        return true;
    }

    /**
     * @return getEyes() as string
     */
    public String toString() {
        return String.valueOf(this.getEyes());
    }
}
