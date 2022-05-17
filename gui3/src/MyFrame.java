import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;
	protected ArrayList<Figure> figList = new ArrayList<>();
	protected ArrayList<MyButton> btnList = new ArrayList<>();
	int drawingMode = 0, inButton = 0, startX, startY;

	class MyMouseListener implements MouseListener {

		public void setDrawingMode(MouseEvent e) {
			for(int i = 0; i < btnList.size(); i++) {
				if(btnList.get(i).contains(e.getPoint())) {
					drawingMode = i + 1;
					inButton = 1;
					break;
				}
			}		
		}
		
		public void drawFigure(Figure f) {			
			figList.add(f);
			myFrame.repaint();	
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
					drawFigure(new Rect("", startX, startY, e.getX()-startX, e.getY()- startY));					
				}												
			} else if (drawingMode == 2) {
				inButton = 0;
				setDrawingMode(e);
				if(inButton != 1) {
					drawFigure(new Oval("", startX, startY, e.getX()-startX, e.getY()- startY));	
				}				
			} else if (drawingMode == 3) {
				inButton = 0;
				setDrawingMode(e);
				if(inButton != 1) {
					drawFigure(new Line("", startX, startY, e.getX(), e.getY()));					
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
		
		MyButton btnRect = new MyButton("사각형");
		MyButton btnOval = new MyButton("타원");
		MyButton btnLine = new MyButton("선분");
		btnRect.setBounds(10, 60, 70, 25);  
		btnOval.setBounds(90, 60, 70, 25);
		btnLine.setBounds(170, 60, 70, 25);
		
		this.add(btnRect);
		this.add(btnOval);
		this.add(btnLine);
	}

	public void add(MyButton b) {
		btnList.add(b);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < figList.size(); i++) {
			figList.get(i).draw(g);
		}
		for(int i = 0; i < btnList.size(); i++) {
			btnList.get(i).draw(g);
		}
	}
}

public class MyFrame extends JFrame {

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
