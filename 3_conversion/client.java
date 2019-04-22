import java.net.*;
import java.io.*;
import java.util.*;


public class client { 

    public static void main (String args[]) { 
		Socket socket = null; 

		try{ 
		    socket = new Socket("127.0.0.1", 7896);
		    DataInputStream in = new DataInputStream( socket.getInputStream());
		    DataOutputStream out = new DataOutputStream( socket.getOutputStream());

		    //Get message from user
		    System.out.println("Enter message:");
		    Scanner scanner = new Scanner(System.in);
		    String message = scanner.next();

		    //send message
		    out.writeUTF(message);

		    //get response
		    String data = in.readUTF();
		    System.out.println("Received: "+ data);
		} catch (Exception e){
		    System.out.println("Exception: "+e.getMessage());
		}
	}
}