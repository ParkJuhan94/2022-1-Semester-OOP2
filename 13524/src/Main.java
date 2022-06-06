import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Main extends JFrame{

	public JDialog mydialog;
	
	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!mydialog.isVisible()) {
					mydialog.setVisible(true);					
				} else {
					mydialog.setVisible(false);
				}
				System.out.println("Clicked");
			}
		});
		setVisible(true);
	}
	
	public void makeGui() {
		//낫모달
		mydialog = new JDialog(this, "Stupid dialog", false);
		//모달 : 현재 dialog를 무조건 처리해야만 하도록 하기
		//mydialog = new JDialog(this, "Stupid dialog", true);		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}