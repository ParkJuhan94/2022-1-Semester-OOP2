
public class Stack extends TwoWayList{
	public void push(Integer n) {
		super.addRight(n);
	}
	
	public void pop() throws Exception {
		super.removeRight();
	}
	
	public Integer peek() throws Exception {
		return super.getRightItem();
	}
	
	public void addRight(Integer i) {
		return;
	}
	
	public void addLeft(Integer i) {
		return;
	}
}
