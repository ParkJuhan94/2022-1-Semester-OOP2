import java.io.IOException;

public class prac4036 {
	public static String getNext() throws IOException {
		String res = "";
		int c;

		while (Character.isWhitespace(c = System.in.read())) {
			if (c == -1) {
				return "";
			}
		}

		res += (char) c;
		while (!Character.isWhitespace(c = System.in.read())) {
			if (c == -1) {
				return "";
			}
			res += (char) c;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		String s;
		s = getNext();
		while (!s.equals("")) {
			System.out.println(s);
			s = getNext();
		}
	}	
}
