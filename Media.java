/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

public abstract class Media implements Comparable<Media> {
	private String title;
	private String genre;
	private int rate;
	private int duration;

	public Media(String title, String genre, int rate, int duration) {
		this.title = title;
		this.genre = genre;
		this.rate = rate;
		this.duration = duration;
	}

	public Media(String title, String genre) {
		this(title, genre, 0, 0);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public abstract void getDetails();

	@Override
	public String toString() {
		int hrs = duration / 60;
		int mins = duration % 60;
		return "Title: " + title + ", Genre: " + genre + ", Rating: " + rate + ", Duration: " + hrs + "h " + mins
				+ "min";
	}

	// Overriding compareTo to sort media by title in ascending order
	@Override
	public int compareTo(Media o) {
		return this.title.compareToIgnoreCase(o.title);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media temp = (Media) obj;
			if (this.title.equals(temp.title) && this.genre.equals(temp.genre) && this.rate == temp.rate
					&& this.duration == temp.duration) {
				return true;
			}
		}
		return false;
	}
}
