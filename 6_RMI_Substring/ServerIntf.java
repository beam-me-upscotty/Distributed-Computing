import java.rmi.*;

public interface ServerIntf extends Remote{
	public int substring(String string1, String string2) throws RemoteException;
}
