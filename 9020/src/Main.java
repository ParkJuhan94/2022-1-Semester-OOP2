
class Dog {
	public void bark(){
		System.out.println("멍멍!");
	}
}

class NoisyDog extends Dog{
	public void bark() {
		super.bark();
		super.bark();
		super.bark();
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoisyDog d = new NoisyDog();
		d.bark();
	}

}
