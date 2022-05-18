import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

class MyFrame extends JFrame {
	protected ArrayList<Figure> figList = new ArrayList<>();

	public MyFrame(String title) {
		super(title);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font myFont = new Font("굴림체", Font.PLAIN, 32);
		this.setFont(myFont);
	}

	public void addFigure(int type, String str, int x, int y, int w, int h) {
		Figure f = null;
		if (type == 0) {
			f = new Rect(str, x, y, w, h);
		} else if (type == 1) {
			f = new Oval(str, x, y, w, h);
		} else if (type == 2) {
			f = new Line(str, x, y, w, h);
		} else if (type == 3) {
			f = new StringFig(str, x, y, w, h);
		}
		figList.add(f);
		this.repaint();
	}

	// event 하고 그림이 남아있음
	// 창을 다시 그릴 이유가 생기면 호출 ->
	// setVisible(true) / resize / component를 다시 그릴 경우 / revalidate() 호출
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < figList.size(); i++) {
			figList.get(i).draw(g);
		}
	}
}

class Figure {
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
		//g = this.getGraphics();
		g.drawRect(x, y, w, h);
		System.out.println("draw 실행됨");
	}
}

class Oval extends Figure {

	public Oval(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(x, y, w, h);
		System.out.println("draw 실행됨");
	}
}

class Line extends Figure {

	public Line(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x, y, w, h);
		System.out.println("draw 실행됨");
	}
}

class StringFig extends Figure {

	public StringFig(String str, int x, int y, int w, int h) {
		super(str, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(str, x, y);
		System.out.println("draw 실행됨");
	}
}

public class Main {

	public static void main(String[] args) {
		// 가능하긴한데 JFrmae 에 없고 MyFrameB 에만 있는 함수는 못 씀
		// JFrame f = new MyFrameB("첫 윈도 프레임");
		MyFrame f = new MyFrame("그림판 프레임");
		f.setVisible(true);

		int type, x, y, w, h;
		String str;
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			if((type = sc.nextInt()) == 3) {
				f.addFigure(type, sc.next(), sc.nextInt(), sc.nextInt(), 0, 0);	
			}else {
				f.addFigure(type, "", sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());	
			}	
		}					
	}
}
