/** Checks if the password that a customer entered is correct or not.
 * @author Daniel C Moreno
 * @version 4.0
 * @since April 04, 2021
 */
public class IncorrectPasswordException extends Exception{
    String password;
    
    /**
     * Creates a new IncorrectPasswordException. A String containing the Customer's correct password is stored for future reference.
     * @param password a Customer's unique password needed for making transactions.
     */
    public IncorrectPasswordException(String password) {
        this.password = password;
    }
    
    /**
     * Prints the reason that this exception was thrown.
     */
    public String toString() {
        return "Incorrect Password: " + password;
    }
}
