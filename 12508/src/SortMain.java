public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School mju = new School(20);
		mju.add(new Student("홍길동", "20201111", 2.0));
		mju.add(new Student("조길동", "20201112", 2.5));
		mju.add(new Student("정길동", "20201113", 3.0));
		mju.add(new Student("박길동", "20201114", 3.5));
		mju.add(new Student("김길동", "20201115", 4.5));			
		
		// ) 학점 순 내림차순 정렬
		// 정렬된 순서대로 천제 출력
		mju.sort(new scoreComparer());
		mju.print();
		System.out.println();
		// 2) 이름 순 오름차순 정렬
		// 정렬된 순서대로 천제 출력
		mju.sort(new nameComparer());
		mju.print();
		System.out.println();
		// 3) ID 별 오름차순 정렬
		// 정렬된 순서대로 천제 출력
		mju.sort(new idComparer());
		mju.print();
		System.out.println();
	}

}
