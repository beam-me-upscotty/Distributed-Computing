import java.net.*;
import java.rmi.*;
public interface ServerIntf extends Remote{
	public String Stringreverse(String string) throws RemoteException;
}
