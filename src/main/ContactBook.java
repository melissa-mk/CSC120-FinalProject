package main;

import utils.InputValidator;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {
    Contact current;
    InputValidator iv=new InputValidator();
    ArrayList<Contact> contacts=new ArrayList<>();

    /**
     * takes user input for a new Contact object
     * and stores it in contacts.txt file
     */
    public void createContact() {
        Scanner s= new Scanner(System.in);
        System.out.print("Please enter the first name of the contact: ");
        String firstName= s.nextLine();
        System.out.print("Please enter the last name of the contact: ");
        String lastName= s.nextLine();
        System.out.print("Please enter the phone number of the contact (Include country code, Numbers only) ");
        String phone= s.nextLine();
        System.out.print("Please enter the email of the contact: ");
        String email= s.nextLine();
        System.out.print("Please enter the year of birth of the contact: ");
        int year=s.nextInt();
        System.out.print("Please enter the month of birth of the contact (1-12): ");
        int month=s.nextInt();
        System.out.print("Please enter the day of birth of the contact: ");
        int day=s.nextInt();
        if(iv.isDateValid(LocalDate.of(year,month,day))&&iv.isPhoneValid(phone)&& iv.isEmailValid(email)&&iv.isNameValid(firstName)&&iv.isNameValid(lastName)){
            current=new Contact(firstName,lastName,phone,email,LocalDate.of(year,month,day));
            try (FileWriter writer = new FileWriter("contacts.txt")) {
                writer.append(current.toString());
                System.out.println("Contact created ✅");
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }else{
            System.out.println("Uh-oh! Some wrong input!");
        }
        contacts.add(current);
    }

    /**
     * traverses the contact book (contacts.txt)
     * looking for a contact with a search parameter input by the user
     */
    public void search(){
        Scanner s= new Scanner(System.in);

        System.out.println("Who are you looking for?");
        String searchParam = s.nextLine();

        System.out.println("Searching for " + searchParam);

        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String line=reader.readLine();
            boolean found = false;

            while (line!= null) {
                if (line.contains(searchParam)) {
                    found = true;
                    System.out.println("\t" + line);
                }
                line=reader.readLine();
            }
            if (!found) {
                System.out.println("Who even is " + searchParam + "? We couldn't find 'em.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * prints the information of all contacts, if any
     */
    public void viewAll(){
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("You're lonely bro 👀");
            } else {
                while (line != null) {
                    System.out.println(line); // current line
                    line = reader.readLine(); // next line
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * goes to the next contact in the contact book
     * @param c
     * @return
     */
    public static Contact nextContact(Contact c) {
        return c;
    }

    /**
     * goes to the previous contact in the contact book
     * @param c
     * @return
     */
    public static Contact previousContact(Contact c) {
        return c;
    }

    /**
     * @return the number of contacts in the contact book
     */
    public static int countContacts() {
        int count=0;
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String line=reader.readLine();

            while (line!= null) {
                count++;
                line=reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return count;
    }

    /**
     * takes user input of first and last name to determine which contact to update.
     * Then takes and sets user input of new values in the contacts.txt file.
     */
    public void updateContact() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the first name of the contact you want to edit: ");
        String firstName = s.nextLine();

        System.out.println("Please enter the last name of the contact you want to edit: ");
        String lastName = s.nextLine();

        try {
            // Read all contacts from the file into an arraylist
            ArrayList<Contact> contactList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length >= 5) { // Ensure the line has all required fields
                        String fName = parts[0];
                        String lName = parts[1];
                        String phone = parts[2];
                        String email = parts[3];
                        String[] dateParts = parts[4].split("-");
                        LocalDate dob = LocalDate.of(
                                Integer.parseInt(dateParts[0]),
                                Integer.parseInt(dateParts[1]),
                                Integer.parseInt(dateParts[2])
                        );
                        contactList.add(new Contact(fName, lName, phone, email, dob));
                    }
                }
            }

            // Search for the contact to edit
            boolean found = false;
            for (Contact contact : contactList) {
                if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                    found = true;

                    System.out.println("Contact found: " + contact);
                    System.out.println("Enter new details (press Enter to keep current values):");

                    System.out.print("New first name: ");
                    String newFirstName = s.nextLine();
                    if (!newFirstName.isEmpty()) {
                        contact.setFirstName(newFirstName);
                    }

                    System.out.print("New last name: ");
                    String newLastName = s.nextLine();
                    if (!newLastName.isEmpty()) {
                        contact.setLastName(newLastName);
                    }

                    System.out.print("New phone number (numbers only, with country code): ");
                    String newPhone = s.nextLine();
                    if (!newPhone.isEmpty() && iv.isPhoneValid(newPhone)) {
                        contact.setPhone(newPhone);
                    }

                    System.out.print("New email: ");
                    String newEmail = s.nextLine();
                    if (!newEmail.isEmpty() && iv.isEmailValid(newEmail)) {
                        contact.setEmail(newEmail);
                    }

                    System.out.print("New year of birth: ");
                    String newYear = s.nextLine();
                    System.out.print("New month of birth: ");
                    String newMonth = s.nextLine();
                    System.out.print("New day of birth: ");
                    String newDate = s.nextLine();

                    if (!newYear.isEmpty() && !newMonth.isEmpty() && !newDate.isEmpty()) {
                        LocalDate newDob = LocalDate.of(Integer.parseInt(newYear), Integer.parseInt(newMonth), Integer.parseInt(newDate));
                        if (iv.isDateValid(newDob)) {
                            contact.setDateOfBirth(newDob);
                        } else {
                            System.out.println("Invalid date of birth. Keeping the current value.");
                        }
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Contact not found.");
            } else {
                // write the updated arraylist into the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt"))) {
                    for (Contact c : contactList) {
                        writer.write(c.toString());
                        writer.newLine();
                    }
                    System.out.println("Contact updated successfully ✅");
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format. Please try again.");
        }
    }

    /**
     * takes user input of first name and last name
     * to determine which contact to delete.
     * then deletes that contact from the contacts.txt file.
     */
    public void deleteContact() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the first name of the contact you want to delete: ");
        String firstName = s.nextLine();

        System.out.println("Please enter the last name of the contact you want to delete: ");
        String lastName = s.nextLine();

        File file = new File("contacts.txt");
        ArrayList<String> updatedContacts = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 5) {
                    String fName = parts[0];
                    String lName = parts[1];

                    // Check if this is the contact to delete
                    if (fName.equalsIgnoreCase(firstName) && lName.equalsIgnoreCase(lastName)) {
                        found = true; // Skip this contact
                        continue;
                    }
                }
                updatedContacts.add(line); // Add all other lines
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Contact not found.");
            return;
        }

        // Write the updated arraylist back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String contact : updatedContacts) {
                writer.write(contact);
                writer.newLine();
            }
            System.out.println("Contact deleted successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * clears the contacts.txt file and
     * loses all previous contact information
     */
    public void clear(){
        System.out.println("Are you sure you want to delete all contacts? Y/N");
        Scanner s= new Scanner(System.in);
        String choice= s.nextLine();
        if(choice.equalsIgnoreCase("y")){
                try (FileOutputStream fos = new FileOutputStream("contacts.txt")) { // reinitializes and clears the file
                System.out.println("Fresh start!");
            } catch (IOException e) {
                    throw new RuntimeException(e);}
        }else{
            System.out.println("Glad you changed your mind.");
        }
    }

    /**
     * developer's entrypoint to test validator class
     * @param args array of string arguments
     */
    public static void main(String[] args){
        ContactBook my=new ContactBook();
        Scanner s= new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n------Contacts App------\nWhat do you want to do?\n1. Create a contact\n2. View all your contacts\n3. View a specific contact\n4. Edit a contact\n5. Delete a contact\n6. Delete all contacts\n7. Exit");
            choice=s.nextInt();
            if(choice!= Integer.parseInt(String.valueOf(choice))){
                System.out.println("Invalid choice. Please try again.\n");
            }else {
                switch (choice) {
                    case 1:
                        my.createContact();
                        break;
                    case 2:
                        System.out.println("You have " +countContacts()+" contacts.");
                        my.viewAll();
                        Contact c=new Contact("Melissa", "Kabalisa", "14134727947","mkabalisa@smith.edu");
                        Contact o=new Contact("Melissa", "Keza", "250784249865","mkeza@smith.edu");
                        System.out.println(c.compareTo(o));
                        break;
                    case 3:
                        my.search();
                        break;
                    case 4:
                        my.updateContact();
                        break;
                    case 5:
                        my.deleteContact();
                        break;
                    case 6:
                        my.clear();
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        return;
                }
            }
        }while(choice!=7);
    }
}