import java.util.LinkedList;

public class Stack extends LinkedList {
	
	@Override 
	public boolean add(Object o) {
		super.addFirst(o);
		return true;
	}
	
	@Override 
	public void addFirst(Object o) {
		return;
	}
	
	@Override 
	public void addLast(Object o) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override 
	public Object getFirst() {
		return null;
	}
	
	@Override 
	public Object getLast() {
		return null;
	}
}