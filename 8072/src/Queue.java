
class Link {
	public String data;
	public Link next;

	public Link(String data, Link link) {
		// 생성자를 이용하자.
		this.data = data;
		this.next = link;
	}

	public Link() {
		Link next = null;
	}
}

public class Queue {
	private Link firstLink;
	private Link lastLink;
	private int size;

	public Queue() {		
		size = 0;
	}

	// 비어있는지 확인하는 함수
	public boolean isEmpty() {
		return size == 0;
	}

	public void enQueue(String s) {
		if (isEmpty()) {
			firstLink = new Link(s, null);
			lastLink = new Link();
			lastLink = firstLink;
			size++;			
		} else {
			Link newNode = new Link(s, null);
			lastLink.next = newNode;
			lastLink = lastLink.next;
			size++;			
		}
	}

	public String front() throws Exception {
		if (isEmpty()) {
			throw new Exception("비어있으므로 front() 할 수 없음");
		} else {
			return firstLink.data;
		}
	}

	public void remove() throws Exception {
		if (isEmpty()) {
			throw new Exception("비어있으므로 remove() 할 수 없음");
		} else {
			Link cursor = new Link();
			cursor = firstLink;
			firstLink = firstLink.next;
			cursor.next = null;
			size--;
		}
	}
}
