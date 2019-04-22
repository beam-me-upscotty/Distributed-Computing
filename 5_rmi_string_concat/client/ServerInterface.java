import java.rmi.*;
public interface ServerInterface extends Remote{
  public String concatenate(String string1, String string2) throws RemoteException;
}
