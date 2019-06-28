package com.bridgeit.objectoriented.addressBook;

import java.util.Scanner;

public class AddressBookController {
	static AddressBook addressBook = new AddressBook();
	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);

	public static void createnewAddressBook() {
		String response = null;
		if (addressBook.getFile() != null) {

			System.out.println("\nAn existing AddressBook is already opened!"
					+ "\n Do you really wish to exit? \n (reply with 'yes' or 'no'): ");
			response = sc.nextLine().toLowerCase();
		}
		if (addressBook.getFile() == null || response.equals("yes")) {
			addressBook.createAddressBook();
		} else if (response.equals("no")) {
			System.out.println("\nThank you! continue with existing file... \n");

		} else {
			System.out.println("\ninvalid response!\n");
		}
	}

	public static void openExistingAddressBook() {
		String response = null;
		if (addressBook.getFile() != null) {
			System.out.println("\nAn existing AddressBook is already opened!"
					+ "\n Do you really wish to exit? \n (**reply with 'yes' or 'no'): ");
			response = sc.nextLine().toLowerCase();
		}
		if (addressBook.getFile() == null || response.equals("yes")) {
			addressBook.openAddressBook();
			System.out.println();
		} else if (response.equals("no")) {
			System.out.println(
					"\nThank you! continue with existing file... \n" + "(**don't forget to save the changes!)\n");
		} else {
			System.out.println("\ninvalid response!\n");
		}
	}

	public static void addPersonInAddressBook() {
		if (addressBook.getFile() != null) {
			System.out.println("Enter the first name:");
			String firstName = sc.nextLine().toUpperCase();
			System.out.println("Enter the last name:");
			String lastName = sc.nextLine().toUpperCase();
			System.out.println("enter the address:");
			String address = sc.nextLine().toUpperCase();
			System.out.println("enter the city:");
			String city = sc.nextLine().toUpperCase();
			System.out.println("Enter the state:");
			String state = sc.nextLine().toUpperCase();
			System.out.println("Enter the zip");
			String zip = sc.nextLine();
			System.out.println("Enter the Phone");
			String phone = sc.nextLine();

			addressBook.addPerson(firstName, lastName, address, city, state, zip, phone);
		} else {
			System.out.println("\nNo Address Book linked! Create new one or open existing..\n");
		}
	}

	public static void updatePersonInAddressBook() {
		if (addressBook.getFile() != null) {
			System.out.println("search person by first name: ");
			String searchName = sc.nextLine().toUpperCase();
			int index = addressBook.searchPersonbyFirstName(searchName);
			if (index >= 0) {
				System.out.println("enter the address:");
				String address = sc.nextLine().toUpperCase();
				System.out.println("enter the city");
				String city = sc.nextLine().toUpperCase();
				System.out.println("enter the State:");
				String state = sc.nextLine().toUpperCase();
				System.out.println("Enter the zip:");
				String zip = sc.nextLine();
				System.out.println("enter the phone:");
				String phone = sc.nextLine();

				addressBook.updatePerson(index, address, city, state, zip, phone);
			} else {
				System.out.println("\nPerson not found!\n");
			}
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void removePersonInAddressBook() {
		if (addressBook.getFile() != null) {
			System.out.println("search person by first name: ");
			String searchName = sc.next().toUpperCase();
			int index = addressBook.searchPersonbyFirstName(searchName);
			if (index >= 0) {
				addressBook.removePerson(index);
			} else {
				System.out.println("\nPerson not Found!\n");
			}
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void sortAddressBookByName() {
		if (addressBook.getFile() != null) {
			addressBook.sortByName();
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void sortAddressBookByZip() {
		if (addressBook.getFile() != null) {
			addressBook.sortByZip();
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void printAddressBook() {
		if (addressBook.getFile() != null) {
			System.out.println(
					"\n===================> " + "File Name: " + addressBook.getFileName() + " <===================\n");
			addressBook.printAll();
			System.out.println("==================x End of this AddressBook x==================\n");
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void saveAddressBook() {
		if (addressBook.getFile() != null) {
			AddressInterface.saveFile(addressBook.getFile());
			System.out.println("\nAddressBook Saved Successfully!\n");
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

	public static void saveAsAnotherAddressBook() {
		if (addressBook.getFile() != null) {
			System.out.println("enter the file name: ");
			String fileName = sc.nextLine();
			System.out.println("enter the file extension: ");
			String fileExt = sc.nextLine();
			if (fileExt.equals(".json") || fileExt.equals(".txt")) {
				AddressInterface.saveFile(FileSystem.createNewFile(fileName, fileExt));
				System.out.println("\nAddressBook Saved to another file successfully!\n");
			}
		} else {
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}

}
