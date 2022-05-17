import java.util.ArrayList;

class Thing{
	protected String name;
	ArrayList<Thing> list = new ArrayList<>();
	
	public Thing(String name) {
		this.name = name;
	}
	
	void add(Thing t) {
		list.add(t);
	}
	
	public String toString() {
		return null;
	}
}

class Figure extends Thing{
	
	public Figure(String name) {
		super(name);
	}
}

class Rect extends Figure{
	public Rect(String name) {
		super(name);
	}
	
	@Override public String toString() {
		return "사각형 " + name + "\n";
	}
}

class Oval  extends Figure{
	public Oval (String name) {
		super(name);
	}
	
	@Override public String toString() {
		return "타원 " + name;
	}
}

class Group extends Thing{
	
	public Group(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		String s = "[\n" + "그룹도형 " + name + "\n";
		s += "멤버 수: " + list.size() + "\n멤버들: \n";
		for (Thing f: list) {
			s += f.toString();
		}
		s += "\n]\n";
		return s;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group g1 = new Group("대그룹");
		Group g2 = new Group("소그룹");
		Rect r1 = new Rect("김사각");
		Oval o1 = new Oval("김타원");
		Rect r2 = new Rect("이사각");
		Oval o2 = new Oval("이타원");
		g1.add(r1);
		g1.add(o1);
		g2.add(r2);
		g2.add(o2);
		g1.add(g2);                // comment 해제해야한다.
		System.out.println(g1);
	}

}
