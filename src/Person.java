/**
 * Interface is subset of Abstract class.
 * @author Elijah Pele
 * @version 3.0
 * @since February 24, 2021
 *
 */

public abstract class Person {
    //Generic attributes to a person
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private long identificationNumber;
    private String address;
    private String phoneNumber;
    //check for @ and .extension (fancy)
    private String email;

    /**
     * default constructor
     */
    public Person() { }

    /**
     * Constructor for data read from CSV file.
     * @param firstName Customer's first name.
     * @param lastName Customer's last name.
     * @param dateOfBirth Customer's date of birth.
     * @param identificationNumber Customer's ID number.
     * @param address Customer's address.
     * @param phoneNumber Customer's phone number.
     * @param email Customer's email address.
     */
    public Person(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                  String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.identificationNumber = identificationNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /**
     * Returns Persons's first name.
     * @return Person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Assigns a value to person's first name.
     * {@link Person#getFirstName()}
     * @param firstName user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns Person's last name.
     * @return Person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Assigns a value to Person's last name.
     * {@link Person#getLastName()}
     * @param lastName user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns Person's first and last name.
     * @return Person's first and last name space separated.
     */
    public String getFullName() { return this.firstName + " " + this.lastName;}

    /**
     * Returns Person's date of birth.
     * @return Person's date of birth as string.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Assigns a value to Person's date of birth.
     * {@link Person#getDateOfBirth()}
     * @param dateOfBirth user's date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns a Person's identification number.
     * @return person's identification number
     */
    public long getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Assigns a value to the Person's identification number.
     * {@link Person#getIdentificationNumber()}
     * @param identificationNumber user's id number
     */
    public void setIdentificationNumber(long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     * Returns a Person's address.
     * @return person's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Assigns a value to Person's address.
     * {@link Person#getAddress()}
     * @param address user's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a  Person's phone number.
     * @return person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Assigns a value to a persons phone number.
     * {@link Person#getPhoneNumber()}
     * @param phoneNumber user's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a persons email address.
     * @return String with email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Assigns a value to Person's email address.
     * {@link Person#getEmail()}
     * @param email user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns Person's last and first name.
     * @return A Persons's last name and first name.
     */
    public String fullName() {
        String s = this.firstName +" " +this.lastName;
        return s;
    }
}
