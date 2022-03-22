import java.util.Arrays;

public class MyStringBuffer {
	private char[] data;
	private int size = 16;
	
	public MyStringBuffer() {
		data = new char[0];
	}
	
	public MyStringBuffer(String s) {
		data = s.toCharArray();	
		size += s.length();
	}
	
	public int length() {
		return data.length;
	}
	
	public int capacity() {
		return size;
	}
	
	public String toString() {
		String arrayString = String.valueOf(data);		
		return arrayString;
	}
	
	public void append(MyStringBuffer s) {
		String arrayStr = new String(data);
		String temp = new String(s.data,0,data.length);
		arrayStr += temp;		
		
		data = arrayStr.toCharArray();
	}
	
	public void append(int n) {
		String arrayStr = String.valueOf(data);
		arrayStr += n;		
		
		data = arrayStr.toCharArray();
	}
	
	public void delete(int index, int num) {		
		if(data.length - num <= 0) {
			char[] temp = new char[num - (num - index)];
			for(int i = 0 ; i < data.length; i++) {
				if(i < index) {
					temp[i] = data[i];
				}else if(i >= index && i < index + num){
					//empty
				}else {
					temp[i - num] = data[i];
				}
			}
			data = temp;
		}else {
			char[] temp = new char[data.length - num];	
			for(int i = 0 ; i < data.length; i++) {
				if(i < index) {
					temp[i] = data[i];
				}else if(i >= index && i < index + num){
					//empty
				}else {
					temp[i - num] = data[i];
				}
			}
			data = temp;
		}			
		
		
	}
	
	public void insert(int index, String s) {
		char[] temp = new char[data.length + s.length()];
		temp = Arrays.copyOf(s.toCharArray(), data.length + s.length()); 
		
		for(int i = index; i < data.length; i++) {
			temp[i + s.length()] = data[i];
		}
		data = temp;
	}

	public void reverse() {
		char[] temp = new char[data.length];
		for(int i = 0 ; i < data.length; i++) {
			temp[i] = data[data.length - i - 1];
		}
		data = temp;
	}
	
	public void trimToSize() {
		size = data.length;
	}
}
