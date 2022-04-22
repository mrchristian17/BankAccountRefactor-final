import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/** Validates the input given by a customer or a bank employee.
 * @author Daniel C Moreno
 * @version 4.0
 * @since April 04, 2021
 */

public class InputManager {

    private static Scanner in = new Scanner(System.in);
    
    /**
     * Default constructor.
     */
    public InputManager() {
    }

    /**
     * Checks to make sure user input matches the user type options.
     * Will continue to prompt user to reenter input until it's accepted.
     * @return User type input.
     *
     */
    public String checkUserTypeInput() {
        String options = "Options: ";
        int endIndexUserTypeList = RunBank.UserType.values().length - 1;
        for (RunBank.UserType type : RunBank.UserType.values()) {
            options += type;
            if (type.ordinal() != endIndexUserTypeList) {
                options += ", ";
            }
        }
        RunBank.UserType userType = null;
        while (true) {
            System.out.println("Which account would you like to use?");
            System.out.println(options);
            try {
                String input = in.nextLine();
                userType = RunBank.UserType.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return userType.name();
    }

    /**
     * Checks to make sure user input matches the transaction type options.
     * Will continue to prompt user to reenter input until it's accepted.
     * @return Transaction type input.
     *
     */
    public String checkTransactionTypeInput() {
        RunBank.TransactionType transactionTypeEnum = null;

        String options = "Options: ";
        options += RunBank.TransactionType.values()[0];
        boolean isFirst = true;
        for (RunBank.TransactionType type : RunBank.TransactionType.values()) {
            if (isFirst) {
                isFirst = false;
                continue;
            }
            options += ", " + type;
        }
        while (true) {
            System.out.println("What transaction type would you like to execute?");
            System.out.println(options);
            try {
                String inputTransaction = in.nextLine();
                transactionTypeEnum = RunBank.TransactionType.valueOf(inputTransaction.toUpperCase());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Input is not a valid transaction type.");
                System.out.println();
                continue;
            }
        }
        return transactionTypeEnum.name();
    }
    
    /**
     * Parses input from the transaction file and verifies if the input is a valid transaction type.
     * @param fileInput A file containing a series of transactions to be performed.
     * @return A boolean representing if the input is a valid type of transaction.
     */
    public boolean checkFileTransactionTypeInput(String fileInput) {
        RunBank.FileTransaction transactionTypeEnum = null;
        try {
            transactionTypeEnum = RunBank.FileTransaction.valueOf(fileInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }


    /**
     * Checks to make sure user input matches the account type options.
     * Will continue to prompt user to reenter input until it's accepted.
     * @return Account type input.
     *
     */
    public String checkAccountTypeInput() {
        String options = "Options: ";
        int endIndexAccountTypeList = RunBank.AccountType.values().length - 1;
        for (RunBank.AccountType type : RunBank.AccountType.values()) {
            options += type;
            if (type.ordinal() != endIndexAccountTypeList) {
                options += ", ";
            }
        }

        RunBank.AccountType accountType = null;
        while (true) {
            System.out.println(options);
            try {
                String input = in.nextLine();
                accountType = RunBank.AccountType.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return accountType.name();
    }

    /**
     * Parse input from the transaction file and verifies if the input is a valid Account type.
     * @param fileInput A file containing a series of transactions.
     * @return A boolean representing if the input is a valid account type.
     */
    public boolean checkAccountTypeInput(String fileInput) {
        RunBank.AccountType accountType = null;
        try {
            accountType = RunBank.AccountType.valueOf(fileInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("This is NOT a valid account type.");
            return false;
        }
        return true;
    }


    /**
     * Checks to make sure user input matches the yes or no type options.
     * Will continue to prompt user to reenter input until it's accepted.
     * @return User's Yes or No input.
     * @param text_input user input
     */
    //Checks user input until user selects yes or no
    public String check_yes_no(String text_input) {
        RunBank.YesNo yesNo = null;

        while (true) {
            System.out.println(text_input);
            System.out.println("Yes or No?");
            try {
                String input = in.nextLine();
                yesNo = RunBank.YesNo.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return yesNo.name();
    }

    /**
     * Checks to make sure user input matches the A or B type options
     * Will continue to prompt user to reenter input until it's accepted
     * @return User a or b option.
     */
    //compares enum AB to user input
    public String checkABInput() {
        RunBank.AB option = null;
        while (true) {
            System.out.println("A,B, or C?");
            try {
                String input = in.nextLine();
                option = RunBank.AB.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return option.name();
    }


    /**
     * Checks to make sure user input is an acceptable numerical value.
     * Will continue to prompt user to reenter input until it's accepted.
     * Does not accept negative values.
     * @return User money input.
     * @param transType user input for transaction type
     */
    public double checkMoneyInput(String transType) {
        String message = "How much money would you like to " + transType + "?";
        double inputAmount = 0;
        while (true) {
            try {
                System.out.println(message);
                inputAmount = Double.parseDouble(in.nextLine());
                if (inputAmount < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: not a valid amount.");
            }
        }
        return inputAmount;
    }
    
    /**
     * Checks to make sure user input is in an acceptable format for a date.
     * @return String in the correct date format.
     * @throws ParseException if user input does not match the format required to represent their DOB.
     */
    public String checkDateOfBirthInput() throws ParseException {
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        String inputDobPattern = "MM/dd/yy";
        SimpleDateFormat inDateFormat = new SimpleDateFormat("MM/dd/yy");

        String outputDobPattern = "MMMMM dd, yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outputDobPattern);

        while(true) {
            System.out.println("What is your Date of Birth?");
            System.out.println(inputDobPattern);
            String dobString = in.nextLine();
            if(dobString.matches(regex)) {
                Date date = simpleDateFormat.parse(dobString);
                return inDateFormat.format(date);
            }
            System.out.println("Invalid Date of Birth. Please try again..");
        }
    }

    /**
     * Checks to make sure user input is in an acceptable format for a phone number.
     * @return String with the phone number in the correct format.
     */
    public String checkPhoneNumberInput() {
        String phoneNumber = "";
        while(true) {
            System.out.println("Phone Number?");
            System.out.println("3-digit area code: ");
            String area = in.nextLine();
            System.out.println("7 digit phone number: ");
            String number = in.nextLine();
            if (area == null || number == null) {
                System.out.println("Not a valid phone number...");
                continue;
            }
            try {
                int intArea = Integer.parseInt(area);
                int intNumber = Integer.parseInt(number);
                String combinedNumber = area+number;
                if(combinedNumber.length() != 10)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Not a valid phone number...");
                continue;
            }
            phoneNumber = "(" + area + ") " + number.substring(0,3) + "-" + number.substring(3,7);
            break;
        }
        return phoneNumber;
    }

    /**
     * Checks to make sure user input is in an acceptable format for an email address.
     * @return String with the email address in the correct format.
     */
    public String checkEmailAddressInput() {
        //regex that looks for @ and ensures that there is a decimal extension at the end
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        while (true) {
            System.out.println("What is your email?");
            String email = in.nextLine();
            if (email.matches(regex))
                return email;
            System.out.println("Invalid email. Please try again");
        }
    }
    
    /**
     * Checks to  make sure the user entered the correct password.
     * @param correctPassword the password that the users input should match with.
     */
    public void checkPassword(String correctPassword)  {
        while (true) {
            try {
                System.out.println("Please enter your password; ");
                String inPassword = in.nextLine();
                if(!inPassword.equals(correctPassword))
                    throw new IncorrectPasswordException(inPassword);
                break;
            } catch (IncorrectPasswordException e) {
                System.out.println(e);
                System.out.println("Please try again: ");
            }
        }
    }
}

