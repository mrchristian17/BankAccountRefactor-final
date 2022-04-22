import java.util.ArrayList;
import java.util.List;
/** Represents a person that is a customer to the bank.
 * @author Daniel C Moreno
 * @version 4.0
 * @since April 04, 2021
 */

public class Customer extends Person{
    private String password;
    private IAccount checking;
    private IAccount savings;
    private IAccount credit;
    private List<String> transactions;
    private BankStatement bankStatement;

    /**
     * Default constructor
     * calls super class AccountAbstract default constructor
     */
    public Customer() {
        super();
    }

    /**
     *  @param firstName user's first name
     * @param lastName user's last name
     * @param dateOfBirth user's date of birth
     * @param identificationNumber user's id number
     * @param address user's address
     * @param phoneNumber user's phone number
     * @param email user's email
     * @param password user's password
     * @param checkingAccountNum user's checking account number
     * @param savingAccountNum user's savings account number
     * @param creditAccountNum user's credit account number
     * @param checkingBalance user's checking balance
     * @param savingBalance user's saving balance
     * @param creditBalance user's credit balance
     * @param creditMax user's max credit balance
     */
    public Customer(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                    String address, String phoneNumber, String email, String password,
                    long checkingAccountNum, long savingAccountNum, long creditAccountNum, double checkingBalance,
                    double savingBalance, double creditBalance, double creditMax) {
        super(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email);
        this.password = password;
        this.checking = new Checking(checkingAccountNum, checkingBalance);
        this.savings = new Savings(savingAccountNum, savingBalance);
        this.credit = new Credit(creditAccountNum, creditBalance, creditMax);
        this.transactions = new ArrayList<String>();
        this.bankStatement = new BankStatement(this);
    }

    /**
     *  @param firstName user's first name
     * @param lastName user's last name
     * @param dateOfBirth user's date of birth
     * @param identificationNumber user's id number
     * @param address user's address
     * @param phoneNumber user's phone number
     * @param email user's email
     * @param password user's password
     * @param savingAccountNum user's savings account number
     * @param savingBalance user's saving balance
     */
    public Customer(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                    String address, String phoneNumber, String email, String password,
                    long savingAccountNum, double savingBalance) {
        super(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email);
        this.password = password;
        this.checking = null;
        this.savings = new Savings(savingAccountNum, savingBalance);
        this.credit = null;
        this.transactions = new ArrayList<String>();
        this.bankStatement = new BankStatement(this);
    }

    /**
     * Provides the name of the account owner, its account number, and the current account balance for all accounts.
     * @return A String containing each accounts information.
     */
    public String printAllInfo() {

        if(checking == null && credit == null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    savings.getBalanceDetails();
        else if (checking==null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    savings.getBalanceDetails() + ", " +
                    credit.getBalanceDetails();
        else if(credit == null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    checking.getBalanceDetails() + ", " +
                    savings.getBalanceDetails();
        else return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    checking.getBalanceDetails() + ", " +
                    savings.getBalanceDetails() + ", " +
                    credit.getBalanceDetails();
    }

    /**
     * Allows a customer to transfer funds from one of their personal accounts to another.
     * @param transferAmount amount to be transferred
     * @param srcAccountString source account type
     * @param destAccountString destination account type
     * @return Boolean representing whether or not the transaction was successful.
     */
    public boolean transfer(double transferAmount, String srcAccountString, String destAccountString) {
        boolean transferSuccessful = true;
        IAccount sourceAccount = findAccount(srcAccountString);
        IAccount destAccount = findAccount(destAccountString);
        if(sourceAccount == destAccount || sourceAccount.getBalance() < transferAmount)
            return false;
        boolean sourceWithdraw = sourceAccount.withdraw(transferAmount);
        boolean destDeposit = destAccount.deposit(transferAmount);
        return sourceWithdraw && destDeposit;
    }

    /**
     * Returns a customers account, e.g Checking, Savings, or Credit.
     * @param account A String that should be equal to either "Checking", "Savings", or "Credit'.
     * @return The specified account.
     */
    public IAccount findAccount(String account) {
        switch(account){
            case "CHECKING":
                return getChecking();
            case "SAVING":
                return getSavings();
            case "CREDIT":
                return getCredit();
            default:
                return null;
        }
    }
    
    /**
     * Logs a customers transaction.
     * @param currTransaction A String describing the trasnaction that was performed.
     */
    public void addTransactions(String currTransaction) {
        transactions.add(currTransaction);
    }
    
    /**
     * Returns all logged transactions that were made by a customer.
     * @return A List of Strings containing transaction history.
     */
    public List<String> getTransactions() {
        return this.transactions;
    }

    /**
     * Returns a Customer's Account of type Credit.
     * @return Customer's credit account.
     */
    public IAccount getCredit() {
        return credit;
    }
    /**
     * {@link Customer#getCredit()}
     */
    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    /**
     * Returns a Customer's Account of type Checking.
     * @return Customer's checking account.
     */
    public IAccount getChecking() {
        return checking;
    }

    /**
     * {@link Customer#getChecking()}
     */
    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    /**
     * Returns a Customer's Account of type Savings.
     * @return Customer's saving account.
     */
    public IAccount getSavings() {
        return savings;
    }

    /**
     * {@link Customer#getSavings()}
     */
    public void setSavings(Savings saving) {
        this.savings = saving;
    }

    /**
     * Returns a Customer's password which is used to perform transactions.
     * @return Customer's unique password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a Customer's password.
     * @param password A String representing a Customer's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Returns a Customer's Bank Statement.
     * @return CUstomer's bank statement.
     */
    public BankStatement getBankStatement() {
        return this.bankStatement;
    }
}
