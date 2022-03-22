class MyInteger{
	private int data;
	public MyInteger(int p){
		data =  p;
	}
	public MyInteger addOne(){
		return new MyInteger(data+1);
	}
	public String toString() {
		return Integer.toString(data);
	}
}
public class Main{

	public static void main(String[] args){
		MyInteger i = new MyInteger(123);
		
		System.out.println(i.addOne());
	}
}