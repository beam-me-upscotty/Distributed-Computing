import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
	public ServerImpl() throws RemoteException{

	}
	public String concatenate(String string1, String string2){
		return string1+string2;
	}
}
