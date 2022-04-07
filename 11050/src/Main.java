import java.util.Scanner;

public class Main {
	Target[] mytanklist = new Tank[20];
	Target[] mysoldierlist = new Soldier[20];
	int numTank = 0;
	int numSoldier = 0;
	public void run() {
		mytanklist[numTank++] = new Tank(10,10);
		mytanklist[numTank++] = new Tank(20,20);
		mysoldierlist[numSoldier++] = new Soldier(5, 5);
		mysoldierlist[numSoldier++] =new Soldier(3, 3);
		
		Scanner s = new Scanner(System.in);
		while (s.hasNextInt()) {
			int x = s.nextInt();
			if (s.hasNext()) {
				int y = s.nextInt();
				for (int i=0; i<numTank; i++){
					if (mytanklist[i].areYouThere(x, y))
						mytanklist[i].damage(10);
				}
				for (int i=0; i<numSoldier; i++){
					if (mysoldierlist[i].areYouThere(x, y))
						mysoldierlist[i].damage(10);
				}
			} else break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.run();
	}

}
