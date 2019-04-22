import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
	public ServerImpl() throws RemoteException{

	}
	public String Stringreverse(String string){
		StringBuilder s = new StringBuilder();
		s.append(string);
		s = s.reverse();
		return s.toString();
	}
}
