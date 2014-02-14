package dk.mercantec.hot.java.vitreher.matador.models;

import dk.mercantec.hot.java.vitreher.matador.dataStructures.BankAccount;
import dk.mercantec.hot.java.vitreher.matador.dataStructures.IDeed;

import java.util.Observable;

/**
 * Created by BoFjord on 13-02-14.
 */
public class TransactionModel extends Observable {

    private final IDeed[] deeds;
    private final BankAccount[] bankAccounts;

    /**
     *
     */
    public TransactionModel(IDeed[] deeds, BankAccount[] bankAccounts) {
        this.deeds = deeds;
        this.bankAccounts = bankAccounts;
    }

    /**
     *
     * @param fieldName
     * @param buyer
     */
    public void buyDeed(String fieldName, int buyer) {
        IDeed deed = getDeedFromName(fieldName);

        if (deed.getDeed().getOwner() == buyer)
            throw new UnsupportedOperationException("Player cannot buy a deed they already own");
        if (deed.getDeed().getOwner() != 0)
            throw new UnsupportedOperationException("Player cannot buy a deed owned by another player");

        try {
            bankAccounts[buyer].withdraw(deed.getDeed().getDeedPrice());
            deed.getDeed().setOwner(buyer);
            setChanged();
            notifyObservers();
        } catch (UnsupportedOperationException e) {
            clearChanged();
        }
    }

    /**
     *
     * @param name
     * @return
     */
    private IDeed getDeedFromName(String name) {
        for (IDeed deed : this.deeds) {
            if (deed.getName().equals(name))
                return deed;
        }
        return null;
    }

}
