/*
 * ADUFlix - Smart Streaming Management System
 * ---------------------------------------------------------
 * This application simulates a media streaming system using
 * Object-Oriented Programming (OOP) principles and File I/O.
 * Developed for: CSC202 - Programming 2
 * Institution: Abu Dhabi University
 */

import java.util.*;
import java.io.*;

//this implements StartWatching and FinishWatching interfaces and allows tracking of what the user has watched in the media
public class User implements StartedWatching, FinishedWatching {

	// The list of all the media in MediaFileManager class read from the file
	private ArrayList<Media> mediaList = MediaFileManager.readMediaFromFile();

	private ArrayList<Media> watchedHistory;
	private int age;
	private String name;
	private int id;
	private static int countID = 1;

	public User(int age, String name) {
		this.age = age;
		this.name = name;
		this.id = countID;
		countID++;
		this.watchedHistory = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void userInfo() {
		System.out.println(
				"User: " + name + ", Age: " + age + ", ID: " + id + ", Watched: " + watchedHistory.size() + " item(s)");
	}

	public void userInfo(int age) {
		System.out.println("User: " + name + ", Age: " + age);
	}

	@Override
	public void watch(String title) {
		System.out.println("Started watching: " + title);
	}

	public void watch(String title, int userRate) {
		System.out.println("Watched " + title + " with a rate of " + userRate);
	}

	@Override
	public void finishedWatching() {
		System.out.println("Finished watching. Hope you enjoyed it :)");
	}

	public void watchMedia(Scanner input) {

		// Sort media alphabetically by title using the Comparable interface
		Collections.sort(mediaList);
		System.out.println("\nAvailable Media:");

		// displays all the available media that is grouped by their type
		System.out.println();
		for (Media media : mediaList) {
			if (media instanceof Movie) {
				System.out.println(media.toString());
			}
		}

		// check if media type is Series, if true then displays series details
		System.out.println();
		for (Media media : mediaList) {
			if (media instanceof Series) {
				System.out.println(media.toString());
			}
		}

		// check if media type is Documentary, if true then displays documentary details
		System.out.println();
		for (Media media : mediaList) {
			if (media instanceof Documentary) {
				System.out.println(media.toString());
			}
		}

		System.out.print("\nEnter the name of the show you want to watch: ");
		String userTitle = input.nextLine();
		for (Media media : mediaList) {
			if (media.getTitle().equalsIgnoreCase(userTitle)) {
				watchedHistory.add(media); // add it the list watching
				exportWatchHistoryToFile(); // write the user watched media to WatchHistory file

				System.out.print("Rate (1-5) or enter 0 to skip: ");
				int userRate = input.nextInt();
				input.nextLine();
				watch(media.getTitle());

				if (userRate >= 1 && userRate <= 5) {
					watch(media.getTitle(), userRate);
				} else if (userRate == 0) {
					System.out.println("No rating");
				} else {
					System.out.println("Invalid rating.");
				}

				finishedWatching();
				recommendation();
				return;
			}
		}
		System.out.println("Sorry, that media is not available.");
	}

	// Method used to write the user watched history list
	public void exportWatchHistoryToFile() {
		try {
			File file = new File("WatchHistory_" + id + ".txt");
			PrintWriter writer = new PrintWriter(file);

			for (Media media : watchedHistory) {
				writer.println(media.toString());
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while writing the watch history to the file.");
		}
	}

	// method to display the recommendation based on last genre and filtering
	public void recommendation() {
		if (watchedHistory.isEmpty()) {
			System.out.println("No media watched yet, so no recommendation based on your previous media.");
			return;
		}

		String lastWatchedGenre = watchedHistory.get(watchedHistory.size() - 1).getGenre();

		final int MIN_RATING = 2;
		final int MAX_DURATION = 150;

		System.out.println("Recommended for you (based on " + lastWatchedGenre + " (genre), minimum " + MIN_RATING
				+ " rating, maximum 2:30 duration):");

		boolean isRecommended = false;
		for (Media media : mediaList) {
			if (watchedHistory.contains(media)) {
				continue;
			}
			if (media.getGenre().equals(lastWatchedGenre) && media.getRate() >= MIN_RATING
					&& media.getDuration() <= MAX_DURATION) {
				System.out.println(media.toString());
				isRecommended = true;
			}
		}
		if (!isRecommended) {
			System.out.println("Sorry, we couldnt find any recommendation based on the criteria.");

		}
	}

	// method to display what user watched
	public void displayWatchHistory() {
		if (watchedHistory.isEmpty()) {
			System.out.println("No media watched yet.");
			return;
		}

		System.out.println("Watch History of " + name + ":");
		int i = 0;
		for (Media media : watchedHistory) {
			i++;
			System.out.println(i + ". " + media.getTitle());
		}
	}
}
