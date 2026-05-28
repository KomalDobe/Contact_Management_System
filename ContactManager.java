package cont;

import java.io.*;
import java.util.*;

public class ContactManager {

    private final String FILE_NAME = "contacts.txt";

    // Add Contact
    public void addContact(Contact contact) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME, true))) {

            bw.write(contact.toString());
            bw.newLine();

            System.out.println("Contact Added Successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View Contacts
    public void viewContacts() {

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n--- Contact List ---");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(
                        "Name: " + data[0] +
                        " | Phone: " + data[1]);
            }

        } catch (FileNotFoundException e) {

            System.out.println("No contacts found!");

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Contact
    public void updateContact(String name, String newPhone) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(inputFile));

                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(tempFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(name)) {

                    bw.write(name + "," + newPhone);
                    found = true;

                } else {

                    bw.write(line);
                }

                bw.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Contact Updated Successfully!");
        } else {
            System.out.println("Contact Not Found!");
        }
    }

    // Delete Contact
    public void deleteContact(String name) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(inputFile));

                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(tempFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(name)) {

                    found = true;

                } else {

                    bw.write(line);
                    bw.newLine();
                }
            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Contact Deleted Successfully!");
        } else {
            System.out.println("Contact Not Found!");
        }
    }
}