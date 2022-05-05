/*
 14501과 동일한 프로그램을 작성한다.
이번에는 anonymous class 가 아닌 lambda를 이용한다.
 */

 @FunctionalInterface
interface LoggerInterfae{
   void writeLog(float degree);
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerInterfae f = (float degree) -> System.out.println("현재 온도는 " + degree + " 도 입니다.");
		
		f.writeLog((float) 99.5);  // f 가 변수명이라하고 이렇게 호출.
	}

}
