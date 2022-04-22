/**
 * An Absract class that will represent the basic functionalities of a bank Account.
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public abstract class Account implements IAccount{
    private double startingBalance;
    private double balance;
    private long accountID;
    private String accountType;
    
    /**
     * Creates an Account without initializing any values.
     */
    public Account() {}

    /**
     * Creates an Account given an account ID and a starting balance for the account.
     * @param accID an identification unique to an account.
     * @param amount the amount of money that is being assigned to this account.
     */
    public Account(long accID, double amount) {
        this.startingBalance = amount;
        this.balance = amount;
        this.accountID = accID;
    }

    //refactor
    /**
     * Adds money into corresponding bank account.
     * @param depositAmount the amount of money that is being deposited.
     * @return A boolean representing if a deposit was successful.
     * @author Daniel Moreno
     *
     */
    public boolean deposit(double depositAmount) {
        boolean depositSuccessful = true;
        double currBalance = getBalance();
        if(depositAmount <= 0) {
            return false;
        }
        double updatedBalance = currBalance + depositAmount;
        setBalance(updatedBalance);
        return depositSuccessful;

    }

    /**
     *
     * Takes out money from bank account cannot take out more money than the current account balance.
     * @param withdrawAmount the amount of money that is being withdrawn.
     * @return A boolean representing if a withdraw was successful.
     * @author Daniel Moreno
     *
     */
    public boolean withdraw(double withdrawAmount) {
        boolean withdrawSuccessful = true;
        double currBalance = getBalance();
        if (currBalance < withdrawAmount) {
            return false;
        }
        double updatedBalance = currBalance - withdrawAmount;
        setBalance(updatedBalance);
        return withdrawSuccessful;
    }

    /**
     * Returns the amount that an account was initialized at.
     * @return The starting balance of an account.
     */
    public double getStartingBalance() {
        return this.startingBalance;
    }

    /**
     * Prints the account type and its ID.
     * @return A String describing a customer's specific account type, account number, and account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance to equal the given amount for the account.
     * @param balance the new balance for the account.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the accounts ID
     * @return An accounts ID.
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the accounts ID
     * @param accountID the unique identification number for the account.
     */
    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    /**
     * Returns the current balance on the account
     * @return THe balance of a specified account.
     */
    public double inquire() {
        return this.getBalance();
    }

    /**
     * Prints the account type and its ID.
     * @return A String with the account type, account number.
     */
    public abstract String getAccDetails();

    /**
     * Returns the accounts type, account ID, and balance.
     * @return An accounts account number, the account type, and its current balance.
     */
    public abstract String getBalanceDetails();

    /**
     * Returns the type account that this is classified as.
     * @return The type of account e.g Checking, Savings, Credit.
     */
    public String getType() {
        return this.accountType;
    }
    /**
     * Sets the type of Account that this account will be classifies as, e.g Checking, Savings, Credit.
     * @param s The account type.
     */
    public void setAccountType(String s) {
        this.accountType =s;
    }
}
