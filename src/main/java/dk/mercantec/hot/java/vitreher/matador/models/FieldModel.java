package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.*;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by BFJ on 12-02-14.
 */
public class FieldModel extends Observable {

    private final ArrayList<Field> fields;
    private final ArrayList<ILease> leaseable;
    private final ArrayList<IReward> rewardable;
    private final ArrayList<IDeed> deeds;

    /**
     *
     */
    public FieldModel() {
        this.fields = new ArrayList<Field>();
        this.leaseable = new ArrayList<ILease>();
        this.rewardable = new ArrayList<IReward>();
        this.deeds = new ArrayList<IDeed>();
    }

    public void create(JSONObject jsonObject)
    {
        Field field;
        if (zone == "start")
            field = new Start(name, zone, deedPrice);
        else if (zone == "jail")
            field = new Jail(name, zone);
        else if (zone == "brewery") {
            field = new Brewery(name, zone, new Deed())
        }
    }
}
