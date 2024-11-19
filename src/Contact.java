import java.util.Date;

public class Contact {
    private String firstName;
    private String lastName;
    private int phone;
    private String email;
    private Date dateOfBirth;
    String ran="Contact book (create, read, update, delete contacts. Use regex for input validation; could use sorting and linked lists for “previous” and “next” features)\n" +
            "doubly linked list for previous and next";
    /**
     * Constructor
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param dateOfBirth
     */
    public Contact(String firstName, String lastName, int phone, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    public Contact(String firstName, String lastName, int phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     */
    public Contact(String firstName, String lastName, String email) {}

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param phone
     */
    public Contact(String firstName, String lastName, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    /**
     * getter
     * @return the contact's date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * setter
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * getter
     * @return the contact's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter
     * @return the contact's phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * setter
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * getter
     * @return the contact's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter
     * @return the contact's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Contact deleteContact(Contact c){
        c=null;
        return c;
    }

}
