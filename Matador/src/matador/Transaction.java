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
public class Transaction {
    
    private BankAccount sender;
    private BankAccount recipient;
    private int Amount;
    
    /**
     * This will create an transaction
     * @param sender
     * @param recipient
     * @param Amount 
     */
    
    public Transaction(BankAccount sender, BankAccount recipient, int Amount)
    {
        this.sender = sender;
        this.recipient = recipient;
        this.Amount = Amount;
    }
    
    /**
     * This will return the sender
     * of the transaction.
     * @return sender 
     */    
    public BankAccount getSender()
    {
        return this.sender;
    }
    
    /**
     * This will return the recipient
     * of the transaction.
     * @return recipient
     */
    public BankAccount getRecipient()
    {
        return this.recipient;
    }
    
    /**
     * This will return the
     * amount of the transaction.
     * @return amount 
     */    
    public int getAmount()
    {
        return this.Amount;
    }
}
