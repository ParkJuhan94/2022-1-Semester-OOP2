
interface Comparer {
	boolean compare(Student one, Student two);
}

class scoreComparer implements Comparer {

	@Override
	public boolean compare(Student one, Student two) {
		// TODO Auto-generated method stub
		return one.gpa < two.gpa;
	}
}

class nameComparer implements Comparer {

	@Override
	public boolean compare(Student one, Student two) {
		// TODO Auto-generated method stub
		if (one.name.compareTo(two.name) <= 0) {
			return false;
		} else {
			return true;
		}
	}
}

class idComparer implements Comparer {

	@Override
	public boolean compare(Student one, Student two) {
		// TODO Auto-generated method stub
		if (one.id.compareTo(two.id) <= 0) {
			return false;
		} else {
			return true;
		}
	}
}

public class School {
	private Student[] students;
	private int size;
	private int maxSize;

	public School(int size) {
		maxSize = size;
		students = new Student[size];
		size = 0; // empty
	}

	public void add(Student p) {
		if (size >= maxSize)
			return;
		students[size++] = p;
	}

	public void sort(Comparer c) {
		Student temp;
		// bubble sort by name
//		for (int last = size - 1; last >= 0; last--) {
//			for (int i = 0; i < last; i++) {
//				// 현재로서는 이름의 오름 차순으로만 정렬할 수 있다.
//				if (students[i].getName().compareTo(students[i + 1].getName()) > 0) {
//					Student p = students[i];
//					students[i] = students[i + 1];
//					students[i + 1] = p;
//				}
//
//			}
//		}
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (c.compare(students[j], students[j+1])) {
						temp = students[j];
						students[j] = students[j+1];
						students[j+1] = temp;
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(students[i]);
		}
	}
}
