public class Main {
	static int seq=1;
	static void debugprint(MyStringBuffer s) {
		System.out.println(seq++ + ". " + s + " len= " + s.length() + " / size = " + s.capacity());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuffer s = new MyStringBuffer("Hello");
		MyStringBuffer t = new MyStringBuffer("world");
			debugprint(s);  // toString 이 필요하다.
			
		s.append(t);
		s.append(123);
			debugprint(s);  // toString 이 필요하다.
			
		s.delete(0,3);
			debugprint(s);
			
		s.insert(0, "Hel");
			debugprint(s);
			
		t.reverse();
			debugprint(t);
			
		s.delete(8, s.length());
			debugprint(s);
			
		s.trimToSize();
			debugprint(s);			
	}

}
