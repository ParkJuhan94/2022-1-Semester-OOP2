import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Down " + e.getX() + ", " + e.getY());			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Up " + e.getX() + ", " + e.getY());					
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}

	public MyPanel(MyFrame f) {
		this.myFrame = f;
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyMouseListener());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1, 1, 50, 50);
	}

}

class MyFrame extends JFrame {
	public MyFrame() {
		//
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MyFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocation(100, 0);
		
		frame.setContentPane(new MyPanel((MyFrame) frame));
		frame.setVisible(true);
	}
}
