
public class MyInt {
	private int n_;
	
	public MyInt(int n) {
		this.n_ = n;
	}
	
	public static MyInt add(MyInt a, MyInt b) {
		MyInt res = new MyInt(a.n_ + b.n_);
		
		return res;
	}
	
	public void addTo(MyInt a) {
		n_ += a.n_;
	}
	
	public void println() {
		System.out.println(n_);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInt a, b;
        a = new MyInt(111); b = new MyInt(222);
        
        MyInt c = MyInt.add(a, b);
        c.println(); // 출력 함수를 만들어 준다.
        c.addTo(a);
        c.println();
	}

}
