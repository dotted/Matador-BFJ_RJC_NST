package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class PlayerPiece {
    private Player owner;

    /**
     * This will create a PlayerPiece
     * with an Player owner.
     * @param player
     */
    public PlayerPiece(Player player)
    {
        this.owner = player;
    }

    /**
     * This will return the Player which
     * is the owner of the PlayerPiece.
     * @return owner
     */
    public Player getOwner()
    {
        return this.owner;
    }

}

