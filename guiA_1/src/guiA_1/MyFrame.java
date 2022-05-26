package guiA_1;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;
	protected ArrayList<Figure> figList = new ArrayList<>();	
	protected int startX, startY, drawingMode = 0, groupMode = 0;
	protected int figType = 0, colorType = 1;
	myFigActionListener figListener = new myFigActionListener();
	myColorActionListener colorListener = new myColorActionListener();
	myGroupActionListener groupListener = new myGroupActionListener();

	class myFigActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Rect")) {
				drawingMode = 1;
				figType = 1;
			} else if (e.getActionCommand().equals("Oval")) {
				drawingMode = 1;
				figType = 2;
			} else if (e.getActionCommand().equals("Line")) {
				drawingMode = 1;
				figType = 3;
			}
		}
	}

	class myColorActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Black")) {
				colorType = 1;
			} else if (e.getActionCommand().equals("Red")) {
				colorType = 2;
			} else if (e.getActionCommand().equals("Blue")) {
				colorType = 3;
			}
		}
	}

	class myGroupActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (groupMode == 0) {
				groupMode = 1;
			} else {
				groupMode = 0;
			}
		}
	}

	public int getColorType() {
		return this.colorType;
	}

	public void addFig(Figure f) {
		figList.add(f);
		myFrame.repaint();
	}

	public void grouping(int startX, int startY, int endX, int endY) {
		ArrayList<Figure> tempFigList = new ArrayList<>();
		int flag = 0;
		int minX = 2147000000, minY = 2147000000, maxX = 0, maxY = 0;
		Figure f;

		for (int i = 0; i < figList.size(); i++) {
			f = figList.get(i);
			if (startX <= f.x && (f.x + f.w) <= endX && startY <= f.y && (f.y + f.h) <= endY) {

				if (f.x < minX) {
					minX = f.x;
				}
				if ((f.x + f.w) > maxX) {
					maxX = f.x + f.w;
				}
				if (f.y < minY) {
					minY = f.y;
				}
				if ((f.y + f.h) > maxY) {
					maxY = f.y + f.h;
				}

				tempFigList.add(f);
				flag = 1;
			}
		}

		for (int i = 0; i < tempFigList.size(); i++) {
			figList.remove(tempFigList.get(i));
		}

		if (flag == 1) {
			Group g = new Group(colorType, this, "", minX, minY, maxX - minX, maxY - minY);
			for (int i = 0; i < tempFigList.size(); i++) {
				g.add(tempFigList.get(i));
			}
			addFig(g);
		}
	}
	
	public void moveFig(int startX, int startY, int endX, int endY) {
		
		for(int i = figList.size() - 1; i >= 0; i--) {
			Figure f = figList.get(i);
			if(f.x <= startX && startX <= (f.x + f.w) &&
					f.y <= startY && startY <= (f.y + f.h)) {
				f.x += endX - startX;
				f.y += endY - startY;
				f.groupMove(endX - startX, endY - startY);
				repaint();
				break;
			}
		}
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
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (drawingMode == 0) {
					// 메뉴 선택하기 전 : empty
				} else {
					if (groupMode == 0) {
						if (figType == 1) {
							addFig(new Rect(colorType, this, "", startX, startY, e.getX() - startX, e.getY() - startY));
						} else if (figType == 2) {
							addFig(new Oval(colorType, this, "", startX, startY, e.getX() - startX, e.getY() - startY));
						} else if (figType == 3) {
							addFig(new Line(colorType, this, "", startX, startY, e.getX(), e.getY()));
						}
					} else {
						grouping(startX, startY, e.getX(), e.getY());
					}
				}
				break;
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				//이동
				System.out.println("우클랙");
				moveFig(startX, startY, e.getX(), e.getY());
			}
		}
	}

	public MyPanel(MyFrame f) {
		this.myFrame = f;
		enableEvents(AWTEvent.MOUSE_EVENT_MASK); // 이걸 해줘야 processMouseEvent 가 호출된다.

		JMenuBar menubar = new JMenuBar();
		f.setJMenuBar(menubar);

		JMenu figMenu = new JMenu("도형");
		JMenu colorMenu = new JMenu("색상");
		JMenu groupMenu = new JMenu("그룹화모드");
		menubar.add(figMenu);
		menubar.add(colorMenu);
		menubar.add(groupMenu);

		JMenuItem itemRect = new JMenuItem("사각형");
		JMenuItem itemOval = new JMenuItem("타원");
		JMenuItem itemLine = new JMenuItem("선분");
		figMenu.add(itemRect);
		figMenu.add(itemOval);
		figMenu.add(itemLine);
		itemRect.addActionListener(figListener);
		itemOval.addActionListener(figListener);
		itemLine.addActionListener(figListener);
		itemRect.setActionCommand("Rect");
		itemOval.setActionCommand("Oval");
		itemLine.setActionCommand("Line");

		JMenuItem itemBlack = new JMenuItem("검정");
		JMenuItem itemRed = new JMenuItem("빨강");
		JMenuItem itemBlue = new JMenuItem("파랑");
		colorMenu.add(itemBlack);
		colorMenu.add(itemRed);
		colorMenu.add(itemBlue);
		itemBlack.addActionListener(colorListener);
		itemRed.addActionListener(colorListener);
		itemBlue.addActionListener(colorListener);
		itemBlack.setActionCommand("Black");
		itemRed.setActionCommand("Red");
		itemBlue.setActionCommand("Blue");

		JMenuItem itemGroup = new JMenuItem("그룹화OnOff");
		groupMenu.add(itemGroup);
		itemGroup.addActionListener(groupListener);

		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < figList.size(); i++) {
			figList.get(i).draw(g);
		}
	}
}

public class MyFrame extends JFrame {
	public MyFrame(String title) {
		super(title);
		setLayout(null);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font myFont = new Font("굴림체", Font.PLAIN, 32);
		this.setFont(myFont);
	}
}
