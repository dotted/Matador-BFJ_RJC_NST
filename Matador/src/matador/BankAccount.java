/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

/**
 *
 * @author Nicolai
 */
public class BankAccount {
    
    private int balance;
    private Player owner;
    
    public BankAccount(int balance,Player owner)
    {
        this.balance = balance;
        this.owner = owner;
    }
    
    /**
     * This will return the
     * balance of this BankAccount.
     * @return balance
     */
    public int getBalance()
    {
        return this.balance;
    }
    
    /**
     * This will return the
     * Player object of this account
     * @return bank
     */
    public Player getOwner()
    {
        return this.owner;
    }
    /**
     * This will make a transaction to another BankAccount
     * if there's coverage on the senders BankAccount, else it
     * will make a deposit to recipients BankAccount 
     * @param transaction 
     */
    public void transaction(Transaction transaction)
    {
        if (transaction.getSender() == this)
            if (this.balance >= transaction.getAmount())
                this.balance -= transaction.getAmount();
            else
                throw new UnsupportedOperationException();
        else
            this.balance += transaction.getAmount();
    }
    
}
