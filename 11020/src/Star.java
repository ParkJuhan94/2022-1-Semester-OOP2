// 한 파일에 여러개가 있으므로 public class로 하지 않는다.
class Unit{
	public void speak(){
		System.out.println("I am a unit.");
	}
}

// Dragoon 과 Zealot 클래스를 Unit에서 상속받고, 메소드를 override하라.
// "I am a dragoon" 혹은 "I am a Zealot" 과 같이 출력하게 하면 된다.

class Dragoon extends Unit{
	@Override
	public void speak() {
		System.out.println("I am a dragoon");
	}
}

class Zealot extends Unit{
	@Override
	public void speak() {
		System.out.println("I am a Zealot");
	}
}

public class Star{
	public static void main(String[] args){
		Unit u;
	
	// Dragoon의 instance를 u 에 넣고 speak를 호출하라.
	// Zealot의 instance를 u 에 넣고 speak를 호출하라.
		u = new Dragoon();
		u.speak();
		
		u = new Zealot();
		u.speak();		
	}
}
