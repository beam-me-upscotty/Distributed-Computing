import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
	public ServerImpl() throws RemoteException{

	}
	public int countVowels(String string){
		int count = 0;
		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' ||
			string.charAt(i) == 'o' || string.charAt(i) == 'u'){
				count+=1;
			}
		}
		return count;
	}
}
