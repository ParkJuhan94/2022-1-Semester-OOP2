import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		// scanner는 표준 입력 스캐너
		Scanner myscanner = new Scanner(System.in);
		
		while (myscanner.hasNext()){
			queue.insert(myscanner.next());
		}

		while ( !queue.isEmpty() ){
			System.out.println(queue.peek());
			queue.remove();
		}

		queue.insert("aaa");
		queue.insert("bbb");
		queue.addBack("ccc");
		queue.addFront("ddd");

		while ( !queue.isEmpty() ){
			System.out.println(queue.peek());
			queue.remove();
		}
	}
}
