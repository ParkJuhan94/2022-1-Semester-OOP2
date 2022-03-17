import java.io.IOException;

public class prac4037 {

	public static String getNext() {
		int c;
		try {
			c = System.in.read();
			while(Character.isWhitespace(c)) {
				c = System.in.read();
			}
			// System.out.println("빈칸이 아닌 글자: " + c);
			
			if (c == -1) { // EOF가 되었음
				return "";
			}

			String result = "";

			while (c != -1 && !Character.isWhitespace(c)) {
				result += (char) c;
				c = System.in.read();
			}
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		s = getNext();
		while (!s.equals("")) {
			System.out.println(s);
			s = getNext();
		}
	}
}
