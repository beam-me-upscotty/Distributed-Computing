import java.rmi.*;

public class Server{
	public static void main(String args[]){
		try{
			Naming.rebind("Server",new ServerImpl());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
