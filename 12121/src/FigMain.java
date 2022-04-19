import java.util.Scanner;

// 도형은 삼각형 사각형 두종류만 있다고 하자.
// 삼각형은 이등변 삼각형으로 가정한다.
// 입력시 0 은 삼각형  1은 사각형이다.
// 0 이나 1이 아닌 것은 더이상 입력이 없는 것으로 한다.

interface Comparer{
	boolean compare(Figure one, Figure two);
}

class WidthComparer implements Comparer{

	@Override
	public boolean compare(Figure one, Figure two) {
		// TODO Auto-generated method stub
		return one.width < two.width;
	}
}

class AreaComparer implements Comparer{

	@Override
	public boolean compare(Figure one, Figure two) {
		// TODO Auto-generated method stub
		return one.width*one.height < two.width*two.height;
	}
}

class Figure{	
	public int width, height;
	public void print() {}
}

class Triangle extends Figure{
	@Override
	public void print() {
		System.out.println("삼각형 " + this.width + " " + this.height + " " + this.width*this.height);
	}
}

class Rectangle extends Figure{
	@Override
	public void print() {
		System.out.println("사각형 " + this.width + " " + this.height + " " + this.width*this.height);
	}
}

class Figures{
	Figure[] f;
	public int num = 0;
	public int size;
	
	public Figures(int n) {
		this.size = n;
		f = new Figure[size];
	}
	public void add(int type, int width, int height) {
		if(type == 0) {
			f[num] = new Triangle();
		}else {
			f[num] = new Rectangle();
		}
		f[num].width = width;
		f[num].height = height;
		num++;
	}
	public void listAll() {
		for(int i = 0; i < num; i++) {
			f[i].print();
		}				
	}
	public void sort(Comparer c) {
		Figure tempFig;
		for(int i = 1; i < num; i++) {
			for(int j = 0; j < num - i; j++) {
				if(c.compare(f[j], f[j + 1])) {
					tempFig = f[j];
					f[j] = f[j + 1];
					f[j + 1] = tempFig;
				}
			}
		}
	}
}

public class FigMain{
	public static void main(String[] args){
		Figures myFigures = new Figures(100);  //주어진 개수대로 최대 크기를 결정
		//Scanner 를 이용하여 도형을 입력한다.
		Scanner sc = new Scanner(System.in);
		while ( sc.hasNext() ){
			// 도형 종류,  너비, 높이 (모두 정수) 순서로 입력한다.
			// 입력 예시: 0 10 8
			//            1 5 4
			myFigures.add(sc.nextInt(),sc.nextInt(),sc.nextInt());  // add 함수를 이용하여 추가.  
		}
		myFigures.listAll(); // 순서대로 출력
		// 예시:   사각형  10  8 80     너비 높이 면적 순으로 출력
		//         삼각형  10  8 40
		// 편의상 면적도 정수로 한다.
		
		
		
		// 아래는 버전 2 부분이다.
		// 인터페이스를 이용하여 정렬
		myFigures.sort(new WidthComparer());  // 너비 기준으로 정렬
		myFigures.listAll();
		myFigures.sort(new AreaComparer()); // 면적 기준으로 정렬
		myFigures.listAll();
	}
}
