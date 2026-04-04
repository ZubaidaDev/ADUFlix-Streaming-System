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

public class MediaFileManager {

	public static ArrayList<Media> readMediaFromFile() {
		ArrayList<Media> mediaList = new ArrayList<>(); // stores Movie, Series, and Documentary as Media type

		try {
			File file = new File("mediaList.txt"); 
			Scanner reader = new Scanner(file); 

			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] parts = line.split(",");
				String type = parts[0];

				if (type.equalsIgnoreCase("MOVIE")) { // Checks if parts[0] is "MOVIE"
					String title = parts[1];
					String genre = parts[2];
					int rate = Integer.parseInt(parts[3]);
					int duration = Integer.parseInt(parts[4]);
					String mainActor = parts[5];
					Movie m = new Movie(title, genre, rate, duration, mainActor);
					mediaList.add(m);
				} else if (type.equalsIgnoreCase("SERIES")) {
					String title = parts[1];
					String genre = parts[2];
					int rate = Integer.parseInt(parts[3]);
					int duration = Integer.parseInt(parts[4]);
					int totalSeason = Integer.parseInt(parts[5]);
					Series s = new Series(title, genre, rate, duration, totalSeason);
					mediaList.add(s);
				} else if (type.equalsIgnoreCase("DOCUMENTARY")) {
					String title = parts[1];
					String genre = parts[2];
					int rate = Integer.parseInt(parts[3]);
					int duration = Integer.parseInt(parts[4]);
					String mainTheme = parts[5];
					Documentary d = new Documentary(title, genre, rate, duration, mainTheme);
					mediaList.add(d);
				}
			}

			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading media file: " + e.getMessage());
		}

		return mediaList;
	}
}
