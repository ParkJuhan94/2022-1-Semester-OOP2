 import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

interface MyActionListenerI{
	public void actionPerformed(ActionEvent e);
}

class MyActionListenerOne implements MyActionListenerI{
	protected MyButton b;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		b.setBtnType((MyButton)e.getSource());	
	}
	
	public void setBtn(MyButton b) {
		this.b = b;
	} 
}

public class MyButton {
	protected String name;
	protected MyPanel p;
	protected MyButton btnType;
	protected int x, y, w, h, drawingMode = 0, inButton = 0;
	protected ArrayList<MyActionListenerOne> listenerList = new ArrayList<>();
		
	public MyButton(String name, MyPanel p) { 
		this.name = name;
		this.p = p;
		}
	
	public MyButton getBtnType() {
		return this.btnType;
	}
	
	public void setBtnType(MyButton b) {
		this.btnType = b;
	}	
	
	public void setBounds(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
		g.drawString(name, x + 15, y + 17);
	}
	
	public boolean contains(Point p) {
		if(x < p.getX() && p.getX() < x + 70 && y < p.getY() && p.getY() < y + 25) {
			return true;
		}else {
			return false;
		}
	}

	protected void processMouseEvent(MouseEvent e) {
		switch(e.getID()) {
		case MouseEvent.MOUSE_CLICKED:
			ActionEvent ae = new ActionEvent(this, MouseEvent.MOUSE_CLICKED, "");						
			for(int i = 0; i < listenerList.size(); i++) {
				listenerList.get(i).actionPerformed(ae);
			}
			break;
		}		
	} 
	
	public void addMyActionListener(MyActionListenerOne myActionListenerOne) {
		listenerList.add(myActionListenerOne);
		myActionListenerOne.setBtn(this);
		System.out.println(this.name + "버튼에 리스너 추가됨 ");
	}	
}
