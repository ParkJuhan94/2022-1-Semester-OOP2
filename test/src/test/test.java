package test;

import java.util.Scanner;

public class test{
	
	
	public static void main(String[] arg) {
		Scanner Scanner = new Scanner(System.in);
		int sum = 0;

		while (Scanner.hasNextInt()) {
			sum += Scanner.nextInt();			
		}

		System.out.println("Sum is " + sum);

		while (Scanner.hasNext()) {
			System.out.println("hasNext들어옴");
			System.out.println("String " + Scanner.next());
		}
	}
}