package server_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss;
		ss = new ServerSocket(8002);
		Socket client = ss.accept();
		System.out.println(client.getInetAddress());
	}

}
