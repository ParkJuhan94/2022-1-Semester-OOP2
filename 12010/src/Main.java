interface Logger{
	void log(String message);
}

class Printer {
	public void print(String msg) {
		System.out.println("프린터가 출력: " + msg);
	}
}

class PrintLogger extends Printer implements Logger {

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		print(message);
	}
} 

class AtomicPlant{
	Logger myLogger;
	public AtomicPlant(Logger logger) {
		// 초기화
		myLogger = logger;
	}
	public void checkTemparature() {
		// 로거를 이용해서 "66도" 라고 출력한다.
		myLogger.log("66도");
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintLogger myLogger = new PrintLogger();
		AtomicPlant ap = new AtomicPlant(myLogger);
		ap.checkTemparature();
	}

}