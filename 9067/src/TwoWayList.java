public class TwoWayList {
	private static class Link{
		Link(Integer s, Link left, Link right){
			this.value = s; this.nextLeft = left; this.nextRight = right; 
		}
		void setLeft(Link t) {
			this.nextLeft = t;
		}
		void setRight(Link t) {
			this.nextRight = t;
		}
		Integer value;
		Link nextRight;
		Link nextLeft;
	}
	
	private Link first = null;  // 왼쪽을 first 로, 오른쪽을 last로 가정한다.
	private Link last = null;
	
	public boolean isEmpty(){
		return first == null;
	}
	public void addLeft(Integer i) {
		if (first == null) {
			last = first = new Link(i, null, null);
		} else {
			Link t = new Link(i, null, first);
			first.setLeft(t);
			first = t;
		}
	}
	public void addRight(Integer i) {
		if (last == null) {
			last = first = new Link(i, null, null);
		} else {
			Link t = new Link(i, last, null);
			last.setRight(t);
			last = t;
		}
	}
	public Integer getLeftItem() throws Exception {
		if (isEmpty())
			throw new Exception("Cannot peek");
		else
			return first.value;
	}
	public Integer getRightItem() throws Exception {
		if (isEmpty())
			throw new Exception("Cannot peek");
		else
			return last.value;
	}
	public void removeLeft() throws Exception {
		if (isEmpty())
			throw new Exception("No item to remove");
		else if (first == last) {
			first = last = null;
		} else {
			first = first.nextRight;
			first.setLeft(null);
		}
	}
	public void removeRight() throws Exception {
		if (isEmpty())
			throw new Exception("No item to remove");
		else if (last == first) {
			first = last = null;
		} else {
			last = last.nextLeft;
			last.setRight(null);
		}
	}
	public void remove(Integer s) {
		for (Link t = first; t != null; t=t.nextRight) {
			if (t.value.equals(s)) {
				Link p = t.nextLeft; Link n = t.nextRight;
				if (t == first) {
					first = n;
					t.setLeft(null);
				} else {
					p.setRight(n);		
				}
				if ( t== last) {
					last = p;
					p.setRight(null);
				} else {
					n.setLeft(p);
				}
			}
		}
	}
	public void printForward() {
		System.out.println("Front부터 출력:");
		for (Link t = first; t != null; t=t.nextRight) {
			System.out.println(t.value);
		}
	}
	public void printBackward() {
		System.out.println("Back부터 출력:");
			for (Link t = last; t != null; t=t.nextLeft) {
			System.out.println(t.value);
		}
	}
}
