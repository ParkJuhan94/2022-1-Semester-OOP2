import java.util.Scanner;

public class Echo {
	public static void main(String[] a) {		
		Scanner mySc = new Scanner(System.in);

			if(mySc.hasNextInt()) {
				int num = mySc.nextInt();
				System.out.println(num);			
			}else {
				System.out.println("none");
			}
		}	
}