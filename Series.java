/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

public class Series extends Media {
	private int totalSeason;

	public Series(String title, String genre, int rate, int duration, int totalSeason) {
		super(title, genre, rate, duration); // calls Media constructor
		this.totalSeason = totalSeason;
	}

	public Series(String title, String genre) {
		super(title, genre); 
		this.totalSeason = 1; // default value
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	@Override
	public void getDetails() {
		System.out.println("Series Details:");
		System.out.println(toString()); 
	}

	@Override
	public String toString() {
		return "Series - " + super.toString() + ", Total Seasons: " + totalSeason; // calls parent's toString()
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Series) {
			Series temp = (Series) obj;
			return super.equals(temp) && this.totalSeason == (temp.totalSeason);
		}
		return false;
	}
}