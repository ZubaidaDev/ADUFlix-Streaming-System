/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

public class Documentary extends Media {
	private String mainTheme;

	public Documentary(String title, String genre, int rate, int duration, String mainTheme) {
		super(title, genre, rate, duration); // calls Media constructor
		this.mainTheme = mainTheme;
	}

	public Documentary(String title, String genre) {
		super(title, genre); // calls Media(title, genre)
		this.mainTheme = "General";
	}

	public String getMainTheme() {
		return mainTheme;
	}

	public void setMainTheme(String mainTheme) {
		this.mainTheme = mainTheme;
	}

	// Uses the toString method to print the details of the documentary
	@Override
	public void getDetails() {
		System.out.println("Documentary Details:");
		System.out.println(toString()); // uses overridden toString() from below
	}

	// overrides toString method and uses super to invoke the toString method in
	@Override
	public String toString() {
		return "Documentary - " + super.toString() + ", Main Theme: " + mainTheme; // calls parent's toString()
	}

	// overridden equals() that compares 2 documentary objects to see if they are equal
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documentary) {
			Documentary temp = (Documentary) obj;
			return super.equals(temp) && this.mainTheme.equals(temp.mainTheme);
		}
		return false;
	}
}
