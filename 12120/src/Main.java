interface Comparer{
	/// 인터페이스를 정의해보라.
	boolean compare(Player one, Player two);
}

class NameComparer implements Comparer{

	@Override
	public boolean compare(Player one, Player two) {
		// TODO Auto-generated method stub
		
		if(one.name.compareTo(two.name) >= 0) {
			return true;	
		}else {
			return false;
		}
	}
}

class AgeComparer implements Comparer{

	@Override
	public boolean compare(Player one, Player two) {
		// TODO Auto-generated method stub
		return one.age < two.age;
	}
}

class AverageComparer implements Comparer{

	@Override
	public boolean compare(Player one, Player two) {
		// TODO Auto-generated method stub
		return one.average < two.average;
	}
}

class ReverseAverageComparer implements Comparer{

	@Override
	public boolean compare(Player one, Player two) {
		// TODO Auto-generated method stub
		return one.average > two.average;
	}
}

class Team{
	public int max;
	public int idx = 0;
	public Player[] p;
	
	public Team(int max) {
		this.max = max;
		p = new Player[max];
	}
	public void add(Player p) {
		this.p[idx] = p;
		idx++;
	}
	public String getBest(Comparer c) {
		int maxIdx = 0;
		Player p = this.p[0];
		for(int i = 1; i < idx; i++) {
			if(c.compare(p, this.p[i])) {				
				p = this.p[i];
				maxIdx = i;
			}
		}
		
		return this.p[maxIdx].name;
	}
}

class Player{
	public String name;
	public int age;
	public double average;
	public Player(String name, int age, double average){
		this.name = name;
		this.age = age;
		this.average = average;
	}
}

public class Main{
	public static void main(String[] args){
		Team myTeam = new Team(20);  // 최대 20명
		myTeam.add(new Player("홍길동", 25, 0.25));
		myTeam.add(new Player("조길동", 35, 0.2));
		myTeam.add(new Player("정길동", 22, 0.33));
		myTeam.add(new Player("박길동", 27, 0.30));
		myTeam.add(new Player("김길동", 24, 0.35));
		
		System.out.println("이름이 가장 빠른 사람:" 
		    + myTeam.getBest(new NameComparer()));
        System.out.println("나이가 가장 많은 사람:" 
		    + myTeam.getBest(new AgeComparer()));
		System.out.println("타율이 가장 높은 사람:" 
		    + myTeam.getBest(new AverageComparer()));
		System.out.println("타율이 가장 낮은 사람:" 
		    + myTeam.getBest(new ReverseAverageComparer()));
	}
}
