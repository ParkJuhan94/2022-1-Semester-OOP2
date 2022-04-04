class MyInt{
	public MyInt(int x) {value = x;}
	public void set(int x) {value = x;}
	public int value;
}
public class prac8087 {

	public static void fun(MyInt x) {
		x = new MyInt(1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInt xx;
		xx = new MyInt(999);
		fun(xx);
		System.out.println(xx.value);
	}
}
  