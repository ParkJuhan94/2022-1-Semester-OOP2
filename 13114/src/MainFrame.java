import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;



public class MainFrame extends JFrame implements MouseListener{		
	
	private int count=0;
	
	public int getCount() {
		return ++count;
	}
	public MainFrame() {
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
		System.out.println(getCount());
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		// 리스너를 추가한다.		
	}
	
}
