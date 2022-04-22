/**
 * Child class to Account class.
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public  class Savings extends Account {
    /**
     * Will call its parents constructor to create a new Account of type Checking
     * @param accID
     * @param amount
     */
    public Savings(long accID, double amount) {
        super(accID,amount);
        super.setAccountType("Savings");

    }
    
    /**
     * Creates a new Savings account.
     */
    public Savings() {
        super.setAccountType("Savings");
        // TODO Auto-generated constructor stub
    }

    /**
     * Prints the account type and its ID.
     * @return A String describing a customer's specific account type, account number, and account balance.
     */
    public String getAccDetails() {
        String s = "Savings-"+this.getAccountID();
        return s;
    }

    /**
     * Prints the details of the accounts balance, its type and its ID.
     * @returns s String
     */
    public String getBalanceDetails() {
        String s = "Balance for Savings-"+this.getAccountID()+":$"+this.getBalance();
        return s;
    }
}