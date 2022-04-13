import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class MyBufferedFileInputStream extends FileInputStream{
	private byte[] arr = new byte[8192];
	private int size = 0;
	private int idx = -1;
	private int c;	
	
	public MyBufferedFileInputStream(String string) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(string);
	}
	
	@Override
	public int read() throws IOException {		
		if(idx == -1 || idx == 8191) {
			size = super.read(arr, 0, 8192);					
			idx = -1;
		}
											
		if(idx == size) {
			return -1;
		}
		idx++;		
		return arr[idx];
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int c;
		int count = 0;
		long start = System.currentTimeMillis();
		
		FileInputStream mystream1= new FileInputStream("one_mega.txt");
		while ( ( c = mystream1.read()) != -1 ) {
		    if ( c == 'a' ) count++;
		}
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println(end-start);
		mystream1.close();

		count = 0;
		MyBufferedFileInputStream mystream2 = new MyBufferedFileInputStream ("one_mega.txt");
		start = System.currentTimeMillis();
		while ( ( c = mystream2 .read()) != -1) {
		    if ( c == 'a' ) count++;
		}
		end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println(end-start);
		mystream1.close();
	}

}
