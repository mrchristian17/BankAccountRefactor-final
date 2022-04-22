import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Writes a Bank Statement outlining a given customers bank information.
 * @author Daniel C Moreno
 * @version 4.0
 * @since April 04, 2021
 * 
 */

public class BankStatement implements Printable {
    private Customer customer;
    private String fileName;
    private double checkingStartingBalance;
    private double savingStartingBalance;
    private double creditStartingBalance;
    private String date;

    /**
     * Default constructor.
     */
    public BankStatement() {}

    /**
     * If no checking/credit account is initialized, then starting balances are set to -1. THe file name is customername.txt.
     * @param customer Customer object
     *
     */
    public BankStatement(Customer customer) {
        this.customer = customer;
        this.fileName = customer.getFullName()+".txt";
        if(customer.getChecking() == null)
            this.checkingStartingBalance = -1;
        else
            this.checkingStartingBalance = customer.getChecking().getBalance();
        this.savingStartingBalance = customer.getSavings().getBalance();
        if(customer.getCredit() == null)
            this.creditStartingBalance = -1;
        else
            this.creditStartingBalance = customer.getCredit().getBalance();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDateTime today = LocalDateTime.now();
        this.date = dtf.format(today);
    }

    /**
     * Creates a new file or overwrites file if it already exists.
     */
    public void createFile() {
        //Creates file
        try {
            File bankStatement = new File(this.fileName);
            if (bankStatement.createNewFile()) {
                System.out.println("File created: " + bankStatement.getName());
            } else {
                System.out.println("Overwriting previous file: " + this.fileName+"\n");
                FileWriter myWriter = new FileWriter(this.fileName, false);
                myWriter.write("");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Writes bank statement with user info, transactions and starting and final balances for all accounts.
     */
    public void writeFile(String bankSummary) {
        //calls create file
        //overwrites if called multiple times
        createFile();
        try {
            FileWriter myWriter = new FileWriter(this.fileName, true);
            myWriter.write(bankSummary);
            myWriter.close();
            System.out.println("Successfully wrote to "+ this.fileName+"\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * @return A String containing all transactions executed from beginning to this point of the session.
     */
    public String getBankStatementSummary() {
        List<String> transactions = this.customer.getTransactions();
        String currStatement = "";
//        currStatement += getCustomerInformation();
        currStatement += printCustomerInfo(this.customer);
        currStatement += "\n";

        currStatement += getStartingAccountInformation();

        for(int i = 0; transactions != null && i < transactions.size(); i++) {
            currStatement += this.date + ":\t" + transactions.get(i) + "\n";
        }
        currStatement += getCurrentAccountInformation();

        return currStatement;
    }

    /**
     * Returns a customers full name, ID number, DOB, address, and phone number.
     * @return Customers general information.
     *
     */
//    public String getCustomerInformation() {
//        String customerInfo = customer.getFullName();
//        customerInfo += "\nID Number: " + this.customer.getIdentificationNumber();
//        customerInfo += "\nDOB: " + this.customer.getDateOfBirth();
//        customerInfo += "\nAddress: " + this.customer.getAddress();
//        customerInfo += "\nPhone Number: " + this.customer.getPhoneNumber();
//        return customerInfo;
//    }

    /**
     * @param customer Customer object
     * @return customer information
     *
     */
    public String printCustomerInfo(Customer customer) {
        String customerInfo = customer.getFullName();
        customerInfo += "\nID Number: " + customer.getIdentificationNumber();
        customerInfo += "\nDOB: " + customer.getDateOfBirth();
        customerInfo += "\nAddress: " + customer.getAddress();
        customerInfo += "\nPhone Number: " + customer.getPhoneNumber();
        return customerInfo;
    }

    /**
     * Returns the starting balance of a customers account.
     * @return Account information and balances from the beginning of the session.
     */
    public String getStartingAccountInformation() {
        String accountInfo = "\nStart of Period Balances:\n";
        if(customer.getChecking() == null) {
            accountInfo += "Checking Account: none";
        }
        else {
            if(checkingStartingBalance == -1)
                accountInfo += customer.getChecking().getAccDetails() + ":\t" + "-";
            else
                accountInfo += customer.getChecking().getAccDetails() + ":\t" + toCurrency(checkingStartingBalance);
        }
        accountInfo += "\n";
        if(customer.getSavings() == null) {
            accountInfo += "Saving Account: none";
        }
        else {
            if(savingStartingBalance == -1)
                accountInfo += customer.getSavings().getAccDetails() + ":\t" + "-";
            else
                accountInfo += customer.getSavings().getAccDetails() + ":\t" + toCurrency(savingStartingBalance);
        }
        accountInfo += "\n";
        if(customer.getCredit() == null) {
            accountInfo += "Credit Account: none";
        }
        else {
            if(creditStartingBalance == -1)
                accountInfo += customer.getCredit().getAccDetails() + ":\t" + "-";
            else
                accountInfo += customer.getCredit().getAccDetails() + ":\t" + toCurrency(creditStartingBalance);
        }
        accountInfo += "\n\n";
        return accountInfo;
    }

    /**
     * Returns the current balance on a customers account.
     * @return Account info and balance at this point of the session.
     */
    public String getCurrentAccountInformation() {
        String accountInfo = "\nEnd of Period Balances:\n";
        if(customer.getChecking() == null) {
            accountInfo += "Checking Account: none";
        }
        else {
            accountInfo += customer.getChecking().getAccDetails() + ":\t" + toCurrency(customer.getChecking().getBalance());
        }
        accountInfo += "\n";
        if(customer.getSavings() == null) {
            accountInfo += "Saving Account: none";
        }
        else {
            accountInfo += customer.getSavings().getAccDetails() + ":\t" + toCurrency(customer.getSavings().getBalance());
        }
        accountInfo += "\n";
        if(customer.getCredit() == null) {
            accountInfo += "Credit Account: none";
        }
        else {
            accountInfo += customer.getCredit().getAccDetails() + ":\t" + toCurrency(customer.getCredit().getBalance());
        }
        accountInfo += "\n\n";
        return accountInfo;
    }

    /**
     * Returns the current date.
     * @return  String representing the current date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Formats a number to match the common way of representing a monetary number.
     * @param amount dollar amount to be converted to dollar currency
     * @return Double in $currency format.
     */
    public String toCurrency(double amount) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String amountString = "$"+numberFormat.format(amount);
        return amountString;
    }

}
