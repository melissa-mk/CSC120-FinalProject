package main;

import java.time.LocalDate;
import utils.InputValidator;

public class Contact {
    InputValidator iv = new InputValidator();
    private String firstName;
    private String lastName; // most common sort attribute cc Nina
    private String phone;
    private String email;
    private LocalDate dateOfBirth;
    /**
     * Constructor
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param dateOfBirth
     */
    public Contact(String firstName, String lastName, String phone, String email, LocalDate dateOfBirth) {
        if(iv.isNameValid(firstName)){
            this.firstName = firstName;
        }else{
            System.out.println("First name is invalid");
        }
        if(iv.isNameValid(lastName)){
            this.lastName = lastName;
        }else{
            System.out.println("Last name is invalid");
        }
        if(iv.isPhoneValid(phone)) {
            this.phone = phone;
        }else{
            System.out.println("Phone number is invalid");
        }
        if(iv.isEmailValid(email)){
            this.email = email;
        }else{
            System.out.println("Email is invalid");
        }
        if(iv.isDateValid(dateOfBirth)) {
            this.dateOfBirth = dateOfBirth;
        }else{
            System.out.println("Date of birth is invalid");
        }
    }

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    public Contact(String firstName, String lastName, String phone, String email) {
        if(iv.isNameValid(firstName)){
            this.firstName = firstName;
        }else{
            System.out.println("First name is invalid");
        }
        if(iv.isNameValid(lastName)){
            this.lastName = lastName;
        }else{
            System.out.println("Last name is invalid");
        }
        if(iv.isPhoneValid(phone)) {
            this.phone = phone;
        }else{
            System.out.println("Phone number is invalid");
        }
        if(iv.isEmailValid(email)){
            this.email = email;
        }else{
            System.out.println("Email is invalid");
        }
    }

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     */
    public Contact(String firstName, String lastName, String email) {
        if(iv.isNameValid(firstName)){
            this.firstName = firstName;
        }else{
            System.out.println("First name is invalid");
        }
        if(iv.isNameValid(lastName)){
            this.lastName = lastName;
        }else{
            System.out.println("Last name is invalid");
        }
        if(iv.isEmailValid(email)){
            this.email = email;
        }else{
            System.out.println("Email is invalid");
        }
    }

//    /**
//     * constructor
//     * @param firstName
//     * @param lastName
//     * @param phone
//     */
//    public Contact(String firstName, String lastName, String phone) {
//        if(iv.isNameValid(firstName)){
//            this.firstName = firstName;
//        }else{
//            System.out.println("First name is invalid");
//        }
//        if(iv.isNameValid(lastName)){
//            this.lastName = lastName;
//        }else{
//            System.out.println("Last name is invalid");
//        }
//        if(iv.isPhoneValid(phone)) {
//            this.phone = phone;
//        }else{
//            System.out.println("Phone number is invalid");
//        }
//    }

    /**
     * getter
     * @return the contact's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * setter
     * @param dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
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
    public String getPhone() {
        return phone;
    }

    /**
     * setter
     * @param phone
     */
    public void setPhone(String phone) {
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
