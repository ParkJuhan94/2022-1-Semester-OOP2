import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		char c1 = o1.charAt(0);
		char c2 = o2.charAt(0);
		return c1 - c2;
	}
}

class LengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		//	o1과 o2의 길이를 비교 (뺄셈으로)  o1이 짧으면 음수가 나오도록
		int len1 = o1.length();
		int len2 = o2.length();
		return len1 - len2;
	}
}

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		Scanner myScanner = new Scanner(System.in);
		while (myScanner.hasNext()) {
			myList.add(myScanner.next());
		}
		myList.sort(new MyComparator());
		for (String s: myList) {
			System.out.println(s);
		}

		myList.sort(new LengthComparator());
		for (String s: myList) {
			System.out.println(s);
		}
	}
}