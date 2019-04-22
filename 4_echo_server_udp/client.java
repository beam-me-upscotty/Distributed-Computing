import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 
  
public class client
{ 
    public static void main(String args[]) throws IOException 
    { 
        DatagramSocket socket = new DatagramSocket(); 

        InetAddress ip = InetAddress.getLocalHost();

        byte buf[] = null;

        Scanner sc = new Scanner(System.in); 
        String inp = sc.nextLine(); 
        buf = inp.getBytes();
        System.out.println(buf.length+"");

        DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 1234);
        socket.send(packet);
        System.out.println("Sent");
        byte[] messageBytes = new byte[65535]; 
        DatagramPacket DpReceive = new DatagramPacket(messageBytes, messageBytes.length); 
        socket.receive(DpReceive);
        String message = new String(messageBytes);
        System.out.println("Received:-" + message); 
        socket.close();
    } 
} 
