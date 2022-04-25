/*
주어진 프로그램에서 Iterator를 추가하라.

반복을 위해서 쓰이는 클래스를 말합니다. java Iterator를 몰라도 상관 없습니다.
그냥 main 처럼 실행될 수 있는 클래스를 만들면 됩니다.

힌트 1:   IntIterator는  MyIterable 을 implement 합니다. 
힌트 2: IntIterator는 inner클래스이므로 생성시에 배열 반복을 위한 정보(첫 항목을 가리키는 정수)를 가지면 됩니다.

힌트 3: getIterator함수는 새로운 IntIterator 를 만들어 돌려주면 됩니다.
*/

interface MyIterable{
	public boolean hasNext();
	public Integer next();
}

class IntVector{
	Integer[] ilist;
	int max;
	IntVector(){
		ilist = new Integer[100];
		max = 0;
	}
	void insert(Integer o){
		ilist[max++] = o;
	}
	Integer get(int i){
		return ilist[i];
	}
	public MyIterable getIterator() {
		IntIterator it = new IntIterator();
		return it;
	}
	
	// IntVector의 inner클래스로서 IntIterator를 정의해보라.
	class IntIterator implements MyIterable{
		private int idx;
		public IntIterator() {
			this.idx = 0;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(idx < max) {
				return true;
			}else {
				return false;	
			}			
		}
		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			idx++;
			return get(idx - 1);			
		}
	}
}
public class IntVecIterEx{
	public static void main(String[] args){
		IntVector v = new IntVector();
		v.insert(new Integer(11));
		v.insert(new Integer(22));
		v.insert(new Integer(33));
		MyIterable t = v.getIterator();
		while (t.hasNext()){
			System.out.println(t.next());
		}
	}
}
