
class Account{
	private Person p;
	public int deposit = 0;
	
	public Account(Person p) {
		this.p = p;
		p.ar[p.numAcc] = this;
		p.numAcc++;
	}
	
	public void report() {
		System.out.println("예금주 " + p.name + " " + p.id + " 잔액 " + deposit);
	}
	
	public void deposit(int n) {
		deposit += n;
	}
}

public class Person{
	public String name;
	public String id;  // 주민번호
	public int numAcc = 0;
	
	// 최대 10개의 계좌 정보를 가지도록 한다.
	public Account[] ar = new Account[10];
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void report(){
		// 이 사람이 가지고 있는 모든 계좌의 정보를 출력한다.
		System.out.println("이름 " + name + " " + id);
		System.out.println("소유 계좌:");
		for(int i = 0; i < numAcc; i++) {
			ar[i].report();
		}
	}
}
