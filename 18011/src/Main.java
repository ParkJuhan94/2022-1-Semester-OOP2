import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss;
		ss = new ServerSocket(1000);
		Socket client = ss.accept();
		
		/*	Server에서 보낸 값을 받기 위한 통로 */		
		InputStream istream = client.getInputStream();
		
		int n = 0;
		while((n = istream.read()) != -1) {
			System.out.print((char)n);
		}

//		byte[] data = new byte[16];
//		int n = istream.read(data);
//		final String resultFromServer = new String(data,0,n);		
		
//		System.out.print(resultFromServer);
		
		client.close();
	}

}
