import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable {
	String name;

	public Student(String name) {
		this.name = name;
	}

	public void speak() {
		System.out.println("제 이름은 " + name + "입니다.");
	}
}

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s = null;
		String stuName = "";
		int menuItem = 0;

		System.out.print("메뉴 번호를 입력하세요 : ");
		
		while (sc.hasNextInt()) {						
			menuItem = sc.nextInt();
			
			if (menuItem == 0) {
				System.out.println("학생의 이름을 입력하세요 : ");
				stuName = sc.next();
				System.out.println(stuName + " 저장 완료!");
				
			} else if (menuItem == 1) {
				System.out.println("학생 객체를 serialize 하여 data.txt 에 저장합니다.");
				s = new Student(stuName);				
				try {
					ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("data.txt"));
					oss.writeObject(s);
					oss.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("완료!");
				
			} else if (menuItem == 2) {
				System.out.println("data.txt에서 학생 객체를 불러옵니다.");
				try {
					ObjectInputStream instream = new ObjectInputStream(new FileInputStream("data.txt"));
					s = (Student)instream.readObject();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("완료!");
				
			} else if (menuItem == 3) {
				System.out.println("학생 객체의 이름을 출력합니다.");
				s.speak();
				System.out.println("완료!");
			}

		}
	}
}
