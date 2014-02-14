/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.BankAccount;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


/**
 *
 * @author Nicolai
 */
public class PlayerModel extends Observable {

    private final Player[] players;
    private final BankAccount[] bankAccounts;

    public PlayerModel(Player[] players, BankAccount[] bankAccounts)
    {
        this.players = players;
        this.bankAccounts = bankAccounts;
    }

    /**
     *
     */
    /*public PlayerModel() {
        this.players = new ArrayList<Player>();
        this.bankAccounts = new ArrayList<BankAccount>();
    }*/

    /**
     * This will create a Player and a BankAccount
     * @param playerName String
     * @param bankBalance int
     */
    /*public void create(String playerName, int bankBalance)
    {
        Player player = new Player(playerName);
        BankAccount bankAccount = new BankAccount(bankBalance);
        this.players.add(player);
        this.bankAccounts.add(bankAccount);

        setChanged();
        notifyObservers(this.bankAccounts);
    }*/
    
    /**
     * This will make a transaction between 2 players.
     * @param fromPlayer int
     * @param toPlayer int
     * @param amount int
     */
    public void transaction(int fromPlayer, int toPlayer, int amount)
    {
        BankAccount from = this.bankAccounts[fromPlayer];
        BankAccount to = this.bankAccounts[toPlayer];
        try {
            from.withdraw(amount);
            to.deposit(amount);
            setChanged();
        } catch (UnsupportedOperationException e) {
            clearChanged();
        }
        notifyObservers(this.bankAccounts);
    }

    /**
     *
     * @param gameTurn
     * @return
     */
    public int getCurrentPlayer(int gameTurn) {
        return (gameTurn % this.players.length) + 1;
    }
}
