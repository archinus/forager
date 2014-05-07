package net.archinus.forager.bots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jibble.pircbot.PircBot;

public class PopularityBot extends PircBot {

	private int id;

	public PopularityBot(String name, Boolean verbose) {
		this.setVerbose(verbose);
		this.setAutoNickChange(true);
		this.setName(name);

	}

	@Override
	protected void onJoin(String channel, String sender, String login,
			String hostname) {
		// TODO Auto-generated method stub
		super.onJoin(channel, sender, login, hostname);

		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter("joins.txt", true)))) {

			System.err.println("Wrote new join to file");
			String time = new java.util.Date().toString();
			out.println("[" + time + "] " + hostname + " " + channel);
		} catch (IOException e) {
		}

	}

}
