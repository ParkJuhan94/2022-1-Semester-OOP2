/*
generic Rectangle 클래스를 정의한다. 각 변의 타입이 Integer, Double이 다 될 수 있도록 한다.

출력 결과:

사각형 밑변 2 높이 3
사각형 밑변 3.5 높이 3.5
*/

class Rectangle<T>{
	private T a, b;
	public Rectangle(T a, T b) {
		this.a = a;
		this.b = b;
	}
	public String toString() {
		return "사각형 밑변 " + this.a + " 높이 " + this.b;
	}
}

public class Main {
	public static void main(String[] args) {
	
		Rectangle<Integer> myRectangle = 
                new Rectangle<Integer>(2, 3);
		System.out.println(myRectangle);
		Rectangle<Double> myDoubleRectangle = 
                new Rectangle<Double>(2.5, 3.5);
		System.out.println(myDoubleRectangle);
	}

}
