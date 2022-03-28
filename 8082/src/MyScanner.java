import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
		private InputStream s_;
		private int i, j;
		String str = "";
		char[] strArr;
		int c;	

		public MyScanner(InputStream s) {
			s_ = s;
		}

		public boolean hasNextInt() throws IOException {
			str = findStr();		
			strArr = str.toCharArray();
			int len = str.length();		
			if(str.equals("")) return false;		
			
			for (i = 0; i < len; i++) {
				if (!Character.isDigit(strArr[i])) {						
					return false;
				}
			}
			return true;
		}

		public int nextInt() {
			return Integer.parseInt(str);
		}
		
		///////////
		public String findStr() throws IOException {
			String res = "";		

			while (Character.isWhitespace(c = s_.read())) {
				if (c == -1) {
					return "";
				}
			}

			res += (char) c;
			while (!Character.isWhitespace(c = s_.read())) {
				if (c == -1) {
					return "";
				}
				res += (char) c;
			}
			return res;
		}

		////////////
		public boolean hasNext() throws IOException {
			str = findStr();
			if(str.equals("")) return false;		
			
			return true;
		}

		public String next() {
			return str;
		}
}
