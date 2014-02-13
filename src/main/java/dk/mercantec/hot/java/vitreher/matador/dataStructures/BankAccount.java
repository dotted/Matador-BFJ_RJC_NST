package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class BankAccount {

    private int balance;

    public BankAccount(int balance)
    {
        this.balance = balance;
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
    
    public void deposit(int amount) {
        this.balance += amount;
    }
    
    public void withdraw(int amount) {
        if (amount > this.balance)
            throw new UnsupportedOperationException(String.format("Tried to withdraw %d from bank account, but only had %d", amount, this.balance));

        this.balance -= amount;
    }
  

}
