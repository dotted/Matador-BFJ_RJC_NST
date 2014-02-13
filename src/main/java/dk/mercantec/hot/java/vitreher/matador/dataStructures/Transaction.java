package dk.mercantec.hot.java.vitreher.matador.dataStructures;

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
     * @param amount
     */

    public Transaction(BankAccount sender, BankAccount recipient, int amount)
    {
        if (amount < 0)
            throw new UnsupportedOperationException();
        this.sender = sender;
        this.recipient = recipient;
        this.Amount = amount;
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
