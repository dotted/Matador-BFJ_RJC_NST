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

    private final ArrayList<Field> fields;
    private Field[] playerLocations;
    /**
     * This will create an FieldModel which contains
     * information about all the Fields, the players location,
     * and set the start field.
     * @param fields
     * @param amountPlayers
     * @param startField
     */
    public FieldModel(JSONObject fields, int amountPlayers, String startField) {
        this.fields = new ArrayList<Field>();
        initialize(fields);
        this.playerLocations = new Field[amountPlayers];
        int indexOfField = getFieldIndex(startField);
        for (int i = 0; i < this.playerLocations.length; i++)
        {
            playerLocations[i] = this.fields.get(indexOfField);
        }
    }

    /**
     * Import json and parse it to fields
     * @param fields raw jason input
     */
    private void initialize(JSONObject fields)
    {
        JSONArray array = fields.getJSONArray("fields");

        for(int i = 0; i < array.length(); i++) {
            JSONObject field = array.getJSONObject(i);

            String name = field.getString("name");
            String zone = field.getString("zone");
            int deedPrice = field.optInt("deedPrice", 0);
            int housePrice = field.optInt("housePrice");
            int reward = field.optInt("reward");

            JSONArray rent = field.optJSONArray("rent");

            int[] rentArray = null;

            if (rent != null)
            {
                rentArray = new int[rent.length()];

                for(int r = 0; i < rent.length(); i++) {
                    rentArray[r] = rent.getInt(r);
                }
            }

            if ("start".equals(zone))
                this.fields.add(new Start(name, zone, reward));
            else if ("brewery".equals(zone))
                this.fields.add(new Brewery(name, zone, new Deed(deedPrice, deedPrice/2)));
            else if ("shipping".equals(zone))
                this.fields.add(new Shipping(name, zone, new Deed(deedPrice, deedPrice/2), rentArray));
            //else if (zone == "jail")
            else
                this.fields.add(new Street(name, zone, new UpgradeableDeed(deedPrice, deedPrice/2, housePrice), rentArray));
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
        int indexOfField = -1;
        for (Field field: this.fields)
        {
            if (field.getName().equals(fieldName))
                indexOfField = this.fields.indexOf(field);
        }
        return indexOfField;
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
        Field field = this.fields.get(indexOfField);
        IDeed fieldDeed = (IDeed)field;
        Deed deed = fieldDeed.getDeed();
        deed.setOwner(player);
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
        Street street = (Street)this.fields.get(indexOfField);
        street.addHouse(amount);
    }

    /**
     * This method will add 1 house on
     * an UpgradeableDeed
     * @param fieldName String
     */
    public void addHouse(String fieldName)
    {
        int indexOfField = getFieldIndex(fieldName);
        Street street = (Street)this.fields.get(indexOfField);
        street.addHouse();
    }

    /**
     * This will update the location of the player in the ayrray
     * according to the dice eyes.
     * @param player int
     * @param moves IDice
     */
    public void movePlayerPiece(int player, IDice moves)
    {
        int currentIndex = this.fields.indexOf(playerLocations[player]);
        int newIndex = currentIndex + moves.getEyes();
        if (newIndex <= this.fields.size())
            playerLocations[player] = this.fields.get(newIndex);
        else
            playerLocations[player] = this.fields.get(newIndex % this.fields.size());
    }
}
