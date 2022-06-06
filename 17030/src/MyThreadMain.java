interface MyRunnable {
	public void go();
}

class ARunnable implements MyRunnable {
	// go 함수를 override하여 hello 0 부터 hello 9 까지 1초 간격으로
	// 출력하게 한다. (Thread.sleep(1000); 이용)
	@Override
	public void go() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("hello " + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
		}	
	}
}

class MyThread extends Thread {
	MyRunnable r;

	MyThread(MyRunnable r){
		this.r = r;
	}
	
	@Override
	public void run() {
		r.go();
	}
}

public class MyThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread t = new MyThread(new ARunnable());
		t.start();
	}

}
