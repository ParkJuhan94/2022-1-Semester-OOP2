import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException {

		final String content = "Hello from java14";
		Socket socket = new Socket("127.0.0.1", 1000);
		
		OutputStream outStream = socket.getOutputStream();
		InputStream inStream = socket.getInputStream();
		
		outStream.write(content.getBytes());
		outStream.flush();
		
		socket.close();
	}

}
