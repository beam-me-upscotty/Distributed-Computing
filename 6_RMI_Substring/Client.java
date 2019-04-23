import java.util.*;
import java.rmi.*;

public class Client{
	public static void main(String args[]){
		try{
			String URL = "rmi://localhost/Server";
			ServerIntf serverintf = (ServerIntf)Naming.lookup(URL);
			System.out.println("Enter first string");
			Scanner in = new Scanner(System.in);
			String string1 = in.nextLine();
			System.out.println("Enter second string");
			String string2 = in.nextLine();
			int result  = serverintf.substring(string1, string2);
			if(result == 1){
				System.out.println("String2 is substring of string1");
			}
			else{
				System.out.println("String2 is not a substring of string1");
			}
		}
		catch(Exception e){
				System.out.println(e);
		}
	}
}
