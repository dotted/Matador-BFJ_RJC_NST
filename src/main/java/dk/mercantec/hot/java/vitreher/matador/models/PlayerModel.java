/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.BankAccount;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.Player;
import java.util.ArrayList;


/**
 *
 * @author Nicolai
 */
public class PlayerModel {
    
    private ArrayList<Player> players;
    private ArrayList<BankAccount> bankAccounts;
    
    /**
     * This will create a Player and a BankAccount
     * @param playerName String
     * @param bankBalance int
     */    
    public void create(String playerName, int bankBalance)
    {
        this.players.add(new Player(playerName));
        this.bankAccounts.add(new BankAccount(bankBalance));
    }
    
    /**
     * This will make a transaction between 2 players.
     * @param fromPlayer int
     * @param toPlayer int
     * @param amount int
     */
    public void transaction(int fromPlayer, int toPlayer, int amount)
    {
        BankAccount from = this.bankAccounts.get(fromPlayer);
        BankAccount to = this.bankAccounts.get(toPlayer);
        from.withdraw(amount);
        to.deposit(amount);
    }
    
    

}

