import java.util.ArrayList;

class Pet{
	String name;
	public Pet(String name) {
		this.name = name;		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

class Dog extends Pet{
	//String name;
	public Dog(String name) {
		super(name);
	}
	public String toString() {
		return "멍멍이 "  + super.toString();
	}
}

class Cat extends Pet{
	//String name;
	public Cat(String name) {
		super(name);
	}
	public String toString() {
		return "야옹이 "  + super.toString();
	}
}

class School<T extends Pet>{
	ArrayList<T> petList = new ArrayList<>();
	public void add(T P) {
		petList.add(P);
	}
	public void show() {
		for (T p: petList) {
			System.out.println(p);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//<String> stringSchool = new School<>();
		School<Dog> dogSchool = new School<>();
		School<Cat> catSchool = new School<>();
		dogSchool.add(new Dog("aaa"));
		dogSchool.add(new Dog("bbb"));
		//dogSchool.add(new Cat("xxx"));
		
		catSchool.add(new Cat("ccc"));
		catSchool.add(new Cat("ddd"));
		
		dogSchool.show();
		catSchool.show();
	}

}
