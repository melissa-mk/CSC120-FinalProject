package utils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class InputValidator {
    /**
     * verifies that the name is between 1 and 50 characters
     * @param name
     * @return true if the name is a valid string, false otherwise
     */
    public boolean isNameValid(String name){
        return name.length() > 1 && name.length() < 50;
    }

    /**
     *
     * @param date
     * @return true if the date is valid (past but not too far in the past), false otherwise
     */
     public boolean isDateValid(LocalDate date) {
            // Define the valid range
            LocalDate earliest = LocalDate.of(1930, 1, 1); // "Too far in the past" threshold
            LocalDate latest = LocalDate.now();           // Current date

            // Check if the date is within the valid range
            return !date.isBefore(earliest) && !date.isAfter(latest);
     }

    /**
     * uses regular expressions to validate character in email address
     * @param email
     * @return true if the email is valid, false otherwise
     */
    public boolean isEmailValid(String email){
        Pattern p=Pattern.compile("^[\\w.+-]+@[\\w.]+.[a-zA-Z]{2,}$");
        return p.matcher(email).matches();
    }

    /**
     * verifies if the input string for phone is made of only numbers
     * @param phone
     * @return true if input string has only digits, false otherwise
     */
    public boolean isDigitsOnly(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false; // Return false for any null or empty string
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false; // Return false if a non-digit character is found
            }
        }
        return true;
    }

    /**
     * verifies if the input string is made of only 10-15 numbers
     * @param phone
     * @return true if the phone number is valid in terms of length, false otherwise
     */
    // a standard phone number will be 10-15 digits long
    public boolean isPhoneValid(String phone){
        if(isDigitsOnly(phone)) {
            return phone.length() >= 10 && phone.length() <= 15;
        }else{
            return false;
        }
    }
}
