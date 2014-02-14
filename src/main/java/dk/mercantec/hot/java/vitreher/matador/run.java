package dk.mercantec.hot.java.vitreher.matador;

import dk.mercantec.hot.java.vitreher.matador.controllers.ConsoleGameController;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.*;
import dk.mercantec.hot.java.vitreher.matador.models.FieldModel;
import dk.mercantec.hot.java.vitreher.matador.models.PlayerModel;
import dk.mercantec.hot.java.vitreher.matador.models.TransactionModel;
import dk.mercantec.hot.java.vitreher.matador.views.ConsoleGameView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by BFJ on 14-02-14.
 */
public class run {

    /**
     *
     * @param amountOfPlayers
     */
    public run(int amountOfPlayers) {

        Player[] players = new Player[amountOfPlayers + 1]; // bank is player 0
        BankAccount[] bankAccounts = new BankAccount[amountOfPlayers + 1]; // bank is player 0

        players[0] = new Player("bank");
        bankAccounts[0] = new BankAccount(1000000000);
        for(int i = 1; i <= amountOfPlayers; i++)
        {
            System.out.println("Enter name for player: ");

            String playerName;

            Scanner scanIn = new Scanner(System.in);
            playerName = scanIn.nextLine();

            scanIn.close();
            players[i] = new Player(playerName);
            bankAccounts[i] =  new BankAccount(30000);
        }

        InputStream is = run.class.getResourceAsStream("/fields.json");
        String jsonString = convertStreamToString(is);
        JSONObject json = new JSONObject(jsonString);

        JSONArray array = json.getJSONArray("fields");

        Field[] fields = new Field[array.length()];

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
                fields[i] = new Start(name, zone, reward);
            else if ("brewery".equals(zone))
                fields[i] = new Brewery(name, zone, new Deed(deedPrice, deedPrice/2));
            else if ("shipping".equals(zone))
                fields[i] = new Shipping(name, zone, new Deed(deedPrice, deedPrice/2), rentArray);
                //else if (zone == "jail")
            else
                fields[i] = new Street(name, zone, new UpgradeableDeed(deedPrice, deedPrice/2, housePrice), rentArray);
        }

        FieldModel fieldModel = new FieldModel(fields, players.length, "start");
        PlayerModel playerModel = new PlayerModel(players, bankAccounts);
        TransactionModel transactionModel = new TransactionModel((IDeed[])fields, bankAccounts);

        ConsoleGameView consoleGameView = new ConsoleGameView();

        fieldModel.addObserver(consoleGameView);
        playerModel.addObserver(consoleGameView);
        transactionModel.addObserver(consoleGameView);

        ConsoleGameController consoleGameController = new ConsoleGameController(fieldModel, playerModel, transactionModel, consoleGameView);
    }

    private static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
