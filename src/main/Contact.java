package main;

import java.time.LocalDate;

import utils.InputValidator;

public class Contact implements Comparable<Contact> {
    InputValidator iv = new InputValidator();
    String firstName;
    String lastName; // most common sort attribute cc Nina
    String phone;
    String email;
    LocalDate dateOfBirth;

    /**
     * Constructor
     * @param firstName contact's first name
     * @param lastName contact's last name
     * @param phone contact's phone number with no special characters
     * @param email contact's email address
     * @param dateOfBirth contact's date of birth
     */
    public Contact(String firstName, String lastName, String phone, String email, LocalDate dateOfBirth) {
        if(iv.isNameValid(firstName)){
            this.firstName = firstName;
        }else{
            System.out.println("Invalid first name");
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
     * Constructor
     * @param firstName contact's first name
     * @param lastName contact's last name
     * @param phone contact's phone number with no special characters
     * @param email contact's email address
     */
    public Contact(String firstName, String lastName, String phone, String email) {
        if(iv.isNameValid(firstName)){
            this.firstName = firstName;
        }else{
            System.out.println("First name is invalid");
            return;
        }
        if(iv.isNameValid(lastName)){
            this.lastName = lastName;
        }else{
            System.out.println("Last name is invalid");
            return;
        }
        if(iv.isPhoneValid(phone)) {
            this.phone = phone;
        }else{
            System.out.println("Phone number is invalid");
            return;
        }
        if(iv.isEmailValid(email)){
            this.email = email;
        }else{
            System.out.println("Email is invalid");
        }
    }

    /**
     * Constructor
     * @param firstName contact's first name
     * @param lastName contact's last name
     * @param email contact's email address
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

    /**
     * getter
     * @return the contact's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * setter
     * @param dateOfBirth contact's date of birth
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
     * @param email contact's email address
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
     * @param phone contact's phone number
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
     * @param lastName contact's last name
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
     * @param firstName contact's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a string representation of the contact.
     * @return a string of all attributes of the contact
     */
    @Override
    public String toString() {
       return firstName+" "+lastName+" "+phone+" "+email+" "+dateOfBirth;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Contact o) {
        if(!this.lastName.equalsIgnoreCase(o.lastName)) {
            return this.lastName.compareToIgnoreCase(o.lastName);
        }else {
            return this.firstName.compareToIgnoreCase(o.firstName);
        }
    }
}