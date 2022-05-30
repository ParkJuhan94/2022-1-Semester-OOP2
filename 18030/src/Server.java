import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1000);
		Socket socket = serverSocket.accept(); 
		
		OutputStream outStream = socket.getOutputStream();
		InputStream inStream = socket.getInputStream();

		int n = 0;
		while((n = inStream.read()) != -1) {
			System.out.print((char)n);
		}
		
		outStream.close();
		inStream.close();
		serverSocket.close();
	}

}
