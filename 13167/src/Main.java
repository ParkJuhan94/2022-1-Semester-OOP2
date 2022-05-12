import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyFrame myFrame;
	BufferedImage img = null; 

	public MyPanel(MyFrame f) {
		loadImage();
		this.myFrame = f;
		setBackground(new Color(200, 255, 255));
	}

	void loadImage() {
		try {
			img = ImageIO.read(new File("duke.png"));
		}catch(IOException e) {
			System.out.println("Cannot open image file.");
		}	
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(img != null) {
			g.drawImage(img, 0,0,450,450,null);
		}
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
