import java.io.IOException;
import java.util.Scanner;

public class prac3040 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
				
		while(sc.hasNextInt()) {
			sum += sc.nextInt();
		}
		System.out.println(sum);
	}
}