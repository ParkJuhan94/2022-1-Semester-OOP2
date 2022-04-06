import java.lang.Thread;
public class KyoChon{
	public void MakeChicken() throws Exception {
		for (int i=1; i<=5; i++){
			System.out.println("Timer: "+i+"분");
			Thread.sleep(300);
		}
		System.out.println("다 익었습니다.");
	}
}

class Padak extends KyoChon{
	public void MakeChicken() throws Exception{
		super.MakeChicken();
		System.out.println("파를 100그램 얹는다.");
	}
	
}
