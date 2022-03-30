
public class ExceptionPrac {
	public static int divide(int a,int b) throws Exception{
		if(b == 0) {
			throw (new Exception("Divide Error"));
		}
		return a/b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int res;
			res = divide(3, 2);
			System.out.println(res);
			res = divide(3, 0);
			System.out.println(res);
		} catch(Exception e) {
			System.out.println(e.getMessage()); 						
		}
	}
}
