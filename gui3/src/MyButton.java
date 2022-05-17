import java.awt.Graphics;
import java.awt.Point;

public class MyButton {
	protected String name;
	protected int x, y, w, h;
	
	public MyButton(String name) { this.name = name;}
	
	public void setBounds(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
		g.drawString(name, x + 15, y + 17);
	}
	
	public boolean contains(Point p) {
		if(x < p.getX() && p.getX() < x + 70 && y < p.getY() && p.getY() < y + 25) {
			return true;
		}else {
			return false;
		}
	}
	
}
