import java.io.IOException;
import java.util.Scanner;

class Student {
	static int stuNum_;
	static String name_;
	static double grade_;
	
	public Student(int stuNum, String name, double grade) {
		stuNum_ = stuNum;
		name_ = name;
		grade_ = grade;
	}	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public static void show() {
		System.out.println(stuNum_);
		System.out.println(name_);
		System.out.println(grade_);
	}
}

public class StuApp {

	public static Student getStudent (Scanner sc){
		
		
		if(sc.hasNext() || sc.hasNextInt() || sc.hasNextDouble()) {
			int stuNum = sc.nextInt();
			String name = sc.next();
			double grade = sc.nextDouble();
			
			Student res = new Student(stuNum, name, grade);
			
			return res;
		}else {
			return null;
		}		
	}
	
	public static void main(String[] args) {
		
		Student[] s = new Student[100];  // 주의. s 배열은 전부 null이다.
		s[0] = new Student();  // 이렇게 해야 진짜 Student 하나가 생긴다.		 
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int cnt = 0;
		while((s[i] = getStudent(sc)) != null) {
			i++;
			s[i] = new Student();
			//s[i] = getStudent(sc);
			
		}
		cnt = i;
		
		for(i = cnt - 1; i >= 0; i--) {
			s[i].show();
		}	
	}
}
