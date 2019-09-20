package tp;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class SimpleServer {
	static ServerSocket socket1;
	protected final static int port = 1600;
	static Socket connection;
	
	static boolean first;
	static StringBuffer process;
	static String TimeStamp;
	
	public static void main(String[] args) {
		
		String clientSentence;
//		String capitalizedSentence;
		String toReturn;
		
		try {
		ServerSocket welcomeSocket = new ServerSocket(port);
		
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine().toUpperCase();
			
			if (clientSentence.equals("MOON?")) {
				toReturn = "I DON'T KNOW" + '\n';
			}
			else if (clientSentence.equals("DATE?")) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

				toReturn = "ACTUAL DATE IS " + simpleDateFormat.format(new Date()) + '\n';
				
			}
			else if (clientSentence.equals(("HOUR?"))) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
				
				toReturn = "ACTUAL HOUR IS " + simpleDateFormat.format(new Date()) + '\n';
			}
			else {
				toReturn = "INVALID REQUEST" + '\n';
			}
			System.out.println(toReturn);
			//capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(toReturn);
			
			}
		}
		catch (IOException f) {
		      System.out.println("IOException: " + f);
		}
		catch (Exception g) {
		      System.out.println("Exception: " + g);
		}
		
	}
}
