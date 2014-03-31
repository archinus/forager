package net.archinus.forager.server;

import java.util.ArrayList;

public class ServerList {

	private ArrayList<Server> serverList = new ArrayList<Server>();

	public void addServer(int id, String commonname, String hostname,
			String password, String name, String nick, int port,
			boolean identify, String identifypassword) {
		serverList.add(new Server(id, commonname, hostname, password, name,
				nick, port, identify, identifypassword));
	}

	public void removeServer(String commonname) {
		for (Server s : serverList) {
			if (s.getCommonname() == commonname) {
				serverList.remove(s);
			}
		}
	}

	public ArrayList<Server> getServers() {
		return serverList;
	}

}
