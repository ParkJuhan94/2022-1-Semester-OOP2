interface RectPrinter{
	public void print(Rectangle r);
}

class SimplePrinter implements RectPrinter{
	@Override
	public void print(Rectangle r) {
		System.out.println(r.getWidth() + ", " + r.getHeight());
	}	
}

class PrettyPrinter implements RectPrinter{
	@Override
	public void print(Rectangle r) {
		System.out.println("가로 " + r.getWidth() + ", 세로 " + r.getHeight() + " 의 사각형입니다.");
	}	
}

class Rectangle{
	private int width;
	private int height;
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Rectangle(int w, int h){
		width = w; height = h;
	}
}

class RectList{
	public Rectangle[] myRect ;
	public int numRect = 0;
	RectList(int size){
		myRect = new Rectangle[size];
	}
	public void printall(RectPrinter p) {
		for (int i=0; i<numRect; i++) {
			p.print(myRect[i]);
			//printRect(myRect[i]);
		}
	}
	public void printRect(Rectangle r) {
		
		System.out.println(r.getWidth() + ", " + r.getHeight());
	}
	public void add(Rectangle r) {
		myRect[numRect++] = r;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectList list = new RectList(10);
		list.add(new Rectangle(1,2));
		list.add(new Rectangle(2,3));
		list.add(new Rectangle(4,5));
		list.printall(new SimplePrinter());
		list.printall(new PrettyPrinter());
	}
}
