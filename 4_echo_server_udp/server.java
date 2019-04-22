
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
                DatagramPacket DpReceive = new DatagramPacket(messageBytes, messageBytes.length); 
                ds.receive(DpReceive);
                String message = new String(messageBytes);
                System.out.println("Client:-" + message); 
                DatagramPacket DpSend = new DatagramPacket(messageBytes, messageBytes.length, ip,message.split("\\$")[1]); 
                ds.send(DpReceive);
            }
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        ds.close();
   } 
}