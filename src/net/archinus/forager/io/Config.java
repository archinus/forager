package net.archinus.forager.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.archinus.forager.server.Server;
import net.archinus.forager.server.ServerList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Config {

	public static ServerList loadServers() throws SAXException, IOException,
			ParserConfigurationException {

		ServerList serverlist = new ServerList();

		File fXmlFile = new File("servers.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		// optional, but recommended
		// read this -
		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :"
				+ doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("server");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Serverid: " + eElement.getAttribute("id"));
				String idstr = eElement.getAttribute("id");
				int id = Integer.parseInt(idstr);

				System.out.println("Common name: "
						+ eElement.getElementsByTagName("commonname").item(0)
								.getTextContent());
				String commonname = eElement.getElementsByTagName("hostname")
						.item(0).getTextContent();

				System.out.println("Hostname: "
						+ eElement.getElementsByTagName("hostname").item(0)
								.getTextContent());
				String hostname = eElement.getElementsByTagName("hostname")
						.item(0).getTextContent();

				System.out.println("Port: "
						+ eElement.getElementsByTagName("port").item(0)
								.getTextContent());
				String portstr = eElement.getElementsByTagName("port").item(0)
						.getTextContent();
				int port = Integer.parseInt(portstr);

				System.out.println("Password: "
						+ eElement.getElementsByTagName("password").item(0)
								.getTextContent());
				String password = eElement.getElementsByTagName("password")
						.item(0).getTextContent();

				System.out.println("Name: "
						+ eElement.getElementsByTagName("name").item(0)
								.getTextContent());
				String name = eElement.getElementsByTagName("name").item(0)
						.getTextContent();

				System.out.println("Nick: "
						+ eElement.getElementsByTagName("nick").item(0)
								.getTextContent());
				String nick = eElement.getElementsByTagName("nick").item(0)
						.getTextContent();

				System.out.println("Identify: "
						+ eElement.getElementsByTagName("identify").item(0)
								.getTextContent());
				boolean identify = eElement.getElementsByTagName("identify")
						.item(0).getTextContent().equalsIgnoreCase("true");

				System.out.println("Identifypass: "
						+ eElement.getElementsByTagName("identifypassword")
								.item(0).getTextContent());
				String identifypassword = eElement
						.getElementsByTagName("identifypassword").item(0)
						.getTextContent();

				serverlist.addServer(id, commonname, hostname, password, name,
						nick, port, identify, identifypassword);

			}
		}
		return serverlist;
	}

	public static ArrayList<String> getChannels(String config)
			throws SAXException, IOException, ParserConfigurationException {
		ArrayList<String> channelArray = new ArrayList<>();

		File fXmlFile = new File(config);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		System.out.println("----------------------------");

		doc.getDocumentElement().normalize();

		System.out.println("Loading Channels");

		NodeList nList = doc.getElementsByTagName("server");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				System.out.println("Serverid: " + eElement.getAttribute("id"));
				System.out.println("Channels: "
						+ eElement.getElementsByTagName("channels").item(0)
								.getTextContent());
				System.out.println(eElement.getElementsByTagName("channel")
						.getLength() + " channels found");

				for (int i = 0; i < eElement.getElementsByTagName("channel")
						.getLength(); i++) {
					System.out.println(i
							+ ": "
							+ eElement.getElementsByTagName("channel").item(i)
									.getTextContent().toString());

					channelArray.add(eElement.getElementsByTagName("channel")
							.item(i).getTextContent().toString());

					System.out.println("\n");

				}

			}
		}
		return channelArray;
	}

}
