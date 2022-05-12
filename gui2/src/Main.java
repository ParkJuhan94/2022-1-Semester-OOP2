import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;
	protected ArrayList<Figure> figList = new ArrayList<>();
	int drawingMode = 0, inButton = 0, startX, startY;

	class MyMouseListener implements MouseListener {

		public void setDrawingMode(MouseEvent e) {
			if (1 < e.getX() && e.getX() < 51 && 1 < e.getY() && e.getY() < 21) {
				drawingMode = 1;
				inButton = 1;
			} else if (51 < e.getX() && e.getX() < 101 && 1 < e.getY() && e.getY() < 21) {
				drawingMode = 2;
				inButton = 1;
			} else if (101 < e.getX() && e.getX() < 151 && 1 < e.getY() && e.getY() < 21) {
				drawingMode = 3;
				inButton = 1;
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			startX = e.getX();
			startY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (drawingMode == 0) {
				setDrawingMode(e);
			} else if (drawingMode == 1) {
				inButton = 0;
				setDrawingMode(e);
				if(inButton != 1) {
					Figure f = new Rect("", startX, startY, e.getX()-startX, e.getY()- startY);
					figList.add(f);
					myFrame.repaint();	
				}												
			} else if (drawingMode == 2) {
				inButton = 0;
				setDrawingMode(e);
				if(inButton != 1) {
					Figure f = new Oval("", startX, startY, e.getX()-startX, e.getY()- startY);
					figList.add(f);
					myFrame.repaint();	
				}				
			} else if (drawingMode == 3) {
				inButton = 0;
				setDrawingMode(e);
				if(inButton != 1) {
					Figure f = new Line("", startX, startY, e.getX(), e.getY());
					figList.add(f);
					myFrame.repaint();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	public MyPanel(MyFrame f) {
		this.myFrame = f;
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyMouseListener());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1, 1, 50, 20);
		g.drawRect(51, 1, 50, 20);
		g.drawRect(101, 1, 50, 20);
		g.drawString("Rect", 11, 15);
		g.drawString("Oval", 61, 15);
		g.drawString("Line", 111, 15);
		for (int i = 0; i < figList.size(); i++) {
			figList.get(i).draw(g);
		}
	}

}

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font myFont = new Font("굴림체", Font.PLAIN, 32);
		this.setFont(myFont);
		
		
	}
	
	public void img() {
		BufferedImage img = null; 
		try {
			img = ImageIO.read(new File("duke.jpg"));
		}catch(IOException e) {
			System.out.println("Cannot open image file.");
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

public class Main {

	public static void main(String[] args) {
		// 가능하긴한데 JFrmae 에 없고 MyFrameB 에만 있는 함수는 못 씀
		// JFrame f = new MyFrameB("첫 윈도 프레임");
		MyFrame f = new MyFrame("그림판 프레임");
		f.setContentPane(new MyPanel(f));
		f.setVisible(true);
	}
}
