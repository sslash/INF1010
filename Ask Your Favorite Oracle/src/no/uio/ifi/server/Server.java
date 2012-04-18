package no.uio.ifi.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	AskOracleController controller;

	public Server (AskOracleController controller) {
		this.controller = controller;
	}

	/** Listens for requests from clients */
	public void waitForRequests() {
		ServerSocket serversocket = null;

		/* Open the connection */
		try {
			System.out.println("Opens a socket connection on " + 1111);
			// make a ServerSocket and bind it to given port,
			serversocket = new ServerSocket(1111);
		} catch (Exception e) {
			return;
		}

		/* Wait for requests */
		while (true) {
			System.out.println("\nReady, Waiting for requests...\n");

			// this call waits/blocks until someone connects to the port we
			// are listening to
			Socket connectionsocket;

			try {
				connectionsocket = serversocket.accept();

				// figure out what ipaddress the client commes from, just for
				// show!
				InetAddress client = connectionsocket.getInetAddress();
				// and print it to terminal
				System.err.println(client.getHostName()
						+ " connected to server.\n");

				/*
				 * Read an object from the socket. The object is a request
				 * object that implements Serializable
				 */
				InputStream is = connectionsocket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				Object o;

				o = ois.readObject();

				/* Handle the request in a seperate thread */
				handleRequest(o);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // go back in loop, wait for next request

	}

	private void handleRequest(Object o) {
		
		if ( o instanceof String ) {
			String s = (String)o;
			Oracle oracle = controller.getOracles(s.split(":")[1]);
			IfiPerson student = new Student (s.split(":")[0], 
					controller.getLowestBasePriority(oracle) - 1, 0);
			controller.addStudentToOracle(student, s.split(":")[1]);
		}
		}

	
}
