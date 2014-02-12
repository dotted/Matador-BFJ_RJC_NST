package matador;

/**
 * Created by BFJ on 11-02-14.
 */
public class Turn {
    private final Player player;
    private final DiceCup diceCup;
    private final GameBoard gameBoard;

    public Turn(Player player, DiceCup diceCup, GameBoard gameBoard) {
        this.player = player;
        this.diceCup = diceCup;
        this.gameBoard = gameBoard;
        this.start();
    }

    private void start() {

    }

    private void rollDice() {
        this.diceCup.roll();

    }

    private void buyDeed() {

    }

    private void buyDeed(IDeed deed) {

    }

    private void upgradeDeed() {

    }

    private void payLease() {

    }
}
