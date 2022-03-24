
public class prac8085 {

	static void changeString(String s) {
		s = "new string";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "old string";
		changeString(s);
		System.out.println(s);
	}

}
