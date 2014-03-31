package net.archinus.forager.bots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jibble.pircbot.PircBot;

public class LinkBot extends PircBot {

	private int id;

	public LinkBot(String name, Boolean verbose) {
		this.setVerbose(verbose);
		this.setAutoNickChange(true);
		this.setName(name);

	}

	public static boolean containsLink(String message) {
		String[] words = message.split("\\s+");

		for (String word : words) {
			if (word.toLowerCase().matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
				return true;
			}
		}

		return false;
	}

	public void onMessage(String channel, String sender, String login,
			String hostname, String message) {
		// if (message.equalsIgnoreCase("time")) {
		// String time = new java.util.Date().toString();
		// sendMessage(channel, sender + ": The time is now " + time);
		// }
		if (containsLink(message)) {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("links.txt", true)))) {

				System.err.println("Wrote new link to file");
				out.println(message);
			} catch (IOException e) {
				// exception handling left as an exercise for the reader
			}
		}

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
