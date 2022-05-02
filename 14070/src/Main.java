import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface iterator {
	public boolean hasNext();
	public String next();
	public boolean hasPrevious();
	public String previous();
	public void setIdx(int n);
}

class ListIterator implements iterator {
	private MyLinkedList<String> list;
	int idx = 0;
	
	public ListIterator(MyLinkedList<String> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return idx < list.size();
	}

	@Override
	public String next() {
		return (String) list.get(idx++);
	}

	@Override
	public boolean hasPrevious() {
		return 0 <= idx;
	}

	@Override
	public String previous() {
		return (String) list.get(idx--);
	}

	@Override
	public void setIdx(int n) {
		// TODO Auto-generated method stub
		this.idx = n;
	}
}

class MyLinkedList<T> {
	//private List<T> list = new ArrayList<T>();
	class Node {
		private T data;
		private Node prev;
		private Node next;
	}

	private int size = 0;
	private Node head = null;	
	private Node cursor = null;
	private ListIterator iter = new ListIterator((MyLinkedList<String>) this);

	public void add(T data) {
		if (head == null) {
			Node newNode = new Node();
			newNode.data = data;
			head = newNode;
			newNode.prev = head;
			size++;
		} else {
			cursor = head;
			Node newNode = new Node();
			newNode.data = data;
			while (cursor.next != null) {
				cursor = cursor.next;
			}
			newNode.prev = cursor;
			cursor.next = newNode;
			size++;
		}
	}

	public T get(int idx) {
		cursor = head;
		for(int i = 0; i < idx; i++) {
			cursor = cursor.next;
		}
		return cursor.data;
	}

	public int size() {
		return this.size;
	}

	public ListIterator listIterator() {
		return this.iter;
	}

	public ListIterator listIterator(int size) {		
		this.size = size;
		iter.setIdx(size - 1);
		return this.iter;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<String> list = new MyLinkedList<>();
		Scanner myscanner = new Scanner(System.in);

		while (myscanner.hasNext()) {
			list.add(myscanner.next());
		}

		ListIterator iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		ListIterator iter2 = list.listIterator(list.size()); // 끝 항목부터 시작
		while (iter2.hasPrevious()) {
			System.out.println(iter2.previous());
		}

	}
}