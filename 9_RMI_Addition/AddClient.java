import java.rmi.*;

public class AddClient{
	public static void main(String args[]){
		try{

			String urladdress = "rmi://" + args[0] + "/AddServer";
			AddServerIntf addserverintf = (AddServerIntf)Naming.lookup(urladdress);
			double d1 = Double.valueOf(args[1]).doubleValue();
			double d2 = Double.valueOf(args[2]).doubleValue();
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(addserverintf.add(d1,d2));
		}
		catch(Exception e){
			System.out.println(e);

		}
	}
}
