package tp;

import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 1600;
		
		try {
		InetAddress address = InetAddress.getByName(host);
		Socket connection = new Socket(address,port);
		
		System.out.println("SocketClient initialized");
		
		String sentence;
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer = new DataOutputStream(connection.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER : "+modifiedSentence);
		connection.close();
		}

		catch (IOException f) {
		      System.out.println("IOException: " + f);
		}
		catch (Exception g) {
		      System.out.println("Exception: " + g);
		}
		
	}
}
