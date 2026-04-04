/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

import java.util.*;

class Main {

	private static final int MIN_AGE = 12;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ADUFlix – Smart Streaming Meets Smart Living!");

		System.out.print("Enter your name: ");
		String name = input.nextLine();
		System.out.print("Enter your age: ");

		int age = 0;
		while (true) {

			try {
				age = input.nextInt();
				input.nextLine();

				if (age < MIN_AGE) {
					throw new UnderAgeException("Age must be at least 12.");
				}
				break;
			} catch (InputMismatchException e) {
				System.out.print("Enter a valid number for age: ");
				input.nextLine(); 
			}
			catch (UnderAgeException e) {
				System.out.print("Access Denied: " + e.getMessage());
				input.close();
				return;
			}
		}

		// creates a new user object with the provided name and age, and then enters a loop to
		User user1 = new User(age, name);

		while (true) {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1. View Profile");
			System.out.println("2. Watch Media");
			System.out.println("3. View Watch History");
			System.out.println("4. Get Recommendations");
			System.out.println("5. Exit");
			System.out.print("Select an option: ");
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 1:
				user1.userInfo();
				break;
			case 2:
				user1.watchMedia(input);
				break;
			case 3:
				user1.displayWatchHistory();
				break;
			case 4:
				user1.recommendation();
				break;
			case 5:
				System.out.println("Thank you for using ADUFlix!");
				input.close();
				return; 
			default:
				System.out.println("Invalid option.");
			}
		}
	}
}