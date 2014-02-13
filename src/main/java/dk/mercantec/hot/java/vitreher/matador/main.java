package dk.mercantec.hot.java.vitreher.matador;

import dk.mercantec.hot.java.vitreher.matador.models.FieldModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        System.out.println("FUCK");
        System.out.println(is.toString());
        JSONObject json = new JSONObject(jsonString);
        FieldModel fModel = new FieldModel(json);
 
    }
}      

