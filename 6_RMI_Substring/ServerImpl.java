import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
	public ServerImpl() throws RemoteException{

	}
	public int substring(String string1, String string2){
		return string1.indexOf(string2);
	}
}
