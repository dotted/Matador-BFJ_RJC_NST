package dk.mercantec.hot.java.vitreher.matador;

import dk.mercantec.hot.java.vitreher.matador.models.FieldModel;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONObject;

/**
 * Created by BoFjord on 13-02-14.
 */
public class main {

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static void main(String[] args) {

        InputStream is = main.class.getResourceAsStream("/fields.json");
        String jsonString = convertStreamToString(is);
        JSONObject json = new JSONObject(jsonString);
        FieldModel fModel = new FieldModel(json,4,"Start");
        fModel.addHouse("Strandvej",4);
        fModel.setOwner("Strandvej", 3);

    }
}

