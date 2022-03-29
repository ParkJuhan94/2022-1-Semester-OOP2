
class Husband{
	String name;
	private Wife myWife;
	public Husband(String name) {
		this.name = name;
	}
	
	public void SetWife(Wife w) {
		myWife = w;
	}
	public void Speak() {
		System.out.println("나는 "+name+" 내 아내는 "+myWife.getName());
	}
	public String getName() {
		return this.name;
	}
}

class Wife{
	String name;
	private Husband myHusband;
	public Wife(String name) {
		this.name = name;
	}
	
	public void SetHusband(Husband h) {
		myHusband = h;
	}
	public void Speak() {
		System.out.println("나는 "+name+" 내 남편은 "+myHusband.getName());
	}
	public String getName() {
		return this.name;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Husband h1 = new Husband("홍길동");
		Wife w1 = new Wife("홍길순");
		h1.SetWife(w1);
		w1.SetHusband(h1);
		h1.Speak();  // 자기와 자기 부인 소개  예시: 나는 홍길동 내 아내는 홍길순
		w1.Speak();  // 자기와 자기 남편 소개  예시: 나는 홍길순 내 남편은 홍길동
	}

}
