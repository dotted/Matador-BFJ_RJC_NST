package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.Brewery;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Deed;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Field;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.IDeed;
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
    /**
     *
     */
    public FieldModel(JSONObject fields) {
        this.fields = new ArrayList<Field>();
        initialize(fields);
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

    public void setOwner(String fieldName, int player)
    {
        int indexOfField = getFieldIndex(fieldName);
        Field field = this.fields.get(indexOfField);
        IDeed fieldDeed = (IDeed)field;
        Deed deed = fieldDeed.getDeed();
        deed.setOwner(player);
    }

    public void addHouse(String fieldName, int amount)
    {
        int indexOfField = getFieldIndex(fieldName);
        Street street = (Street)this.fields.get(indexOfField);
        street.addHouse(amount);
    }

    public void addHouse(String fieldName)
    {
        int indexOfField = getFieldIndex(fieldName);
        Street street = (Street)this.fields.get(indexOfField);
        street.addHouse();
    }
}
