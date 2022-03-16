
public class prac4032 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis(); 
		
		for (int i = 0; i < 10000000; i++) {
			System.out.println("int = " + i);
		}
		
		/*
		for (Integer i = 0; i < 10000000; i++) {
			System.out.println("Integer = " + i);
		}
		*/	
		
        long end = System.currentTimeMillis();

        System.out.println("start : " + start); //시작시간의 밀리세컨드
        System.out.println("end : " + end);  //종료시간의 밀리케선드
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //최종 실행시간
	}

}
