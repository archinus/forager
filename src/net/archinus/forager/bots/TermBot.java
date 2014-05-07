package net.archinus.forager.bots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jibble.pircbot.PircBot;

public class TermBot extends PircBot {

	private int id;

	public TermBot(String name, Boolean verbose) {
		this.setVerbose(verbose);
		this.setAutoNickChange(true);
		this.setName(name);

	}

	public void onMessage(String channel, String sender, String login,
			String hostname, String message) {
		String[] words = sift(message);

		for (String word : words) {

			try (PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("words.txt", true)))) {

				System.err.println("Wrote new word to file");
				String time = new java.util.Date().toString();
				out.println(word);
			} catch (IOException e) {
			}
		}
	}

	public String[] sift(String message) {
		String[] words = message.split("\\s+");

		return words;
	}
}
