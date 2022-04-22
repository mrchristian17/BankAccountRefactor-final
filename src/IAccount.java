/**
 * Interface is subset of Abstract class.
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public interface IAccount{
	/**
	 * Handles the withdraw transaction.
	 * @param amount A double representing the amount of money being withdrawn.
	 * @return Boolean representing if the transaction was successful.
	 */
    public boolean withdraw(double amount);
    
	/**
	 * Handles the deposit transaction.
	 * @param amount A double representing the amount of money being deposited.
	 * @return Boolean representing if the transaction was successful.
	 */
    public boolean deposit(double amount);
    
    /**
     * Returns the current balance of a specified account.
     * @return A double representing the starting balance of an account.
     */
    public double getBalance();
    
    /**
     * Assigns a new value to the balance of an account.
     * @param balance a double representing the new balance of an account.
     */
    public void setBalance(double balance);
    
    /**
     * Returns an accounts ID.
     * @return A long representing the account ID.
     */
    public long getAccountID();
    
    /**
     * Prints the account type and its ID.
     * @return String describing a customer's specific account type and account number.
     */
    public  String getAccDetails();
    
    /**
     * Prints the account type and its ID.
     * @return A String describing a customer's specific account type, account number, and account balance.
     */
    public String getBalanceDetails();
    
    /**
     * Assigns an account its type, e.g Checking, Savings, or Credit.
     * @param s Will be either "Checking", Savings", or "Credit".
     */
    public void setAccountType(String s);
}
