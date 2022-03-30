import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);		
		
		while(sc.hasNextInt()) {
			stack.add(sc.nextInt());
		}
		
		while ( !stack.isEmpty() ){		
		    // top 값을 출력
			System.out.println(stack.top());
		    // pop
			try {
				stack.pop();	
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}									
		}
		try {
			System.out.println(stack.top());   // 비어 있으므로 예외 처리 메시지가 출력되게 한다.			
		}catch (Exception e){			
			System.out.println(e.getMessage());
		}

	}

}
