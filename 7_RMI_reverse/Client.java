import java.net.*;
import java.io.*;
import java.rmi.*;
import java.util.*;

public class Client{
	public static void main(String args[]){
		try{
			String URL = "rmi://localhost/Server";
			ServerIntf serverintf = (ServerIntf)Naming.lookup(URL);
			Scanner s = new Scanner(System.in);
			String string = s.nextLine();
			System.out.println(serverintf.Stringreverse(string));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
