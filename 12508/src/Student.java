
public class Student {
	String name;
	String id;
	double gpa; // 평점 평균
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student(String name, String id, double gpa) {
		super();
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}
	@Override public String toString() {
		return name + " " + id + " " + Double.toString(gpa);
	}
}
