
public class Main {

	public static void main(String[] args) {
		// 가능하긴한데 JFrmae 에 없고 MyFrameB 에만 있는 함수는 못 씀
		// JFrame f = new MyFrameB("첫 윈도 프레임");
		MyFrame f = new MyFrame("그림판 프레임");
		f.setContentPane(new MyPanel(f));
		f.setVisible(true);
	}
}
