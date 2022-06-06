import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main extends JFrame{

	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}
	
	public void makeGui() {
		String fruits[] = { "apple", "banana", "mango", "kiwi" };
		JComboBox<String> fruitCombo = new JComboBox<>(fruits);
		fruitCombo.setBounds(0,0,200,30);
		add(fruitCombo);
		fruitCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(e.getItem());	
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}