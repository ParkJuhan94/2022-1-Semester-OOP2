import java.awt.Color;

class Rectangle{
	public String title;
	public Rectangle(String title) {
		this.title = title;
	}
}

class ColoredRectangle extends Rectangle{
	protected Color myColor;
	
	public ColoredRectangle(String title, Color c) {
		super(title);
		this.myColor = c;
	}
	
	public void show() {
		System.out.println(title);
		System.out.println(myColor);
	}
}
public class Main {
	public static void main(String[] args) {
		ColoredRectangle myrect = 
			new ColoredRectangle("평범한 사각형", Color.green);
		myrect.show();
	}

}