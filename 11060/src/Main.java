// p_1105의 배열 버전이다. Collection 을 아직 안 배운 경우를 대비.
import java.util.Scanner;

class Animal{
	protected String name;
	public Animal(String name) {
		this.name = name;
	}
	public void run() {
		//
	}
	public void swim() {
		//
	}
}

class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(name + " running");
	}
}

class Fish extends Animal{
	public Fish(String name) {
		super(name);
	}
	@Override
	public void swim() {
		System.out.println(name + " swimming");
	}
}

public class Main {
	Fish[] fishList = new Fish[20];
	Dog[] dogList = new Dog[20];
	int numberOfFish = 0;
	int numberOfDogs = 0;
	
	public void create() {
		Scanner s = new Scanner(System.in);
		fishList[numberOfFish++] = new Fish(s.next());
		fishList[numberOfFish++] = new Fish(s.next());
		dogList[numberOfDogs++] = new Dog(s.next());
		dogList[numberOfDogs++] =new Dog(s.next());
	}

	public void move() {
		for (int i = 0; i < numberOfFish; i++) {
			fishList[i].swim();
		}
		for (int i = 0; i < numberOfDogs; i++) {
			dogList[i].run();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.create();
		m.move();
	}

}
