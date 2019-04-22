import java.net.*;
import java.rmi.*;
public class Server{
	public static void main(String[] args){
		try{
			Naming.rebind("server", new ServerImpl());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
