
public class prac3050 {

	public static int division(int a, int b) throws Exception{
		if(b == 0) {
			Exception e = null;
			throw e;
		}else {
			return a / b;
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("여기는 finally 사용한 try입니다");
			System.out.println(division(4,0));
		} catch (Exception e){			
			System.out.println("0으로 나눌 수 없습니다");		
			return;
		} finally {
			System.out.println("finally 나눗셈 완료");
		}

		
		try {
			System.out.println("여기는 finally 없는 try입니다");
			System.out.println(division(4,0));
		} catch (Exception e){
			System.out.println("0으로 나눌 수 없습니다");		
			return;
		}  
		System.out.println("non finally 나눗셈 완료");
	}
}