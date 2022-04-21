import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjVector myVector = new ObjVector(10);
		Scanner sc = new Scanner(System.in);
		myVector.add(sc.nextDouble());
		myVector.add(sc.nextDouble());
		myVector.add(sc.nextInt());		
		myVector.add(sc.nextInt());
	
		//	여기서는 캐스팅이 없어도 출력이 잘 되지만 안되는 경우 생김
		//	System.out.println( myVector.get(0) + myVector.get(1));
		System.out.println( (Double) myVector.get(0));
		System.out.println( (Double) myVector.get(1));
		System.out.println( (Integer) myVector.get(2));
		System.out.println( (Integer) myVector.get(3));
	}
}
