package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.Brewery;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Deed;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Field;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.IDeed;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.IDice;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Shipping;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Start;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Street;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.UpgradeableDeed;
import java.util.ArrayList;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by BFJ on 12-02-14.
 */
public class FieldModel extends Observable {

    private final Field[] fields;
    private Field[] playerLocations;
    /**
     * This will create an FieldModel which contains
     * information about all the Fields, the players location,
     * and set the start field.
     * @param fields
     * @param amountPlayers
     * @param startField
     */
    public FieldModel(Field[] fields, int amountPlayers, String startField) {
        this.fields = fields;
        this.playerLocations = new Field[amountPlayers];
        int indexOfField = getFieldIndex(startField);
        for (int i = 0; i < this.playerLocations.length; i++)
        {
            playerLocations[i] = this.fields[indexOfField];
        }
    }

    /**
     * This will find the index of a Field in the fields
     * arrayList and then return the index
     * @param fieldName string
     * @return int
     */
    private int getFieldIndex(String fieldName)
    {
        for (int i = 0; i < this.fields.length; i++){
            if (this.fields[i].getName().equals(fieldName))
                return i;
        }
        return -1;
    }

    /**
     * This will find the Field object with the
     * name given and give the deed an owner.
     * @param fieldName String
     * @param player int
     */
    public void setOwner(String fieldName, int player)
    {
        int indexOfField = getFieldIndex(fieldName);
        Field field = this.fields[indexOfField];
        IDeed fieldDeed = (IDeed)field;
        Deed deed = fieldDeed.getDeed();
        deed.setOwner(player);
        setChanged();
        notifyObservers(deed);
    }

    /**
     * This will add a specified amount of houses
     * to an UpgradeableDeed
     * @param fieldName String
     * @param amount int
     */
    public void addHouse(String fieldName, int amount)
    {
        int indexOfField = getFieldIndex(fieldName);
        Street street = (Street)this.fields[indexOfField];
        street.addHouse(amount);
        setChanged();
        notifyObservers(street);
    }

    /**
     * This method will add 1 house on
     * an UpgradeableDeed
     * @param fieldName String
     */
    public void addHouse(String fieldName)
    {
        int indexOfField = getFieldIndex(fieldName);
        Street street = (Street)this.fields[indexOfField];
        street.addHouse();
        setChanged();
        notifyObservers(street);
    }

    /**
     * This will update the location of the player in the ayrray
     * according to the dice eyes.
     * @param player int
     * @param moves IDice
     */
    public void movePlayerPiece(int player, int moves)
    {
        int currentIndex = getFieldIndex(playerLocations[player].getName());
        int newIndex = currentIndex + moves;
        if (newIndex <= this.fields.length)
            playerLocations[player] = this.fields[newIndex];
        else
            playerLocations[player] = this.fields[newIndex % this.fields.length];
        setChanged();
        notifyObservers(playerLocations[player]);
    }

    /**
     *
     * @param player
     * @return
     */
    public String getPlayerLocation(int player) {
        return this.playerLocations[player].getName();
    }
}
