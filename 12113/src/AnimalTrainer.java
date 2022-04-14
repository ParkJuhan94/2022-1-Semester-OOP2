interface TrainedAnimal{
	public void move();
}

class Kangaroo implements TrainedAnimal{
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Jump");
	}
}

class Fish implements TrainedAnimal{
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Swim");
	}
}

public class AnimalTrainer {
	void makeMove(TrainedAnimal t) {
		t.move();
	}

	//void makeMove(Kangaroo k) {
		//k.move();
	//}
	//void makeMove(Fish f) {
		//f.move();
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalTrainer at = new AnimalTrainer();
		at.makeMove(new Kangaroo());
		at.makeMove(new Fish());
	}

}
