import java.util.Scanner;

public class prac3130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String res = "";
		
		while(sc.hasNext()) {
			String str = sc.next();
			res = str + ' ' + res;
		}
		System.out.println(res);
	}
}
