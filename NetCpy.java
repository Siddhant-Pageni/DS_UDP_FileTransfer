import java.net.*;
import java.io.*;
//import java.util.Scanner;

public class NetCpy{
	private DatagramSocket socket = null;
	private FileHandlers fileH = null;
	private String sourceFilePath = "F:/Distibuted System/UDP_FileTransfer/xyz.mp4";
	private String destinationPath = "F:/";
	private String hostName = "localHost";
	private int server_port = 6789;
	
	public static void main(String[] args) {
		File temp = new File("xyz.mp4");
		try
		{
			if(temp.exists()){
				System.out.println("File Exists.. Initiating Transfer");
				try{
					FileHandlers fh = new FileHandlers(temp);
					FileOutputStream fOS = new FileOutputStream(new File(destinationPath+"/output.mp4"),true);
					
					while(!readFH.getIsReadComplete()){
						byte[] bfn = readFH.read();
						//convert into udp packets (for instance lets use packet)
						//send packet
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						ObjectOutputStream os = new ObjectOutputStream(outputStream);
						os.writeObject(packet);
						byte[] data = outputStream.toByteArray();
						do{
						DatagramPacket sendPacket = new DatagramPacket(data, data.length, hostName, server_port);
						socket.send(sendPacket);
						System.out.println("File sent from client");
						//check if the packets reach the destination
						DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
						socket.receive(incomingPacket);
						String response = new String(incomingPacket.getData());
						}while(response != "success")
						//once they reach then start reading again and sending again until
						//all the file is transfered to the destination.
						fOS.write(bfn);
						fOS.close();
					}catch(FileNotFoundException e){
						System.out.println("File not found"+e.getMessage());
					}catch(IOException e){
						System.out.println("IO: "+e.getMessage());
					}

				}else{
					System.out.println("File "+args[0]+" doesn't exists!");
				}
			}
		}
	}
}
					
			/*socket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName(hostName);
			//Scanner s = new Scanner(System.in);
			while(true) {
				//System.out.print("Client: ");
				//String msg = s.next();
				//byte[] m = msg.getBytes();
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
	public 
}*/