public class Main{
	public static void main(String[] args){
		Person p1 = new Person("김길동", "941212-1234567");
		Person p2 = new Person("홍길동", "941212-1111111");
		Account a = new Account(p1);
		Account b = new Account(p2);
		Account c = new Account(p2);
		try{
			a.deposit(1000);
			b.deposit(2000);
			c.deposit(3000);
			System.out.println("===============");
			a.report();
			System.out.println("===============");
			b.report();
			System.out.println("===============");
			c.report();
			System.out.println("===============");
			p1.report();
			System.out.println("===============");
			p2.report();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
