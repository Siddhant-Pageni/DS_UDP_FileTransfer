import java.net.*;
import java.io.*;
//import java.util.Scanner;

public class NetCpy{
	private DatagramSocket socket = null;
	private FileHandlers fileH = null;
	private String sourceFilePath = "F:/Distibuted System/UDP_FileTransfer/xyz.mp4";
	private String destinationPath = "C:/tmp/downloads/udp/";
	private String hostName = "localHost";
	
	public static void main(String[] args) {
		try
		{
			socket = new DatagramSocket();
			//Scanner s = new Scanner(System.in);
			InetAddress server_ip = InetAddress.getByName("localhost");
			int server_port = 6789;
			while(true) {
				System.out.print("Client: ");
				String msg = s.next();
				byte[] m = msg.getBytes();
				DatagramPacket request = new DatagramPacket(m, m.length, server_ip, server_port);
				socket.send(request);
				System.out.println("message sent to server....");
				byte[] buffer = new byte[1000];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				socket.receive(reply);
				System.out.println("Server: " + new String(reply.getData()));
			}

		}
		catch(SocketException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(socket != null)
				socket.close();
		}
	}
}