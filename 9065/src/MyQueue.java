
public class MyQueue extends MyLinkedList {
	// 삽입
	void insert(String s) {
		super.addFront(s);
	}

	// 제일 먼저 빠져나올 항목의 값을 가져온다.
	String peek() throws Exception {
		return super.peekFront();
	}

	//  항목 하나를 빼버린다.
	void remove() throws Exception {
		super.removeFront();
	}

	// 큐가 비었는지 판단.
	Boolean isEmpty() {
		return super.isEmpty();
	}
}
