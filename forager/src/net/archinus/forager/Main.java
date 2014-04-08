package net.archinus.forager;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import net.archinus.forager.bots.LinkBot;
import net.archinus.forager.io.Config;
import net.archinus.forager.server.Server;
import net.archinus.forager.server.ServerList;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws NickAlreadyInUseException,
			IOException, IrcException, SAXException,
			ParserConfigurationException {

		try {
			ArrayList<String> channels = Config.getChannels("servers.xml");
			for (String channel : channels) {
				System.out.println("Channel " + (channels.indexOf(channel) + 1)
						+ " Loaded: " + channel.toString());
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Load our servers from config
		ServerList serverlist = Config.loadServers();

		ArrayList<LinkBot> linkBots = new ArrayList<LinkBot>();

		for (Server s : serverlist.getServers()) {
			linkBots.add(new LinkBot(s.getName(), true));
			linkBots.get(s.getId()).connect(s.getHostname(), s.getPort(),
					s.getPassword());

			// Load channels for server s
			s.setChannels(Config.getChannels("servers.xml"));

			// Stuff the bot executes on every channel it joins
			for (String channel : s.getChannels()) {
				linkBots.get(s.getId()).joinChannel(channel.toString());
				linkBots.get(s.getId()).changeNick(s.getNick());
				if (s.isIdentify() == true) {
					linkBots.get(s.getId()).identify(s.getIdentifypassword());
				}
				// linkBots.get(s.getId()).sendMessage(channel,
				// "I am bot " + s.getId());
			}
		}

	}

}
