import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
	private InputStream s_;
	private int i;                        
	String str = "";
	char[] strArr;
	int flag = 0; // 1이면 스캐너 범위 넘어가는 중인 상황.

	public MyScanner(InputStream s) {
		s_ = s;
	}

	public boolean hasNextInt() throws IOException {
		str = findStr();
		strArr = str.toCharArray();
		int len = str.length();
		if (str.equals(""))
			return false;

		if (flag == 1) {
			flag = 0;
			return true;
		} else {
			for (i = 0; i < len; i++) {
				if (!Character.isDigit(strArr[i])) {
					flag = 1;
					return false;
				}
			}
			return true;
		}
	} 

	///////////
	public String findStr() throws IOException {
		String res = "";
		int c;

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
		if (flag == 1) {
			flag = 0;
			return true;
		} else {
			str = findStr();
			if (str.equals("")) {				
				return false;
			}
			return true;
		}
	}

	public String next() {
		return str;
	}

	public int nextInt() {
		return Integer.parseInt(str);
	}
}
