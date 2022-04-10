class KyoChon{
	public void MakeChicken() throws Exception {
		for (int i=1; i<=5; i++){
			System.out.println("Timer: "+i+"분");
			Thread.sleep(300);
		}
		System.out.println("다 익었습니다.");
	}
}

class Padak {
	KyoChon k = new KyoChon();
	
	public void MakeChicken() throws Exception{
		k.MakeChicken();;
		System.out.println("파를 100그램 얹는다.");
	}
	
}

public class Main {
	public static void main(String[] args){
		Padak k = new Padak();
		try {
			k.MakeChicken();
		} catch (Exception e){
			System.out.println("Cannot make chicken");
		}
	}
}
