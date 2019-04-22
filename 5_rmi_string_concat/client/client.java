import java.rmi.*;
import java.util.*;
public class client {
	public static void main(String args[]) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			String url = "rmi://localhost/server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(url);
			System.out.println("Enter String one:");
			String s1 = scanner.nextLine();
			System.out.println("Enter String two:");
			String s2 = scanner.nextLine();
			System.out.println("The sum is: " + serverInterface.concatenate(s1, s2));
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
