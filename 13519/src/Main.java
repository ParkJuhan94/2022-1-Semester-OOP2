import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame {

	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}

	public void makeGui() {
		String fruits[] = { "apple", "banana", "mango", "kiwi" };
		JList<String> mylist = new JList<>(fruits);
		mylist.setBounds(0, 0, 200, 200);
		mylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(mylist);

		mylist.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					System.out.println(mylist.getSelectedIndex() + "." + 
							mylist.getSelectedValue());
				}

			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}