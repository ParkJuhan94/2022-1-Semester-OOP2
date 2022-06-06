
class MyRunnable implements Runnable{
		String name;
		int interval;
		
		MyRunnable(String name, int interval){
			this.name = name;
			this.interval = interval;
		}
		
		@Override
		public void run() {			
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println(name);
					Thread.sleep(interval);
				}
			} catch (Exception e) {
			}	
		}
	}

public class Main{
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable("apple", 1000);
		MyRunnable r2 = new MyRunnable("banana", 2000);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
