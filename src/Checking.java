/**
 * Child class to Account.
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public class Checking extends Account {

    /**
     * Will call its parents constructor to create a new Account of type Checking
     * @param accID ID number for this account.
     * @param amount the amount of money in the account after initialization.
     */
    public Checking(long accID, double amount) {
        super(accID,amount);
        super.setAccountType("Checking");
    }
    
    /**
     * Creates a new Checking Account without referencing its parent class.
     */
    public Checking() {
        super.setAccountType("Checking");
    }

    /**
     * Prints the account type and its ID.
     * @return String describing a customer's specific account type and account number.
     */
    public String getAccDetails() {
        String s = "Checking-"+this.getAccountID();
        return s;
    }

    /**
     * Prints the details of the accounts balance, its type and its ID.
     * @return String describing a customer's specific account type, account number, and account balance.
     */
    public String getBalanceDetails() {
        String s = "Balance for Checking-"+this.getAccountID()+":$"+this.getBalance();
        return s;
    }

}
