import java.rmi.*;
import java.net.*;

public interface ServerIntf extends Remote{
	public int countVowels(String string) throws RemoteException;
}
