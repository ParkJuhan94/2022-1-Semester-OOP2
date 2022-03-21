
public class Counter {
	private int cnt = 0;
	
	public void Bump() {
		cnt++;
	}
	
	public void Reset() {
		cnt = 0;
	}
	
	public void Show() {
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c = new Counter();
		c.Reset();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Show();
	}

}
