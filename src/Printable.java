import java.io.FileWriter;
import java.io.IOException;
/** An interface that defines three methods used for printing customer information.
 * @author Daniel C Moreno and Elijah Pele
 * @version 4.0
 * @since April 04, 2021
 */

public interface Printable {
	
	/**
	 * Creates the file for a Customer's bank statement. 
	 */
    public void createFile();
    
    /**
     * Writes bank statement with user info, transactions and starting and final balances for all accounts.
     * @param currTransaction String representing a transaction that a Customer made.
     */
    public void writeFile(String currTransaction);

    /**
     * Prints the specified customers information
     * @param customer  Current customer object.
     */
    public String printCustomerInfo(Customer customer);
}
