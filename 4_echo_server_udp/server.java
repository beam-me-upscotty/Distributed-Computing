
// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
  
public class server 
{ 
    public static void main(String[] args) throws IOException 
    { 
        DatagramSocket ds = new DatagramSocket(1234); 
        try{
            // Step 1 : Create a socket to listen at port 1234 
            InetAddress ip = InetAddress.getLocalHost();

            while(true){
                byte[] messageBytes = new byte[65535]; 

                DatagramPacket receivedPacket = new DatagramPacket(messageBytes, messageBytes.length); 
                ds.receive(receivedPacket);

                System.out.println("Client:-" + new String(messageBytes));

                ds.send(receivedPacket);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error:"+e.getLocalizedMessage());
        }
        ds.close();
   } 
}