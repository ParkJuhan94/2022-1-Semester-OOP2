class Link{
	public int data;  
	public Link next;
	public Link(int data, Link link){
		// 생성자를 이용하자.		
		this.data = data;
		this.next = link;
	}
	public Link() {
		// TODO Auto-generated constructor stub
		Link next = null;
	}
}

public class Stack{
	private Link firstLink;
	private Link topLink;
	private int size;
	
	// 삽입
	public Stack() {		
		size = 0;
	}
	
	public void add(int n) {
		if(isEmpty()) {
			firstLink = new Link(n, null);
			topLink = new Link();
			topLink = firstLink;
			size++;
		}else {						
			Link newNode = new Link(n, null);						
			topLink.next = newNode;
			topLink = topLink.next;
			size++;				
		}		
	}
	
	// top에 있는 정수 값을 반환
	public int top() throws Exception{
		if(isEmpty()) {
			throw new Exception("스택이 비어있어서 top() 할 수 없음");
		}else {			
			return topLink.data;	
		}
	}
	
	// 비어있는지 확인하는 함수
	public boolean isEmpty() {
		return size == 0;
	}
	
	// top에 있는 항목(가장 최근 삽입한)을 삭제하는 함수
	public void pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("스택이 비어있어서 pop() 할 수 없음");
		}else {
			Link cursor = new Link();
			cursor = firstLink;
			for(int i = 0; i < size - 2; i++) {
				cursor = cursor.next;
			}
			cursor.next = null;
			topLink = cursor;
			size--;	
		}		
	}
}