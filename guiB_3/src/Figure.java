import java.awt.Graphics;

public class Figure {
	protected int x, y, w, h;
	protected String str;

	public Figure(String str, int x, int y, int w, int h) {
		this.str = str;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	// event 하고 그림이 남아있지 않음
	public void draw(Graphics g) {
		// empty
	}
}

class Rect extends Figure {

	public Rect(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}
}

class Oval extends Figure {

	public Oval(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(x, y, w, h);
	}
}

class Line extends Figure {

	public Line(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x, y, w, h);
	}
}