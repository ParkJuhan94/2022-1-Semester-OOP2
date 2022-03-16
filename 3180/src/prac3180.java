import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prac3180 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		int sum = 0;	
		
		for(int i = 0 ; i < args.length; i++) {
			// System.out.println(args[i]);			
			String fileName = args[i];
			
			FileInputStream in = new FileInputStream(fileName);
			Scanner sc = new Scanner(in);
			
			while(sc.hasNextInt()) {
				sum += sc.nextInt();
			}			
		}
		System.out.println(sum);		
	}
}
