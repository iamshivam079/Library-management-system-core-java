package edu.qsp.lms.view;

import java.util.Scanner;

import edu.qsp.lms.controller.LibraryController;
import edu.qsp.lms.model.Book;
import edu.qsp.lms.model.Library;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static LibraryController controller = new LibraryController();
	static Library library = new Library();

	static {
		System.out.println("----welcome  To The library Management System-----");
		System.out.print("Enter name of library: ");
		String libraryName = myInput.nextLine();
		library.setLibraryName(libraryName);
		System.out.print("Enter address of library: ");
		String libraryAddress=myInput.nextLine();
		library.setLibraryAddress(libraryAddress);
		System.out.print("Enter pincode: ");
		int libraryPincode = myInput.nextInt();
		myInput.nextLine();
		library.setLibraryPincode(libraryPincode);
	}

	public static void main(String[] args) {
		do {
			System.out.println("Select operation to perform: ");
			System.out.println(
					"1.Add book\n2.Remove book\n3.Update book\n4.Get book by book name\n5.Get all books\0.Exit");
			System.out.println("Enter digit respective to desired option: ");
			int userChoice = myInput.nextInt();
			myInput.nextLine();

			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("----EXITED----");
				System.exit(0);
				break;
			case 1:
				Book book1 = new Book();
				System.out.println("Enter book name: ");
				book1.setBookName(myInput.nextLine());
				System.out.println("Enter book author");
				book1.setBookAuthor(myInput.nextLine());
				System.out.println("Enter price of book: ");
				book1.setPrice(myInput.nextDouble());
				myInput.nextLine();
				System.out.println("Enter publication: ");
				book1.setPublication(myInput.nextLine());
				//
				controller.addBook(book1);
				break;
				
				//
			case 2:
				System.out.println("Enter the name of the book to be removed: ");
				String bookToBeRemoved = myInput.nextLine();
				boolean verify= controller.removeBookByBookName(bookToBeRemoved);
				if (verify) {
					System.out.println("Book removed from the library");
				} else {
					System.out.println("Book does not present in the library");
				}
				
				//
				break;
			case 3:
				Book book3 = new Book();
				System.out.println("Enter name of book to update: ");
				String bookToUpdate=myInput.nextLine();
				book3.setBookName(bookToUpdate);
				System.out.println("Enter price to update: ");
				double newPrice=myInput.nextDouble();
				book3.setPrice(newPrice);
				//
				boolean verifyUpdate=controller.updateBookPriceByBookName(book3);
				if (verifyUpdate) {
					System.out.println("Price updated");
				} else {
					System.out.println("Mentioned book does not exist in libarary");
				}
				
				
				break;
			case 4:
				System.out.println("Enter name of book: ");
				String bookToGet=myInput.nextLine();
				//
				Book book4=controller.searchBook(bookToGet);
				if (book4!=null) {
					System.out.println("book4");
					
				} else {
					System.out.println("Book not found.");
				}
				break;
			case 5:
				System.out.println(controller.getAllBooks());
				break;

			default:
				System.out.println("----INVALID SELECTION----");
				break;
			}
		} while (true);
	}
}
