import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Buttons extends JFrame {
	JButton btnApple, btnBanana, btnOrange;

	class MyActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(e.getSource());
			JButton b = (JButton)e.getSource();			
			//	getText()로 제목을 가져오면 된다.
			System.out.println(b.getText());
		}
	}
	
	Buttons() {
		Container mainPane = getContentPane();
		mainPane.setBackground(Color.yellow);
		mainPane.setLayout(null);    // 여기에 따라
		
		btnApple = new JButton("Apple");
		btnBanana = new JButton("Banana");
		btnOrange = new JButton("Orange");
		btnApple.setBounds(10, 10, 100, 30);
		btnBanana.setBounds(10, 50, 100, 30);
		btnOrange.setBounds(10, 90, 100, 30);
		this.add(btnApple);
		this.add(btnBanana);
		this.add(btnOrange);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnApple.addActionListener(new MyActionListener());
		btnBanana.addActionListener(new MyActionListener());
		btnOrange.addActionListener(new MyActionListener());
	}
	
	public static void main(String[] args) {
		Buttons b = new Buttons();
	}
}
