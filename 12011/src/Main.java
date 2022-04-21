import sms_sender.*;

class MsgSender{
	public String phone = "";
	public MsgSender(String phone) {
		this.phone = phone;
	}
	public String send (String msg) {
		if(this.phone.equals("")) {
			return "송신 실패";
		}else {
			return "송신 성공";
		}
	}
}

interface Logger{
	void log(String msg);
}

class SMSLogger extends MsgSender implements Logger{		
	
	public SMSLogger(String pn) {
		super(pn);
	}
	
	@Override
	public void log(String msg) {
		// TODO Auto-generated method stub
		send(msg);
		System.out.println(send(msg));
	}
}

class AtomicPlant{
	Logger myLogger;
	public AtomicPlant(Logger logger) {
		// 초기화
		this.myLogger = logger;
	}
	public void checkTemparature() {
		// 로거를 이용해서 "관리자 java39 흥길동" 처럼 출력한다.
		// 각자 자기의 ID와 이름을 보내는 거다.
		myLogger.log("classadapter__박주한_java14");
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SMSLogger myLogger = new SMSLogger("01085784321"); // 조세형교수 전번임
		AtomicPlant ap = new AtomicPlant(myLogger);
		ap.checkTemparature();
	}

}