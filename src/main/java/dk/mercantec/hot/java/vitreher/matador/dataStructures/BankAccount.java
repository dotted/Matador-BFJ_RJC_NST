package dk.mercantec.hot.java.vitreher.matador.dataStructures;

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
