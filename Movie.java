/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

public class Movie extends Media {
	private String mainActor;


	public Movie(String title, String genre, int rate, int duration, String mainActor) {
		super(title, genre, rate, duration); // calls Media constructor
		this.mainActor = mainActor;
	}

	public Movie(String title, String genre) {
		super(title, genre); // calls Media(title, genre)
		this.mainActor = "Unknown";
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	@Override
	public void getDetails() {
		System.out.println("Movie Details:");
		System.out.println(toString()); 
	}

	@Override
	public String toString() {
		return "Movie - " + super.toString() + ", Main Actor: " + mainActor;
	}

	// overridden equals method from the object class this method compares 2 Movies
	// objects to see if they are equal based on all the variables
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Movie) {
			Movie temp = (Movie) obj;
			return super.equals(temp) && this.mainActor.equals(temp.mainActor);
		}
		return false;
	}
}
