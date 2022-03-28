import java.util.Scanner;

class MyIntArray {
	private int[] IntArr;
	private int maxSize = 0;
	private int size = 0;
	private int idxPrint = 0;
	private int i = 0;

	public MyIntArray(int n) {
		this.maxSize = n;
		this.IntArr = new int[maxSize];
	}

	public void add(int n) {
		if (size == maxSize) {
			maxSize *= 2;
			int[] temp = IntArr;
			this.IntArr = new int[maxSize];

			for (i = 0; i < size; i++) {
				IntArr[i] = temp[i];
			}
		}
		
		this.IntArr[size] = n;
		size++;
	}

	public void pushAt(int idx, int n) {
		if (size == maxSize) {
			maxSize *= 2;
			int[] temp = IntArr;
			this.IntArr = new int[maxSize];

			for (i = 0; i < size; i++) {
				IntArr[i] = temp[i];
			}
		}
		
		for (i = size; i > idx; i--) {
			IntArr[i] = IntArr[i - 1];
		}
		this.IntArr[idx] = n;
		size++;
	}

	public void decendingSort() {
		int temp;
		int j;

		for (i = 0; i < size; i++) {
			for (j = 0; j < size - i; j++) {
				if (IntArr[j] < IntArr[j + 1]) {
					temp = IntArr[j];
					IntArr[j] = IntArr[j + 1];
					IntArr[j + 1] = temp;
				}
			}
		}
	}

	public void deleteAt(int idx) {				
		for (i = idx; i < size; i++) {
			IntArr[i] = IntArr[i + 1];
		}
		size--;
		
		if(size * 4 <= maxSize) {
			maxSize /= 2;
			int[] temp = IntArr;
			this.IntArr = new int[maxSize];
			
			for (i = 0; i < size; i++) {
				IntArr[i] = temp[i];
			}
		}
	}

	public void printAll() {
		System.out.print("* 크기 " + maxSize + " 사용 " + size + " 내용 ");
		for (i = 0; i < size; i++) {
			System.out.print(IntArr[i] + " ");
		}
		System.out.println(" 끝");
	}
}

public class Main {

	public static void main(String[] args) {
		MyIntArray myArray = new MyIntArray(4);
		Scanner sc = new Scanner(System.in);
		String input;

		while (sc.hasNext()) {
			input = sc.next();

			if (input.equals("p")) {
				myArray.printAll();
			} else if (input.equals("a")) {
				myArray.add(sc.nextInt());
			} else if (input.equals("i")) {
				myArray.pushAt(sc.nextInt(), sc.nextInt());
			} else if (input.equals("s")) {
				myArray.decendingSort();
			} else if (input.equals("x")) {
				myArray.deleteAt(sc.nextInt());
			}
		}
	}

}
