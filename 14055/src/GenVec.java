
class MyVector<t>{
	private int size = 0;
	private int maxSize;
	private t[] arr;
	private Object[] arr1;
	
	public MyVector(int maxSize) {
		this.maxSize = maxSize;
		arr1 = new Object[maxSize];
		arr = (t[])arr1;
	}
	public void insert(t n) {
		arr[size] = n;
		size++;
	}
	public int size() {
		return this.size;
	}
	public t get(int i) {
		return arr[i];
	}
}

public class GenVec{
    public static void main(String[] args){
        MyVector<Integer> v = new MyVector<Integer>(100);   // 100개짜리로 한다.
        v.insert(11);
        v.insert(22);
        v.insert(33);
        for (int i=0; i<v.size(); i++){
            System.out.println(v.get(i));
        }
    }
}