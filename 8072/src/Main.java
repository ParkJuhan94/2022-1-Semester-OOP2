import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			queue.enQueue(sc.next());
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.front()); 
			queue.remove();
		}

		try {
			String s = queue.front(); // 없으므로 예외처리를 하게 만든다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
