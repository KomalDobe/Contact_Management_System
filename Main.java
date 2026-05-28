package cont;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContactManager manager = new ContactManager();

        int choice;

        do {

            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Contact contact = new Contact(name, phone);

                    manager.addContact(contact);

                    break;

                case 2:

                    manager.viewContacts();

                    break;

                case 3:

                    System.out.print("Enter Contact Name to Update: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();

                    manager.updateContact(updateName, newPhone);

                    break;

                case 4:

                    System.out.print("Enter Contact Name to Delete: ");
                    String deleteName = sc.nextLine();

                    manager.deleteContact(deleteName);

                    break;

                case 5:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}