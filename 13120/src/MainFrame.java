
import java.awt.event.MouseEvent;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private int count = 0;
	private int startX, startY, endX, endY;

	public int getCount() {
		return ++count;
	}

	public MainFrame() {
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	@Override
	protected void processMouseEvent(MouseEvent e) {
		//	super.processMouseEvent(e);
		
		switch(e.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			startX = e.getX();
			startY = e.getY();
			break;
		case MouseEvent.MOUSE_RELEASED:
			endX = e.getX();
			endY = e.getY();
			this.repaint();
			break;
		}		
	} 
	
	public void draw(Graphics g) {
		g.drawRect(startX, startY, endX - startX, endY - startY);
	}
	
	@Override
	public void paint(Graphics g) {
		draw(g);
	}

	public static void main(String[] args) {

		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		// 리스너를 추가한다.		
		mf.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
	}

}
