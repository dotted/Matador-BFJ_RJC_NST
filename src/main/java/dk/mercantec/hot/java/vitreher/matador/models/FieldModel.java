package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Observable;

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

            JSONArray rent = field.optJSONArray("rent");
            int[] rentArray;

            if (rent.length() > 0)
            {
                rentArray = new int[rent.length()];

                for(int r = 0; i < rent.length(); i++) {
                    rentArray[r] = rent.getInt(r);
                }
            }

            if (zone == "start")
                this.fields.add(new Start(name, zone, deedPrice));
            else if (zone == "brewery")
                this.fields.add(new Brewery(name, zone, new Deed(deedPrice, deedPrice/2)));
            else if (zone == "shipping")
            {
                this.fields.add(new Shipping(name, zone, new Deed(deedPrice, deedPrice/2), rentArray));
            }
            //else if (zone == "jail")
            else
                this.fields.add(new Street(name, zone, new UpgradeableDeed(deedPrice, deedPrice/2, rentArray)));

        }
    }
}
