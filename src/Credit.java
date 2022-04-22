/**
 * Child class to Account.
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public class Credit extends Account{

    private double limit;

    /**
     * Will call the parents constructor to create an Account of type Savings.
     * @param accID users account number
     * @param amount initial amount
     */
    public Credit(long accID, double amount) {
        super(accID,amount);
        super.setAccountType("Credit");
    }
    
    /**
     * Creates a new Credit Account without referencing its parent class.
     */
    public Credit() {
    }
    
    /**
     * Creates a new Credit Account using an account ID, an a mount to be deposited and a balance limit on the credit account.
     * @param accID the Credit account's ID.
     * @param amount the amount being deposited in to the Credit account.
     * @param limit the balance limit for this account.
     */
    public Credit(long accID, double amount, double limit) {
        super(accID, amount);
        super.setAccountType("Credit");
        this.limit = limit;
    }
    /**
     * Prints the account type and its ID.
     * @return String with the account type, and account number.
     */
    public String getAccDetails() {
        String s = "Credit-"+this.getAccountID();
        return s;
    }

    /**
     * Prints the account type and its ID.
     * @return A String describing a customer's specific account type, account number, and account balance.
     */
    public String getBalanceDetails() {
        String s = "Balance for Credit-"+this.getAccountID()+":$"+this.getBalance();
        return s;
    }

    /**
     * Returns the max limit on the Credit Account.
     * @return limit
     */
    public double getLimit() {
        return this.limit;
    }
    /**
     * Sets the maximum spending limit on a Credit account.
     * @param limit The maximum amount of money that a credit account holds.
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }

}

