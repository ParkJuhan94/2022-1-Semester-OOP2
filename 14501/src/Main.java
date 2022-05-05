/*
 주어진 functional interface 에 맞는 Anonymous class 를 이용하여 
"현재 온도는 99.5 도 입니다." 처럼 출력하기.
 */

// 인터페이스 정의한다.
 @FunctionalInterface
interface LoggerInterfae{
   void writeLog(float degree);
}
 
public class Main {

	public static void main(String[] args) {
		// 여기에 무명 클래스 선언이 필요한다.
		LoggerInterfae f = new LoggerInterfae() {
			@Override
			public void writeLog(float degree) {
				// TODO Auto-generated method stub
				System.out.println("현재 온도는 " + degree + " 도 입니다.");				
			}
		};

		f.writeLog((float) 99.5);  // f 가 변수명이라하고 이렇게 호출.
	}
 
}