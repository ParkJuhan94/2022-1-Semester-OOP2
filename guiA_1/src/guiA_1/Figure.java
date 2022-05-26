package guiA_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Figure {
	public int x, y, w, h, color;
	protected String str;
	protected MyPanel myPanel; 
	
	public Figure(int color, MyPanel mypanel, String str, int x, int y, int w, int h) {
		this.color = color;
		this.myPanel = mypanel;
		this.str = str;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	// event 하고 그림이 남아있지 않음
	public void draw(Graphics g) {
		if(color == 1) {
			g.setColor(Color.BLACK);	
		}else if(color == 2) {
			g.setColor(Color.RED);			
		}else if(color == 3) {
			g.setColor(Color.BLUE);
		}
	}
	
	public void groupMove(int x, int y) {
		//	empty
	}
}

class Rect extends Figure {

	public Rect(int color, MyPanel mypanel, String str, int x, int y, int w, int h) {
		super(color, mypanel, str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawRect(x, y, w, h);
	}
}

class Oval extends Figure {

	public Oval(int color, MyPanel mypanel, String str, int x, int y, int w, int h) {
		super(color, mypanel, str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(x, y, w, h);
	}
}

class Line extends Figure {

	public Line(int color, MyPanel mypanel, String str, int x, int y, int w, int h) {
		super(color, mypanel, str, x, y, w, h);
	}


	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawLine(x, y, w, h);
	}
}

class Group extends Figure{
	protected ArrayList<Figure> groupList = new ArrayList<>();
	
	public Group(int color, MyPanel mypanel, String str, int x, int y, int w, int h) {
		super(color, mypanel, str, x, y, w, h);
	}
	
	public void add(Figure f) {
		groupList.add(f);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawRect(x, y, w, h);
		for(int i = 0 ; i < groupList.size(); i++) {
			groupList.get(i).draw(g);
		}		
	}
	
	@Override
	public void groupMove(int x, int y) {
		for(int i = 0; i < groupList.size(); i++) {
			groupList.get(i).x += x;			
			groupList.get(i).y += y;
		}
	}
}