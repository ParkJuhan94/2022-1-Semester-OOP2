
class Dog{
	private DogSchool s;
	private String name, breed;
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public void setSchool(DogSchool s) {
		this.s = s;
	}
	
	public void speak() {
		if(s == null) {
			System.out.println(name + " " + breed + " 소속학교는 없습니다");
		}else {
			System.out.println(name + " " + breed + " 소속학교는 " + s.getName());	
		}
		
	}
	
	public void rename(String rename) {
		this.name = rename;
	}
}

class DogSchool{
	private Dog[] da = new Dog[100];
	private String name;
	private int stuNum = 0;
	
	public DogSchool(String name) {
		this.name = name;
	}
	
	public void register(Dog d) {
		this.da[stuNum] = d;
		d.setSchool(this);
		stuNum++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void speak() {
		System.out.println("여기는 " + name + " 학생은: ");
		for(int i = 0 ; i < stuNum; i++) {
			da[i].speak();
		}
	}
	
}

public class Main{
    public static void main(String[] args){
        DogSchool ds = new DogSchool("MJ 애견학교" );
        Dog d1 = new Dog("뚱이", "불독");
        Dog d2 = new Dog("철이", "푸들");
        Dog d3 = new Dog("순이", "푸들");
        ds.register(d1);
        ds.register(d2);
        ds.register(d3);

        d1.speak();
        ds.speak();
        d1.rename("띵이");
        ds.speak();
    }
}