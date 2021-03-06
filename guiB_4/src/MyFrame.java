import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;
	protected ArrayList<Figure> figList = new ArrayList<>();
	protected ArrayList<MyButton> btnList = new ArrayList<>();
	protected int btnIdx, startX, startY, drawingMode = 0, inButton = 0;
	MyButton btnRect, btnOval, btnLine;
	
	public void addFig(Figure f) {		
		figList.add(f);
		myFrame.repaint();
	}

	@Override
	protected void processMouseEvent(MouseEvent e) {

		switch (e.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			System.out.println("PRESSED");
			startX = e.getX();
			startY = e.getY();
			break;		
		case MouseEvent.MOUSE_RELEASED:
			System.out.println("RELEASED");
			if(drawingMode == 0) {
				//	empty				
			}else {				
				if(btnList.get(btnIdx).getBtnType() == btnRect) {
					addFig(new Rect("", startX, startY, e.getX() - startX, e.getY() - startY));
				}else if(btnList.get(btnIdx).getBtnType() == btnOval) {
					addFig(new Oval("", startX, startY, e.getX() - startX, e.getY() - startY));
				}else if(btnList.get(btnIdx).getBtnType() == btnLine) {
					addFig(new Line("", startX, startY, e.getX(), e.getY()));
				}
			}
			break;
		case MouseEvent.MOUSE_CLICKED:
			for (int i = 0; i < btnList.size(); i++) {
				if (btnList.get(i).contains(e.getPoint())) {					
					btnIdx = i;
					drawingMode = 1;
					btnList.get(i).processMouseEvent(e);					
					break;
				}
			}					
			break;
		}				
	}

	public MyPanel(MyFrame f) {
		this.myFrame = f;
		setBackground(new Color(200, 255, 255));
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);  // 이걸 해줘야 processMouseEvent 가 호출된다.
				
		btnRect = new MyButton("사각형", this);
		btnOval = new MyButton("타원", this);
		btnLine = new MyButton("선분", this);
		btnRect.setBounds(10, 60, 70, 25);
		btnOval.setBounds(90, 60, 70, 25);
		btnLine.setBounds(170, 60, 70, 25);
		this.addBtn(btnRect);
		this.addBtn(btnOval);
		this.addBtn(btnLine);		
		btnRect.addMyActionListener(new MyActionListenerOne());
		btnOval.addMyActionListener(new MyActionListenerOne());
		btnLine.addMyActionListener(new MyActionListenerOne());
	}

	public void addBtn(MyButton b) {
		btnList.add(b);
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < figList.size(); i++) {
			figList.get(i).draw(g);
		}
		for (int i = 0; i < btnList.size(); i++) {
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
}
