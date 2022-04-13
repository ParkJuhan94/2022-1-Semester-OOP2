import java.util.Scanner;

class Link {
	int data;
	Link next;

	public Link(int n, Link nxt) {
		data = n;
		next = nxt;
	}
}

class Stack {
	private Link first;

	public Stack() {
		first = null;
	}

	public void push(int n) {
		Link t = new Link(n, first);
		first = t;
	}

	public boolean isEmpty() {
		return first == null;

	}

	public void pop() {
		if (first != null)
			first = first.next;

	}

	public int top() {
		return first.data;
	}
}

class OrderedStack {
	Stack s;
	private Link first;
	private Link cursor;

	public OrderedStack(){ first = null; }

	public void push(int n) {
		Link t = new Link(n, first);		
		
		if(n < first.data) {
			first = t;
			
		}else {
			first.next = t;
		}
	}

	public boolean isEmpty() {
		return first == null;

	}

	public void pop() {
		if (first != null)
			first = first.next;

	}

	public int top() {
		return first.data;
	}
	
	

}

public class Main {
	public static void main(String[] args) {
		//
		Scanner scanner = new Scanner(System.in);
		OrderedStack st = new OrderedStack();
		while (scanner.hasNextInt()) {
			st.push(scanner.nextInt());
		}
		while (!st.isEmpty()) {
			System.out.println(st.top());
			st.pop();
		}
	}
}
