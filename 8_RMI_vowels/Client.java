import java.rmi.*;
import java.util.*;

public class Client{
	public static void main(String args[]){
		try{
			String URL = "rmi://localhost/Server";
			ServerIntf serverintf = (ServerIntf)Naming.lookup(URL);
			Scanner s = new Scanner(System.in);
			System.out.println("Enter String");
			String string = s.nextLine();
			System.out.println(serverintf.countVowels(string));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
