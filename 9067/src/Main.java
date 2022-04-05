import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			Scanner myscanner = new Scanner(System.in);
			Stack stack = new Stack();
			//
			while (myscanner.hasNextInt()) {
				stack.push(myscanner.nextInt());
			}

			while (!stack.isEmpty()) {
				System.out.println(stack.peek());
				stack.pop();
			}

			stack.push(111);
			stack.push(222);
			stack.push(333);
			stack.addRight(888);
			stack.addLeft(999);

			while (!stack.isEmpty()) {
				System.out.println(stack.peek());
				stack.pop();
			}
			stack.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
