import java.net.*;
import java.io.*;


public class server {
    public static void main (String args[]) { 
		try{
		    ServerSocket listenSocket = new ServerSocket(7896); 
		    while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
		    }
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

class Connection extends Thread { 
    DataInputStream in; DataOutputStream out; 
    Socket clientSocket;
    public Connection (Socket aClientSocket) { 
		try {
		    clientSocket = aClientSocket; 
		    in = new DataInputStream(clientSocket.getInputStream()); 
		    out = new DataOutputStream( clientSocket.getOutputStream()); 
		    this.start();
		} catch(Exception e) {
			System.out.println("Connection: "+e.getMessage());
		}
    } 

    public void run(){
		try {
		    
		    String data = in.readUTF();
		    System.out.println("Processing request with id :"+getId());
		    out.writeUTF((0.3048*Float.parseFloat(data))+"");
		    clientSocket.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}