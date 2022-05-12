import java.util.*;   // Vector나 ArrayList를 위해 import한다.

class Thing{
	String name;
	public Thing(String name) {
		this.name = name;
	}
	public void show() {
		System.out.println("이름은: " + name);
	}
}

class Fruit extends Thing{
	//String name;
	Fruit(String name){
		super(name);
	}	
}

class Apple extends Fruit{
	Apple(String name){
		super(name);
	}
	
	@Override
	public void show(){
		System.out.println("사과입니다. ");
		// 이름 출력은 상위 클래스 이용
		super.show();
	}
}

class Banana extends Fruit{
	Banana(String name){
		super(name);
	}
	
	@Override
	public void show(){
		System.out.println("바나나입니다: ");
		// 이름 출력은 상위 클래스 이용
		super.show();
	}
}

class GeneralBox extends Thing{
	// myList 는 Vector나 ArrayList를 이용한다. 적당한 크기의 배열도 OK
	ArrayList<Thing> myList = new ArrayList<>();
	
	GeneralBox(String name){
		super(name);
		// myList를 초기화 한다.
	}
	public void add(Thing f){
		// myList를 이용하여 내용물을 보관한다.
		myList.add(f);
	}
	public void show(){

		System.out.println("[상자입니다. 이름은: " + name);
		System.out.println("내용물은:");
		for (int i=0; i<myList.size(); i++){
			myList.get(i).show();
		}
	}
}

public class Main{
    public static void main(String[] args){
        GeneralBox b1 = new GeneralBox("큰 상자");
        GeneralBox b2 = new GeneralBox("작은 상자");
        b1.add(new Apple("김사과"));
        b1.add(new Banana("홍바나나"));
        b2.add(new Apple("이사과"));
        b1.add(b2);
        b1.add(new Apple("박 사과"));
        b1.add(new Apple("최 사과"));
        b1.add(new Banana("박 바나나"));

        b1.show();
    }
}
