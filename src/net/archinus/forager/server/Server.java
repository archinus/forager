package net.archinus.forager.server;

import java.util.ArrayList;

public class Server {

	private String commonname;

	private String hostname;
	private String password;
	private String name;
	private String nick;
	private String identifypassword;

	private int id;
	private int port;
	
	private boolean identify;

	private ArrayList<String> channels = new ArrayList<String>();

	public Server(int id, String commonname, String hostname, String password,
			String name, String nick, int port, boolean identify, String identifypassword) {
		setId(id);
		setCommonname(commonname);
		setHostname(hostname);
		setPassword(password);
		setName(name);
		setNick(nick);
		setPort(port);
	}

	/**
	 * @return the commonname
	 */
	public String getCommonname() {
		return commonname;
	}

	/**
	 * @param commonname
	 *            the commonname to set
	 */
	public void setCommonname(String commonname) {
		this.commonname = commonname;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
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

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the channels
	 */
	public ArrayList<String> getChannels() {
		return channels;
	}

	/**
	 * @param channels
	 *            the channels to set
	 */
	public void setChannels(ArrayList<String> channels) {
		this.channels = channels;
	}

	/**
	 * @return the identifypassword
	 */
	public String getIdentifypassword() {
		return identifypassword;
	}

	/**
	 * @param identifypassword the identifypassword to set
	 */
	public void setIdentifypassword(String identifypassword) {
		this.identifypassword = identifypassword;
	}

	/**
	 * @return the identify
	 */
	public boolean isIdentify() {
		return identify;
	}

	/**
	 * @param identify the identify to set
	 */
	public void setIdentify(boolean identify) {
		this.identify = identify;
	}

}
