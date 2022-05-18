import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

class MouseAdapter implements
	MouseListener, MouseMotionListener, MouseWheelListener
	{
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	}

public class MainFrame extends JFrame {
	class InternalListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(getCount());
		}
	}
	
	private int count = 0;

	public int getCount() {
		return ++count;
	}

	public MainFrame() {
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new InternalListener());
	}

	public static void main(String[] args) {

		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		// 리스너를 추가한다.		
	}

}
