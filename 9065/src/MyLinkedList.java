public class MyLinkedList{
	public String data;
	protected MyLinkedList head;
	protected MyLinkedList prev;
	protected MyLinkedList next;
	protected MyLinkedList cursor;
	protected int numNode;
	
	public MyLinkedList() {
		head = null;
		prev = null;
		next = null;
		cursor = null;
		numNode = 0;
	}
	
	public MyLinkedList(String data, MyLinkedList prev, MyLinkedList next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	Boolean isEmpty() {
		return numNode == 0;
	}
	
	public void addFront(String s){
		if(isEmpty()) {
			MyLinkedList newNode = new MyLinkedList(s, null, null);			
			head = newNode;				
			numNode++;
		}else {			
			MyLinkedList newNode = new MyLinkedList(s, null, head);
			head.prev = newNode;
			head = newNode;			
			numNode++;
		}		
	}
	
	public void addBack(String s){
		if(isEmpty()) {
			MyLinkedList newNode = new MyLinkedList(s, null, null);
			head = newNode;			
			numNode++;
		}else {						
			cursor = head;
			while(cursor.next != null) {				
				cursor = cursor.next;								
			}						
			MyLinkedList newNode = new MyLinkedList(s, cursor, null);
			cursor.next = newNode;
			newNode.prev = cursor;
			numNode++;
		}
	}
	
	// front항목을 돌려준다. 없으면 예외를 던진다.
	String peekFront() throws Exception{
		if(isEmpty()) {
			throw new Exception("비어있음");
		}else {
			return head.data;
		}
	}
	
	// back에 있는 항목을 돌려준다. 없으면 예외를 던진다.
	String peekBack() throws Exception {
		if(isEmpty()) {
			throw new Exception("비어있음");
		}else {
			cursor = head;
			while(cursor.next != null) {
				cursor = cursor.next;
			}
			return cursor.data;
		}
	}
	
	// front항목을 삭제한다. 없으면 예외를 던진다.
	String removeFront() throws Exception{
		if(isEmpty()) {
			throw new Exception("비어있음");
		}else if(numNode == 1) {
			cursor = head;
			head = null;
			
			numNode--;
			return cursor.data;
		}else {
			cursor = head;
			head = head.next;
			head.prev = null;
			
			numNode--;
			return cursor.data;
		}
	}
	
	// s와 같은 내용의 스트링이 있으면 리스트에서 뺀다.
	void remove(String s) throws Exception{
		if(isEmpty()) {
			throw new Exception("비어있음");
		}else {
			cursor = head;
			MyLinkedList temp;
			
			while(cursor.next != null) {
				if(cursor.data.equals(s)) {
					temp = cursor.next;
					cursor.prev.next = cursor.next;
					cursor.next.prev = cursor.prev;
					
					cursor.prev = null;
					cursor.next = null;
							
					cursor = temp;
					numNode--;
				}
				cursor = cursor.next;
			}										
		}
	}
	
	// back 항목을 삭제한다. 없으면 예외를 던진다.
	String removeBack() throws Exception{
		if(isEmpty()) {
			throw new Exception("비어있음");
		}else {			
			cursor = head;
			while(cursor.next != null) {
				cursor = cursor.next;
			}
			cursor.prev.next = null;
			cursor.prev = null;
			
			numNode--;	
			return cursor.data;
		}
	}
	
	// front 부터 back까지 순서대로 출력
	public void printForward() throws Exception{
		if(isEmpty()) {
			throw new Exception("Linked List가 비었음\n");
		}else {
			cursor = head;		
			while(cursor != null) {
				System.out.print(cursor.data + " --> ");
				cursor = cursor.next;
			}
			System.out.println("END");
		}		
	}
	
	// back 부터 front 까지 순서대로 출력
	public void printBackward() throws Exception{
		if(isEmpty()) {
			throw new Exception("Linked List가 비었음\n");
		}else {
			cursor = head;		
			while(cursor.next != null) {			
				cursor = cursor.next;
			}
			
			for(int i = 0; i < numNode - 1 ; i++) {
				System.out.print(cursor.data + " --> ");
				cursor = cursor.prev;	
			}
			System.out.print(head.data + " --> ");
			System.out.println("END");
		}		
	}
}
