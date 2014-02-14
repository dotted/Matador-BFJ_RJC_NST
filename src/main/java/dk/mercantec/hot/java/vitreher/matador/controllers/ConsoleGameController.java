package dk.mercantec.hot.java.vitreher.matador.controllers;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.Dice;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.IDice;
import dk.mercantec.hot.java.vitreher.matador.models.FieldModel;
import dk.mercantec.hot.java.vitreher.matador.models.PlayerModel;
import dk.mercantec.hot.java.vitreher.matador.models.TransactionModel;
//import dk.mercantec.hot.java.vitreher.matador.views.ConsoleGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by BFJ on 14-02-14.
 */
public class ConsoleGameController implements ActionListener {

    private final FieldModel fieldModel;
    private final PlayerModel playerModel;
    private final TransactionModel transactionModel;
    //private final ConsoleGameView consoleGameView;

    private int gameTurn = 0;

    public ConsoleGameController(FieldModel fieldModel, PlayerModel playerModel, TransactionModel transactionModel) { //ConsoleGameView consoleGameView) {
        this.fieldModel = fieldModel;
        this.playerModel = playerModel;
        this.transactionModel = transactionModel;
        //this.consoleGameView = consoleGameView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     *
     * @param helperText
     * @return
     */
    private String getInput(String helperText) {
        System.out.println(helperText);

        String input;

        Scanner scanIn = new Scanner(System.in);
        input = scanIn.nextLine();

        scanIn.close();
        return input;
    }

    public void start() {
        IDice dice1 = new Dice();
        IDice dice2 = new Dice();

        while (true) {
            int currentPlayer = playerModel.getCurrentPlayer(this.gameTurn);

            dice1.roll();
            dice2.roll();
            fieldModel.movePlayerPiece(currentPlayer, dice1.getEyes() + dice2.getEyes());

            if (getInput(String.format("Buy %s?: [y/N]", fieldModel.getPlayerLocation(currentPlayer))).equals("y"))
                try {
                    transactionModel.buyDeed(fieldModel.getPlayerLocation(currentPlayer), currentPlayer);
                } catch (UnsupportedOperationException e) {

                }


            this.gameTurn++;
        }
    }
}
